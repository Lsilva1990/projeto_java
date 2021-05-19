/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author thi_s
 */
public class ProjetoExceptions  extends Exception{
    
    private String msg;
    
    public ProjetoExceptions(String error){
        super(error);
        msg = error;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }


}
