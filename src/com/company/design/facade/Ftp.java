package com.company.design.facade;

public class Ftp {

    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    // 연결
    public void connect() {
        System.out.println("FTP Host : " + host + " Port : " + port + "로 연결합니다.");
    }

    // path 이동
    public void moveDirectory() {
        System.out.println("path : " + path + " 로 이동합니다.");
    }

    // 연결 해제
    public void disConnect() {
        System.out.println("FTP 연결을 종료합니다.");
    }
}
