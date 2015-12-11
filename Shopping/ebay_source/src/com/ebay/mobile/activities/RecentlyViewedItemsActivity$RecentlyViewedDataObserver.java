// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.activities:
//            RecentlyViewedItemsActivity

private final class <init> extends com.ebay.mobile.recents.er
{

    final RecentlyViewedItemsActivity this$0;

    public void onAllViewedItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
    {
        findViewById(0x7f100120).setVisibility(8);
        if (content != null && content.getStatus().hasError())
        {
            Toast.makeText(RecentlyViewedItemsActivity.this, getString(0x7f0703d1), 1).show();
            return;
        } else
        {
            recentsdatamanager = new Intent();
            recentsdatamanager.putExtra("cleared", true);
            setResult(-1, recentsdatamanager);
            finish();
            return;
        }
    }

    private ()
    {
        this$0 = RecentlyViewedItemsActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
