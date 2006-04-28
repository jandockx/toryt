package org.toryt.util_I.collections.bigSet.lockable;


import java.math.BigInteger;

import org.toryt.util_I.annotations.vcs.CvsInfo;
import org.toryt.util_I.collections.bigSet.BigSet;
import org.toryt.util_I.collections.lockable.AbstractLockedSet;


/**
 * <p>Implementation of some methods for a locked {@link BigSet}.</p>
 *
 * @author Jan Dockx
 */
@CvsInfo(revision = "$Revision$",
         date     = "$Date$",
         state    = "$State$",
         tag      = "$Name$")
public abstract class AbstractLockedBigSet extends AbstractLockedSet
    implements LockableBigSet {

  /**
   * @pre elementType != null;
   * @pre bigSize != null;
   * @pre bigSize >= 0;
   */
  protected AbstractLockedBigSet(Class elementType, boolean nullAllowed, BigInteger bigSize) {
    assert elementType != null;
    assert bigSize != null;
    assert bigSize.compareTo(BigInteger.ZERO) >= 0;
    $nullAllowed = nullAllowed;
    $elementType = elementType;
    $bigSize = bigSize;
  }



  /* <property name="null allowed"> */
  //------------------------------------------------------------------

  public final boolean isNullAllowed() {
    return $nullAllowed;
  }

  private boolean $nullAllowed;

  /*</property>*/



  /* <property name="element type"> */
  //------------------------------------------------------------------

  public final Class getElementType() {
    return $elementType;
  }

  /**
   * @invar $elementType != null;
   */
  private Class $elementType;

  /*</property>*/



  /* <property name="size"> */
  //------------------------------------------------------------------

  /**
   * @basic
   */
  public final BigInteger getBigSize() {
    return $bigSize;
  }

  private final static BigInteger MAXINT = BigInteger.valueOf(Integer.MAX_VALUE);

  /**
   * @deprecated
   */
  public final int size() {
    return (getBigSize().compareTo(MAXINT) < 0) ?
             getBigSize().intValue() :
             Integer.MAX_VALUE;
  }

  /**
   * @invar $bigSize != null;
   */
  private BigInteger $bigSize;

  /*</property>*/


  /* this implementation is too expensive
  public boolean contains(final Object o) {
    Iterator iter = iterator();
    while (iter.hasNext()) {
      if (iter.next().equals(o)) {
        return true;
      }
    }
    return false;
  }
  */

  /**
   * Overridden to use {@link #getBigSize()} instead of {@link #size()}.
   */
  public boolean equals(Object o) {
    return (o != null) &&
           (o instanceof BigSet) &&
           getBigSize().equals(((BigSet)o).getBigSize()) &&
           containsAll((BigSet)o) &&
           ((BigSet)o).containsAll(this);
  }

  // no need to override hashCode()

}