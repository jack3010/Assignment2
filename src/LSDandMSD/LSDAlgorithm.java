package LSDandMSD;

public class LSDAlgorithm {

    public static void main(String[] args) {
        String[] sampleData = new String[]{"password", "wordpass", "w01dp4ss", "p455w0rd",
                "2assw0rd", "drowssap", "ssapdrow"};
        sort(sampleData);
        int sampleDataLength = sampleData.length;
        for (int i = 0; i < sampleDataLength; ++i) {
            System.out.println(sampleData[i]);
        }
    }

    public static int findLongestLength(String[] inputArray) {
        int longest = 0;
        for (int i = 0; i < inputArray.length; ++i) {
            if (inputArray[i].length() > longest) {
                longest = inputArray[i].length();
            }
        }
        return longest;
    }

    public static int findCharAtInString(int stringPosition, int characterPosition, String[] inputArray) {
        if (characterPosition < 0 || characterPosition >= inputArray[stringPosition].length()) {
            return 0;
        }
        return inputArray[stringPosition].charAt(characterPosition);
    }

    public static void sort(String[] inputArray) {
        int arrayLength = inputArray.length;
        int R = 256;    // extended ASCII alphabet size.
        String[] aux = new String[arrayLength];
        int w = findLongestLength(inputArray);  // w is the length of longest string in a.
        for (int d = w - 1; d >= 0; d--) {
            // sort by key-indexed counting on dth character

            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < arrayLength; ++i) {
                int c = findCharAtInString(i, d, inputArray);
                count[c + 1]++;
            }

            // compute cumulates
            for (int r = 0; r < R; ++r) {
                count[r + 1] += count[r];
            }

            // move data
            for (int i = 0; i < arrayLength; ++i) {
                int c = findCharAtInString(i, d, inputArray);
                aux[count[c]++] = inputArray[i];
            }

            // copy back
            for (int i = 0; i < arrayLength; ++i) {
                inputArray[i] = aux[i];
                System.out.println(inputArray[i]);
            }
            System.out.println("=======================================================");
        }
    }
}
