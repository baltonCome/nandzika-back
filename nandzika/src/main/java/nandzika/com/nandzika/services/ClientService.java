package nandzika.com.nandzika.services;

import ch.qos.logback.core.net.server.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientService {
    
    private Client client;

    public Client getClient(){
        
        return client;
    }
}