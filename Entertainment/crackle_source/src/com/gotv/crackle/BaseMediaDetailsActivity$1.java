// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Intent;
import android.view.MenuItem;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.OmnitureWrapper;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity, MainActivity, Application

class this._cls0
    implements com.gotv.crackle.data.ener
{

    final BaseMediaDetailsActivity this$0;

    public void onDataFailed(String s, String s1)
    {
        onChannelDataFailed(s, s1);
        s = new Intent(BaseMediaDetailsActivity.this, com/gotv/crackle/MainActivity);
        startActivity(s);
    }

    public void onDataSuccess(String s)
    {
label0:
        {
            if (s.equalsIgnoreCase("DetailsProvider"))
            {
                mCurrentDetailsProvider = mDetailsProvider;
                if (mDetailsProvider != null && mDetailsProvider.getDetailsType() == com.gotv.crackle.data..Movie)
                {
                    Application.getInstance().getOmnitureTracker().detailScreenMovie(mDetailsProvider.getTitle());
                }
                if (!mStartPlaying || mDetailsProvider.getMediaId() == null || BaseMediaDetailsActivity.access$000(BaseMediaDetailsActivity.this).isConnected())
                {
                    break label0;
                }
                if (mMediaID != null)
                {
                    s = mMediaID;
                } else
                {
                    s = mDetailsProvider.getMediaId();
                }
                playMediaItem(s, new Runnable() {

                    final BaseMediaDetailsActivity._cls1 this$1;

                    public void run()
                    {
                        finish();
                    }

            
            {
                this$1 = BaseMediaDetailsActivity._cls1.this;
                super();
            }
                });
            }
            return;
        }
        if (!Application.isLeanBack() && !Application.isNookTablet())
        {
            runOnUiThread(new Runnable() {

                final BaseMediaDetailsActivity._cls1 this$1;

                public void run()
                {
                    if (mDetailsProvider.getMediaDetailsItem() != null && !mDetailsProvider.getMediaDetailsItem().getAmazonLink().isEmpty() && !mDetailsProvider.getMediaDetailsItem().getAmazonLink().equalsIgnoreCase("null") && mBuyItem != null)
                    {
                        mBuyItem.setVisible(true);
                        BaseMediaDetailsActivity.access$102(this$0, mDetailsProvider.getMediaDetailsItem().getAmazonLink());
                    }
                }

            
            {
                this$1 = BaseMediaDetailsActivity._cls1.this;
                super();
            }
            });
        }
        if (!Application.isLeanBack())
        {
            runOnUiThread(new Runnable() {

                final BaseMediaDetailsActivity._cls1 this$1;

                public void run()
                {
                    getAd();
                }

            
            {
                this$1 = BaseMediaDetailsActivity._cls1.this;
                super();
            }
            });
        }
        onChannelDataSuccess();
    }

    _cls3.this._cls1()
    {
        this$0 = BaseMediaDetailsActivity.this;
        super();
    }
}
