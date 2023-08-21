package com.zuken.zicdemoapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainControllerTest {

  @Test
  public void should_run_sample_test() {

    //given
    int a = 2;

    //when
    int result = a + a;

    //then
    Assertions.assertEquals(result, a * 2);
  }

  @Test
  public void should_run_other_sample_test() {

    //given
    int a = 4;

    //when
    int result = a + a;

    //then
    Assertions.assertEquals(result, a * 2);
  }
}