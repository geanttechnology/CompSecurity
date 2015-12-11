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
//            RingtoneSearchFragment

class this._cls0 extends Handler
{

    final RingtoneSearchFragment this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 600: 
            break;
        }
        try
        {
            RingtoneSearchFragment.access$1(RingtoneSearchFragment.this).setText((new StringBuilder(String.valueOf(Player.formatTime(RingtoneSearchFragment.access$2(RingtoneSearchFragment.this).mediaPlayer.getCurrentPosition())))).toString());
            if (RingtoneSearchFragment.access$3(RingtoneSearchFragment.this).getVisibility() == 8)
            {
                RingtoneSearchFragment.access$2(RingtoneSearchFragment.this).pause();
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
        this$0 = RingtoneSearchFragment.this;
        super();
    }
}
