// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.AbstractList;
import java.util.List;

// Referenced classes of package com.parse:
//            Lists

private static class size extends AbstractList
{

    private final List list;
    private final int size;

    public volatile Object get(int i)
    {
        return get(i);
    }

    public List get(int i)
    {
        i = size * i;
        int j = Math.min(size + i, list.size());
        return list.subList(i, j);
    }

    public int size()
    {
        return (int)Math.ceil((double)list.size() / (double)size);
    }

    public (List list1, int i)
    {
        list = list1;
        size = i;
    }
}
