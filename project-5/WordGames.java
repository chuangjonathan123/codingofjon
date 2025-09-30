public class WordGames
{
    
    public static String scramble(String word)
    {
        // switch first half
        int middle = word.length() / 2;
        String left = word.substring(0,middle);
        String right = word.substring(middle);
        return right + left;
        // and second half
      
    }
    
    
    public static String bananaSplit(String word, int insertIdx, String insertText)
    {
        // Insert insertText at the position
        // insertIdx
        String left = word.substring(0,insertIdx);
        String right = word.substring (insertIdx);
        return left +insertText + right;
       
    }
    
    
    public static String bananaSplit(String word, String insertChar, String insertText)
    {
        // Insert insertText after the first
        // occurence of the insertChar
        int insertIdx = word.indexOf(insertChar);
        String left = word.substring(0, insertIdx);
        String right = word.substring(insertIdx);
        return left + insertText + right;
    }

    
}
