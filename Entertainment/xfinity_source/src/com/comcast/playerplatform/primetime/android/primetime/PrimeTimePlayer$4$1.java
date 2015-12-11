// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.qos.LoadInfo;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.TimeUtil;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer, PlayerMetrics

class val.loadInfo
    implements Runnable
{

    final val.loadInfo this$1;
    final LoadInfo val$loadInfo;

    public void run()
    {
        if (val$loadInfo.getSize() != 0L)
        {
            synchronized (PrimeTimePlayer.access$2000(_fld0))
            {
                PrimeTimePlayer.access$2000(_fld0).addFragment(val$loadInfo.getDownloadDuration(), val$loadInfo.getMediaDuration(), val$loadInfo.getSize());
            }
            if (val$loadInfo.getDownloadDuration() > val$loadInfo.getMediaDuration() && PrimeTimePlayer.access$1000(_fld0) != null)
            {
                PrimeTimePlayer.access$1000(_fld0).fragmentWarning(val$loadInfo.getDownloadDuration(), val$loadInfo.getMediaDuration(), val$loadInfo.getSize(), val$loadInfo.getUrl());
            }
        }
        return;
        exception;
        fragmentinfo;
        JVM INSTR monitorexit ;
        throw exception;
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$loadInfo = LoadInfo.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$4

/* anonymous class */
    class PrimeTimePlayer._cls4
        implements com.adobe.mediacore.MediaPlayer.QOSEventListener
    {

        final PrimeTimePlayer this$0;

        public void onBufferComplete()
        {
            if (!PrimeTimePlayer.access$500(PrimeTimePlayer.this).isIslatencyComplete())
            {
                PrimeTimePlayer.access$500(PrimeTimePlayer.this).setPlaybackLatencyEnd(TimeUtil.getClockMonoTonicMillis());
                PrimeTimePlayer.access$500(PrimeTimePlayer.this).setIslatencyComplete(true);
            }
            if (PrimeTimePlayer.access$1800(PrimeTimePlayer.this))
            {
                PrimeTimePlayer.access$1802(PrimeTimePlayer.this, false);
            }
            PrimeTimePlayer.access$1900(PrimeTimePlayer.this, 0);
            if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
            {
                PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onBufferComplete();
            }
        }

        public void onBufferStart()
        {
            if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
            {
                PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onBufferStart();
            }
        }

        public void onLoadInfo(LoadInfo loadinfo)
        {
            ThreadManager.getInstance().executeRunnable(loadinfo. new PrimeTimePlayer._cls4._cls1());
        }

        public void onOperationFailed(com.adobe.mediacore.MediaPlayerNotification.Warning warning)
        {
            PrimeTimePlayer.access$1500(PrimeTimePlayer.this, warning);
        }

        public void onSeekComplete(long l)
        {
            if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
            {
                PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onSeekComplete(l);
            }
        }

        public void onSeekStart()
        {
            if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
            {
                PrimeTimePlayer.access$1000(PrimeTimePlayer.this).onSeekStart();
            }
        }

            
            {
                this$0 = PrimeTimePlayer.this;
                super();
            }
    }

}
