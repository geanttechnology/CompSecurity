// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.TextView;
import com.groupon.callbacks.OnMarketplaceEventListener;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            MarketplaceViewHolder

public class this._cls0
    implements android.view.uttonClickListener
{

    final MarketplaceViewHolder this$0;

    public void onClick(View view)
    {
        boolean flag = expandableTextView.isShown();
        view = expandableTextView;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        ((OnMarketplaceEventListener)callback).onExpandTextClick(flag);
    }

    public Y()
    {
        this$0 = MarketplaceViewHolder.this;
        super();
    }
}
