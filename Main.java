class Main {
  public static void main(String[] args) {
    
    // 110V 헤어드라이기
    HairDryer HairDryer = new HairDryer();
    connect(HairDryer);
    
    // 220V 청소기
    Cleaner cleaner = new Cleaner();
    // SocketAdapter는 Electronic110V 인터페이스를 상속받음
    Electronic110V adapter = new SocketAdapter(cleaner);
    connect(adapter);
    
    
    //220V 에어컨
    AirConditioner airConditioner = new AirConditioner();
    Electronic110V airAdapter = new SocketAdapter(airConditioner);
    connect(airAdapter);
  }
  
  // 220V
  // 220V를 110V로 변환시켜주는 어댑터가 필요
  public static void connect(Electronic110V electronic110V) {
    electronic110V.powerOn();
  }
}