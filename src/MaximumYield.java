/**
 * A class to find the maximum yield from a given strip 
 *
 * @author Lydia
 */

public class MaximumYield {

	/**
	 * Method takes a strip string and calculates the maximum yield.
	 *
	 * @param strip - A string of mines information
	 * @return Maximum yield for a given strip returned as integer.
	 */
	
    public int findMaximumYield(String strip) throws ApplicationException{
    	
    	//Check if the input strip is empty
    	if(strip == null || "".equals(strip)) {
    		return 0;
    	}
    	
    	//Split the strip into parts or squares.
        String[] parts = strip.replaceAll(" ","").split(",");
        int len = parts.length;
        int[] mines = new int[len];
        
        //Convert the squares values into integers
        for(int i=0;i<len;i++){
        	if(parts[i] != null && !("".equals(parts[i]))) {
        		try{	
        			mines[i]=Integer.parseInt(parts[i]);
        		}catch (NumberFormatException e) {
        			throw new ApplicationException("One of the mines has incorrect input");
        		}
        	} else {
        		throw new ApplicationException("One of the mines has no input");
        	}
        }
        //Calculate the optimal or maximum yield
        return calculateOptimal(mines, len);
    }

	/**
	 * Method takes the mines list and calculates the optimal yield.
	 *
	 * @param minesArr - An integer array of mines from the strip
	 * @param length - Length of a strip
	 * @return Maximum yield for a given strip returned as integer.
	 */
    
    public int calculateOptimal(int[] minesArr, int length){
        int include = minesArr[0], exclude = 0;
        for (int i = 1; i < length; i++) {
            int oldInclude = include;
            include = Math.max(include, exclude + minesArr[i]);
            exclude = oldInclude;
        }
        return Math.max(include, exclude);
    }
}