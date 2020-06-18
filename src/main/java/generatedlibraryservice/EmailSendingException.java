
package generatedlibraryservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "EmailSendingFault", targetNamespace = "http://LibraryService/")
public class EmailSendingException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UnspecifiedFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public EmailSendingException(String message, UnspecifiedFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public EmailSendingException(String message, UnspecifiedFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: generatedlibraryservice.UnspecifiedFault
     */
    public UnspecifiedFault getFaultInfo() {
        return faultInfo;
    }

}
