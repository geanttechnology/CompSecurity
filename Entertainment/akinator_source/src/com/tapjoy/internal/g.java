// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bu

public final class g
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public long g;

    public g(String s)
    {
        s = bu.b(s);
        s.i();
        while (s.k()) 
        {
            String s1 = s.m();
            if ("productId".equals(s1))
            {
                a = s.n();
            } else
            if ("type".equals(s1))
            {
                b = s.n();
            } else
            if ("price".equals(s1))
            {
                c = s.n();
            } else
            if ("title".equals(s1))
            {
                d = s.n();
            } else
            if ("description".equals(s1))
            {
                e = s.n();
            } else
            if ("price_currency_code".equals(s1))
            {
                f = s.n();
            } else
            if ("price_amount_micros".equals(s1))
            {
                g = s.r();
            } else
            {
                s.t();
            }
        }
        s.j();
    }
}
