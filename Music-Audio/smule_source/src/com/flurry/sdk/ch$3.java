// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ch, gk, gd, ap, 
//            cq, av

class it>
    implements it>
{

    final String a;
    final ap b;
    final ch c;

    public volatile void a(gk gk1, Object obj)
    {
        a(gk1, (String)obj);
    }

    public void a(gk gk1, String s)
    {
        int i = gk1.e();
        gd.a(3, ch.d(), (new StringBuilder()).append("Prerender: HTTP status code is:").append(i).append(" for url: ").append(a).toString());
        if (gk1.c())
        {
            b.b(s);
            cq.a(ch.l(c));
            ch.m(c);
            return;
        } else
        {
            ch.a(c, b, av.k);
            ch.m(c);
            return;
        }
    }

    der(ch ch1, String s, ap ap1)
    {
        c = ch1;
        a = s;
        b = ap1;
        super();
    }
}
