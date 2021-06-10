package fun.lfchen.creationalpatterns;

/**
 * 工厂方法模式
 * 在《简单工厂模式》一节我们介绍了简单工厂模式，提到了简单工厂模式违背了开闭原则，而“工厂方法模式”是对简单工厂模式的进一步抽象化，其好处是可以使系统在不修改原来代码的情况下引进新的产品，即满足开闭原则。
 * 优点：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
 * 灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
 * 典型的解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。
 * 缺点：
 * 类的个数容易过多，增加复杂度
 * 增加了系统的抽象性和理解难度
 * 抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
 * 应用场景：
 * 客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
 * 创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
 * 客户不关心创建产品的细节，只关心产品的品牌
 */
public class FactoryMethod {
    /**
     * 抽象动物
     */
    interface Animal{
        void show();
    };

    class Horse implements Animal{

        @Override
        public void show() {
            System.out.println("农场的马");
        }
    }

    class Cattle implements Animal{

        @Override
        public void show() {
            System.out.println("农场的牛");
        }
    }


    /**
     * 抽象农场
     */
    interface AnimalFarm{
        Animal createAnimal();
    }

    public class HorseFarm implements AnimalFarm{

        @Override
        public Animal createAnimal() {
            return new Horse();
        }
    }

    public class CattleFarm implements AnimalFarm{

        @Override
        public Animal createAnimal() {
            return new Cattle();
        }
    }

    public static void main(String[] args) {
        FactoryMethod factoryMethod = new FactoryMethod();

        FactoryMethod.HorseFarm horseFarm = factoryMethod.new HorseFarm();
        Animal horse = horseFarm.createAnimal();

        CattleFarm cattleFarm = factoryMethod.new CattleFarm();
        Animal cattle = cattleFarm.createAnimal();

        horse.show();
        cattle.show();



    }



}
