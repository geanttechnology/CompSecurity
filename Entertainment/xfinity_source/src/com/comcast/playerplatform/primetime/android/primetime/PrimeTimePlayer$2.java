// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.BufferControlParameters;
import com.adobe.mediacore.MediaPlayer;
import com.adobe.mediacore.MediaPlayerItem;
import com.adobe.mediacore.MediaPlayerNotification;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.adobe.mediacore.qos.QOSProvider;
import com.adobe.mediacore.utils.TimeRange;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.util.android.StringUtil;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer, PlayerMetrics

class this._cls0
    implements com.adobe.mediacore.ckEventListener
{

    final PrimeTimePlayer this$0;

    public void onPlayComplete()
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).mediaEnded();
        }
    }

    public void onPlayStart()
    {
        PrimeTimePlayer.access$1102(PrimeTimePlayer.this, 0);
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onPlayStarted();
        }
    }

    public void onPrepared()
    {
        PrimeTimePlayer.access$500(PrimeTimePlayer.this).setPlaybackInformation(PrimeTimePlayer.access$400(PrimeTimePlayer.this).getPlaybackInformation());
        if (PrimeTimePlayer.access$000(PrimeTimePlayer.this).getCurrentItem().isLive())
        {
            Object obj = (new ConfigurationHelper()).getLinearBuffer();
            long l;
            if (!StringUtil.isNotNullOrEmpty(((String) (obj))))
            {
                obj = "0";
            }
            l = Long.parseLong(((String) (obj)));
            PrimeTimePlayer.access$000(PrimeTimePlayer.this).setBufferControlParameters(BufferControlParameters.createDual(PrimeTimePlayer.access$600(PrimeTimePlayer.this), l));
        } else
        {
            PrimeTimePlayer.access$000(PrimeTimePlayer.this).setBufferControlParameters(BufferControlParameters.createDual(PrimeTimePlayer.access$600(PrimeTimePlayer.this), PrimeTimePlayer.access$700(PrimeTimePlayer.this)));
        }
        PrimeTimePlayer.access$000(PrimeTimePlayer.this).prepareBuffer();
        obj = getAdManager();
        if (obj != null && (PrimeTimePlayer.access$800(PrimeTimePlayer.this).getAdType() == AdType.C3 || PrimeTimePlayer.access$800(PrimeTimePlayer.this).getAdType() == AdType.MANIFEST_MANIPULATOR))
        {
            ((BaseAdManager) (obj)).setResumePosition(getCurrentPosition());
        }
    }

    public void onProfileChanged(long l, long l1)
    {
    }

    public void onRatePlaying(float f)
    {
    }

    public void onRateSelected(float f)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).playbackSpeedChanged(f);
        }
    }

    public void onReplaceMediaPlayerItem()
    {
    }

    public void onSizeAvailable(long l, long l1)
    {
    }

    public void onStateChanged(com.adobe.mediacore.State state, MediaPlayerNotification mediaplayernotification)
    {
        PrimeTimePlayer.access$200(PrimeTimePlayer.this).i("com.comcast.playerplatform.primetime::primetimeplayer", (new StringBuilder()).append("onStateChanged Event:").append(state.name()).toString());
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).playStateChanged(PlayerStatus.valueOf(state.name()));
        }
        switch (.SwitchMap.com.adobe.mediacore.MediaPlayer.PlayerState[state.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (PrimeTimePlayer.access$000(PrimeTimePlayer.this).getSeekableRange().contains(PrimeTimePlayer.access$1200(PrimeTimePlayer.this)))
            {
                PrimeTimePlayer.access$000(PrimeTimePlayer.this).prepareToPlay(PrimeTimePlayer.access$1200(PrimeTimePlayer.this));
                return;
            } else
            {
                PrimeTimePlayer.access$000(PrimeTimePlayer.this).prepareToPlay();
                return;
            }

        case 2: // '\002'
            PrimeTimePlayer.access$1300(PrimeTimePlayer.this);
            return;

        case 3: // '\003'
            PrimeTimePlayer.access$1400(PrimeTimePlayer.this);
            return;

        case 4: // '\004'
            PrimeTimePlayer.access$1500(PrimeTimePlayer.this, mediaplayernotification);
            return;
        }
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
        if (PrimeTimePlayer.access$900(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$900(PrimeTimePlayer.this).onTimedMetadata(timedmetadata);
        }
    }

    public void onTimelineUpdated()
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onTimelineUpdated();
        }
    }

    public void onUpdated()
    {
        PrimeTimePlayer.access$200(PrimeTimePlayer.this).d("onUpdated", "");
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
