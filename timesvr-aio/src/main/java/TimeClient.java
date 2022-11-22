/**
 * 功能描述
 *
 * @auhtor sunlei
 * @since 2022/11/21 14:44
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0) {
            try{
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {}
        }

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AsyncTimeClientHandler-001").start();
    }

}
