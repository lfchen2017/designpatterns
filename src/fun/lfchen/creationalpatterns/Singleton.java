package fun.lfchen.creationalpatterns;


/**
 *  饿汉 单例模式
 */
public class Singleton {
    private Singleton(){};

    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getSingleton();
    }
}
