// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.webkit.WebView;
import android.widget.ImageButton;
import com.mixerbox.mixerbox3b.services.MyService;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class <init> extends BroadcastReceiver
{

    final MainPage this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!intent.getAction().equals("android.intent.action.HEADSET_PLUG")) goto _L2; else goto _L1
_L1:
        intent.getIntExtra("state", -1);
        JVM INSTR tableswitch 0 0: default 36
    //                   0 37;
           goto _L2 _L3
_L2:
        return;
_L3:
        if (videoState == 1)
        {
            wv.loadUrl("javascript:pauseVideo()");
            btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
            return;
        }
        if (MyService.mediaPlayer != null && MyService.mediaPlayer.isPlaying())
        {
            MyService.mediaPlayer.pause();
            btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    private ()
    {
        this$0 = MainPage.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
