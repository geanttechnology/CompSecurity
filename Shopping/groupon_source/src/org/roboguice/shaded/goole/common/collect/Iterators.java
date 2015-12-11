// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Joiner;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.base.Predicate;
import org.roboguice.shaded.goole.common.base.Predicates;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Collections2, UnmodifiableIterator, UnmodifiableListIterator, AbstractIndexedListIterator, 
//            CollectPreconditions, TransformedIterator

public final class Iterators
{

    static final UnmodifiableListIterator EMPTY_LIST_ITERATOR = new UnmodifiableListIterator() {

        public boolean hasNext()
        {
            return false;
        }

        public boolean hasPrevious()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

        public int nextIndex()
        {
            return 0;
        }

        public Object previous()
        {
            throw new NoSuchElementException();
        }

        public int previousIndex()
        {
            return -1;
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
            CollectPreconditions.checkRemove(false);
        }

    };

    public static boolean addAll(Collection collection, Iterator iterator)
    {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(iterator);
        boolean flag;
        for (flag = false; iterator.hasNext(); flag |= collection.add(iterator.next())) { }
        return flag;
    }

    public static boolean any(Iterator iterator, Predicate predicate)
    {
        return indexOf(iterator, predicate) != -1;
    }

    static void clear(Iterator iterator)
    {
        Preconditions.checkNotNull(iterator);
        for (; iterator.hasNext(); iterator.remove())
        {
            iterator.next();
        }

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
                CollectPreconditions.checkRemove(flag);
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

    public static boolean contains(Iterator iterator, Object obj)
    {
        return any(iterator, Predicates.equalTo(obj));
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
        return emptyListIterator();
    }

    static UnmodifiableListIterator emptyListIterator()
    {
        return EMPTY_LIST_ITERATOR;
    }

    public static transient UnmodifiableIterator forArray(Object aobj[])
    {
        return forArray(aobj, 0, aobj.length, 0);
    }

    static UnmodifiableListIterator forArray(Object aobj[], int i, int j, int k)
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
        Preconditions.checkPositionIndex(k, j);
        if (j == 0)
        {
            return emptyListIterator();
        } else
        {
            return new AbstractIndexedListIterator(j, k, aobj, i) {

                final Object val$array[];
                final int val$offset;

                protected Object get(int l)
                {
                    return array[offset + l];
                }

            
            {
                array = aobj;
                offset = k;
                super(i, j);
            }
            };
        }
    }

    public static Object getNext(Iterator iterator, Object obj)
    {
        if (iterator.hasNext())
        {
            obj = iterator.next();
        }
        return obj;
    }

    public static Object getOnlyElement(Iterator iterator)
    {
        Object obj = iterator.next();
        if (!iterator.hasNext())
        {
            return obj;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder()).append("expected one element but was: <").append(obj).toString());
        for (int i = 0; i < 4 && iterator.hasNext(); i++)
        {
            stringbuilder.append((new StringBuilder()).append(", ").append(iterator.next()).toString());
        }

        if (iterator.hasNext())
        {
            stringbuilder.append(", ...");
        }
        stringbuilder.append('>');
        throw new IllegalArgumentException(stringbuilder.toString());
    }

    public static int indexOf(Iterator iterator, Predicate predicate)
    {
        Preconditions.checkNotNull(predicate, "predicate");
        for (int i = 0; iterator.hasNext(); i++)
        {
            if (predicate.apply(iterator.next()))
            {
                return i;
            }
        }

        return -1;
    }

    public static boolean removeAll(Iterator iterator, Collection collection)
    {
        return removeIf(iterator, Predicates.in(collection));
    }

    public static boolean removeIf(Iterator iterator, Predicate predicate)
    {
        Preconditions.checkNotNull(predicate);
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (predicate.apply(iterator.next()))
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        return flag;
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

    public static String toString(Iterator iterator)
    {
        return Collections2.STANDARD_JOINER.appendTo((new StringBuilder()).append('['), iterator).append(']').toString();
    }

    public static Iterator transform(Iterator iterator, Function function)
    {
        Preconditions.checkNotNull(function);
        return new TransformedIterator(iterator, function) {

            final Function val$function;

            Object transform(Object obj)
            {
                return function.apply(obj);
            }

            
            {
                function = function1;
                super(iterator);
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
