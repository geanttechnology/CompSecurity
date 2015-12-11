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

class this._cls0
    implements com.adobe.mediacore.ntListener
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

    public void onLoadInfo(final LoadInfo loadInfo)
    {
        ThreadManager.getInstance().executeRunnable(new Runnable() {

            final PrimeTimePlayer._cls4 this$1;
            final LoadInfo val$loadInfo;

            public void run()
            {
                if (loadInfo.getSize() != 0L)
                {
                    synchronized (PrimeTimePlayer.access$2000(this$0))
                    {
                        PrimeTimePlayer.access$2000(this$0).addFragment(loadInfo.getDownloadDuration(), loadInfo.getMediaDuration(), loadInfo.getSize());
                    }
                    if (loadInfo.getDownloadDuration() > loadInfo.getMediaDuration() && PrimeTimePlayer.access$1000(this$0) != null)
                    {
                        PrimeTimePlayer.access$1000(this$0).fragmentWarning(loadInfo.getDownloadDuration(), loadInfo.getMediaDuration(), loadInfo.getSize(), loadInfo.getUrl());
                    }
                }
                return;
                exception;
                fragmentinfo;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$1 = PrimeTimePlayer._cls4.this;
                loadInfo = loadinfo;
                super();
            }
        });
    }

    public void onOperationFailed(com.adobe.mediacore.ation.Warning warning)
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

    _cls1.val.loadInfo()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
