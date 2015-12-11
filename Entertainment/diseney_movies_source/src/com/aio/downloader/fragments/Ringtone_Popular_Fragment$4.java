// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.fragments:
//            Ringtone_Popular_Fragment

class this._cls0 extends BroadcastReceiver
{

    final Ringtone_Popular_Fragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Ringtone_Popular_Fragment.access$4(Ringtone_Popular_Fragment.this).setText((new StringBuilder(String.valueOf(Player.formatTime(Ringtone_Popular_Fragment.access$2(Ringtone_Popular_Fragment.this).mediaPlayer.getDuration())))).toString());
        mytotaltime = Ringtone_Popular_Fragment.access$2(Ringtone_Popular_Fragment.this).mediaPlayer.getDuration();
        getActivity().unregisterReceiver(this);
    }

    ()
    {
        this$0 = Ringtone_Popular_Fragment.this;
        super();
    }
}
