// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s, i

public class av extends f
{

    private final PageItemHierarchy mPageItemHierarchy;

    private av(PageItemHierarchy pageitemhierarchy)
    {
        mPageItemHierarchy = pageitemhierarchy;
    }

    public static av a(PageItemHierarchy pageitemhierarchy)
    {
        return new av(pageitemhierarchy);
    }

    protected s c()
    {
        return s.Categories;
    }

    protected List d()
    {
        return com.target.ui.analytics.a.i.b(mPageItemHierarchy);
    }

    protected Long i()
    {
        return Long.valueOf(0L);
    }
}
