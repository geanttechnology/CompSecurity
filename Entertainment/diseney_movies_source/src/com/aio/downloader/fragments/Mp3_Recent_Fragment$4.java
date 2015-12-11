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
//            Mp3_Recent_Fragment

class this._cls0 extends BroadcastReceiver
{

    final Mp3_Recent_Fragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Mp3_Recent_Fragment.access$4(Mp3_Recent_Fragment.this).setText((new StringBuilder(String.valueOf(Player.formatTime(Mp3_Recent_Fragment.access$2(Mp3_Recent_Fragment.this).mediaPlayer.getDuration())))).toString());
        Mp3_Recent_Fragment.access$5(Mp3_Recent_Fragment.this, Mp3_Recent_Fragment.access$2(Mp3_Recent_Fragment.this).mediaPlayer.getDuration());
        getActivity().unregisterReceiver(this);
    }

    ()
    {
        this$0 = Mp3_Recent_Fragment.this;
        super();
    }
}
