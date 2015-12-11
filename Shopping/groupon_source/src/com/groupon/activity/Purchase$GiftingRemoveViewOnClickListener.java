// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            Purchase

private class removeView
    implements android.view.istener
{

    private TextView labelView;
    private TextView removeView;
    final Purchase this$0;
    private TextView valueView;

    public void onClick(View view)
    {
        view = new ClickExtraInfo();
        view.pageId = getPageViewId();
        logger.logClick("", "remove_gift_click", channel.toString(), null, view);
        labelView.setText(getString(0x7f080080));
        valueView.setVisibility(8);
        removeView.setVisibility(8);
        giftingRecord = null;
    }

    public (TextView textview, TextView textview1, TextView textview2)
    {
        this$0 = Purchase.this;
        super();
        labelView = textview;
        valueView = textview1;
        removeView = textview2;
    }
}
