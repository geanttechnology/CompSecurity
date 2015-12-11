// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;


// Referenced classes of package com.google.api.a.g:
//            a, v

final class b
    implements java.util.Entry
{

    final a a;
    private int b;

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof java.util.Entry))
            {
                return false;
            }
            obj = (java.util.Entry)obj;
            if (!v.a(getKey(), ((java.util.Entry) (obj)).getKey()) || !v.a(getValue(), ((java.util.Entry) (obj)).getValue()))
            {
                return false;
            }
        }
        return true;
    }

    public final Object getKey()
    {
        a a1 = a;
        int i = b;
        if (i < 0 || i >= a1.a)
        {
            return null;
        } else
        {
            return a1.b[i << 1];
        }
    }

    public final Object getValue()
    {
        return a.a(b);
    }

    public final int hashCode()
    {
        return getKey().hashCode() ^ getValue().hashCode();
    }

    public final Object setValue(Object obj)
    {
        return a.a(b, obj);
    }

    (a a1, int i)
    {
        a = a1;
        super();
        b = i;
    }
}
