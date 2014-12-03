package com.graham.pomodoro;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class Timer {

    private Long timeRemaining;

    public Timer(long amount, TemporalUnit unit) {
        this.timeRemaining = Duration.of(amount, unit).getSeconds();
    }

    public Timer minus(long amount, TemporalUnit unit) {
        timeRemaining = Duration.ofSeconds(timeRemaining).minus(amount, unit).getSeconds();
        return this;
    }

    public boolean hasTimeLeft() {
        return timeRemaining > 0;
    }

    @Override
    public String toString() {
        Long hours = timeRemaining / 3600;
        Long mins = timeRemaining / 60;
        Long seconds = timeRemaining % 60;
        return convertToDoubleDigit(hours) + ":" + convertToDoubleDigit(mins) + ":" + convertToDoubleDigit(seconds);
    }

    private String convertToDoubleDigit(Long time) {
        return (time.toString().length() <= 1) ? "0" + time : (time >= 60) ? "00" : time.toString();
    }
}
