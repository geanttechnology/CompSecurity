// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s

public class bb extends f
{

    private final int mNumItems;

    private bb(int j)
    {
        mNumItems = j;
    }

    public static bb a(int j)
    {
        return new bb(j);
    }

    protected Map b()
    {
        Map map = super.b();
        map.put("numberOfItemsInLists", String.valueOf(mNumItems));
        map.put("productFindingMethod", "shopping list");
        return map;
    }

    protected s c()
    {
        return com.target.ui.analytics.a.s.List;
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return Long.valueOf(0L);
    }
}
