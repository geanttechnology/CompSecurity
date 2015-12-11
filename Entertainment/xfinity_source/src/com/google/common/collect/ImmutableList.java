// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

// Referenced classes of package com.google.common.collect:
//            ImmutableCollection, RegularImmutableList, SingletonImmutableList, EmptyImmutableList, 
//            Lists, UnmodifiableIterator, UnmodifiableListIterator

public abstract class ImmutableList extends ImmutableCollection
    implements List, RandomAccess
{
    private static class SerializedForm
        implements Serializable
    {

        final Object elements[];

        Object readResolve()
        {
            return ImmutableList.copyOf(elements);
        }

        SerializedForm(Object aobj[])
        {
            elements = aobj;
        }
    }


    ImmutableList()
    {
    }

    private static Object checkElementNotNull(Object obj, int i)
    {
        if (obj == null)
        {
            throw new NullPointerException((new StringBuilder()).append("at index ").append(i).toString());
        } else
        {
            return obj;
        }
    }

    private static transient ImmutableList construct(Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            checkElementNotNull(aobj[i], i);
        }

        return new RegularImmutableList(aobj);
    }

    private static ImmutableList copyFromCollection(Collection collection)
    {
        collection = ((Collection) (collection.toArray()));
        switch (collection.length)
        {
        default:
            return construct(collection);

        case 0: // '\0'
            return of();

        case 1: // '\001'
            return new SingletonImmutableList(collection[0]);
        }
    }

    public static ImmutableList copyOf(Collection collection)
    {
        if (collection instanceof ImmutableCollection)
        {
            ImmutableList immutablelist = ((ImmutableCollection)collection).asList();
            collection = immutablelist;
            if (immutablelist.isPartialView())
            {
                collection = copyFromCollection(immutablelist);
            }
            return collection;
        } else
        {
            return copyFromCollection(collection);
        }
    }

    public static ImmutableList copyOf(Object aobj[])
    {
        switch (aobj.length)
        {
        default:
            return construct((Object[])((Object []) (aobj)).clone());

        case 0: // '\0'
            return of();

        case 1: // '\001'
            return new SingletonImmutableList(aobj[0]);
        }
    }

    public static ImmutableList of()
    {
        return EmptyImmutableList.INSTANCE;
    }

    public static ImmutableList of(Object obj)
    {
        return new SingletonImmutableList(obj);
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws InvalidObjectException
    {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public final void add(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i, Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public ImmutableList asList()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return Lists.equalsImpl(this, obj);
    }

    public int hashCode()
    {
        return Lists.hashCodeImpl(this);
    }

    public UnmodifiableIterator iterator()
    {
        return listIterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public UnmodifiableListIterator listIterator()
    {
        return listIterator(0);
    }

    public abstract UnmodifiableListIterator listIterator(int i);

    public volatile ListIterator listIterator()
    {
        return listIterator();
    }

    public volatile ListIterator listIterator(int i)
    {
        return listIterator(i);
    }

    public final Object remove(int i)
    {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i, Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableList subList(int i, int j);

    public volatile List subList(int i, int j)
    {
        return subList(i, j);
    }

    Object writeReplace()
    {
        return new SerializedForm(toArray());
    }
}
