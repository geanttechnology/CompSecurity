// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bu

public final class h
{

    public String a;
    public String b;
    public String c;
    public long d;
    public int e;
    public String f;
    public String g;

    public h(String s)
    {
        s = bu.b(s);
        s.i();
        while (s.k()) 
        {
            String s1 = s.m();
            if ("orderId".equals(s1))
            {
                a = s.n();
            } else
            if ("packageName".equals(s1))
            {
                b = s.n();
            } else
            if ("productId".equals(s1))
            {
                c = s.n();
            } else
            if ("purchaseTime".equals(s1))
            {
                d = s.r();
            } else
            if ("purchaseState".equals(s1))
            {
                e = s.s();
            } else
            if ("developerPayload".equals(s1))
            {
                f = s.n();
            } else
            if ("purchaseToken".equals(s1))
            {
                g = s.n();
            } else
            {
                s.t();
            }
        }
        s.j();
    }
}
