// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.AbstractList;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            LazyStringArrayList

private static class list extends AbstractList
{

    private final List list;

    public volatile void add(int i, Object obj)
    {
        add(i, (byte[])obj);
    }

    public void add(int i, byte abyte0[])
    {
        list.add(i, abyte0);
        modCount = modCount + 1;
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public byte[] get(int i)
    {
        Object obj = list.get(i);
        byte abyte0[] = LazyStringArrayList.access$000(obj);
        if (abyte0 != obj)
        {
            list.set(i, abyte0);
        }
        return abyte0;
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public byte[] remove(int i)
    {
        Object obj = list.remove(i);
        modCount = modCount + 1;
        return LazyStringArrayList.access$000(obj);
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (byte[])obj);
    }

    public byte[] set(int i, byte abyte0[])
    {
        return LazyStringArrayList.access$000(list.set(i, abyte0));
    }

    public int size()
    {
        return list.size();
    }

    (List list1)
    {
        list = list1;
    }
}
