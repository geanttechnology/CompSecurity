// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            ga

final class fz
{

    static String a(String s)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        String s1;
        s1 = s.trim();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s1;
        if (s1.length() != 0) goto _L4; else goto _L3
_L3:
        return null;
    }

    static String a(String s, String s1, String s2)
    {
        if (s == null)
        {
            ga.a(s1, s2, "must not be null");
            return null;
        }
        if (s.length() == 0)
        {
            ga.a(s1, s2, "must not be empty");
            return null;
        }
        s = s.trim();
        if (s.length() == 0)
        {
            ga.a(s1, s2, "must not be blank");
            return null;
        } else
        {
            return s;
        }
    }

    public static String b(String s)
    {
        if (s != null && s.length() != 0)
        {
            if ((s = s.trim()).length() != 0)
            {
                return s;
            }
        }
        return null;
    }
}
