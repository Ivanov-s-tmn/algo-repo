/*
 * Разработайте счетчик обращений, который подсчитывает количество обращений, полученных за последние 5 минут.

 * Ваша система должна принимать timestamp параметр (с точностью до секунд), и вы можете предположить,
 * что вызовы выполняются в системе в хронологическом порядке (т.е. временная метка монотонно увеличивается).
 * Несколько обращений могут поступить примерно одновременно.
 *
 * */
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ActionCounter actionCounter = new ActionCounter();
        actionCounter.call(1);
        actionCounter.call(2);
        actionCounter.call(2);
        actionCounter.call(3);
        actionCounter.call(4);
        actionCounter.call(5);
        actionCounter.call(6);
        actionCounter.call(7);
        System.out.println(actionCounter.getActions(4)); //возвращает 3 обращения
        actionCounter.call(300);
        System.out.println(actionCounter.getActions(300)); //возвращает 4 обращения
        System.out.println(actionCounter.getActions(301)); //возвращает 3 обращения
        actionCounter.call(19523);
        actionCounter.call(19801);
        System.out.println(actionCounter.getActions(19500));
        System.out.println(actionCounter.getActions(19800));
    }
}

class ActionCounter {

    private final Stack<Integer> hits;
    private static final int TIMESTAMP_INTERVAL_SEC = 300;

    public ActionCounter() {
        hits = new Stack<>();
    }

    public void call(int timestamp) {
        hits.push(timestamp);
    }

    public int getActions(int timestamp) {
        return (int) hits.stream()
                .filter(hit -> (hit > timestamp - TIMESTAMP_INTERVAL_SEC) && (hit <= timestamp)) //фильтруем по времени обращения (за последние 5 минут), т.е. при указании timestamp(301), посчитаются обращения за время от 2 до 301 секунд включительно
                .count();
    }
}