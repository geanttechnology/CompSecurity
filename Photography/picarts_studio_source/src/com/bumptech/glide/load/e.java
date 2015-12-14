// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import android.support.v4.util.ArrayMap;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.bumptech.glide.load:
//            b, c, d

public final class e
    implements b
{

    public final ArrayMap b = new ArrayMap();

    public e()
    {
    }

    public final Object a(c c1)
    {
        if (b.containsKey(c1))
        {
            return b.get(c1);
        } else
        {
            return c1.a;
        }
    }

    public final void a(e e1)
    {
        b.putAll(e1.b);
    }

    public final void a(MessageDigest messagedigest)
    {
        c c1;
        Object obj;
        d d1;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); d1.a(c1.d, obj, messagedigest))
        {
            obj = (java.util.Map.Entry)iterator.next();
            c1 = (c)((java.util.Map.Entry) (obj)).getKey();
            obj = ((java.util.Map.Entry) (obj)).getValue();
            d1 = c1.b;
            if (c1.d == null)
            {
                c1.d = c1.c.getBytes(b.a);
            }
        }

    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof e)
        {
            obj = (e)obj;
            return b.equals(((e) (obj)).b);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return b.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("Options{values=")).append(b).append('}').toString();
    }
}
