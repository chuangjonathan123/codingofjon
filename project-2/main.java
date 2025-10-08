public class WordGames
{
    
    public static String scramble(String word)
    {
        int middle = word.length() / 2;
        String left = word.substring(0,middle);
        String right = word.substring(middle);
        return right + left;
      
    }
    
    
    public static String bananaSplit(String word, int insertIdx, String insertText)
    {
       
        String left = word.substring(0,insertIdx);
        String right = word.substring (insertIdx);
        return left +insertText + right;
       
    }
    
    
    public static String bananaSplit(String word, String insertChar, String insertText)
    {
        
        int insertIdx = word.indexOf(insertChar);
        String left = word.substring(0, insertIdx);
        String right = word.substring(insertIdx);
        return left + insertText + right;
    }

    
}
