// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryView

public class HistoryActivity extends AmazonActivity
{

    private HistoryView mHistoryView;

    public HistoryActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setClickStreamOrigin(ClickStreamTag.ORIGIN_RVI.getTag());
        mHistoryView = new HistoryView(this);
        setRootView(mHistoryView);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mHistoryView = new HistoryView(this);
        setRootView(mHistoryView);
    }

    protected void onStop()
    {
        super.onStop();
        if (mHistoryView != null && mHistoryView.deleteAsinsFromDB())
        {
            mHistoryView.refresh();
        }
    }
}
