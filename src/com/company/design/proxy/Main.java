package com.company.design.proxy;

import com.company.design.aop.AopBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {

        // 캐시 미적용
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        // 캐시 적용
        IBrowser browser2 = new BrowserProxy("www.naver.com");
        browser2.show();
        browser2.show();
        browser2.show();
        browser2.show();

        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println();

        // AOP
        // => 특정한 메소드가 있으면 이 메소드의 실행시간이나 특정 패키지안의 메소드들의 실행시간
        // 전후로 작업하고싶은 부분들, 일괄적으로 특정한 요청에 대해 리퀘스트 정보, 리스폰스 요청정보를 남긴다고 할때
        // 코드에다 개별적으로 하는게 아니라 일괄적으로 특정 패키지의 모든 메소드들 이런식으로 전후에 있는 기능들을 넣을 수 있는것이
        // AOP라 할 수 있다. 우리 시스템에서 메소드가 얼마나 시간이 걸리고있는건지 등을 알 수 있다.

        // 동시성 사용
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                // 람다식 표현
                ()-> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()-> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );

        aopBrowser.show();
        System.out.println("loading time : " + end.get());

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }

    // 이런식으로 AOP패턴은 프록시 패턴을 활용하고 있고, 특정 메서드나 기능, 특정 기능에 앞뒤로 원하는 기능, 넘어가는 매개변수 등에
    // 조작도 할 수 있고 흩어져있는 공통된 기능을 묶을 수 있다.
    // 주로 사용하는게 http client가 어딘가로 통신한다 할때 흩어져있거나 restful 서비스가 흩어져있다면 그것들의 시간을 체크하거나
    // 데이터베이스 트랜잭션에도 시간관련 AOP를 넣어서 어디서 오래 걸리고 어떤 메소드가 오래걸려서 우리 서버가 느린건지 발견하는 데에도
    // 많이 사용한다. APM(Application Performance Monitoring)에 사용되는 듯하다.
}
