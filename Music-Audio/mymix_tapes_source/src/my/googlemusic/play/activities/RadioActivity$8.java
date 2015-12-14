// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.util.Log;
import com.targetspot.android.sdk.SimpleAdListener;
import my.googlemusic.play.interfaces.Player;

// Referenced classes of package my.googlemusic.play.activities:
//            RadioActivity

class it> extends SimpleAdListener
{

    final RadioActivity this$0;

    public void onAdAvailable()
    {
        Log.d("Sample", "Ad available");
        adAvailable = true;
    }

    public void onAdRefreshing()
    {
        Log.d("Sample", "Ads are being refreshed");
        adAvailable = false;
    }

    public void onError(int i, Exception exception)
    {
        Log.e("Sample", (new StringBuilder()).append("Error ").append(i).append(": ").append(exception.getMessage()).toString());
        RadioActivity.access$500(RadioActivity.this).play();
    }

    public void onPlaybackStarting()
    {
        Log.d("Sample", "Ad playback starting");
    }

    public void onPlaybackStopped(int i)
    {
        String s = "";
        i;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 74
    //                   2 80
    //                   3 92
    //                   4 86;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Log.d("Sample", (new StringBuilder()).append("Ad playback stopped: ").append(s).toString());
        RadioActivity.access$500(RadioActivity.this).play();
        return;
_L2:
        s = "completed";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "cancelled";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "more info request";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "interrupted";
        if (true) goto _L1; else goto _L6
_L6:
    }

    ()
    {
        this$0 = RadioActivity.this;
        super();
    }
}
