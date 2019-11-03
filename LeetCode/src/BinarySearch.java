public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,8};
        System.out.println(binarySearch(arr,0,4,6));
    }
    public static boolean binarySearch(int[] arr,int start,int end,int target){
        int mid = (start+end)/2;
        if(start>end){
            return false;
        }
        if(arr[mid]==target){
            return true;
        }
        if(target<arr[mid]) {
            return binarySearch(arr, start, mid - 1, target);
        }else if(target>arr[mid]){
            return binarySearch(arr,mid+1,end,target);
        }
        return false;
    }
}
