package ru.iskra;

public class Utils {

    /*  Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     иначе в методе необходимо выбросить RuntimeException. */
    public int[]  last_four_array(int[] arr) {
        int ret[] = new int[0];

        if(arr == null) {
            return ret;
        }

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                index = i;
            }
        }

        if(index < 0) {
            throw new RuntimeException();
        }

        index++;
        ret = new int[arr.length - index];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = arr[index];
            index++;
        }

        return ret;
    }

    /* Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false */
    boolean is1and2(int[] arr) {
        boolean is1 = false;
        boolean is4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) is1 = true;
            if (arr[i] == 4) is4 = true;
        }
        return ( is1 || is4 );
    }
}
