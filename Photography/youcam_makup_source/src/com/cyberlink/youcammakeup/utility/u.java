// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            w

public final class u
{

    public static final int a;
    public static final int b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;

    private static int a(String s)
    {
        int i = 0;
        if (s != null)
        {
            if ((s = Pattern.compile(" (\\d+)(?:\\.(\\d+))?").matcher(s)).find())
            {
                int j = Integer.parseInt(s.group(1)) << 16;
                i = j;
                if (s.groupCount() >= 2)
                {
                    return j | Integer.parseInt(s.group(2));
                }
            }
        }
        return i;
    }

    static 
    {
        boolean flag1 = true;
        w w1 = new w();
        a = w1.a[0];
        b = a(w1.b);
        boolean flag;
        if (b >= 0x20000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (b >= 0x30000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if (b >= 0x30001)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        e = flag;
    }
}
