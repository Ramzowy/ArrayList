import java.util.ArrayList;

public class SortedList {
    public ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    // Insert a new string into the list, maintaining sorted order
    public void insert(String value) {
        int index = binarySearch(value, 0, list.size() - 1);
        list.add(index, value);
    }

    // Binary search to find the correct insertion point
    private int binarySearch(String value, int low, int high) {
        if (low > high) {
            return low; // Return the insertion point
        }
        int mid = (low + high) / 2;
        int cmp = list.get(mid).compareTo(value);
        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            return binarySearch(value, mid + 1, high);
        } else {
            return binarySearch(value, low, mid - 1);
        }
    }

    // Search for a string in the list using binary search
    public int search(String value) {
        return binarySearch(value, 0, list.size() - 1);
    }

    // Get the list as a formatted string
    public String getListAsString() {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
