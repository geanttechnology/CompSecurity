// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import java.util.Comparator;

// Referenced classes of package com.sessionm.core:
//            i

static final class r
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((String)obj, (String)obj1);
    }

    public int compare(String s, String s1)
    {
        byte byte0 = 2;
        String as[] = s.split("=");
        String s3 = as[0];
        s = "";
        if (as.length > 1)
        {
            s = as[1];
        }
        int j = 2;
        String s2 = s;
        for (; j < as.length; j++)
        {
            s2 = (new StringBuilder()).append(s2).append("=").append(as[j]).toString();
        }

        s1 = s1.split("=");
        String s4 = s1[0];
        s = "";
        j = byte0;
        if (s1.length > 1)
        {
            s = s1[1];
            j = byte0;
        }
        for (; j < s1.length; j++)
        {
            s = (new StringBuilder()).append(s).append("=").append(s1[j]).toString();
        }

        if (s3.equals(s4))
        {
            return s2.compareTo(s);
        } else
        {
            return s3.compareTo(s4);
        }
    }

    r()
    {
    }
}
