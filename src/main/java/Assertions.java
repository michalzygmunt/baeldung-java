import java.sql.Connection;

public class Assertions {
    Connection conn;

    public void setup(){
        if(conn == null){
            throw new RuntimeException("Connection is null:");
        }
    }

    public void setupWithAssertion(){
        assert conn == null : "Connection is null";
    }
    public static void main (String[] args){
        Assertions assertions = new Assertions();
     //   assertions.setup();
        assertions.setupWithAssertion();
    }
}
