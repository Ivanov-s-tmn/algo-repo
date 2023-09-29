/*
Дана деревянная планка длиной n единиц, по которой бегают 2 муравья со скоростью 1 единица за ход.
Один муравей ходит влево left, другой вправо right. Первым ходит левый муравей. 1 ход состоит из хода левого и правого муравья.
Если один из муравьев на своем ходу должен сходить на занятую другим муравьем клетку, они оба меняют направление движения
и ходит текущий муравей. Ходы продолжаются пока первый муравей не упадет с планки.

Реализовать метод int calculate(int n, int left, int right), возвращающий количество шагов, за которое первый муравей упадет с планки
 */


public class WoodenPlankSolution {
    public static void main(String[] args) {
        System.out.println(calculate(4, 1, 3));
        System.out.println(calculate(4, 4, 1));
        System.out.println(calculate(4, 4, 3));
        System.out.println(calculate(3, 3, 1));
        System.out.println(calculate(5, 5, 1));
    }

    public static int calculate(int n, int left, int right) {

        boolean isDirectionChanged = false;//флаг для смены направления, если один из муравьев наступит на другого
        int stepsCount = 0; //счетчик шагов

        if (left > right) { //если положение левого больше правого, значит они будут идти навстречу друг другу и в итоге вынуждены будут развернуться
            int distanceBetween = left - right;
            while (distanceBetween != 1) { //если муравьи на соседних клетках, то сразу разворачиваем их и меняем направление движения
                left--;
                distanceBetween--;
                if (distanceBetween == 1) { //если после хода левого муравья дистанция сокращается до одной клетки, то правый ходить не может - меняем направление
                    break;
                }
                right++;
                distanceBetween--;
                stepsCount++;
            }
            isDirectionChanged = true;
        }

        while (left <= n && left >= 0 && right <= n && right >= 0) { //пока один из муравьев не упадет с доски
            if (isDirectionChanged) { //если было изменено направление движения, то шагаем в противоположные стороны
                left++;
                right--;
            } else { //иначе шагаем как обычно
                left--;
                right++;
            }
            stepsCount++;
        }
        return stepsCount;
    }
}
