package domain;

public class MovieTicket {

    private MovieScreening movieScreening;
    private boolean isPremiumTicket;

    private int seatRow;
    private int seatNr;

    public MovieTicket(
            MovieScreening movieScreening,
            boolean isPremiumTicket,
            int seatRow,
            int seatNr
    ) {
        this.movieScreening = movieScreening;
        this.isPremiumTicket = isPremiumTicket;
        this.seatRow = seatRow;
        this.seatNr = seatNr;
    }

    public MovieScreening getMovieScreening() {
        return movieScreening;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public boolean isPremiumTicket() {
        return isPremiumTicket;
    }

    @Override
    public String toString() {
        return movieScreening.toString() + " - row " + seatRow + ", seat " + seatNr +
                (isPremiumTicket ? " (Premium)" : "");
    }
}
