// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

// Referenced classes of package com.google.protobuf:
//            LazyStringList, UnmodifiableLazyStringList, ByteString

public class LazyStringArrayList extends AbstractList
    implements LazyStringList, RandomAccess
{

    public static final LazyStringList EMPTY = new UnmodifiableLazyStringList(new LazyStringArrayList());
    private final List list;

    public LazyStringArrayList()
    {
        list = new ArrayList();
    }

    public LazyStringArrayList(LazyStringList lazystringlist)
    {
        list = new ArrayList(lazystringlist.size());
        addAll(lazystringlist);
    }

    private String asString(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            return ((ByteString)obj).toStringUtf8();
        }
    }

    public volatile void add(int i, Object obj)
    {
        add(i, (String)obj);
    }

    public void add(int i, String s)
    {
        list.add(i, s);
        modCount = modCount + 1;
    }

    public void add(ByteString bytestring)
    {
        list.add(bytestring);
        modCount = modCount + 1;
    }

    public boolean addAll(int i, Collection collection)
    {
        Object obj = collection;
        if (collection instanceof LazyStringList)
        {
            obj = ((LazyStringList)collection).getUnderlyingElements();
        }
        boolean flag = list.addAll(i, ((Collection) (obj)));
        modCount = modCount + 1;
        return flag;
    }

    public boolean addAll(Collection collection)
    {
        return addAll(size(), collection);
    }

    public void clear()
    {
        list.clear();
        modCount = modCount + 1;
    }

    public volatile Object get(int i)
    {
        return get(i);
    }

    public String get(int i)
    {
        Object obj = list.get(i);
        if (obj instanceof String)
        {
            return (String)obj;
        }
        obj = (ByteString)obj;
        String s = ((ByteString) (obj)).toStringUtf8();
        if (((ByteString) (obj)).isValidUtf8())
        {
            list.set(i, s);
        }
        return s;
    }

    public ByteString getByteString(int i)
    {
        Object obj = list.get(i);
        if (obj instanceof String)
        {
            obj = ByteString.copyFromUtf8((String)obj);
            list.set(i, obj);
            return ((ByteString) (obj));
        } else
        {
            return (ByteString)obj;
        }
    }

    public List getUnderlyingElements()
    {
        return Collections.unmodifiableList(list);
    }

    public volatile Object remove(int i)
    {
        return remove(i);
    }

    public String remove(int i)
    {
        Object obj = list.remove(i);
        modCount = modCount + 1;
        return asString(obj);
    }

    public volatile Object set(int i, Object obj)
    {
        return set(i, (String)obj);
    }

    public String set(int i, String s)
    {
        return asString(list.set(i, s));
    }

    public int size()
    {
        return list.size();
    }

}
