// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.listener.OnCategoryItemClickListener;
import com.groupon.models.category.Category;
import com.groupon.util.LoggingUtils;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            Goods

private class <init>
    implements OnCategoryItemClickListener
{

    final Goods this$0;

    public void onItemClick(View view, int i)
    {
        view = (Category)Goods.access$400(Goods.this).get(i);
        loggingUtils.logCategoryCarouselClick("category_click", nstChannel, Channel.GOODS.toString(), view);
        startActivity(((IntentFactory)intentFactory.get()).newCategoryCarouselGlobalSearchResultIntent(channel, view, 1, true, false));
    }

    private A()
    {
        this$0 = Goods.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
