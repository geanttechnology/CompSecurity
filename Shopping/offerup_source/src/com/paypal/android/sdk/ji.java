// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gi, gp, gu, fo, 
//            gq

public final class ji
{

    public final gq a;
    public final gu b;

    private ji(gq gq1, gu gu1)
    {
        a = gq1;
        b = gu1;
    }

    ji(gq gq1, gu gu1, byte byte0)
    {
        this(gq1, gu1);
    }

    public static String a(gi gi1)
    {
        String s = gi1.i();
        String s1 = gi1.k();
        gi1 = s;
        if (s1 != null)
        {
            gi1 = (new StringBuilder()).append(s).append('?').append(s1).toString();
        }
        return gi1;
    }

    public static String a(gp gp1)
    {
        if (gp1 == gp.a)
        {
            return "HTTP/1.0";
        } else
        {
            return "HTTP/1.1";
        }
    }

    public static boolean a(gu gu1, gq gq1)
    {
        gu1.c();
        JVM INSTR lookupswitch 13: default 120
    //                   200: 162
    //                   203: 162
    //                   204: 162
    //                   300: 162
    //                   301: 162
    //                   302: 122
    //                   307: 122
    //                   308: 162
    //                   404: 162
    //                   405: 162
    //                   410: 162
    //                   414: 162
    //                   501: 162;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        return false;
_L3:
        if (gu1.a("Expires") == null && gu1.k().c() == -1 && !gu1.k().e() && !gu1.k().d())
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        if (!gu1.k().b() && !gq1.i().b())
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
