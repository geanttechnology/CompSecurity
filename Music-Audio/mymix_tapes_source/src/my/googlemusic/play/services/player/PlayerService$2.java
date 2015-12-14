// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.services.player;

import android.util.Log;
import com.targetspot.android.sdk.SimpleAdListener;

// Referenced classes of package my.googlemusic.play.services.player:
//            PlayerService, PlayerManager

class this._cls0 extends SimpleAdListener
{

    final PlayerService this$0;

    public void onAdAvailable()
    {
        Log.d("Service", "Ad available");
    }

    public void onAdRefreshing()
    {
        Log.d("Service", "Ads are being refreshed");
    }

    public void onError(int i, Exception exception)
    {
        Log.e("Service", (new StringBuilder()).append("Error ").append(i).append(": ").append(exception.getMessage()).toString());
    }

    public void onPlaybackStarting()
    {
        Log.d("Service", "Ad playback starting");
        if (PlayerService.access$000(PlayerService.this).isRadio())
        {
            PlayerService.access$000(PlayerService.this).pause();
            PlayerService.adAvailable = true;
        }
    }

    public void onPlaybackStopped(int i)
    {
        String s = "";
        i;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 76
    //                   2 82
    //                   3 94
    //                   4 88;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        PlayerService.access$000(PlayerService.this).play();
        PlayerService.adAvailable = false;
        Log.d("Service", (new StringBuilder()).append("Ad playback stopped: ").append(s).toString());
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

    _cls9()
    {
        this$0 = PlayerService.this;
        super();
    }
}
