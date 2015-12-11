// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            RingtoneDownloadedActivity

class this._cls0
    implements android.view.adedActivity._cls8
{

    final RingtoneDownloadedActivity this$0;

    public void onClick(View view)
    {
        if (RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).mediaPlayer.isPlaying())
        {
            RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).pause();
            RingtoneDownloadedActivity.access$12(RingtoneDownloadedActivity.this).setBackgroundResource(0x7f02015e);
            RingtoneDownloadedActivity.access$13(RingtoneDownloadedActivity.this, Boolean.valueOf(true));
            RingtoneDownloadedActivity.access$5(RingtoneDownloadedActivity.this).setVisibility(8);
            return;
        } else
        {
            RingtoneDownloadedActivity.access$12(RingtoneDownloadedActivity.this).setBackgroundResource(0x7f02015e);
            RingtoneDownloadedActivity.access$13(RingtoneDownloadedActivity.this, Boolean.valueOf(true));
            RingtoneDownloadedActivity.access$5(RingtoneDownloadedActivity.this).setVisibility(8);
            return;
        }
    }

    ()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
