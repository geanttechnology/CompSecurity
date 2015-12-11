// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.ImageButton;
import android.widget.SeekBar;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;

// Referenced classes of package com.gotv.crackle:
//            ChromeCastingDetailsActivity

class val.forceResume
    implements Runnable
{

    final ChromeCastingDetailsActivity this$0;
    final boolean val$forceResume;
    final MediaDetailsItem val$media;

    public void run()
    {
        fillData();
        ChromeCastingDetailsActivity.access$002(ChromeCastingDetailsActivity.this, Integer.parseInt(val$media.getDurationInSeconds()));
        ChromeCastingDetailsActivity.access$102(ChromeCastingDetailsActivity.this, (int)((long)ChromeCastingDetailsActivity.access$000(ChromeCastingDetailsActivity.this) * 1000L));
        ChromeCastingDetailsActivity.access$200(ChromeCastingDetailsActivity.this).setMax(ChromeCastingDetailsActivity.access$100(ChromeCastingDetailsActivity.this));
        ChromeCastingDetailsActivity.access$300(ChromeCastingDetailsActivity.this).setEnabled(true);
        ChromeCastingDetailsActivity.access$300(ChromeCastingDetailsActivity.this).setImageResource(0x7f02010c);
        MediaDetailsItem mediadetailsitem = ChromeCastingDetailsActivity.access$400(ChromeCastingDetailsActivity.this).getMediaDetails();
        if (mediadetailsitem == null || !mediadetailsitem.getID().equals(val$media.getID()))
        {
            float f = SharedPrefsManager.getPlayProgressForItem(val$media.getID());
            if (f > 0.0F && (double)(f / 1000F) < (double)ChromeCastingDetailsActivity.access$000(ChromeCastingDetailsActivity.this) - (double)ChromeCastingDetailsActivity.access$000(ChromeCastingDetailsActivity.this) * 0.10000000000000001D && !mSuppressResumePrompt && !val$forceResume && SharedPrefsManager.getShowResumePrompt())
            {
                ChromeCastingDetailsActivity.access$502(ChromeCastingDetailsActivity.this, val$media);
                ChromeCastingDetailsActivity.access$600(ChromeCastingDetailsActivity.this);
            } else
            {
                ChromeCastingDetailsActivity.access$700(ChromeCastingDetailsActivity.this).loadMedia(val$media, true);
            }
        }
        ChromeCastingDetailsActivity.access$800(ChromeCastingDetailsActivity.this, 0);
        ChromeCastingDetailsActivity.access$900(ChromeCastingDetailsActivity.this, val$media);
    }

    ()
    {
        this$0 = final_chromecastingdetailsactivity;
        val$media = mediadetailsitem;
        val$forceResume = Z.this;
        super();
    }
}
