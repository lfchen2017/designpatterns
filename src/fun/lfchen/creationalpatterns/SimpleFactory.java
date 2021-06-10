package fun.lfchen.creationalpatterns;

/**
 * 简单工厂
 */
public class SimpleFactory {
    public interface Car{
        String showCar();
    }

    public static class BMWCar implements Car{

        @Override
        public String showCar() {
            return "this is BMW";
        }
    }

    public static class TSLCar implements Car{

        @Override
        public String showCar() {
            return "this is TSL";
        }
    }

    public static class CarFactory{
        public static Car createCar(String carType){
            if("BMW".equals(carType)){
                return new BMWCar();
            }else if("TSL".equals(carType)){
                return new TSLCar();
            }
            return  null;
        }
    }

    public static void main(String[] args) {
        Car bmw = CarFactory.createCar("BMW");
        bmw.showCar();

        Car tsl = CarFactory.createCar("TSL");
        tsl.showCar();
    }
}
