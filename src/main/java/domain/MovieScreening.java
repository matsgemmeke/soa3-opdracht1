package domain;

import java.time.LocalDateTime;

public class MovieScreening {

    private Movie movie;

    // LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
    private LocalDateTime dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat) {
        this.movie = movie;
        movie.addScreening(this);

        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    @Override
    public String toString() {
        return movie.getTitle() + " - " + dateAndTime;
    }
}
