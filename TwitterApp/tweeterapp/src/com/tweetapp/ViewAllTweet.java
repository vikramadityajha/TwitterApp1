package com.tweetapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.tweetapp.dao.TweetDao;

public class ViewAllTweet {
	public static void viewAllTweet(){

	boolean leftJustifiedRows = true;

	int maxWidth = 30;
	
	List<Tweet> tweets = TweetDao.showAllTweets();
	String[][] table = new String[tweets.size()+1][4];
	for(int i = 0; i<=tweets.size();i++){
			if(i == 0){
				table[i][0] = "Tweet Id";
				table[i][1] = "Messages";
				table[i][2] = "User Id";
				table[i][3] = "Created At";
			}else{
				Tweet tweet = tweets.get(i-1);
				table[i][0] = tweets.get(i-1).getTweetId().toString();
				table[i][1] = tweets.get(i-1).getMessages();
				table[i][2] = tweets.get(i-1).getEmail();
				table[i][3] = tweets.get(i-1).getCreateAt();
			}
	}
 
	List<String[]> tableList = new ArrayList<>(Arrays.asList(table));
	List<String[]> finalTableList = new ArrayList<>();
	for (String[] row : tableList) {
		boolean needExtraRow = false;
		int splitRow = 0;
		do {
			needExtraRow = false;
			String[] newRow = new String[row.length];
			for (int i = 0; i < row.length; i++) {
				if (row[i].length() < maxWidth) {
					newRow[i] = splitRow == 0 ? row[i] : "";
				} else if ((row[i].length() > (splitRow * maxWidth))) {
					int end = row[i].length() > ((splitRow * maxWidth) + maxWidth)
							? (splitRow * maxWidth) + maxWidth
							: row[i].length();
					newRow[i] = row[i].substring((splitRow * maxWidth), end);
					needExtraRow = true;
				} else {
					newRow[i] = "";
				}
			}
			finalTableList.add(newRow);
			if (needExtraRow) {
				splitRow++;
			}
		} while (needExtraRow);
	}
	String[][] finalTable = new String[finalTableList.size()][finalTableList.get(0).length];
	for (int i = 0; i < finalTable.length; i++) {
		finalTable[i] = finalTableList.get(i);
	}
 
	Map<Integer, Integer> columnLengths = new HashMap<>();
	
	Arrays.stream(finalTable).forEach(a -> Stream.iterate(0, (i -> ++i)).limit(a.length).forEach(i -> {
		if (columnLengths.get(i) == null) {
			columnLengths.put(i, 0);
		}
		if (columnLengths.get(i) < a[i].length()) {
			columnLengths.put(i, a[i].length());
		}
	}));
 
	final StringBuilder formatString = new StringBuilder("");
	String flag = leftJustifiedRows ? "-" : "";
	columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
	formatString.append("|\n");
 
	String line = columnLengths.entrySet().stream().reduce("", (ln, b) -> {
		String templn = "+-";
		templn = templn + Stream.iterate(0, (i -> ++i)).limit(b.getValue()).reduce("", (ln1, b1) -> ln1 + "-",
				(a1, b1) -> a1 + b1);
		templn = templn + "-";
		return ln + templn;
	}, (a, b) -> a + b);
	line = line + "+\n";
 
	System.out.print(line);
	Arrays.stream(finalTable).limit(1).forEach(a -> System.out.printf(formatString.toString(), a));
	System.out.print(line);
 
	Stream.iterate(1, (i -> ++i)).limit(finalTable.length-1)
			.forEach(a -> System.out.printf(formatString.toString(), finalTable[a]));
	System.out.print(line);
	}
}
