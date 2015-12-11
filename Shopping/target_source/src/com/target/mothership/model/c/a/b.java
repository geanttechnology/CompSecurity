// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c.a;

import com.target.mothership.model.c.c.a.a;
import com.target.mothership.services.x;
import com.target.mothership.util.o;

public class b
{

    private static final String DIGITS = "0123456789";
    private static final int EXPECTED_LENGTH = 5;
    a mError;

    public b(String s)
    {
        mError = null;
        if (o.e(s) || s.length() != 5)
        {
            mError = a(s);
        } else
        if (!a(s, "0123456789"))
        {
            mError = a(s);
            return;
        }
    }

    private a a(String s)
    {
        a a1 = new a();
        a1.a(x.a((new StringBuilder()).append("input zipcode does not pass basic validation. Expected a 5 digit number, but instead found ").append(s).toString()).a());
        a1.a(com.target.mothership.model.c.c.a.a.a.ERR_GEOCODE_FAILED);
        return a1;
    }

    private boolean a(String s, String s1)
    {
        if (!o.e(s))
        {
            if (o.e(s1))
            {
                return false;
            }
            s = s.toCharArray();
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                if (!s1.contains(String.valueOf(s[i])))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public boolean a()
    {
        return mError != null;
    }

    public a b()
    {
        return mError;
    }
}
