package org.toryt.util_I.collections.typed;


import java.util.Collection;
import java.util.List;

import org.toryt.util_I.annotations.vcs.CvsInfo;


/**
 * <p>{@link List} that only allows elements of type
 *   {@link #getElementType()}.</p>
 *
 * @author Jan Dockx
 *
 * @note When moving to Java 5, replace this with a generics.
 */
@CvsInfo(revision = "$Revision$",
         date     = "$Date$",
         state    = "$State$",
         tag      = "$Name$")
public interface TypedList extends TypedCollection, List {

  /**
   * @post   ((! isNullAllowed()) && (o == null)) ? false;
   * @post   ! getElementType().isInstance(o) ? false;
   * @throws NullPointerException
   *         (! isNullAllowed()) && (o == null);
   * @throws ClassCastException
   *         ! getElementType().isInstance(o);
   */
  void add(int index, Object o) throws NullPointerException, ClassCastException;

  /**
   * @post   ((! isNullAllowed()) && c.contains(null)) ? false;
   * @post   ((c != null) && ! cC:instanceOf(c, getElementType())) ? false;
   * @throws NullPointerException
   *         (! isNullAllowed()) && c.contains(null);
   * @throws ClassCastException
   *         (c != null) && ! cC:instanceOf(this, getElementType());
   */
  boolean addAll(int index, Collection c) throws NullPointerException, ClassCastException;

  /**
   * @post   ((! isNullAllowed()) && (o == null)) ? false;
   * @post   ! getElementType().isInstance(o) ? false;
   * @throws NullPointerException
   *         (! isNullAllowed()) && (o == null);
   * @throws ClassCastException
   *         ! getElementType().isInstance(o);
   */
  Object set(int index, Object o) throws NullPointerException, ClassCastException;

}