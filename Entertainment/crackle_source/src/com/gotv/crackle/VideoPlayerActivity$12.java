// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.views.MediaControllerView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class  extends BroadcastReceiver
{

    final VideoPlayerActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (!((ConnectivityManager)getSystemService("connectivity")).getNetworkInfo(1).isConnected() && SharedPrefsManager.getWifiOnlyEnabled())
        {
            if (VideoPlayerActivity.access$500(VideoPlayerActivity.this).isPlaying())
            {
                VideoPlayerActivity.access$600(VideoPlayerActivity.this).pausePlayback(false);
            }
            showDialogFragment(0xcb51c);
        }
    }

    ew()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
