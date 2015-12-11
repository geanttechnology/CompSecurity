// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.io.Serializable;

// Referenced classes of package com.jirbo.adcolony:
//            a, w

static final class a extends a
    implements Serializable
{

    String a;

    final void a(w w)
    {
        a(w, a);
    }

    final String b()
    {
        return a;
    }

    final double d()
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

    final int e()
    {
        return (int)d();
    }

    final boolean j()
    {
        return true;
    }

    final boolean k()
    {
        String s = a.toLowerCase();
        return s.equals("true") || s.equals("yes");
    }

    xception(String s)
    {
        a = s;
    }
}
