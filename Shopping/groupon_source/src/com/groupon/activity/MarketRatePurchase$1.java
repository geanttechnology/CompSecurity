// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.models.nst.LiveChatExtraInfo;
import com.groupon.tracking.mobile.events.Impression;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.view.LiveChatView;
import com.groupon.view.ObservableScrollView;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase

class this._cls0
    implements com.groupon.view.OnScrollChangedListener
{

    final MarketRatePurchase this$0;

    public void onScrollChanged(ObservableScrollView observablescrollview, int i, int j, int k, int l)
    {
        View view = observablescrollview.getChildAt(observablescrollview.getChildCount() - 1);
        i = view.getBottom();
        k = observablescrollview.getHeight();
        int i1 = observablescrollview.getScrollY();
        int j1 = view.getTop();
        if (l > j && observablescrollview.isScrolledToBottom())
        {
            observablescrollview.setScrolledToBottom(false);
        } else
        if (i - (k + i1 + j1) == 0 && j != l && !observablescrollview.isScrolledToBottom())
        {
            observablescrollview.setScrolledToBottom(true);
            if (liveChatView.getVisibility() == 0)
            {
                logger.log(new Impression("", "show_live_chat", channel.toString(), "bottom", new LiveChatExtraInfo(getClass().getSimpleName(), hotelId)));
                return;
            }
        }
    }

    ion()
    {
        this$0 = MarketRatePurchase.this;
        super();
    }
}
