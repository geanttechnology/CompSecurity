// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            ce

public class cd
{

    public static ce a(String s)
    {
        if (s != null && !s.isEmpty()) goto _L2; else goto _L1
_L1:
        return ce.a;
_L2:
        String as[];
        as = s.split("\\.");
        if (as.length != 3)
        {
            m.e("VersionUtils", (new StringBuilder()).append("Cannot split \"").append(s).append("\" into 3 parts.").toString());
            continue; /* Loop/switch isn't completed */
        }
        int i;
        int j;
        int k;
        try
        {
            i = Integer.parseInt(as[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.b("VersionUtils", (new StringBuilder()).append("Cannot parse the major number: ").append(as[0]).toString(), s);
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            j = Integer.parseInt(as[1]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            m.b("VersionUtils", (new StringBuilder()).append("Cannot parse the minor number: ").append(as[1]).toString(), s);
            continue; /* Loop/switch isn't completed */
        }
        k = Integer.parseInt(as[2]);
        return new ce(i, j, k);
        s;
        m.b("VersionUtils", (new StringBuilder()).append("Cannot parse the third number: ").append(as[2]).toString(), s);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static boolean a(String s, String s1)
    {
        ce ce1 = a(s);
        if (ce1 == ce.a)
        {
            m.e("VersionUtils", (new StringBuilder()).append("Build version \"").append(s).append("\" is a invalid version.").toString());
        } else
        {
            s = a(s1);
            if (s == ce.a)
            {
                m.e("VersionUtils", (new StringBuilder()).append("Latest version \"").append(s).append("\" is a invalid version.").toString());
            } else
            if (ce1.a(s) >= 0)
            {
                m.c("VersionUtils", "Newest build!!");
            } else
            {
                return true;
            }
        }
        return false;
    }
}
