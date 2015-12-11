// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.security.Key;
import java.util.Iterator;
import java.util.List;

public final class cvl
    implements bjp
{

    private final bjp a;
    private final bjp b;
    private final bjp c;
    private final Key d;
    private final cna e;

    public cvl()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public cvl(bjp bjp1, bjp bjp2, bjp bjp3, Key key, cna cna)
    {
        a = (bjp)b.a(bjp1);
        b = (bjp)b.a(bjp2);
        c = (bjp)b.a(bjp3);
        d = key;
        e = cna;
    }

    public final art b()
    {
        art art1 = (art)a.b_();
        ass ass1 = (ass)b.b_();
        Object obj = art1;
        if (ass1 != null)
        {
            obj = new atc(d.getEncoded(), new byte[4096], new asu(ass1, 0x500000L));
            obj = new asw(ass1, art1, new atd(d.getEncoded(), new asb()), ((ars) (obj)), false, true, e);
        }
        for (Iterator iterator = ((List)c.b_()).iterator(); iterator.hasNext();)
        {
            obj = new asw((ass)iterator.next(), ((art) (obj)), new atd(d.getEncoded(), new asb()), null, false, true, null);
        }

        return ((art) (obj));
    }

    public final Object b_()
    {
        return b();
    }
}
