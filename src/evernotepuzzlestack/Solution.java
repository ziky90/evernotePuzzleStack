package evernotepuzzlestack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution{

    private static int bufferSize;
    private static String readed = "";
    private static Queue<String> queue ;
    private static int actualSize;
    
    
    public static void main(String[] args){
        try{
            readData();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    static void addElement(String element){
        if(actualSize < bufferSize){
            queue.add(element);
            actualSize++;
        }else{
            queue.poll();
            queue.add(element);
        }
    }
    
    static void removeElements(int number){
        for(int i = 0; i < number; i++){
            queue.poll();
            actualSize--;
        }
    }
    
    static void listStack(){
        for(String s :  queue){
            System.out.println(s);
        }
    }
    
    /**
    *   Reading the data and dispatching the stuff to the working methods
    **/
    static void readData() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bufferSize = Integer.parseInt(st.nextToken());
        queue = new LinkedList<String>();
        int iterations = 0;
        
        while(!readed.equals("Q")){
            st = new StringTokenizer(br.readLine());
            readed = st.nextToken();
            if(readed.equals("A")){
                iterations = Integer.parseInt(st.nextToken());
                for(int i = 0; i<iterations; i++){
                    st = new StringTokenizer(br.readLine());
                    addElement(st.nextToken());                        
                }
            } else if(readed.equals("R")){
                removeElements(Integer.parseInt(st.nextToken()));
            } else if(readed.equals("L")){
                listStack();            
            }
        }
    }

}
