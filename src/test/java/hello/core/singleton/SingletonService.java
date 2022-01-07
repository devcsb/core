package hello.core.singleton;

public class SingletonService {


    private static final SingletonService instance = new SingletonService(); //static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.

    public static SingletonService getInstance() { // 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다.
        return instance; // 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
    }

    private SingletonService() {} // 단 하나의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막는다.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
