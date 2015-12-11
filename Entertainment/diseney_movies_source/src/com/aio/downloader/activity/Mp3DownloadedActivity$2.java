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
//            Mp3DownloadedActivity

class this._cls0 extends Handler
{

    final Mp3DownloadedActivity this$0;

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
            currenttime.setText((new StringBuilder(String.valueOf(Player.formatTime(Mp3DownloadedActivity.access$3(Mp3DownloadedActivity.this).mediaPlayer.getCurrentPosition())))).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
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
