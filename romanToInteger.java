class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 0);
        map.put('D', 0);
        map.put('C', 0);
        map.put('L', 0);
        map.put('X', 0);
        map.put('V', 0);
        map.put('I', 0);

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char previous = i > 0 ? s.charAt(i - 1) : ' ';

            incrementCount(map, current);

            if (isSubtractive(previous, current)) {
                decrementCount(map, previous);
            }
        }

        return 1000 * map.get('M') + 500 * map.get('D') + 100 * map.get('C') +
               50 * map.get('L') + 10 * map.get('X') + 5 * map.get('V') + map.get('I');
    }

    private void incrementCount(Map<Character, Integer> map, char key) {
        map.put(key, map.get(key) + 1);
    }

    private void decrementCount(Map<Character, Integer> map, char key) {
        map.put(key, map.get(key) - 2);
    }

    private boolean isSubtractive(char previous, char current) {
        return (previous == 'C' && (current == 'D' || current == 'M')) ||
               (previous == 'X' && (current == 'L' || current == 'C')) ||
               (previous == 'I' && (current == 'V' || current == 'X'));
    }
}
