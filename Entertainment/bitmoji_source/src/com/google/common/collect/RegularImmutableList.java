// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ListIterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableList, ObjectArrays, Iterators, UnmodifiableListIterator

class RegularImmutableList extends ImmutableList
{

    static final ImmutableList EMPTY;
    private final transient Object array[];
    private final transient int offset;
    private final transient int size;

    RegularImmutableList(Object aobj[])
    {
        this(aobj, 0, aobj.length);
    }

    RegularImmutableList(Object aobj[], int i, int j)
    {
        offset = i;
        size = j;
        array = aobj;
    }

    int copyIntoArray(Object aobj[], int i)
    {
        System.arraycopy(((Object) (array)), offset, ((Object) (aobj)), i, size);
        return size + i;
    }

    public Object get(int i)
    {
        Preconditions.checkElementIndex(i, size);
        return array[offset + i];
    }

    boolean isPartialView()
    {
        return size != array.length;
    }

    public UnmodifiableListIterator listIterator(int i)
    {
        return Iterators.forArray(array, offset, size, i);
    }

    public volatile ListIterator listIterator(int i)
    {
        return listIterator(i);
    }

    public int size()
    {
        return size;
    }

    ImmutableList subListUnchecked(int i, int j)
    {
        return new RegularImmutableList(array, offset + i, j - i);
    }

    static 
    {
        EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
    }
}
