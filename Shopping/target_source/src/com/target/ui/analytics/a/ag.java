// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class ag extends e
{

    private final String mDealName;

    private ag(String s1)
    {
        mDealName = s1;
    }

    public static ag a(String s1)
    {
        return new ag(s1);
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "tapActionName", mDealName);
        return map;
    }

    protected s c()
    {
        return s.DealsMap;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected y i()
    {
        return y.DealsMapProduct;
    }
}
