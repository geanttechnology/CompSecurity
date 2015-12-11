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
//            Mp3DownloadedActivity

class this._cls0
    implements android.view.adedActivity._cls8
{

    final Mp3DownloadedActivity this$0;

    public void onClick(View view)
    {
        if (Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).mediaPlayer.isPlaying())
        {
            Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).pause();
            Mp3DownloadedActivity.access$12(Mp3DownloadedActivity.this).setBackgroundResource(0x7f02015e);
            Mp3DownloadedActivity.access$13(Mp3DownloadedActivity.this, Boolean.valueOf(true));
            Mp3DownloadedActivity.access$5(Mp3DownloadedActivity.this).setVisibility(8);
            return;
        } else
        {
            Mp3DownloadedActivity.access$12(Mp3DownloadedActivity.this).setBackgroundResource(0x7f02015e);
            Mp3DownloadedActivity.access$13(Mp3DownloadedActivity.this, Boolean.valueOf(true));
            Mp3DownloadedActivity.access$5(Mp3DownloadedActivity.this).setVisibility(8);
            return;
        }
    }

    _cls9()
    {
        this$0 = Mp3DownloadedActivity.this;
        super();
    }
}
