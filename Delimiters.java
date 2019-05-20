import java.util.ArrayList;

public class Delimiters {

    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
        //what if openDel.equals(closeDel)?
    }

    // part a -- start 22:19, end 22:22
    public ArrayList<String> getDelimetersList(String[] tokens) {
        ArrayList<String> al = new ArrayList<>();
        for(String t : tokens) {
            if(t.equals(openDel) || t.equals(closeDel))
                al.add(t);
        }
        return al;
    }

    // part b -- start 22:29, end 22:32
    public boolean isBalanced(ArrayList<String> delimiters) {
        int opens = 0;
        int closes = 0;
        for(String d : delimiters) {
            if(d.equals(openDel))
                opens++;
            if(d.equals(closeDel)) 
                closes++;
            if(closes > opens) return false;
        }
        return closes == opens;
    }

    public static void main(String[] args) {
        System.out.println("testing part a");
        Delimiters d = new Delimiters("(", ")");
        String[] aex1 = {"(","x + y",")"," * 5"};
        ArrayList<String> al = d.getDelimetersList(aex1);
        System.out.println(al + " should be {(, )}");
        boolean aex1b = d.isBalanced(al);
        d = new Delimiters("<q>","</q>");
        String[] aex2 = {"<q>","yy","</q>","zz","</q>"};
        al = d.getDelimetersList(aex2);
        System.out.println(al + " should be {<q>, </q>, </q>}");
        boolean aex2b = d.isBalanced(al);
        System.out.println("\ntesting part b");

        System.out.println(aex1b + " should be true");
        System.out.println(aex2b + " should be false");
        
        d = new Delimiters("<sup>", "</sup>");
        String[] bex1 = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
        al = d.getDelimetersList(bex1);
        System.out.println(d.isBalanced(al) + " should be true");

        String[] bex2 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        al = d.getDelimetersList(bex2);
        System.out.println(d.isBalanced(al) + " should be false");

        String[] bex3 = {"</sup>"};
        al = d.getDelimetersList(bex3);
        System.out.println(d.isBalanced(al) + " should be false");

        String[] bex4 = {"<sup>","<sup>","</sup>"};
        al = d.getDelimetersList(bex4);
        System.out.println(d.isBalanced(al) + " should be false");

        
    }
}

/* plausible rubric

 part a - 5pts
 * instantiate AL
 * access all items in tokens array
 * correct conditional logic (2 cases, not ==)
 * correct call to insert at least 1 item into AL
 * on exit, all and only all delimeters are in AL returned.

 part b - 4 pts
 * access all items in AL
 * syntactically correct comparison with delimiter IVs
 * updates count (must be in context of a comparison and a loop)
 * "logic point" returns correctly in all cases

 */
