// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;


// Referenced classes of package com.google.a.a:
//            d

final class nit> extends d
{

    final String b;
    final d c;

    final CharSequence a(Object obj)
    {
        if (obj == null)
        {
            return b;
        } else
        {
            return c.a(obj);
        }
    }

    public final d b(String s)
    {
        throw new UnsupportedOperationException("already specified useForNull");
    }

    nce(d d1, d d2, String s)
    {
        c = d1;
        b = s;
        super(d2, (byte)0);
    }
}
