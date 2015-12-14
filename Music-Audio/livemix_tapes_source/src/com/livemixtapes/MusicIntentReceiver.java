// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

// Referenced classes of package com.livemixtapes:
//            App, NowPlayingActivity, console

public class MusicIntentReceiver extends BroadcastReceiver
{

    public MusicIntentReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.media.AUDIO_BECOMING_NOISY"))
        {
            context = new Intent("com.livemixtapes.action.PAUSE");
            context.setPackage("com.livemixtapes");
            App.context.startService(context);
        } else
        if (intent.getAction().equals("android.intent.action.MEDIA_BUTTON"))
        {
            context = (KeyEvent)intent.getExtras().get("android.intent.extra.KEY_EVENT");
            if (context.getAction() == 0)
            {
                switch (context.getKeyCode())
                {
                default:
                    return;

                case 79: // 'O'
                case 85: // 'U'
                    context = new Intent("com.livemixtapes.action.TOGGLE_PLAYBACK");
                    context.setPackage("com.livemixtapes");
                    App.context.startService(context);
                    return;

                case 126: // '~'
                    NowPlayingActivity.play();
                    return;

                case 127: // '\177'
                    NowPlayingActivity.pause();
                    return;

                case 86: // 'V'
                    NowPlayingActivity.stop();
                    return;

                case 87: // 'W'
                    console.log(new Object[] {
                        "NEXT BUTTON PRESSED"
                    });
                    NowPlayingActivity.nextTrack();
                    return;

                case 88: // 'X'
                    NowPlayingActivity.previousTrack();
                    return;
                }
            }
        }
    }
}
