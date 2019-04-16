public class Database_data {

    String column_1;
    String column_2;
    String column_3;
    String column_4;
    String column_5;
    String column_6;
    String column_7;
    String column_8;
    String column_9;
    
    
    public Database_data(String c1, String c2, String c3, String c4){
        this.column_1 = c1;
        this.column_2 = c2;
        this.column_3 = c3;
        this.column_4 = c4;
    }
    
    public Database_data(String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9){
        this.column_1 = c1;
        this.column_2 = c2;
        this.column_3 = c3;
        this.column_4 = c4;
        this.column_5 = c5;
        this.column_6 = c6;
        this.column_7 = c7;
        this.column_8 = c8;
        this.column_9 = c9;
    }
   
    public String getColumn_1(){
        return column_1;
    }
   
    public String getColumn_2(){
        return column_2;
    }
   
    public String getColumn_3(){
        return column_3;
    }
   
    public String getColumn_4(){
        return column_4;
    }
    
    public String getColumn_5(){
        return column_5;
    }
    
    public String getColumn_6(){
        return column_6;
    }
    
    public String getColumn_7(){
        return column_7;
    }
    
    public String getColumn_8(){
        return column_8;
    }
    
    public String getColumn_9(){
        return column_9;
    }
}