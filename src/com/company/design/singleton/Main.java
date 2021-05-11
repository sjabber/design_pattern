package com.company.design.singleton;

import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
        Aclazz aclazz = new Aclazz();
        Bclazz bclazz = new Bclazz();

        // 위 두개의 클라이언트가 동일한지 검사해본다.
        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
