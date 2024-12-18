public class StringMisc {

        // Converts the first letter to uppercase and the rest to lowercase.
        public static String norm(String name) {
            // Check special case if name input is empty
            if (name == null) {
                return "";
            }
            return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }

        // Converts a full name into initials for all but the last name,
        // and capitalizes the first letter of the last name.
        public static String init(String name) {
            String[] nameParts = name.split(" ");
            StringBuilder result = new StringBuilder();

            // Process all but the last name
            for (int i = 0; i < nameParts.length - 1; i++) {
                result.append(nameParts[i].substring(0, 1).toUpperCase());
                result.append(". ");
            }

            // Process the last name
            result.append(nameParts[nameParts.length - 1].substring(0, 1).toUpperCase());
            result.append(nameParts[nameParts.length - 1].substring(1).toLowerCase());
            
            return result.toString();
        }

        // Replaces characters in "s" found in "from" with corresponding ones in `to`.
        public static String tr(String s, String from, String to) {
            // Special case: if "from" and "to" not the same length
            if (from.length() != to.length()) {
                throw new IllegalArgumentException("From and To must have the same length");
            }

            StringBuilder result = new StringBuilder();
            for (char c : s.toCharArray()) {
                // Find characters from "s" that match "from" and get the character index
                int index = from.indexOf(c);
                if (index != -1) {
                    result.append(to.charAt(index)); // Replace with the correspoinding (on the same place) character from "to"
                } else {
                    result.append(c);
                }              
            }
            return result.toString();                             
        }

        public static void main (String[] args) {
            System.out.println(norm("caravaggio")); // Expected: Caravaggio
            System.out.println(norm("VERMEER")); // Expected: Vermeer
            System.out.println(init("johann sebastian bach")); // Expected: J. S. Bach
            System.out.println(init("i. babeL")); // Expected: I. Babel
            System.out.println(init("jorge LUIS BORGES")); // Expected: J. L. Borges
            System.out.println(init("WOLFGANG a. mozart")); // Expected: W. A. Mozart
            System.out.println(tr("Mississippi",
                                "abcdefghijklmnopqrstuvwyz",
                                "BCDEFGHIJKLMNOPQRSTUVWYZA")); // Expected: MJTTJTTJQQJ
            System.out.println(tr("abcXYZ","aZcX","||Cx")); // Expected: |bCxY|
    } 
}
