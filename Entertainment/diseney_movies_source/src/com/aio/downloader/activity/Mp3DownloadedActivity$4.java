// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.TextView;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            Mp3DownloadedActivity

class this._cls0 extends BroadcastReceiver
{

    final Mp3DownloadedActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            totaltime.setText((new StringBuilder(String.valueOf(Player.formatTime(Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).mediaPlayer.getDuration())))).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    _cls9()
    {
        this$0 = Mp3DownloadedActivity.this;
        super();
    }
}
