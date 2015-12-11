// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.fragments:
//            Ringtone_Popular_Fragment

class this._cls0 extends Handler
{

    final Ringtone_Popular_Fragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 500: 
            break;
        }
        try
        {
            Ringtone_Popular_Fragment.access$1(Ringtone_Popular_Fragment.this).setText((new StringBuilder(String.valueOf(Player.formatTime(Ringtone_Popular_Fragment.access$2(Ringtone_Popular_Fragment.this).mediaPlayer.getCurrentPosition())))).toString());
            if (Ringtone_Popular_Fragment.access$3(Ringtone_Popular_Fragment.this).getVisibility() == 8)
            {
                Ringtone_Popular_Fragment.access$2(Ringtone_Popular_Fragment.this).pause();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }

    ()
    {
        this$0 = Ringtone_Popular_Fragment.this;
        super();
    }
}
