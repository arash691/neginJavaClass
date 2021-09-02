package javabasic.session3;

/**
 * Created by arash on 02.09.21.
 */

public class Session3 {

    //یک آرایه از کاراکتر دریافت کند و طول طولانی ترین کلمه را برگرداند

    static int getMaxWordLength(char[] array) {
        //"this is a book"
        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 0;
            }
        }
        return maxLen;
    }
    static char[] getMaxWord(char[] array) {
        int maxLen = 0;
        int len = 0;
        int firstLetterMaxWordIndex = 0;
        int lastLetterMaxWordIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                    lastLetterMaxWordIndex = i - 1;
                    int j = lastLetterMaxWordIndex;
                    while (!(j == 0 || array[j] == ' ')) {
                        j--;
                    }
                    firstLetterMaxWordIndex = j;
                }
                len = 0;
            }
        }
        // index out of range
        char[] maxLengthWord = new char[lastLetterMaxWordIndex - firstLetterMaxWordIndex + 1];
        int j = 0;
        for (int i = firstLetterMaxWordIndex; i <= lastLetterMaxWordIndex; i++) {
            maxLengthWord[j++] = array[i];
        }
        return maxLengthWord;
    }

    public static void main(String[] args) {
        char[] array = {'i',' ' ,'t','h', 'i', 's', ' ', 'a'};
        System.out.println(getMaxWord(array));
    }
}

