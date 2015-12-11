// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.w;
import com.google.api.a.g.z;
import java.io.IOException;

// Referenced classes of package com.google.api.a.d:
//            t, m, s, p

public static final class .toString
{

    int a;
    String b;
    m c;
    public String d;
    public String e;

    public (int i, String s1, m m1)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        a = i;
        b = s1;
        c = (m)com.google.api.a.f.a.a.a.a.c.a(m1);
    }

    public a.a.c.a(s s1)
    {
        this(s1.c, s1.d, s1.e.c);
        try
        {
            d = s1.e();
            if (d.length() == 0)
            {
                d = null;
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        s1 = t.a(s1);
        if (d != null)
        {
            s1.append(z.a).append(d);
        }
        e = s1.toString();
    }
}
