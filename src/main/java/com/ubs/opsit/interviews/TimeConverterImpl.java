package com.ubs.opsit.interviews;

public class TimeConverterImpl implements TimeConverter{

	private final String YELLOW="Y";
	private final String OFF="O";
	private final String RED="R";
	private final String LINE_BREAK="\n";
	private final int CLOCK_PRECISION=5;
	private final int ROW_BULB_COUNT=4;
	private final int THIRD_ROW_BULB_COUNT=11;
	@Override
	public String convertTime(String aTime) {
		/**
		 * Assuming input will be in HH:MM:SS format
		 * */
		StringBuilder sb=new StringBuilder();
		String[] timeArr=aTime.split("\\:");
		//System.out.println(Arrays.toString(timeArr));
		int hr=Integer.parseInt(timeArr[0]);
		int mm=Integer.parseInt(timeArr[1]);
		int ss=Integer.parseInt(timeArr[2]);
		
		if(ss%2==0){// First yellow bulb will on for even Seconds
			sb.append(YELLOW);
		}
		else{// OFF for odd seconds
			sb.append(OFF);
		}
		
		sb.append(LINE_BREAK);
		getHoursRows(hr,sb);
		getMinutesRows(mm,sb);
		
		System.out.println(sb.toString());
		return sb.toString();
	}

	private void getHoursRows(int totalHr,StringBuilder sb){
		
		int firstRowOnBulb=totalHr/CLOCK_PRECISION;
		int secondRowOnBulb=totalHr%CLOCK_PRECISION;
		
		// Adding First Red Row in Buffer
		for(int i=1;i<=ROW_BULB_COUNT;i++){
			
			if(firstRowOnBulb>0){
				sb.append(RED);
				firstRowOnBulb--;
			}
			else{
				sb.append(OFF);
			}
		}
		sb.append(LINE_BREAK);
		
	   // Adding Second Red Row in Buffer
      for(int i=1;i<=ROW_BULB_COUNT;i++){
			
			if(secondRowOnBulb>0){
				sb.append(RED);
				secondRowOnBulb--;
			}
			else{
				sb.append(OFF);
			}
		}
       sb.append(LINE_BREAK);
	}
	
	private void getMinutesRows(int totalMm,StringBuilder sb){
		
		int thirdRowOnBuld=totalMm/CLOCK_PRECISION;
		int forthRowOnBUld=totalMm%CLOCK_PRECISION;
		
		//Adding third Yellow row 11 Bulbs
		for(int i=1;i<=THIRD_ROW_BULB_COUNT;i++){
			if(thirdRowOnBuld>0){
				if(i%3==0)// Checking Quarter of minute
				    sb.append(RED);
				else
					sb.append(YELLOW);
				
				thirdRowOnBuld--;
			}
			else{
				sb.append(OFF);
			}
		}
		sb.append(LINE_BREAK);
		
		//Adding fourth Yellow row 4 Bulbs
		for(int i=1;i<=ROW_BULB_COUNT;i++){
			if(forthRowOnBUld>0){
				sb.append(YELLOW);
				forthRowOnBUld--;
			}
			else{
				sb.append(OFF);
			}
		}
	}
  public static void main(String arg[]){
	  TimeConverterImpl imp=new TimeConverterImpl();
	  
	  imp.convertTime("11:59:58");
  }
}
