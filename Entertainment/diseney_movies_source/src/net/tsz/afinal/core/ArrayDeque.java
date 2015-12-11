// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package net.tsz.afinal.core:
//            AbstractCollection, Deque, Arrays

public class ArrayDeque extends AbstractCollection
    implements Deque, Cloneable, Serializable
{
    private class DeqIterator
        implements Iterator
    {

        private int cursor;
        private int fence;
        private int lastRet;
        final ArrayDeque this$0;

        public boolean hasNext()
        {
            return cursor != fence;
        }

        public Object next()
        {
            if (cursor == fence)
            {
                throw new NoSuchElementException();
            }
            Object obj = elements[cursor];
            if (tail != fence || obj == null)
            {
                throw new ConcurrentModificationException();
            } else
            {
                lastRet = cursor;
                cursor = cursor + 1 & elements.length - 1;
                return obj;
            }
        }

        public void remove()
        {
            if (lastRet < 0)
            {
                throw new IllegalStateException();
            }
            if (delete(lastRet))
            {
                cursor = cursor - 1 & elements.length - 1;
                fence = tail;
            }
            lastRet = -1;
        }

        private DeqIterator()
        {
            this$0 = ArrayDeque.this;
            super();
            cursor = head;
            fence = tail;
            lastRet = -1;
        }

        DeqIterator(DeqIterator deqiterator)
        {
            this();
        }
    }

    private class DescendingIterator
        implements Iterator
    {

        private int cursor;
        private int fence;
        private int lastRet;
        final ArrayDeque this$0;

        public boolean hasNext()
        {
            return cursor != fence;
        }

        public Object next()
        {
            if (cursor == fence)
            {
                throw new NoSuchElementException();
            }
            cursor = cursor - 1 & elements.length - 1;
            Object obj = elements[cursor];
            if (head != fence || obj == null)
            {
                throw new ConcurrentModificationException();
            } else
            {
                lastRet = cursor;
                return obj;
            }
        }

        public void remove()
        {
            if (lastRet < 0)
            {
                throw new IllegalStateException();
            }
            if (!delete(lastRet))
            {
                cursor = cursor + 1 & elements.length - 1;
                fence = head;
            }
            lastRet = -1;
        }

        private DescendingIterator()
        {
            this$0 = ArrayDeque.this;
            super();
            cursor = tail;
            fence = head;
            lastRet = -1;
        }

        DescendingIterator(DescendingIterator descendingiterator)
        {
            this();
        }
    }


    static final boolean $assertionsDisabled;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 0x207cda2e240da08bL;
    private transient Object elements[];
    private transient int head;
    private transient int tail;

    public ArrayDeque()
    {
        elements = new Object[16];
    }

    public ArrayDeque(int i)
    {
        allocateElements(i);
    }

    public ArrayDeque(Collection collection)
    {
        allocateElements(collection.size());
        addAll(collection);
    }

    private void allocateElements(int i)
    {
        int j = 8;
        if (i >= 8)
        {
            i |= i >>> 1;
            i |= i >>> 2;
            i |= i >>> 4;
            i |= i >>> 8;
            i = (i | i >>> 16) + 1;
            j = i;
            if (i < 0)
            {
                j = i >>> 1;
            }
        }
        elements = new Object[j];
    }

    private void checkInvariants()
    {
        if (!$assertionsDisabled && elements[tail] != null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && (head != tail ? elements[head] == null || elements[tail - 1 & elements.length - 1] == null : elements[head] != null))
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && elements[head - 1 & elements.length - 1] != null)
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    private Object[] copyElements(Object aobj[])
    {
        if (head < tail)
        {
            System.arraycopy(((Object) (elements)), head, ((Object) (aobj)), 0, size());
        } else
        if (head > tail)
        {
            int i = elements.length - head;
            System.arraycopy(((Object) (elements)), head, ((Object) (aobj)), 0, i);
            System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), i, tail);
            return aobj;
        }
        return aobj;
    }

    private boolean delete(int i)
    {
        checkInvariants();
        Object aobj[] = elements;
        int j = aobj.length - 1;
        int k = head;
        int l = tail;
        int i1 = i - k & j;
        int j1 = l - i & j;
        if (i1 >= (l - k & j))
        {
            throw new ConcurrentModificationException();
        }
        if (i1 < j1)
        {
            if (k <= i)
            {
                System.arraycopy(((Object) (aobj)), k, ((Object) (aobj)), k + 1, i1);
            } else
            {
                System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj)), 1, i);
                aobj[0] = aobj[j];
                System.arraycopy(((Object) (aobj)), k, ((Object) (aobj)), k + 1, j - k);
            }
            aobj[k] = null;
            head = k + 1 & j;
            return false;
        }
        if (i < l)
        {
            System.arraycopy(((Object) (aobj)), i + 1, ((Object) (aobj)), i, j1);
            tail = l - 1;
        } else
        {
            System.arraycopy(((Object) (aobj)), i + 1, ((Object) (aobj)), i, j - i);
            aobj[j] = aobj[0];
            System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj)), 0, l);
            tail = l - 1 & j;
        }
        return true;
    }

    private void doubleCapacity()
    {
        if (!$assertionsDisabled && head != tail)
        {
            throw new AssertionError();
        }
        int i = head;
        int j = elements.length;
        int k = j - i;
        int l = j << 1;
        if (l < 0)
        {
            throw new IllegalStateException("Sorry, deque too big");
        } else
        {
            Object aobj[] = new Object[l];
            System.arraycopy(((Object) (elements)), i, ((Object) (aobj)), 0, k);
            System.arraycopy(((Object) (elements)), 0, ((Object) (aobj)), k, i);
            elements = aobj;
            head = 0;
            tail = j;
            return;
        }
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        int j = objectinputstream.readInt();
        allocateElements(j);
        head = 0;
        tail = j;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            elements[i] = objectinputstream.readObject();
            i++;
        } while (true);
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
        objectoutputstream.writeInt(size());
        int j = elements.length;
        int i = head;
        do
        {
            if (i == tail)
            {
                return;
            }
            objectoutputstream.writeObject(elements[i]);
            i = i + 1 & j - 1;
        } while (true);
    }

    public boolean add(Object obj)
    {
        addLast(obj);
        return true;
    }

    public void addFirst(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
        Object aobj[] = elements;
        int i = head - 1 & elements.length - 1;
        head = i;
        aobj[i] = obj;
        if (head == tail)
        {
            doubleCapacity();
        }
    }

    public void addLast(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
        elements[tail] = obj;
        int i = tail + 1 & elements.length - 1;
        tail = i;
        if (i == head)
        {
            doubleCapacity();
        }
    }

    public void clear()
    {
        int i = head;
        int k = tail;
        if (i != k)
        {
            tail = 0;
            head = 0;
            int l = elements.length;
            int j;
            do
            {
                elements[i] = null;
                j = i + 1 & l - 1;
                i = j;
            } while (j != k);
        }
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public ArrayDeque clone()
    {
        ArrayDeque arraydeque;
        try
        {
            arraydeque = (ArrayDeque)super.clone();
            arraydeque.elements = Arrays.copyOf(elements, elements.length);
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return arraydeque;
    }

    public boolean contains(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = elements.length;
        int i = head;
        do
        {
            Object obj1 = elements[i];
            if (obj1 == null)
            {
                continue;
            }
            if (obj.equals(obj1))
            {
                return true;
            }
            i = i + 1 & j - 1;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public Iterator descendingIterator()
    {
        return new DescendingIterator(null);
    }

    public Object element()
    {
        return getFirst();
    }

    public Object getFirst()
    {
        Object obj = elements[head];
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public Object getLast()
    {
        Object obj = elements[tail - 1 & elements.length - 1];
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public boolean isEmpty()
    {
        return head == tail;
    }

    public Iterator iterator()
    {
        return new DeqIterator(null);
    }

    public boolean offer(Object obj)
    {
        return offerLast(obj);
    }

    public boolean offerFirst(Object obj)
    {
        addFirst(obj);
        return true;
    }

    public boolean offerLast(Object obj)
    {
        addLast(obj);
        return true;
    }

    public Object peek()
    {
        return peekFirst();
    }

    public Object peekFirst()
    {
        return elements[head];
    }

    public Object peekLast()
    {
        return elements[tail - 1 & elements.length - 1];
    }

    public Object poll()
    {
        return pollFirst();
    }

    public Object pollFirst()
    {
        int i = head;
        Object obj = elements[i];
        if (obj == null)
        {
            return null;
        } else
        {
            elements[i] = null;
            head = i + 1 & elements.length - 1;
            return obj;
        }
    }

    public Object pollLast()
    {
        int i = tail - 1 & elements.length - 1;
        Object obj = elements[i];
        if (obj == null)
        {
            return null;
        } else
        {
            elements[i] = null;
            tail = i;
            return obj;
        }
    }

    public Object pop()
    {
        return removeFirst();
    }

    public void push(Object obj)
    {
        addFirst(obj);
    }

    public Object remove()
    {
        return removeFirst();
    }

    public boolean remove(Object obj)
    {
        return removeFirstOccurrence(obj);
    }

    public Object removeFirst()
    {
        Object obj = pollFirst();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public boolean removeFirstOccurrence(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = elements.length;
        int i = head;
        do
        {
            Object obj1 = elements[i];
            if (obj1 == null)
            {
                continue;
            }
            if (obj.equals(obj1))
            {
                delete(i);
                return true;
            }
            i = i + 1 & j - 1;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public Object removeLast()
    {
        Object obj = pollLast();
        if (obj == null)
        {
            throw new NoSuchElementException();
        } else
        {
            return obj;
        }
    }

    public boolean removeLastOccurrence(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = elements.length - 1;
        int i = tail - 1 & j;
        do
        {
            Object obj1 = elements[i];
            if (obj1 == null)
            {
                continue;
            }
            if (obj.equals(obj1))
            {
                delete(i);
                return true;
            }
            i = i - 1 & j;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int size()
    {
        return tail - head & elements.length - 1;
    }

    public Object[] toArray()
    {
        return copyElements(new Object[size()]);
    }

    public Object[] toArray(Object aobj[])
    {
        int i = size();
        Object aobj1[] = aobj;
        if (aobj.length < i)
        {
            aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i);
        }
        copyElements(aobj1);
        if (aobj1.length > i)
        {
            aobj1[i] = null;
        }
        return aobj1;
    }

    static 
    {
        boolean flag;
        if (!net/tsz/afinal/core/ArrayDeque.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }




}
