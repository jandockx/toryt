package org.toryt_II.testmodel;


import java.io.PrintStream;
import java.util.Iterator;
import java.util.Set;

import org.toryt_II.TestModel;



/**
 * Implementation of a number of methods of {@link TestModel}.
 *
 * @author Jan Dockx
 */
public abstract class AbstractTestModel implements TestModel {

  /*<section name="Meta Information">*/
  //  ------------------------------------------------------------------
  /** {@value} */
  public static final String CVS_REVISION = "$Revision$";
  /** {@value} */
  public static final String CVS_DATE = "$Date$";
  /** {@value} */
  public static final String CVS_STATE = "$State$";
  /** {@value} */
  public static final String CVS_TAG = "$Name$";
  /*</section>*/


  public void printStructure(PrintStream out) {
    assert out != null;
    printStructure(new IndentPrinter(out, -1));
  }

  /**
   * @pre out != null;
   * @pre depth >= 0;
   */
  abstract void printStructure(IndentPrinter indentPrinter);

  static class IndentPrinter {

    public IndentPrinter(PrintStream out, int nrOfEntries) {
      $out = out;
      $nrOfEntriesLeft = nrOfEntries;
    }

    public IndentPrinter(IndentPrinter previous, int nrOfEntries) {
      this(previous.getPrintStream(), nrOfEntries);
      $previous = previous;
    }

    public PrintStream getPrintStream() {
      return $out;
    }

    private PrintStream $out;

    private IndentPrinter $previous;

    private int $nrOfEntriesLeft;

    void printIndentSameEntry() {
      if ($previous != null) {
        $previous.printIndentSameEntry();
      }
      if ($nrOfEntriesLeft > 0) {
        $out.print(CONTINUING_ENTRY_INDENT);
      }
      else if ($nrOfEntriesLeft == 0) {
        $out.print(BLANK_INDENT);
      }
      else { // < 0
        assert false;
      }
    }

    private void printIndent() {
      if ($previous != null) {
        $previous.printIndentSameEntry();
      }
      if ($nrOfEntriesLeft > 1) {
        $out.print(ENTRY_INDENT);
      }
      else if ($nrOfEntriesLeft == 1) {
        $out.print(LAST_ENTRY_INDENT);
      }
      // < 1; no indent
      if ($nrOfEntriesLeft > 0) {
        $nrOfEntriesLeft--;
      }
    }

    public void println(String string) {
      printIndent();
      $out.println(string);
    }

    public void println(Object obj) {
      printIndent();
      $out.println(obj);
    }

    public void printChildren(String sectionHeading, Set testModels) {
      println(sectionHeading);
      IndentPrinter indent = new IndentPrinter(this, testModels.size());
      Iterator iter = testModels.iterator();
      while (iter.hasNext()) {
        AbstractTestModel tm = (AbstractTestModel)iter.next();
        tm.printStructure(indent);
      }

    }

  }

  private final static String BLANK_INDENT = "    ";

  private final static String ENTRY_INDENT = "  |-";

  private final static String CONTINUING_ENTRY_INDENT = "  | ";

  private final static String LAST_ENTRY_INDENT = "  `-";

}