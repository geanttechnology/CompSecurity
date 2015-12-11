// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.f;
import com.google.a.a.g;

// Referenced classes of package com.google.a.b:
//            j

public final class l
    implements java.util.Map.Entry
{

    private final Object a;
    private final Object b;
    private final j c;

    l(Object obj, Object obj1, j j1)
    {
        a = obj;
        b = obj1;
        c = (j)g.a(j1);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof java.util.Map.Entry)
        {
            obj = (java.util.Map.Entry)obj;
            flag = flag1;
            if (f.a(getKey(), ((java.util.Map.Entry) (obj)).getKey()))
            {
                flag = flag1;
                if (f.a(getValue(), ((java.util.Map.Entry) (obj)).getValue()))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final Object getKey()
    {
        return a;
    }

    public final Object getValue()
    {
        return b;
    }

    public final int hashCode()
    {
        int k = 0;
        Object obj = getKey();
        Object obj1 = getValue();
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        if (obj1 != null)
        {
            k = obj1.hashCode();
        }
        return k ^ i;
    }

    public final Object setValue(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    public final String toString()
    {
        String s = String.valueOf(String.valueOf(getKey()));
        String s1 = String.valueOf(String.valueOf(getValue()));
        return (new StringBuilder(s.length() + 1 + s1.length())).append(s).append("=").append(s1).toString();
    }
}
