// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.a;

import com.gimbal.internal.c.c;

// Referenced classes of package com.gimbal.internal.proximity.a:
//            a

public class b
{

    private static final com.gimbal.a.b a = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/a/b.getName());

    public b()
    {
    }

    public static Integer a(String s)
    {
        int i;
        boolean flag;
        flag = false;
        i = ((flag) ? 1 : 0);
        if (!c(s))
        {
            break MISSING_BLOCK_LABEL_36;
        }
        s = s.substring(6, 8);
        i = com.gimbal.internal.c.c.b(s)[0];
        i = (i & 0xff) - 70;
_L2:
        return Integer.valueOf(i);
        s;
        a.c("unable to parse temperature from service ID", new Object[0]);
        i = ((flag) ? 1 : 0);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Integer b(String s)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (c(s))
        {
            int j = Character.digit(s.substring(5, 6).charAt(0), 16);
            i = ((flag) ? 1 : 0);
            if (j >= 0)
            {
                i = (byte)j & 3;
            }
        }
        return Integer.valueOf(i);
    }

    private static boolean c(String s)
    {
        if (s != null && s.length() == 32)
        {
            String s1 = com.gimbal.internal.c.c.c("960c4");
            String s2 = com.gimbal.internal.c.c.c("-244c-11e2-b299-00a0c60077ad");
            if (s.toUpperCase().startsWith(s1.toUpperCase()) && s.toUpperCase().endsWith(s2.toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }

}
