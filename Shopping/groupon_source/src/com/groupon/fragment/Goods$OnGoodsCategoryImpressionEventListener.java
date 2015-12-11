// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.adapter.listener.OnCategoryImpressionEventListener;
import com.groupon.models.category.Category;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            Goods

private class <init>
    implements OnCategoryImpressionEventListener
{

    final Goods this$0;

    public void onImpressionEvent(Category category)
    {
        loggingUtils.logGoodsCategoryImpression(category.id);
    }

    private ()
    {
        this$0 = Goods.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
