package com.company.design.singleton;

public class SocketClient {
    // 매번 연결하는게 아니라 한번 연결해놓은 소켓통로를 계속 이용.
    // 싱글톤은 자기 자신을 객체로 가지고 있어야 한다.
    private static SocketClient socketClient = null;

    // Note 싱글톤은 기본 생성자를 통해 생성할 수 없도록 private 으로 막아야 한다.
    private SocketClient() {

    }

    // public 으로 한 다음 new 생성자로 만들경우 객체가 달라지게됨.
//    public SocketClient() {
//
//    }

    // Note static 이므로 어떤곳에서도 접근이 가능.
    public static SocketClient getInstance() {
        // 현재 내가 가지고 있는 객체가 null인지 아닌지 체크한다. => important 한번만 생성되도록 한다.
        if (socketClient == null) {
            socketClient = new SocketClient();
        }

        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }

}
