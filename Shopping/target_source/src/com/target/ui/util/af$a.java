// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import java.math.BigDecimal;
import java.util.Comparator;

// Referenced classes of package com.target.ui.util:
//            af

private static class <init>
    implements Comparator
{

    public int a(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return 0;
        }
        if (s.contains("$"))
        {
            s = s.trim().replace("$", "");
        } else
        {
            s = s.trim();
        }
        if (s1.contains("$"))
        {
            s1 = s1.trim().replace("$", "");
        } else
        {
            s1 = s1.trim();
        }
        if (!af.c(s) || !af.c(s1))
        {
            return 0;
        }
        s = new BigDecimal(s);
        s1 = new BigDecimal(s1);
        if (s.intValue() > s1.intValue())
        {
            return 1;
        }
        return s.intValue() >= s1.intValue() ? 0 : -1;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
