// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            HttpUtil

public static class prefix
    implements prefix
{

    private String prefix;

    public boolean match(String s)
    {
        return s.startsWith(prefix);
    }

    public (String s)
    {
        prefix = s;
    }
}
