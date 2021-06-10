package fun.lfchen.creationalpatterns;

/**
 * 模式的定义与特点
 * 抽象工厂（AbstractFactory）模式的定义：是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 *
 * 抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。
 *
 * 使用抽象工厂模式一般要满足以下条件。
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 *
 * 抽象工厂模式除了具有工厂方法模式的优点外，其他主要优点如下。
 * 可以在类的内部对产品族中相关联的多等级产品共同管理，而不必专门引入多个新的类来进行管理。
 * 当需要产品族时，抽象工厂可以保证客户端始终只使用同一个产品的产品组。
 * 抽象工厂增强了程序的可扩展性，当增加一个新的产品族时，不需要修改原代码，满足开闭原则。
 *
 * 其缺点是：当产品族中需要增加一个新的产品时，所有的工厂类都需要进行修改。增加了系统的抽象性和理解难度。
 * 模式的结构与实现
 * 抽象工厂模式同工厂方法模式一样，也是由抽象工厂、具体工厂、抽象产品和具体产品等 4 个要素构成，但抽象工厂中方法个数不同，抽象产品的个数也不同。现在我们来分析其基本结构和实现方法。
 * 1. 模式的结构
 * 抽象工厂模式的主要角色如下。
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。
 * 具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。
 */
public class AbstractFactory {
    interface Animal{
        void animalShow();
    }

    class Horse implements Animal {

        @Override
        public void animalShow() {
            System.out.println("农场的马");
        }
    }

    class Cattle implements Animal {

        @Override
        public void animalShow() {
            System.out.println("农场的牛");
        }
    }

    interface Fruit{
        void fruitShow();
    }

    class Apple implements Fruit{

        @Override
        public void fruitShow() {
            System.out.println("苹果熟了");
        }
    }

    class Pear implements Fruit{

        @Override
        public void fruitShow() {
            System.out.println("梨子熟了");
        }
    }


    interface Farm{
        Animal createAnimal();

        Fruit createFruit();
    }

    class NorthFarm implements Farm{

        @Override
        public Animal createAnimal() {
            return new Horse();
        }

        @Override
        public Fruit createFruit() {
            return new Apple();
        }
    }

    class SouthFarm implements Farm{

        @Override
        public Animal createAnimal() {
            return new Cattle();
        }

        @Override
        public Fruit createFruit() {
            return  new Pear();
        }
    }


    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();

        NorthFarm northFarm = abstractFactory.new NorthFarm();
        Animal animal = northFarm.createAnimal();
        Fruit fruit = northFarm.createFruit();


        SouthFarm southFarm = abstractFactory.new SouthFarm();
        Animal animal1 = southFarm.createAnimal();
        Fruit fruit1 = southFarm.createFruit();

    }


}
