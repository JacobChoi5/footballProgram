package com.company;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
public class Main {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	    File scores = new File("D:\\Intellij Projects\\footballProgram\\src\\com\\company\\scores.txt");
	    Scanner read = new Scanner(scores);
	    int counter = 0;
	    String temp;

	    while(read.hasNext()){
	        read.nextLine();
			counter++;
        }

		System.out.println("scores has " + counter + " lines");
	    --counter;

	    String[] home = new String[counter];
		String[] away = new String[counter];
		int[] week = new int[counter];
		int[] winScore = new int[counter];
		int[] loseScore = new int[counter];
		int[] commas = new int[3];
		boolean[] homeWin = new boolean[counter];
		read = new Scanner(scores);
		read.nextLine();
		for (int i = 0; i < counter; i++) {
			temp = read.nextLine();
			week[i] = Character.getNumericValue(temp.charAt(5));
			commas[0] = temp.indexOf(',');
			commas[1] = temp.indexOf(',',temp.indexOf(',')+1);
			commas[2] = temp.indexOf(',',temp.indexOf(',', temp.indexOf(',')+1)+1);
			away[i] = temp.substring(commas[0]+2, commas[1]);
			home[i] = temp.substring(commas[1]+2, commas[2]);
			if(java.lang.Character.isDigit(temp.charAt(temp.length()-5))) {
				winScore[i] = Integer.parseInt(temp.substring(temp.length() - 5, temp.length() - 3));
				loseScore[i] = Integer.parseInt(temp.substring(temp.length() - 2));
			}
			else if(java.lang.Character.isDigit(temp.charAt(temp.length()-4))) {
				winScore[i] = Integer.parseInt(temp.substring(temp.length() - 4, temp.length() - 2));
				loseScore[i] = Integer.parseInt(temp.substring(temp.length() - 1));
			}
			else if(java.lang.Character.isDigit(temp.charAt(temp.length()-3))) {
				winScore[i] = Integer.parseInt(temp.substring(temp.length() - 3, temp.length() - 2));
				loseScore[i] = Integer.parseInt(temp.substring(temp.length()));
			}
			if (java.lang.Character.isUpperCase(home[i].charAt(3))){
				homeWin[i] = true;
			}
			else{
				homeWin[i] = false;
			}
			if(homeWin[i])
			System.out.format("%-3s %-5s %-3s %-10s %-3s %-10s %-3s %-3s %-3s %-10s %-3s", "Week: ", week[i], "Away: ", away[i], "Home: ", home[i], "Score: ", winScore[i], loseScore[i], "Winner: ", home[i]);
			else{
				System.out.format("%-3s %-5s %-3s %-10s %-3s %-10s %-3s %-3s %-3s %-10s %-3s", "Week: ", week[i], "Away: ", away[i], "Home: ", home[i], "Score: ", winScore[i], loseScore[i], "Winner: ", away[i]);
			}
			System.out.println();
		}

	    /*File scoresReformatted = new File("D:\\Intellij Projects\\footballProgram\\src\\com\\company\\scoresReformatted.txt");
		PrintWriter pw = new PrintWriter(scoresReformatted);*/

		/*for(int i = 0; i < counter; i++){
			for (int j = i + 1; j < counter; j++){

			}
		}*/
	}
	catch(Exception e){
		System.out.println(e.toString());
    }
    }
}
