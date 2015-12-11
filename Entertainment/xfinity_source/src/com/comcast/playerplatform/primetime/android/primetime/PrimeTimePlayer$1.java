// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.MediaPlayer;
import com.adobe.mediacore.MediaPlayerItem;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer, PlayerAudioTrack

class val.track
    implements Runnable
{

    final PrimeTimePlayer this$0;
    final PlayerAudioTrack val$track;

    public void run()
    {
        if (PrimeTimePlayer.access$000(PrimeTimePlayer.this) != null && PrimeTimePlayer.access$000(PrimeTimePlayer.this).getCurrentItem() != null)
        {
            PrimeTimePlayer.access$102(PrimeTimePlayer.this, getCurrentAudioTrack());
            PrimeTimePlayer.access$000(PrimeTimePlayer.this).getCurrentItem().selectAudioTrack(val$track.getTrack());
            return;
        }
        try
        {
            PrimeTimePlayer.access$200(PrimeTimePlayer.this).i("com.comcast.playerplatform.primetime::primetimeplayer", "Audio Track not set. Player's currentItem is null.");
            return;
        }
        catch (Exception exception)
        {
            PrimeTimePlayer.access$300(PrimeTimePlayer.this, val$track.getLanguage());
        }
        return;
    }

    ()
    {
        this$0 = final_primetimeplayer;
        val$track = PlayerAudioTrack.this;
        super();
    }
}
