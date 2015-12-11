// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import roboguice.util.Strings;

// Referenced classes of package com.groupon:
//            Channel

static final class it> extends Channel
{

    public String extendedDatabaseChannel(String as[])
    {
        String s = "";
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = as[i];
            s = (new StringBuilder()).append(s).append(s1).toString();
        }

        return encodePath(new String[] {
            name(), Strings.md5(s)
        });
    }

    public boolean isNavigableTo()
    {
        return false;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
