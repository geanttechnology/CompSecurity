// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.google.a.a.e;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;

// Referenced classes of package com.target.mothership.util:
//            o

public class q
{

    private static final String CATEGORY_PREFIX = "category=";
    private static final int ENDECA_BASE = 36;
    private static final String ENDECA_PREFIX = "/N-";
    private static final int NUM_CATEGORY_CHARS = 7;
    private static final int NUM_ENDECA_CHARS = 5;

    public static final e a(String s)
    {
        String s1;
        if (o.c(s) || !s.contains("/N-") && !s.contains("category="))
        {
            return e.e();
        }
        s1 = null;
        if (!s.contains("/N-")) goto _L2; else goto _L1
_L1:
        int i = s.indexOf("/N-") + "/N-".length();
        s1 = s.substring(i, i + 5);
_L4:
        if (!o.g(s1))
        {
            return e.e();
        } else
        {
            return e.b(new EndecaId(s1));
        }
_L2:
        if (!s.contains("category=")) goto _L4; else goto _L3
_L3:
        int j = s.indexOf("category=") + "category=".length();
        s1 = Integer.toString(Integer.parseInt(s.substring(j, j + 7)), 36);
          goto _L4
        s;
        s = e.e();
        if (!o.g(null))
        {
            return e.e();
        } else
        {
            new EndecaId(null);
            return s;
        }
        s;
        s = e.e();
        if (!o.g(null))
        {
            return e.e();
        } else
        {
            new EndecaId(null);
            return s;
        }
        s;
        if (!o.g(null))
        {
            return e.e();
        } else
        {
            new EndecaId(null);
            throw s;
        }
    }

    public static final e b(String s)
    {
        String s1;
        if (o.c(s) || !s.contains("category="))
        {
            return e.e();
        }
        s1 = null;
        if (s.contains("category="))
        {
            int i = s.indexOf("category=") + "category=".length();
            s1 = s.substring(i, i + 7);
        }
        if (!o.g(s1) || !c(s1))
        {
            return e.e();
        } else
        {
            return e.b(new CategoryId(s1));
        }
        s;
        s = e.e();
        if (!o.g(null) || !c(null))
        {
            return e.e();
        } else
        {
            new CategoryId(null);
            return s;
        }
        s;
        s = e.e();
        if (!o.g(null) || !c(null))
        {
            return e.e();
        } else
        {
            new CategoryId(null);
            return s;
        }
        s;
        if (!o.g(null) || !c(null))
        {
            return e.e();
        } else
        {
            new CategoryId(null);
            throw s;
        }
    }

    private static boolean c(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }
}
