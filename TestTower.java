import java.util.Scanner;

public class TestTower{
	public static void main(String[] args) {

		//K - The number of mobile phones
		//N - Number of tower layers

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the number of phones");
		int number_of_phones = Integer.parseInt(userInput.nextLine());  // Read user input

		System.out.println("Enter the number of tower layers");
		int number_of_tower_layers = Integer.parseInt(userInput.nextLine());  // Read user input


		if(number_of_phones > 0 && number_of_phones < 100 && number_of_tower_layers > 0 && number_of_tower_layers < Math.pow(10, 4) ){
			int result = number_of_tests(number_of_phones, number_of_tower_layers);
			System.out.format("The number of tests required would be %d%n", result);
		}
		else if(number_of_phones == -1){
			System.exit(0);
		}else{
			System.out.println("The number of phones allowed are 1-100\nThe number of tower layers allowed are 1- 10^4");
		}
	}
	public static int number_of_tests( int K ,int N) {
		if (K == 1) {
			return N;
		}
		 int[][] d = new int[N + 1][K + 1];
		 for (int i = 1; i != d.length; i++) {
			d[i][1] = i;
		}
		 for (int n = 1; n <d.length; n++) {
			 for (int ph = 2; ph <d[0].length; ph++) {
				int min = Integer.MAX_VALUE;
				for (int i = 1; i < n + 1; i++) {
					 int broken = d [i-1][ph-1];
					 int not_broken = d [n-i][ph];
					 int the_number_of_worst_luck = Math.max(broken, not_broken);
					 min = Math.min(min, the_number_of_worst_luck);
				}
				d[n][ph] = min + 1;
			}
		}
		return d[N][K];
	}
}
