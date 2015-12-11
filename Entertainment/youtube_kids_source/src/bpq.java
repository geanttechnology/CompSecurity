// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;

public final class bpq
{

    private static final Map a = new bpr();
    private static final Map b = new bps();
    private static final Map c = new bpt();

    static int a(String s, Map map, int i)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = (Integer)map.get(s);
        }
        if (s == null)
        {
            return 0;
        } else
        {
            return s.intValue();
        }
    }

    static Map a()
    {
        return c;
    }

    public static void a(String s, bnr bnr1)
    {
        b.a(s);
        b.a(bnr1);
        bnr1.a(String.valueOf(s).concat("/card"), new bpz()).a(String.valueOf(s).concat("/card/action"), new bpy()).a(String.valueOf(s).concat("/card/action/event"), new bpx()).a(String.valueOf(s).concat("/card/event"), new bpw()).a(String.valueOf(s).concat("/card/app_card"), new bpv()).a(String.valueOf(s).concat("/card/app_card/icon"), new bpu());
    }

    static Map b()
    {
        return b;
    }

    static Map c()
    {
        return a;
    }

}
