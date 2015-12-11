// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.Set;

// Referenced classes of package com.groupon.util:
//            HttpUtil

public static class excludeSet
    implements excludeSet
{

    private Set excludeSet;

    public boolean match(String s)
    {
        return excludeSet.contains(s);
    }

    public (Set set)
    {
        excludeSet = set;
    }
}
