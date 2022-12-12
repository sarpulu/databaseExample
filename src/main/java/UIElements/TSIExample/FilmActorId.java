package UIElements.TSIExample;

import java.io.Serializable;

public class FilmActorId implements Serializable {

    private int filmID;
    private int actorID;

    public FilmActorId(int filmID,int actorID){
        this.filmID= filmID;
        this.actorID= actorID;
    }

    public FilmActorId(){

    }


}
