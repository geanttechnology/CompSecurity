// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.handler.e;

class i
{

    public static final c DEFAULT_ERROR_CODE;

    public static c a(com.target.mothership.model.coupons.handler.c c1)
    {
        c1 = c1.toString();
        c ac[] = c.values();
        int k = ac.length;
        for (int j = 0; j < k; j++)
        {
            c c2 = ac[j];
            if (c2.a().equals(c1))
            {
                return c2;
            }
        }

        return DEFAULT_ERROR_CODE;
    }

    public static c a(e e1)
    {
        e1 = e1.toString();
        c ac[] = c.values();
        int k = ac.length;
        for (int j = 0; j < k; j++)
        {
            c c1 = ac[j];
            if (c1.a().equals(e1))
            {
                return c1;
            }
        }

        return DEFAULT_ERROR_CODE;
    }

    static 
    {
        DEFAULT_ERROR_CODE = c._ERR_UNKNOWN;
    }
}
