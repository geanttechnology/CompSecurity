// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.common.params.b;
import com.target.mothership.common.tender.a;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.a.c;
import com.target.mothership.util.o;

public class f
    implements aa
{

    private static int NULL_YEAR = 0;
    private String mSecurityCode;

    public f(String s)
    {
        mSecurityCode = s;
    }

    public c a(b b1)
    {
        c c1 = new c();
        c1.a(b1.a(), b1.b(), b1.c());
        c1.b(b1.i());
        String s;
        if (b1.j() != NULL_YEAR)
        {
            s = String.valueOf(b1.j());
        } else
        {
            s = null;
        }
        c1.c(s);
        if (b1.a() == a.TARGET_DEBIT)
        {
            c1.d(mSecurityCode);
        } else
        {
            c1.e(mSecurityCode);
        }
        if (o.g(b1.d()))
        {
            c1.f(b1.d());
        } else
        if (b1.e() != null)
        {
            c1.a(b1.e());
            return c1;
        }
        return c1;
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }

}
