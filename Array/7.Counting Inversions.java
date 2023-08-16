public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        int inversionCount = countInversions(arr);
        System.out.println("Number of inversions: " + inversionCount);
    }

    public static int countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversionCount += mergeSortAndCount(arr, temp, left, mid);
            inversionCount += mergeSortAndCount(arr, temp, mid + 1, right);
            inversionCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return inversionCount;
    }

    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int inversionCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return inversionCount;
    }
}
