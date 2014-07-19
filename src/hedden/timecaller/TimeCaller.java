/* Time Caller Java CLI Application
 * Author: Michael Hedden
 * Creation Date: ?
 * Last Modified 2014-07-19
 * 
 * TODO:
 * - Add documentation
 * - modularize the callTime into an object so I can properly clean up after the sound is finished playing.
 */

package hedden.timecaller;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class TimeCaller {
	//members
	private static int interval = -1;
	private static Timer timer;
	private static boolean isTimerSet = false;
	private static final int SOUND_DELAY = 300;
	private static final int SOUND_GAP = 250;
	private static final int MINUTE_IN_MILLISECONDS = 60000; //60000
	private static final String SOUND_PATH = "\\wav\\";

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		if(args.length > 0){
			switch(args[0]){
			case "-m":
				setInterval(Integer.parseInt(args[1]));
				break;
			default:
				setInterval(5);
			}
		}else{
			setInterval(1);
		}
		
		startTimer();
		while(isTimerSet){
			Console cnsl = null;
		    String input = null;
		      
		    try{
		       // creates a console object
		       cnsl = System.console();
		
		       // if console is not null
		       if (cnsl != null) {
		            
		          // read line from the user input
		    	  System.out.println("\nCurrent Interval: " + interval + " minutes.\n\nTo stop enter 'y'.\nTo change interval enter an integer.");
		          input = cnsl.readLine("input> ");
		            
		          if(input.toLowerCase().equals("yes") || input.toLowerCase().equals("y") ){
		        	  stopTimer();
		          }else if(isInteger(input)){
		        	  setInterval(Integer.parseInt(input));
		          }
		       }      
		    }catch(Exception ex){
		       ex.printStackTrace();      
		    }
		}

	}
	
	//method used to set the interval at which time is called out
	//method:setInterval(int a)
	private static void setInterval(int a){
		interval = a;	
		if(isTimerSet){
    		stopTimer();
    		Reminder(interval * MINUTE_IN_MILLISECONDS);
		}
	}
	
	//method used to start the timer
	//method:startTimer()
	public static void startTimer(){
		Reminder(interval * MINUTE_IN_MILLISECONDS);
	}
	

	public static void Reminder(long ms) {
        timer = new Timer();
        timer.schedule(new RemindTask(), ms, ms);
        isTimerSet = true;
	}

    static class RemindTask extends TimerTask {
        public void run() {
        	callTime();
        }
    }
	
	private static void callTime(){
		Date date = new Date();
		SimpleDateFormat hour = new SimpleDateFormat("H");
		SimpleDateFormat minutes = new SimpleDateFormat("m");
		try {
			callTimeSound(Integer.parseInt(hour.format(date)), Integer.parseInt(minutes.format(date)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	private static void stopTimer(){
		timer.cancel();
		isTimerSet = false;
	}
	

	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	
	
	public static void callTimeSound(int hr, int min) throws InterruptedException{
		switch(hr){
		case 0: 
			playSound("0.wav");
			break;
		case 1:
			playSound("1.wav");
			break;
		case 2:
			playSound("2.wav");
			break;
		case 3:
			playSound("3.wav");
			break;
		case 4:
			playSound("4.wav");
			break;
		case 5:
			playSound("5.wav");
			break;
		case 6:
			playSound("6.wav");
			break;
		case 7:
			playSound("7.wav");
			break;
		case 8:
			playSound("8.wav");
			break;
		case 9:
			playSound("9.wav");
			break;
		case 10:
			playSound("10.wav");
			break;
		case 11:
			playSound("11.wav");
			break;
		case 12:
			playSound("12.wav");
			break;
		case 13:
			playSound("13.wav");
			break;
		case 14:
			playSound("14.wav");
			break;
		case 15:
			playSound("15.wav");
			break;
		case 16:
			playSound("16.wav");
			break;
		case 17:
			playSound("17.wav");
			break;
		case 18:
			playSound("18.wav");
			break;
		case 19:
			playSound("19.wav");
			break;
		case 20:
			playSound("20.wav");
			break;
		case 21:
			playSound("20.wav");
			playSound("1.wav");
			break;
		case 22:
			playSound("20.wav");
			playSound("2.wav");
			break;
		case 23:
			playSound("20.wav");
			playSound("3.wav");
			break;
		}
		Thread.sleep(SOUND_GAP); //adding 200 ms to time in between hours and minutes.
		switch(min){
		case 0: 
			playSound("0.wav"); //TODO make sound "o'clock"
			break;
		case 1:
			playSound("0.wav");  
			playSound("1.wav"); 
			break;
		case 2:
			playSound("0.wav");  
			playSound("2.wav"); 
			break;
		case 3:
			playSound("0.wav");  
			playSound("3.wav"); 
			break;
		case 4:
			playSound("0.wav");  
			playSound("4.wav"); 
			break;
		case 5:
			playSound("0.wav");  
			playSound("5.wav"); 
			break;
		case 6:
			playSound("0.wav");  
			playSound("6.wav"); 
			break;
		case 7:
			playSound("0.wav");  
			playSound("7.wav"); 
			break;
		case 8:
			playSound("0.wav");  
			playSound("8.wav"); 
			break;
		case 9:
			playSound("0.wav");  
			playSound("9.wav"); 
			break;
		case 10:
			playSound("10.wav"); 
			break;
		case 11:
			playSound("11.wav"); 
			break;
		case 12:
			playSound("12.wav"); 
			break;
		case 13:
			playSound("13.wav"); 
			break;
		case 14:
			playSound("14.wav"); 
			break;
		case 15:
			playSound("15.wav"); 
			break;
		case 16:
			playSound("16.wav"); 
			break;
		case 17:
			playSound("17.wav"); 
			break;
		case 18:
			playSound("18.wav"); 
			break;
		case 19:
			playSound("19.wav"); 
			break;
		case 20:
			playSound("20.wav"); 
			break;
		case 21:
			playSound("20.wav"); 
			playSound("1.wav"); 
			break;
		case 22:
			playSound("20.wav"); 
			playSound("2.wav"); 
			break;
		case 23:
			playSound("20.wav"); 
			playSound("3.wav"); 
			break;
		case 24:
			playSound("20.wav"); 
			playSound("4.wav"); 
			break;
		case 25:
			playSound("20.wav"); 
			playSound("5.wav"); 
			break;
		case 26:
			playSound("20.wav"); 
			playSound("6.wav"); 
			break;
		case 27:
			playSound("20.wav"); 
			playSound("7.wav"); 
			break;
		case 28:
			playSound("20.wav"); 
			playSound("8.wav"); 
			break;
		case 29:
			playSound("20.wav"); 
			playSound("9.wav"); 
			break;
		case 30:
			playSound("30.wav"); 
			break;
		case 31:
			playSound("30.wav"); 
			playSound("1.wav"); 
			break;
		case 32:
			playSound("30.wav"); 
			playSound("2.wav"); 
		case 33:
			playSound("30.wav"); 
			playSound("3.wav"); 
			break;
		case 34:
			playSound("30.wav"); 
			playSound("4.wav"); 
			break;
		case 35:
			playSound("30.wav"); 
			playSound("5.wav"); 
			break;
		case 36:
			playSound("30.wav"); 
			playSound("6.wav"); 
			break;
		case 37:
			playSound("30.wav"); 
			playSound("7.wav"); 
			break;
		case 38:
			playSound("30.wav"); 
			playSound("8.wav"); 
			break;
		case 39:
			playSound("30.wav"); 
			playSound("9.wav"); 
			break;
		case 40:
			playSound("40.wav"); 
			break;
		case 41:
			playSound("40.wav"); 
			playSound("1.wav"); 
			break;
		case 42:
			playSound("40.wav"); 
			playSound("2.wav"); 
			break;
		case 43:
			playSound("40.wav"); 
			playSound("3.wav"); 
			break;
		case 44:
			playSound("40.wav"); 
			playSound("4.wav"); 
			break;
		case 45:
			playSound("40.wav"); 
			playSound("5.wav"); 
			break;
		case 46:
			playSound("40.wav"); 
			playSound("6.wav"); 
			break;
		case 47:
			playSound("40.wav"); 
			playSound("7.wav"); 
			break;
		case 48:
			playSound("40.wav"); 
			playSound("8.wav"); 
			break;
		case 49:
			playSound("40.wav"); 
			playSound("9.wav"); 
			break;
		case 50:
			playSound("50.wav");
			break;
		case 51:
			playSound("50.wav");
			playSound("1.wav");
			break;
		case 52:
			playSound("50.wav");
			playSound("2.wav");
			break;
		case 53:
			playSound("50.wav");
			playSound("3.wav");
			break;
		case 54:
			playSound("50.wav");
			playSound("4.wav");
			break;
		case 55:
			playSound("50.wav");
			playSound("5.wav");
			break;
		case 56:
			playSound("50.wav");
			playSound("6.wav");
			break;
		case 57:
			playSound("50.wav");
			playSound("7.wav");
			break;
		case 58:
			playSound("50.wav");
			playSound("8.wav");
			break;
		case 59:
			playSound("50.wav");
			playSound("9.wav");

			break;
		}
		Thread.sleep(SOUND_GAP); //adding 200 ms to time in between hours and minutes.
	}
	
	
	public static void playSound(String fileName) {
		String curPath = System.getProperty("user.dir");
		fileName = curPath + SOUND_PATH + fileName; 
    	File file = new File(fileName).getAbsoluteFile();
        AudioInputStream audioInputStream = null; //AudioSystem.getAudioInputStream(file);
        Clip clip = null; // AudioSystem.getClip();
	    try {
	        audioInputStream = AudioSystem.getAudioInputStream(file);
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.addLineListener(new LineListener(){
				public void update(LineEvent arg0) {
					if(arg0.getType() == LineEvent.Type.STOP){
                        arg0.getLine().close();
                    }
				}
            });
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    } finally{
	        try {
				Thread.sleep(SOUND_DELAY);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	    	try {
				audioInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	//clip.close(); //was stopping the sound executing before it would finish
	    }
	}

}
