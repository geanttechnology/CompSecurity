// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import com.adobe.mediacore.MediaPlayer;
import com.adobe.mediacore.MediaPlayerNotification;
import com.adobe.mediacore.metadata.TimedMetadata;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            AlertAnimationManager, Alert, AlertEventListener

class this._cls0
    implements com.adobe.mediacore.tListener
{

    final AlertAnimationManager this$0;

    public void onPlayComplete()
    {
        String s = AlertAnimationManager.access$200(AlertAnimationManager.this).getIdentifier();
        if (AlertAnimationManager.access$100(AlertAnimationManager.this) != null)
        {
            AlertAnimationManager.access$100(AlertAnimationManager.this).emergencyAlertCompleted(s, false);
        }
        AlertAnimationManager.access$300(AlertAnimationManager.this);
    }

    public void onPlayStart()
    {
    }

    public void onPrepared()
    {
        AlertAnimationManager.access$400(AlertAnimationManager.this).play();
    }

    public void onProfileChanged(long l, long l1)
    {
    }

    public void onRatePlaying(float f)
    {
    }

    public void onRateSelected(float f)
    {
    }

    public void onReplaceMediaPlayerItem()
    {
    }

    public void onSizeAvailable(long l, long l1)
    {
    }

    public void onStateChanged(com.adobe.mediacore.er._cls2 _pcls2, MediaPlayerNotification mediaplayernotification)
    {
        if (_pcls2.equals(com.adobe.mediacore.INITIALIZED))
        {
            AlertAnimationManager.access$400(AlertAnimationManager.this).prepareToPlay();
        }
        if (_pcls2.equals(com.adobe.mediacore.ERROR))
        {
            AlertAnimationManager.access$100(AlertAnimationManager.this).emergencyAlertFailed(AlertAnimationManager.access$200(AlertAnimationManager.this).getIdentifier(), String.valueOf(mediaplayernotification.getCode().getCode()), mediaplayernotification.getDescription(), false);
            AlertAnimationManager.access$300(AlertAnimationManager.this);
        }
    }

    public void onTimedMetadata(TimedMetadata timedmetadata)
    {
    }

    public void onTimelineUpdated()
    {
    }

    public void onUpdated()
    {
    }

    ()
    {
        this$0 = AlertAnimationManager.this;
        super();
    }
}
