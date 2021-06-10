package fun.lfchen.creationalpatterns;

/**
 * 模式的定义与特点
 * 建造者（Builder）模式的定义：指将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 *
 * 该模式的主要优点如下：
 * 封装性好，构建和表示分离。
 * 扩展性好，各个具体的建造者相互独立，有利于系统的解耦。
 * 客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。
 *
 * 其缺点如下：
 * 产品的组成部分必须相同，这限制了其使用范围。
 * 如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。
 *
 * 建造者（Builder）模式和工厂模式的关注点不同：建造者模式注重零部件的组装过程，而工厂方法模式更注重零部件的创建过程，但两者可以结合使用。
 * 模式的结构与实现
 * 建造者（Builder）模式由产品、抽象建造者、具体建造者、指挥者等 4 个要素构成，现在我们来分析其基本结构和实现方法。
 * 1. 模式的结构
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 */
public class Builder {
    /**
     * 客厅
     */
    class Parlour {
        /**
         * 墙
         */
        String wall;
        /**
         * 电视
         */
        String tv;
        /**
         * 沙发
         */
        String sofa;

        public String getWall() {
            return wall;
        }

        public void setWall(String wall) {
            System.out.println(wall);
            this.wall = wall;
        }

        public String getTv() {
            return tv;
        }

        public void setTv(String tv) {
            System.out.println(tv);
            this.tv = tv;
        }

        public String getSofa() {
            return sofa;
        }

        public void setSofa(String sofa) {
            System.out.println(sofa);
            this.sofa = sofa;
        }
    }

    /**
     * 装修工人
     */
    abstract class Decorator{
        Parlour parlour = new Parlour();
        public abstract void buildWall();
        public abstract void buildTv();
        public abstract void buildSofa();

        public Parlour getParlour(){
            return this.parlour;
        }
    }

    class DecoratorZhangSan extends Decorator{

        @Override
        public void buildWall() {
            parlour.setWall("张三建的墙壁");
        }

        @Override
        public void buildTv() {
            parlour.setTv("张三买的电视");
        }

        @Override
        public void buildSofa() {
            parlour.setSofa("张三买的沙发");
        }


    }

    class DecoratorLiSi extends Decorator{

        @Override
        public void buildWall() {
            parlour.setWall("李四建的墙壁");
        }

        @Override
        public void buildTv() {
            parlour.setTv("李四买的电视");
        }

        @Override
        public void buildSofa() {
            parlour.setSofa("李四买的沙发");
        }
    }

    /**
     * 装修领队
     */
    class DecoratorLeader{
        private Decorator builder;

        public DecoratorLeader(Decorator builder) {
            this.builder = builder;
        }

        //产品构建与组装方法
        public Parlour decorate() {
            builder.buildWall();
            builder.buildTv();
            builder.buildSofa();
            return builder.getParlour();
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();

        DecoratorZhangSan decoratorZhangSan = builder.new DecoratorZhangSan();
        DecoratorLiSi decoratorLiSi = builder.new DecoratorLiSi();

        DecoratorLeader zhangSanLeader = builder.new DecoratorLeader(decoratorZhangSan);
        Parlour zhangSanBuildParlour = zhangSanLeader.decorate();


        DecoratorLeader liSiLeader = builder.new DecoratorLeader(decoratorLiSi);
        Parlour liSiBuildParlour = liSiLeader.decorate();


    }

}
