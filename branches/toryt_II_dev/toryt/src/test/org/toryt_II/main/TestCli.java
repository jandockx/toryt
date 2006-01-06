package org.toryt_II.main;

import junit.framework.TestCase;



public class TestCli extends TestCase {

//  public final void testMain1() {
//    String[] args = new String[] {};
//    Cli.main(args);
//    //expect error and usage
//  }

//  public final void testMain2() {
//    String[] args = new String[] {"--version"};
//    Cli.main(args);
//    //expect version
//  }

//  public final void testMain3() {
//    String[] args = new String[] {"-h"};
//    Cli.main(args);
//    //expect usage
//  }

//  public final void testMain4() {
//    String[] args = new String[] {"-p"};
//    Cli.main(args);
//    //expect error (no argument for p) and usage
//  }

//  public final void testMain5() {
//    String[] args = new String[] {"--project", "\"Toryt Main Unit Test\""};
//    Cli.main(args);
//    //expect error (need -d) and usage
//  }

//  public final void testMain6() {
//    String[] args = new String[] {"-p", "\"Toryt Main Unit Test\"", "-d"};
//    Cli.main(args);
//    //expect error (no argument for d) and usage
//  }

//  public final void testMain7() {
//    String[] args = new String[] {"-p", "\"Toryt Main Unit Test\"", "-d", "target/classes"};
//    Cli.main(args);
//    //expect works
//  }

//  public final void testMain8() {
//    String[] args = new String[] {"-k"};
//    Cli.main(args);
//    //expect error (no argument for k) and usage
//  }

//  public final void testMain9() {
//    String[] args = new String[] {"-k", "org.toryt.example"};
//    Cli.main(args);
//    //expect error (need -d) and usage
//  }

//  public final void testMain10() {
//    String[] args = new String[] {"-k", "org.toryt.example", "-d"};
//    Cli.main(args);
//    //expect error (no argument for d) and usage
//  }

//  public final void testMain11() {
//    String[] args = new String[] {"-k", "org.toryt.example", "-d", "target/classes"};
//    Cli.main(args);
//    //expect works
//  }

//  public final void testMain12() {
//    String[] args = new String[] {"-c"};
//    Cli.main(args);
//    //expect error (no argument for c) and usage
//  }

//  public final void testMain13() {
//    String[] args = new String[] {"-c", "org.toryt.example.Kadoodle"};
//    Cli.main(args);
//    //expect error (class doesn't exist) and usage
//  }

  public final void testMain14() {
    String[] args = new String[] {"-c", "org.toryt.example.Bookmark"};
    Cli.main(args);
    //expect works
  }

//  public final void testMain15() {
//    String[] args = new String[] {"-c", "org.toryt.example.Bookmark#Kadoodle"};
//    Cli.main(args);
//    //expect error (no such nested class) and usage
//  }

//  public final void testMain16() {
//    String[] args = new String[] {"-m"};
//    Cli.main(args);
//    //expect error (no argument for m) and usage
//  }

//  public final void testMain17() {
//    String[] args = new String[] {"-m", "org.toryt.example.Bookmark#kadoodle()"};
//    Cli.main(args);
//    //expect error (method doesn't exist) and usage
//  }

//  // DOESN'T WORK
//  public final void testMain18() {
//    String[] args = new String[] {"-m", "org.toryt.example.Bookmark#setRating(int)"};
//    Cli.main(args);
//    //expect works
//  }

}

