// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.g;

// Referenced classes of package com.google.b:
//            l, n

public final class o extends l
{

    public final g a = new g();

    public o()
    {
    }

    public final l a(String s)
    {
        return (l)a.get(s);
    }

    public final void a(String s, l l1)
    {
        Object obj = l1;
        if (l1 == null)
        {
            obj = n.a;
        }
        a.put(s, obj);
    }

    public final boolean equals(Object obj)
    {
        return obj == this || (obj instanceof o) && ((o)obj).a.equals(a);
    }

    public final int hashCode()
    {
        return a.hashCode();
    }
}
