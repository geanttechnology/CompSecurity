// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;

// Referenced classes of package com.jirbo.adcolony:
//            j, ax

class g extends j
    implements Serializable
{

    String a;

    g(String s)
    {
        a = s;
    }

    void a(ax ax)
    {
        a(ax, a);
    }

    String b()
    {
        return a;
    }

    boolean b_()
    {
        return true;
    }

    double d()
    {
        double d1;
        try
        {
            d1 = Double.parseDouble(a);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0.0D;
        }
        return d1;
    }

    int e()
    {
        return (int)d();
    }

    boolean k()
    {
        String s = a.toLowerCase();
        return s.equals("true") || s.equals("yes");
    }
}
