// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            bu, bl, s, y, 
//            n, v, q, ag, 
//            p

public final class bs extends bu
{

    private final bu a = new bl();

    public bs()
    {
    }

    private static y a(y y1)
        throws s
    {
        String s1 = y1.a();
        if (s1.charAt(0) == '0')
        {
            return new y(s1.substring(1), null, y1.b(), n.n);
        } else
        {
            throw s.a();
        }
    }

    protected final int a(ag ag, int ai[], StringBuffer stringbuffer)
        throws v
    {
        return a.a(ag, ai, stringbuffer);
    }

    public final y a(int i, ag ag, Hashtable hashtable)
        throws v, s, q
    {
        return a(a.a(i, ag, hashtable));
    }

    public final y a(int i, ag ag, int ai[], Hashtable hashtable)
        throws v, s, q
    {
        return a(a.a(i, ag, ai, hashtable));
    }

    public final y a(p p, Hashtable hashtable)
        throws v, s
    {
        return a(a.a(p, hashtable));
    }

    final n b()
    {
        return n.n;
    }
}
