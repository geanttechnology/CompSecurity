// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.File;
import java.io.IOException;

// Referenced classes of package com.jirbo.adcolony:
//            ak, be, n, dg, 
//            cy, df

class bg
{

    static byte a[] = new byte[1024];
    String b;

    bg(String s)
    {
        b = (new StringBuilder()).append(ak.c.f.d).append(s).toString();
    }

    dg a()
    {
        return new dg(b);
    }

    void a(String s)
    {
        dg dg1 = a();
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            dg1.a(s.charAt(i));
        }

        dg1.d();
    }

    cy b()
    {
        cy cy1;
        try
        {
            cy1 = new cy(new df(b));
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return cy1;
    }

    void c()
    {
        (new File(b)).delete();
    }

}
