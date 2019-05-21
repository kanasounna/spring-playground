package com.example.springplayground.services;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordCounterTest {
  @Test
  public void testCount(){
      String words="I met my wife on May 15 after I sign up on match.com";
      Map <String,Integer> wordCount=new WordCounter().count(words);
      Assert.assertEquals(2,wordCount.get("I").intValue());
      Assert.assertEquals(1,wordCount.get("met").intValue());
      Assert.assertEquals(1,wordCount.get("my").intValue());
      Assert.assertEquals(1,wordCount.get("wife").intValue());
      Assert.assertEquals(2,wordCount.get("on").intValue());
      Assert.assertTrue(wordCount.get("after").intValue()==1);





  }
}