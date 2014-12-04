package com.graham.pomodoro;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class TimerTest {

    Timer timer;

    @BeforeMethod
    public void setUp() throws Exception {
        this.timer = new Timer(1, ChronoUnit.MINUTES);
    }

    @Test
    public void testMinus() throws Exception {
        assertThat(timer.minus(30, ChronoUnit.SECONDS).toString()).isEqualTo("00:00:30");
    }

    @Test
    public void testHasTimeLeft() throws Exception {
        assertThat(timer.hasTimeLeft()).isTrue();
        assertThat(timer.minus(60, ChronoUnit.SECONDS).hasTimeLeft()).isFalse();
    }

    @Test
    public void testToString() throws Exception {
        assertThat(timer.toString()).isEqualTo("00:01:00");
    }

    @Test
    public void testConvertToDoubleDigit() throws Exception {
        assertThat(timer.convertToDoubleDigit(0L)).isEqualTo("00");
        assertThat(timer.convertToDoubleDigit(70L)).isEqualTo("00");
        assertThat(timer.convertToDoubleDigit(15L)).isEqualTo("15");
    }
}