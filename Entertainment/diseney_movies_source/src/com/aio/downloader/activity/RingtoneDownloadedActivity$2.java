// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            RingtoneDownloadedActivity

class this._cls0 extends Handler
{

    final RingtoneDownloadedActivity this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 100: // 'd'
            break;
        }
        try
        {
            currenttime.setText((new StringBuilder(String.valueOf(Player.formatTime(RingtoneDownloadedActivity.access$3(RingtoneDownloadedActivity.this).mediaPlayer.getCurrentPosition())))).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }

    ()
    {
        this$0 = RingtoneDownloadedActivity.this;
        super();
    }
}
