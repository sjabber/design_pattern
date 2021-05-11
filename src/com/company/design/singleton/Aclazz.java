package com.company.design.singleton;

// class 는 이름은 예약어이기 때문에 clazz 라고도 사용한다.
public class Aclazz {

    private SocketClient socketClient;

    public Aclazz() {
        //Note 디폴트 생성자를 막아놨기 때문에 아래 방식은 사용이 불가능!
        // this.socketClient = new SocketClient();

        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
