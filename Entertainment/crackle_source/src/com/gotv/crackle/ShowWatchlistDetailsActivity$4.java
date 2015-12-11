// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.ProgressDialog;
import android.view.View;
import com.gotv.crackle.data.DetailsProvider;

// Referenced classes of package com.gotv.crackle:
//            ShowWatchlistDetailsActivity, Application

class this._cls0
    implements Runnable
{

    final ShowWatchlistDetailsActivity this$0;

    public void run()
    {
        if (mCategory.equalsIgnoreCase("shows"))
        {
            if (ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getDetailsType() == com.gotv.crackle.data.sode)
            {
                if (Application.getInstance().isTablet())
                {
                    ShowWatchlistDetailsActivity.access$500(ShowWatchlistDetailsActivity.this);
                } else
                {
                    ShowWatchlistDetailsActivity.access$600(ShowWatchlistDetailsActivity.this).setVisibility(0);
                    ShowWatchlistDetailsActivity.access$700(ShowWatchlistDetailsActivity.this).setVisibility(8);
                    ShowWatchlistDetailsActivity.access$102(ShowWatchlistDetailsActivity.this, null);
                }
                ShowWatchlistDetailsActivity.access$800(ShowWatchlistDetailsActivity.this, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getMediaId());
                fillMediaDetailsTitleData(0x7f0a0173, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this));
                fillMediaDetailsMoreInfoData(0x7f0a0175, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this));
                ShowWatchlistDetailsActivity.access$900(ShowWatchlistDetailsActivity.this).dismiss();
            }
        } else
        if (mCategory.equalsIgnoreCase("watchlists"))
        {
            if (ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getDetailsType() == com.gotv.crackle.data.sode)
            {
                ShowWatchlistDetailsActivity.access$600(ShowWatchlistDetailsActivity.this).setVisibility(0);
                ShowWatchlistDetailsActivity.access$1000(ShowWatchlistDetailsActivity.this).setVisibility(4);
                ShowWatchlistDetailsActivity.access$1100(ShowWatchlistDetailsActivity.this, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getMediaId());
                fillMediaDetailsTitleData(0x7f0a0173, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this));
                fillMediaDetailsMoreInfoData(0x7f0a0175, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this));
            } else
            {
                ShowWatchlistDetailsActivity.access$600(ShowWatchlistDetailsActivity.this).setVisibility(4);
                ShowWatchlistDetailsActivity.access$1000(ShowWatchlistDetailsActivity.this).setVisibility(0);
                ShowWatchlistDetailsActivity.access$1100(ShowWatchlistDetailsActivity.this, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getMediaId());
                ShowWatchlistDetailsActivity.access$1200(ShowWatchlistDetailsActivity.this);
            }
            if (Application.getInstance().isTablet())
            {
                ShowWatchlistDetailsActivity.access$500(ShowWatchlistDetailsActivity.this);
            } else
            {
                ShowWatchlistDetailsActivity.access$700(ShowWatchlistDetailsActivity.this).setVisibility(8);
                ShowWatchlistDetailsActivity.access$102(ShowWatchlistDetailsActivity.this, null);
            }
            ShowWatchlistDetailsActivity.access$900(ShowWatchlistDetailsActivity.this).dismiss();
            return;
        }
    }

    e()
    {
        this$0 = ShowWatchlistDetailsActivity.this;
        super();
    }
}
