import java.util.Arrays;

public class Board {

	static int Cube = 99;

	static String CubeColor = "NoColor";

	int Num [] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};

	static double Balance = 1000;

	public static String Bets [][] = {{"Red","Black","Even","Odd","1to12","13to24","25to36","1to18","19to36","Col1","Col2","Col3"},{"0","0","0","0","0","0","0","0","0","0","0","0"}};

	public static void MakeBet(int bet1 , int bet2 , int bet3 , int bet4 , int bet5 , int bet6 , int bet7 , int bet8 , int bet9 , int bet10 , int bet11 , int bet12 ) {
		int Total = bet1+bet2+bet3+bet4+bet5+bet6+bet7+bet8+bet9+bet10+bet11+bet12;
		Balance = Balance - Total;
		Bets[1][0] = String.valueOf(bet1);
		Bets[1][1] = String.valueOf(bet2);
		Bets[1][2] = String.valueOf(bet3);
		Bets[1][3] = String.valueOf(bet4);
		Bets[1][4] = String.valueOf(bet5);
		Bets[1][5] = String.valueOf(bet6);
		Bets[1][6] = String.valueOf(bet7);
		Bets[1][7] = String.valueOf(bet8);
		Bets[1][8] = String.valueOf(bet9);
		Bets[1][9] = String.valueOf(bet10);
		Bets[1][10] = String.valueOf(bet11);
		Bets[1][11] = String.valueOf(bet12);
	}

	public static void PrintBets() {
		for (int i = 0; i < 12 ; i++) {
			if (!(Bets[1][i].equals("0"))) {
				System.out.print(Bets[0][i]);
				System.out.println(" - "+Bets[1][i]);
			}	
		}
	}

	public static void PrintAllBets() {
		for (int i = 0; i < 12 ; i++) {
			System.out.print(Bets[0][i]);
			System.out.println(" - "+Bets[1][i]);
		}
	}

	public static void ColorDeter() {
		//1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36    are Reds
		//   0 is Red , 1 is Black , 2 is Zero , 3 is default cube 99 that's roll error
		if ((Cube == 1)||(Cube == 3)||(Cube == 5)||(Cube == 7)||(Cube == 9)||(Cube == 12)||(Cube == 14)||(Cube == 16)||(Cube == 18)||(Cube == 19)||(Cube == 21)||(Cube == 23)||(Cube == 25)||(Cube == 27)||(Cube == 30)||(Cube == 32)||(Cube == 34)||(Cube == 36)) {
			CubeColor = "Red";
		}else if (Cube == 0) {
			CubeColor = "Zero";
		}else if (Cube == 99) {
			CubeColor = "NoColor";
		}else {
			CubeColor = "Black";
		}
		//		System.out.println("Cube Number "+"["+Cube+"]");
		//		System.out.println("Cube Color "+"["+CubeColor+"]");
	}

	public static void CubeRoll () {
		Cube = (int)(Math.random()*37);
		ColorDeter();
	}

	public static int CalculateBets() {
		//////////////////////// 1ST BET "RED" /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][0])>0) {
			if (CubeColor.equals("Red")) {
				//System.out.println("Bet [-"+Integer.parseInt(Bets[1][0])+"] , Win [+"+(2*(Integer.parseInt(Bets[1][0])))+"] , Result ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][0]));
				//PrintBalance();
				return 1;
			}else if (CubeColor.equals("Black")||CubeColor.equals("Zero")) {
				//System.out.println("Bet [-"+Integer.parseInt(Bets[1][0])+"] ,  Result ["+Cube+","+CubeColor+"]");
				//PrintBalance();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 2ND BET "BLACK" /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][1])>0) {
			if (CubeColor.equals("Red")) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][1])+"] , Win [+"+(2*(Integer.parseInt(Bets[1][1])))+"] , Result ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][1]));
			//	PrintBalance();
			}else if (CubeColor.equals("Black")||CubeColor.equals("Zero")) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][1])+"] ,  Result ["+Cube+","+CubeColor+"]");
			//	PrintBalance();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 3RD BET "EVEN" /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][2])>0) {
			if (Cube%2 == 0) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][2])+"] , Win [+"+(2*(Integer.parseInt(Bets[1][2])))+"] , Result ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][2]));
			//	PrintBalance();
			}else if (Cube%2 == 1) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][2])+"] ,  Result ["+Cube+","+CubeColor+"]");
			//	PrintBalance();
			}else if (Cube == 0) {
				System.out.println("Bet [-"+Integer.parseInt(Bets[1][2])+"] ,  Result ["+Cube+","+CubeColor+"]");
			//	PrintBalance();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 4TH BET "ODD" /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][3])>0) {
			if (Cube%2 == 1) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][3])+"] , Win [+"+(2*(Integer.parseInt(Bets[1][3])))+"] , Result ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][3]));
			//	PrintBalance();
			}else if (Cube%2 == 0) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][3])+"] ,  Result ["+Cube+","+CubeColor+"]");
		//		PrintBalance();
			}else if (Cube == 0) {
			//	System.out.println("Bet [-"+Integer.parseInt(Bets[1][3])+"] ,  Result ["+Cube+","+CubeColor+"]");
			//	PrintBalance();
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 5TH BET 1to12 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][4])>0) {
			if (Cube >= 1 && Cube <= 12) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][4]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 6TH BET 13to24 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][5])>0) {
			if (Cube >= 13 && Cube <= 24) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][5]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 7TH BET 25to36 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][6])>0) {
			if (Cube >= 25 && Cube <= 36) {
			//	System.out.println("Winner !");
			//	System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][6]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 8TH BET 1to18 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][7])>0) {
			if (Cube >= 1 && Cube <= 18) {
			//	System.out.println("Winner !");
			//	System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][7]));
			}else {
			//	System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 9TH BET 19to36 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][8])>0) {
			if (Cube >= 19 && Cube <= 36) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(2*Integer.parseInt(Bets[1][8]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 10TH BET Col1 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][9])>0) {
			if (Cube%3 == 1 ) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][9]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 11TH BET Col2 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][10])>0) {
			if (Cube%3 == 2 ) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][10]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////// 12TH BET Col3 /////////////////////////////////////////////////////////////////////////////
		if (Integer.parseInt(Bets[1][11])>0) {
			if (Cube%3 == 0 ) {
		//		System.out.println("Winner !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
				Balance = Balance+(3*Integer.parseInt(Bets[1][11]));
			}else {
		//		System.out.println("Loser !");
		//		System.out.println("Number and Color = ["+Cube+","+CubeColor+"]");
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
return 0;
	}

	public static void PrintBalance() {
		System.out.println("Balance - ["+Balance+"]");
	}
	
	public static double RunGames () {
		double ten = 10;
		for (int i = 0; (i < 300) && (ten <2561) ; i++) {
		//	System.out.println("Game No. ["+i+"]");
		//	PrintBalance();
			MakeBet(0,0,0,0,(int)ten,(int)ten,0,0,0,0,0,0);
			CubeRoll();
			if (CalculateBets()==1) {
			//	System.out.println("Restart Bet [10]");
				ten = 10;
			}else {
				ten = ten*2;
			}	
		}
		return Balance;
	}
	
	public static void main(String[] args) {
		double wins = 0;
		double loses = 0;
		
		for (int i = 0; i < 10000; i++) {
			Balance = 1000;
			double newBalance = RunGames();
			//System.out.println(newBalance);
			if (newBalance<=1000) {
				loses++;
			}else if (newBalance>1000) {
				wins++;
			}
		}
		
		System.out.println("Wins = "+wins+"    Loses = "+loses);
		
		double winRatio = (wins/(wins+loses));

		System.out.println("Wins Percantage on 300 Games 100,000 times = ["+winRatio+"%]");


	}

}
