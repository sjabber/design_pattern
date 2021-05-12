package com.company.design.strategy;

public class Encoder {
    // 그때그때마다 전략을 주입받는다.
    private EncodingStrategy encodingStrategy;

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }

    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }
}
