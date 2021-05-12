package com.company.design.facade;

public class Main {
    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.foo.co.kr", 25, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println();

        // 퍼사드 적용
        // 앞쪽에 정면만 바라보도록 객체가 하나 만들어진다. (sftpClient)
        // 퍼사드 객체를 통해 안에 있는 여러 복잡한, 의존성을 가진 것들을 새로운 인터페이스로 제공한다.
        // 기존과 달리 굉장히 간략하게 코드를 줄일 수 있다. (sftpClient 객체가 위의 기능들 전부 수행가능함)
        // 여러가지 객체 기능, 의존성들을 안쪽으로 숨겨주는것 => 퍼사드 패턴
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.write();

        sftpClient.read();

        sftpClient.disConnect();
    }
}
