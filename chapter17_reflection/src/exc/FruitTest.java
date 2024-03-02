package exc;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

/**
 * ClassName:FruitTest
 * Description:
 *
 * @Auther Wen Li
 * @Create 2024/2/26 21:20
 * @Version 1.0
 **/
public class FruitTest {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();

        File file = new File("D:\\java_project\\JavaCode\\chapter17_reflection\\src\\config.properties");
        FileInputStream fis = new FileInputStream(file);

        pro.load(fis);

        String fruitName = pro.getProperty("fruitName");
        Class clazz = Class.forName(fruitName);

        Constructor constructor = clazz.getDeclaredConstructor();

        constructor.setAccessible(true);

        Fruit fruit = (Fruit) constructor.newInstance();

        Juicier juicier = new Juicier();
        juicier.run(fruit);
    }
}
