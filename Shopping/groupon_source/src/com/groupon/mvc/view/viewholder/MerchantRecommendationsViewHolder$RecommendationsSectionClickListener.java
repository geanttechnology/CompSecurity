// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.callbacks.OnMerchantRecommendationsClickEventListener;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            MerchantRecommendationsViewHolder

private class <init>
    implements android.view.ctionClickListener
{

    final MerchantRecommendationsViewHolder this$0;

    public void onClick(View view)
    {
        if (callback != null)
        {
            ((OnMerchantRecommendationsClickEventListener)callback).onClick(view, recommendationsLabelView.getText().toString());
        }
    }

    private ()
    {
        this$0 = MerchantRecommendationsViewHolder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
