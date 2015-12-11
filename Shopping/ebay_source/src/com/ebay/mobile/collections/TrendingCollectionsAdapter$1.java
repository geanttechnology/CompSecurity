// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            TrendingCollectionsAdapter

class p extends android.support.v7.widget.kup
{

    final TrendingCollectionsAdapter this$0;

    public int getSpanSize(int i)
    {
        return ((Integer)TrendingCollectionsAdapter.access$000(TrendingCollectionsAdapter.this).get(i)).intValue();
    }

    p()
    {
        this$0 = TrendingCollectionsAdapter.this;
        super();
    }
}
