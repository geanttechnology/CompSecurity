// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import java.util.Comparator;

// Referenced classes of package com.groupon.service.core:
//            AbTestService

static final class 
    implements Comparator
{

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((String)obj, (String)obj1);
    }

    public int compare(String s, String s1)
    {
        String s2 = s.replaceAll("[^0-9]", "");
        String s3 = s1.replaceAll("[^0-9]", "");
        if (s2.isEmpty() && s3.isEmpty())
        {
            return s.compareToIgnoreCase(s1);
        }
        if (s2.isEmpty())
        {
            return -1;
        }
        if (s3.isEmpty())
        {
            return 1;
        }
        int i = Integer.parseInt(s2);
        int j = Integer.parseInt(s3);
        if (i == j)
        {
            return s.compareToIgnoreCase(s1);
        } else
        {
            return i - j;
        }
    }

    ()
    {
    }
}
