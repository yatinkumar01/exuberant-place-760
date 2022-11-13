package BusDAO;

import java.util.ArrayList;

import com.masai.Exceptions.BusException;

public interface BusIntr {
    public ArrayList<String> checkAvailability() throws BusException;

    public String bookTicket(String source, String destination, int cid, int busno, int ticket);

    public String cancelTicket(int bus_no);

}
