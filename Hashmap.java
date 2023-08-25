import java.util.*;
//Name: Rushik Guduru
//NetID: rxg200049

class Hash {

    public static void heapify(Integer[] arr) {
        for (int i = arr.length/2-1; i >= 0; i--) {
            heapSort(arr, i, arr.length);
        }
    }

    public static void heapSort(Integer[] arr, int n, int i){
        int leftChild = n*2+1;
        int rightChild = n*2+2;
        int smallest = n;

        if (leftChild < i && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }

        if (rightChild < i && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        if (smallest != n) {
            swap(arr, n, smallest);
            heapSort(arr, smallest, i);
        }

    }

    public static void removeMin(HashMap<Integer, Double> employees, Integer[] keys, int end) {
        int min = keys[0];
        keys[0] = keys[end];
        heapSort(keys, 0, end);

        employees.remove(min);
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Double> employees = new HashMap<>();

        String dec = "Y";
        while(dec.equals("Y")){
            System.out.println("Do you want to enter the employee information: (Y/N)");
            dec = sc.next();
            if(dec.equals("Y")){
                System.out.println("Enter employee number: ");
                int empNum = sc.nextInt();
                System.out.println("Enter hourly rate: ");
                double rate = sc.nextDouble();
                employees.put(empNum, rate);
            }else{
                break;
            }

        }


        Integer[] key = employees.keySet().toArray(new Integer[0]);
        heapify(key);

        System.out.println("Sorted employees:");
        for (int i = 0; i < key.length; i++) {
            int employeeNum = key[i];
            double hourlyRate = employees.get(employeeNum);
            System.out.println(employeeNum + " " + hourlyRate);
        }

        System.out.println("Do you want to delete a record: (Y/N)");
        dec = sc.next();
        while(dec.equals("Y")){
            System.out.println("Enter employee number to delete: ");
            int empNum = sc.nextInt();
            if(employees.containsKey(empNum)){
                employees.remove(empNum);
                key = employees.keySet().toArray(new Integer[0]);
                heapify(key);

                System.out.println("Updated sorted employees:");
                for (int i = 0; i < key.length; i++) {
                    int employeeNum = key[i];
                    double hourlyRate = employees.get(employeeNum);
                    System.out.println(employeeNum + " " + hourlyRate);
                }
            }else{
                System.out.println("Employee not found");
            }
            System.out.println("Do you want to delete another record: (Y/N)");
            dec = sc.next();
        }
    }
}
