// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.support.v4.app.FragmentManager;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.fragments.ShowDetailsButtonsFragment;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            ShowWatchlistDetailsActivity

class this._cls0
    implements Runnable
{

    final ShowWatchlistDetailsActivity this$0;

    public void run()
    {
        if (mChannelID != null)
        {
            ShowDetailsButtonsFragment showdetailsbuttonsfragment = (ShowDetailsButtonsFragment)getSupportFragmentManager().findFragmentById(0x7f0a016e);
            if (showdetailsbuttonsfragment != null)
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (getFullQueueManager() != null)
                {
                    flag = flag1;
                    if (getFullQueueManager().getIDsList() != null)
                    {
                        flag = flag1;
                        if (getFullQueueManager().getIDsList().contains(mChannelID))
                        {
                            flag = true;
                        }
                    }
                }
                showdetailsbuttonsfragment.setAddToWatchlistButtonState(flag);
            }
        }
        if (ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this) != null && ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getMediaId() != null)
        {
            ShowWatchlistDetailsActivity.access$800(ShowWatchlistDetailsActivity.this, ShowWatchlistDetailsActivity.access$400(ShowWatchlistDetailsActivity.this).getMediaId());
        }
    }

    gment()
    {
        this$0 = ShowWatchlistDetailsActivity.this;
        super();
    }
}
