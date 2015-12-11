// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.common.collect:
//            UnmodifiableIterator, AbstractIndexedListIterator, AbstractIterator

public final class Iterators
{

    static final UnmodifiableIterator EMPTY_ITERATOR = new UnmodifiableIterator() {

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

    };
    private static final Iterator EMPTY_MODIFIABLE_ITERATOR = new Iterator() {

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new IllegalStateException();
        }

    };

    public static boolean addAll(Collection collection, Iterator iterator)
    {
        Preconditions.checkNotNull(collection);
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= collection.add(iterator.next())) { }
        return flag;
    }

    public static Iterator concat(Iterator iterator)
    {
        Preconditions.checkNotNull(iterator);
        return new Iterator(iterator) {

            Iterator current;
            Iterator removeFrom;
            final Iterator val$inputs;

            public boolean hasNext()
            {
                do
                {
                    boolean flag = ((Iterator)Preconditions.checkNotNull(current)).hasNext();
                    if (!flag && inputs.hasNext())
                    {
                        current = (Iterator)inputs.next();
                    } else
                    {
                        return flag;
                    }
                } while (true);
            }

            public Object next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                } else
                {
                    removeFrom = current;
                    return current.next();
                }
            }

            public void remove()
            {
                boolean flag;
                if (removeFrom != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Preconditions.checkState(flag, "no calls to next() since last call to remove()");
                removeFrom.remove();
                removeFrom = null;
            }

            
            {
                inputs = iterator;
                super();
                current = Iterators.emptyIterator();
            }
        };
    }

    public static Iterator concat(Iterator iterator, Iterator iterator1)
    {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(iterator1);
        return concat(Arrays.asList(new Iterator[] {
            iterator, iterator1
        }).iterator());
    }

    public static boolean contains(Iterator iterator, Object obj)
    {
label0:
        {
            if (obj == null)
            {
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (iterator.next() != null);
                return true;
            }
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!obj.equals(iterator.next()));
            return true;
        }
        return false;
    }

    public static boolean elementsEqual(Iterator iterator, Iterator iterator1)
    {
        do
        {
            if (iterator.hasNext())
            {
                if (iterator1.hasNext())
                {
                    continue;
                }
            } else
            if (!iterator1.hasNext())
            {
                return true;
            }
            return false;
        } while (Objects.equal(iterator.next(), iterator1.next()));
        return false;
    }

    public static UnmodifiableIterator emptyIterator()
    {
        return EMPTY_ITERATOR;
    }

    public static UnmodifiableIterator filter(Iterator iterator, Predicate predicate)
    {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator(iterator, predicate) {

            final Predicate val$predicate;
            final Iterator val$unfiltered;

            protected Object computeNext()
            {
                while (unfiltered.hasNext()) 
                {
                    Object obj = unfiltered.next();
                    if (predicate.apply(obj))
                    {
                        return obj;
                    }
                }
                return endOfData();
            }

            
            {
                unfiltered = iterator;
                predicate = predicate1;
                super();
            }
        };
    }

    public static transient UnmodifiableIterator forArray(Object aobj[])
    {
        Preconditions.checkNotNull(((Object) (aobj)));
        return new AbstractIndexedListIterator(aobj.length, aobj) {

            final Object val$array[];

            protected Object get(int i)
            {
                return array[i];
            }

            
            {
                array = aobj;
                super(i);
            }
        };
    }

    static UnmodifiableIterator forArray(Object aobj[], int i, int j)
    {
        boolean flag;
        if (j >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        Preconditions.checkPositionIndexes(i, i + j, aobj.length);
        return new AbstractIndexedListIterator(j, aobj, i) {

            final Object val$array[];
            final int val$offset;

            protected Object get(int k)
            {
                return array[offset + k];
            }

            
            {
                array = aobj;
                offset = j;
                super(i);
            }
        };
    }

    public static UnmodifiableIterator singletonIterator(Object obj)
    {
        return new UnmodifiableIterator(obj) {

            boolean done;
            final Object val$value;

            public boolean hasNext()
            {
                return !done;
            }

            public Object next()
            {
                if (done)
                {
                    throw new NoSuchElementException();
                } else
                {
                    done = true;
                    return value;
                }
            }

            
            {
                value = obj;
                super();
            }
        };
    }

    public static int size(Iterator iterator)
    {
        int i;
        for (i = 0; iterator.hasNext(); i++)
        {
            iterator.next();
        }

        return i;
    }

    public static String toString(Iterator iterator)
    {
        if (!iterator.hasNext())
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('[').append(iterator.next());
        for (; iterator.hasNext(); stringbuilder.append(", ").append(iterator.next())) { }
        return stringbuilder.append(']').toString();
    }

    public static Iterator transform(Iterator iterator, Function function)
    {
        Preconditions.checkNotNull(iterator);
        Preconditions.checkNotNull(function);
        return new Iterator(iterator, function) {

            final Iterator val$fromIterator;
            final Function val$function;

            public boolean hasNext()
            {
                return fromIterator.hasNext();
            }

            public Object next()
            {
                Object obj = fromIterator.next();
                return function.apply(obj);
            }

            public void remove()
            {
                fromIterator.remove();
            }

            
            {
                fromIterator = iterator;
                function = function1;
                super();
            }
        };
    }

    public static UnmodifiableIterator unmodifiableIterator(Iterator iterator)
    {
        Preconditions.checkNotNull(iterator);
        if (iterator instanceof UnmodifiableIterator)
        {
            return (UnmodifiableIterator)iterator;
        } else
        {
            return new UnmodifiableIterator(iterator) {

                final Iterator val$iterator;

                public boolean hasNext()
                {
                    return iterator.hasNext();
                }

                public Object next()
                {
                    return iterator.next();
                }

            
            {
                iterator = iterator1;
                super();
            }
            };
        }
    }

}
