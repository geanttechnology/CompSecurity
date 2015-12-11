// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect

private static class <init>
{
    private static class Entry
        implements java.util.Map.Entry
    {

        private final TypeVariable key;
        private final Class value;

        public volatile Object getKey()
        {
            return getKey();
        }

        public TypeVariable getKey()
        {
            return key;
        }

        public Class getValue()
        {
            return value;
        }

        public volatile Object getValue()
        {
            return getValue();
        }

        public Class setValue(Class class1)
        {
            throw new UnsupportedOperationException();
        }

        public volatile Object setValue(Object obj)
        {
            return setValue((Class)obj);
        }

        public Entry(TypeVariable typevariable, Class class1)
        {
            key = typevariable;
            value = class1;
        }
    }


    private final List bindings;

    public Class get(TypeVariable typevariable)
    {
        for (int i = bindings.size() - 1; i >= 0; i--)
        {
            Entry entry = (Entry)bindings.get(i);
            if (entry.getKey().equals(typevariable))
            {
                return entry.getValue();
            }
        }

        return null;
    }

    public void pop(int i)
    {
        int k = bindings.size();
        for (int j = bindings.size() - 1; j >= k - i; j--)
        {
            bindings.remove(j);
        }

    }

    public void put(TypeVariable typevariable, Class class1)
    {
        bindings.add(new Entry(typevariable, class1));
    }

    public Class resolve(Type type)
    {
        if (type instanceof Class)
        {
            return (Class)type;
        }
        if (type instanceof ParameterizedType)
        {
            return (Class)((ParameterizedType)type).getRawType();
        }
        if (type instanceof TypeVariable)
        {
            return get((TypeVariable)type);
        } else
        {
            return null;
        }
    }

    private Entry.value()
    {
        bindings = new ArrayList();
    }

    bindings(bindings bindings1)
    {
        this();
    }
}
