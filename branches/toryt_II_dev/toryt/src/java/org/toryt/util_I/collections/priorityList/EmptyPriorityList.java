package org.toryt.util_I.collections.priorityList;


import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.toryt.util_I.annotations.vcs.CvsInfo;


/**
 * <p>An empty {@link PriorityList}.</p>
 * <p>We need to provide a
 *   {@link #getPriorityElementType() priority element type} at construction.
 *
 * @author Jan Dockx
 */
@CvsInfo(revision = "$Revision$",
         date     = "$Date$",
         state    = "$State$",
         tag      = "$Name$")
public final class EmptyPriorityList extends AbstractLockedPriorityList {


  public static final EmptyPriorityList OBJECT_INSTANCE = new EmptyPriorityList(Object.class);


  /**
   * This method is introduced for use in {@link #subList(int, int)}.
   *
   * @pre priorityPriorityElementType != null;
   */
  public EmptyPriorityList(Class priorityElementType) {
    super(priorityElementType, BigInteger.ZERO);
  }

  public final int hashCode() {
    return 1;
  }

  public final boolean containsPriorityElement(final Object o) {
    return false;
  }

  public final Iterator priorityElementIterator() {
    return new AbstractLockedCollectionIterator() {

                  public final boolean hasNext() {
                    return false;
                  }

                  public Object next() {
                    throw new IndexOutOfBoundsException();
                  }

                };
  }

  public final int size() {
    return 0;
  }

  public final boolean isEmpty() {
    return true;
  }

  public final boolean contains(Object o) {
    return false;
  }

  public final Object get(int index) {
    throw new IndexOutOfBoundsException();
  }

  public final int indexOf(Object o) {
    return -1;
  }

  public final int lastIndexOf(Object o) {
    return -1;
  }

  public final ListIterator listIterator(int index) {
    return new AbstractLockedListIterator() {

                  public boolean hasNext() {
                    return false;
                  }

                  public Object next() {
                    throw new IndexOutOfBoundsException();
                  }

                  public boolean hasPrevious() {
                    return false;
                  }

                  public Object previous() {
                    throw new IndexOutOfBoundsException();
                  }

                  public int nextIndex() {
                    return 0;
                  }

                  public int previousIndex() {
                    return -1;
                  }

                };
  }

  public final List subList(int fromIndex, int toIndex) {
    if ((fromIndex == 0) && (toIndex == 0)) {
      return this;
    }
    else {
      throw new IndexOutOfBoundsException();
    }
  }

}