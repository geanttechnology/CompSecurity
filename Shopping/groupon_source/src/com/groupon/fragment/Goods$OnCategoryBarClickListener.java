// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Intent;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            Goods

private class <init>
    implements android.view.istener
{

    final Goods this$0;

    public void onClick(View view)
    {
        loggingUtils.logCategoryBarClick("browse_by_category", nstChannel, Channel.GOODS.toString());
        view = ((IntentFactory)intentFactory.get()).newGlobalSearchIntent(getChannel());
        view.putExtra("browse_by_category", Goods.access$900(Goods.this));
        startActivity(view);
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
