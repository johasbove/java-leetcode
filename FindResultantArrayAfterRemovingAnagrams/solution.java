class Solution {
  public List<String> removeAnagrams(String[] words) {
      ArrayList<String> uniqueAnagrams = new ArrayList<String>();
      HashMap<Character, Integer> anagramsCount = new HashMap<Character, Integer> (words.length);
      int previousAnagramIndex = 0;
      uniqueAnagrams.add(words[previousAnagramIndex]);

      for (int i = 1; i < words.length; i++) {
          if (areAnagram(words[i], words[i-1]) && !uniqueAnagrams.contains(words[previousAnagramIndex])) {
              uniqueAnagrams.add(words[previousAnagramIndex]);
          } else if (!areAnagram(words[i], words[i-1])) {
              uniqueAnagrams.add(words[i]);
              previousAnagramIndex = i;
          }
      }

      return uniqueAnagrams;
  }

  private boolean areAnagram(String word1, String word2) {
      HashMap<Character, Integer> letters1 = countLetters(word1);
      HashMap<Character, Integer> letters2 = countLetters(word2);

      return letters1.equals(letters2);
  }

  private HashMap<Character, Integer> countLetters(String word) {
      HashMap<Character, Integer> letters = new HashMap<Character, Integer> (word.length());
      for (int i = 0; i < word.length(); i++) {
          char letter = word.charAt(i);
          if (letters.containsKey(letter)) {
              int count = letters.get(letter);
              letters.put(letter, count + 1);
          } else {
              letters.put(letter, 1);
          }
      }

      return letters;
  }
}

// ****************************************************************************
// Other's code

// Better time-wise and memory-wise solution

class Solution {
    public List<String> removeAnagrams(String[] words) {
       String prev="";
        List<String> list = new ArrayList<>(); // List is the interface and ArrayLIst its implementation
        for(int i=0;i<words.length;i++){
            char[] test = words[i].toCharArray();
            Arrays.sort(test); // wasn't necessary to count how many of each letter the word had

            String str = new String(test);
            if(!str.equals(prev)){
                list.add(words[i]);
                prev=str;
            }
        }

        return list;
    }
}