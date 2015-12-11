// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.groupon.db.models.Deal;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.view.GrouponListView;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GoodsMultiOption

class init> extends DealLoaderCallbacks
{

    final GoodsMultiOption this$0;
    final Bundle val$finalSavedInstanceState;

    public void onDealLoaded(Deal deal)
    {
        GoodsMultiOption.access$002(GoodsMultiOption.this, deal);
        GoodsMultiOption.access$100(GoodsMultiOption.this);
        GoodsMultiOption.access$200(GoodsMultiOption.this, val$finalSavedInstanceState);
        listView.setVisibility(0);
        progress.setVisibility(8);
        Ln.d("GoodsMultiOption Deal Loaded", new Object[0]);
    }

    (String s, Bundle bundle)
    {
        this$0 = final_goodsmultioption;
        val$finalSavedInstanceState = bundle;
        super(Context.this, s);
    }
}
