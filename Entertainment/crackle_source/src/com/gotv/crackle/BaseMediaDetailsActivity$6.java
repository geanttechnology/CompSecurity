// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.util.OmnitureWrapper;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity, Application, TwitterWebActivity

class this._cls0
    implements android.view.y._cls6
{

    final BaseMediaDetailsActivity this$0;

    public void onClick(View view)
    {
        if (mCurrentDetailsProvider != null && mCurrentDetailsProvider.getRequestState() == com.gotv.crackle.data.MPLETE)
        {
            if (view.getId() == 0x7f0a0169)
            {
                mShareDialog.hide();
                postToFacebook(false, mCurrentDetailsProvider.getMediaDetailsItem());
                Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
            } else
            {
                if (view.getId() == 0x7f0a016a)
                {
                    mShareDialog.hide();
                    view = new Intent(BaseMediaDetailsActivity.this, com/gotv/crackle/TwitterWebActivity);
                    view.putExtra("share_link", mCurrentDetailsProvider.getPermaLink());
                    view.putExtra("share_title", mCurrentDetailsProvider.getTitle());
                    startActivity(view);
                    Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                    return;
                }
                if (view.getId() == 0x7f0a0165)
                {
                    try
                    {
                        shareMailClicked(mCurrentDetailsProvider.getMediaDetailsItem());
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    mShareDialog.hide();
                    Application.getInstance().getOmnitureTracker().onVideoShare("Email", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                    return;
                }
                if (view.getId() == 0x7f0a0167)
                {
                    mShareDialog.hide();
                    shareSMSClicked(mCurrentDetailsProvider.getMediaDetailsItem());
                    Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mCurrentDetailsProvider.getMediaId(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getTitle(), mCurrentDetailsProvider.getRootChannelID(), mCurrentDetailsProvider.getMediaType(), mCurrentDetailsProvider.getSeason(), mCurrentDetailsProvider.getEpisode(), "", "", mCurrentDetailsProvider.getDuration());
                    return;
                }
            }
        }
    }

    te()
    {
        this$0 = BaseMediaDetailsActivity.this;
        super();
    }
}
