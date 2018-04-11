package ptoku.library;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/reservation")
public class ReservationWebService {
    @GET
    public Response listReServations() {
        return Response.ok("Oto wszystkie rezerwacje :)").build();
    }
}