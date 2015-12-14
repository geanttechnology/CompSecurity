// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            ii, ij, kn, kg, 
//            ik

class it>
    implements it>
{

    final ij a;
    final ik b;
    final ii c;

    public volatile void a(kn kn1, Object obj)
    {
        a(kn1, (String)obj);
    }

    public void a(kn kn1, String s)
    {
        kg.a(3, ii.b(), (new StringBuilder()).append("Pulse report to ").append(a.i()).append(" for ").append(a.m()).append(", HTTP status code is: ").append(kn1.h()).toString());
        int i = kn1.h();
        b.a((int)kn1.c());
        b.e = i;
        if (!kn1.f())
        {
            Exception exception = kn1.j();
            if (kn1.d())
            {
                if (kn1.i())
                {
                    kg.a(3, ii.b(), (new StringBuilder()).append("Timeout occured when trying to connect to: ").append(a.i()).append(". Exception: ").append(kn1.j().getMessage()).toString());
                } else
                {
                    kg.a(3, ii.b(), (new StringBuilder()).append("Manually managed http request timeout occured for: ").append(a.i()).toString());
                }
                ii.a(c, b, a);
                return;
            } else
            {
                kg.a(3, ii.b(), (new StringBuilder()).append("Error occured when trying to connect to: ").append(a.i()).append(". Exception: ").append(exception.getMessage()).toString());
                ii.a(c, b, a, s);
                return;
            }
        }
        if (i >= 200 && i < 300)
        {
            ii.b(c, b, a);
            return;
        }
        if (i >= 300 && i < 400)
        {
            ii.a(c, b, a, kn1);
            return;
        } else
        {
            kg.a(3, ii.b(), (new StringBuilder()).append(a.m()).append(" report failed sending to : ").append(a.i()).toString());
            ii.a(c, b, a, s);
            return;
        }
    }

    der(ii ii1, ij ij1, ik ik1)
    {
        c = ii1;
        a = ij1;
        b = ik1;
        super();
    }
}
