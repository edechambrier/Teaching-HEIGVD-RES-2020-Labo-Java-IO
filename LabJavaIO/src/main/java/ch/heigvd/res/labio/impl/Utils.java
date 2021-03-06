package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String[] cutString = new String[2];
    int slashR = lines.indexOf('\r');
    int slashN = lines.indexOf('\n');

    int breakPoint = 0;

    if( slashR+1 == slashN){
      breakPoint = slashN;
    }else{
      breakPoint = Math.min(slashR, slashN);
    }
    if(breakPoint < 0)
      breakPoint =  Math.max(slashR, slashN);

    if(breakPoint != 0){
      cutString[0] = lines.substring(0, breakPoint+1);
      cutString[1] = lines.substring(breakPoint+1);
    }else{
      cutString[0] = "";
      cutString[1] = lines;
    }

    return cutString;
  }

}
