package org.toryt.util_I.collections.lockable;


import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

import org.toryt.patterns_I.Assertion;
import org.toryt.patterns_I.Collections;
import org.toryt.util_I.annotations.vcs.CvsInfo;



/**
 * <p>Implementation of modifying methods for a {@link LockableCollection}
 *   that is locked always.</p>
 *
 * @author Jan Dockx
 *
 * @invar isLocked();
 */
@CvsInfo(revision = "$Revision$",
         date     = "$Date$",
         state    = "$State$",
         tag      = "$Name$")
public abstract class AbstractLockedCollection<_ElementType_>
    implements LockableCollection<_ElementType_> {

  protected AbstractLockedCollection(boolean nullAllowed) {
    $nullAllowed = nullAllowed;
  }



  /* <property name="null allowed"> */
  //------------------------------------------------------------------

  public final boolean isNullAllowed() {
    return $nullAllowed;
  }

  private boolean $nullAllowed;

  /*</property>*/



  /* <property name="locked"> */
  //------------------------------------------------------------------

  public final boolean isLocked() {
    return true;
  }

  /*</property>*/



  /**
   * This implementation is very expensive for lazy collections.
   *
   * @protected
   * General implementation as high in the inheritance
   * hierarchy as possible. Overwrite when a more performant
   * implementation is possible.
   */
  public boolean contains(final Object o) {
    return Collections.exists(this, new Assertion<_ElementType_>() {
              public boolean isTrueFor(_ElementType_ element) {
                return (((o == null) && (element == null)) ||
                        ((o != null) && (o.equals(element))));
              }
            });
  }

  /**
   * This implementation is very expensive for lazy collections.
   *
   * @protected
   * General implementation as high in the inheritance
   * hierarchy as possible.
   *
   * @throws NullPointerException
   *         c == null;
   */
  public final boolean containsAll(Collection<?> c) {
    return (size() >= c.size()) && // NullPointerException as expected
           Collections.forAll(c,
                              new Assertion<Object>() {
                                    public boolean isTrueFor(Object o) {
                                      return contains(o);
                                    }
                                  });
  }

  /**
   * This implementation is very expensive for lazy collections.
   *
   * @protected
   * General implementation as high in the inheritance
   * hierarchy as possible.
   */
  public Object[] toArray() {
    return toArray(new Object[size()]);
  }

  /**
   * This implementation is very expensive for lazy collections.
   *
   * @protected
   * General implementation as high in the inheritance
   * hierarchy as possible.
   */
  @SuppressWarnings("unchecked")
  public <_ResultBaseType_> _ResultBaseType_[] toArray(_ResultBaseType_[] a) {
    int size = size();
    _ResultBaseType_[] result;
    if (a.length >= size) {
      result = a;
      result[size] = null;
    }
    else {
      result = (_ResultBaseType_[])Array.newInstance(a.getClass().getComponentType(), size);
      /* unchecked cast because Java API is not generic here */
    }
    Iterator<_ElementType_> iter = iterator();
    int i = 0;
    try {
      while (iter.hasNext()) {
        result[i] = (_ResultBaseType_)iter.next();
        /* this is weird, yes. the reason is that we cannot say that
         * _ResultBaseType_ super _ElementType_ for some reason;
         * so, we might get a ClassCastException, which we will transform into
         * an ArrayStoreException */
        i++;
      }
    }
    catch (ClassCastException ccExc) {
      throw new ArrayStoreException();
    }
    return result;
  }



  /* <section name="Modifying Operations"> */
  //------------------------------------------------------------------

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final boolean add(_ElementType_ o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final boolean remove(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final boolean addAll(Collection<? extends _ElementType_> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final boolean retainAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final boolean removeAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /**
   * @deprecated Unsupported
   */
  @Deprecated
  public final void clear() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Set is locked");
  }

  /*</section>*/


  public abstract class AbstractLockedCollectionIterator implements Iterator<_ElementType_> {

    /**
     * @deprecated Unsupported
     */
    @Deprecated
    public final void remove()  throws UnsupportedOperationException {
      throw new UnsupportedOperationException("Set is locked");
    }

  }

}