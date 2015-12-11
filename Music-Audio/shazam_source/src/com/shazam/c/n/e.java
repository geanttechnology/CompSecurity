// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.n;

import com.shazam.b.a.a;
import com.shazam.p.p.c;
import com.shazam.p.p.l;
import com.shazam.server.response.search.TopResult;

public final class e
    implements a
{

    private final a a;
    private final a b;

    public e(a a1, a a2)
    {
        a = a1;
        b = a2;
    }

    public final Object a(Object obj)
    {
        TopResult topresult = (TopResult)obj;
        com.shazam.p.p.l.a a1 = new com.shazam.p.p.l.a();
        obj = topresult.artist;
        if (obj != null)
        {
            obj = (c)b.a(obj);
        } else
        {
            obj = null;
        }
        a1.a = ((com.shazam.p.p.b) (obj));
        obj = topresult.track;
        if (obj != null)
        {
            obj = (com.shazam.p.p.e)a.a(obj);
        } else
        {
            obj = null;
        }
        a1.b = ((com.shazam.p.p.b) (obj));
        return new l(a1, (byte)0);
    }
}
