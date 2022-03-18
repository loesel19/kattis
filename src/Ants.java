import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ants {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i < cases; i++){
            int length = sc.nextInt();
            int ants = sc.nextInt();
            int positions[] = new int[ants];
            //load current ant positions
            for(int j = 0; j < ants; j++){
                positions[j] = sc.nextInt();
            }
            //call shortest and longest time methods
            shortest(positions, length, ants);
            longest(positions, length, ants);
        }
    }
    public static void shortest(int positions[], int length, int ants){
        //we need an algorithm to calculate shortest paths to fall off the pole
        //we know that left end is 0 and right end is length. so we can calculate each ants minimum distance
        //to an end and the shortest time simply be the largest of these
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < ants; i++){
            int left = positions[i];
            int right = length - positions[i];
            if (left < right){
                map.put(left,left);
            }else{
                map.put(right, right);
            }
        }
        System.out.print(Collections.max(map.values()) + " ");
    }

    public static void longest(int positions[], int length, int ants){
        //ants can only collide with their neighbors, so we should send the towards their furthest away neighbor
        //0 -> left, 1 -> right
        int dir[] = new int[ants];
        for (int i = 1; i < ants - 1; i++) {
            if (positions[i] - positions[i - 1] > positions[i+1] - positions[i]){
                dir[i-1] = 1;
                dir[i] = 0;
                dir[i + 1] = 0;
            }else{
                dir[i-1] = 1;
                dir[i] = 1;
                dir[i + 1] = 0;
            }
        }
        //now we have directions laid out so lets get the maximum distance

        System.out.println();
    }
}
