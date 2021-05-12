package com.company.design.strategy;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();

        // base64 전략 생성
        EncodingStrategy base64 = new Base64Strategy();

        // normal 전략 생성
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        // 필요에 따라 전략을 주입하여 사용한다.
        // base64 전략 주입
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        // normal 전략 주입
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        // ABCD 를 메시지 앞에 추가하는 전략 주입
        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}
