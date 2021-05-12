package com.company.design.aop;

import com.company.design.proxy.Html;
import com.company.design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    // AOP의 특징중에는 전후 메소드라는 것이 있다.
    private String url;
    private Html html;

    //FunctionalInterface인 Runnable을 사용한다.
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        // 전
        before.run();

        if (html == null) {
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url);

            try {
                // 너무 빠르게 처리될 수 있으므로 1.5초를 쉬어준다.
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 후
        after.run();

        System.out.println("AopBrowser html cache : " + url);
        return html;
    }
}
