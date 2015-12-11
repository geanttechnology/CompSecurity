// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import com.comcast.playerplatform.util.android.TimeUtil;
import java.util.Date;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer, PlayerMetrics

class  extends AbstractDrmLicenseEventListener
{

    final PrimeTimePlayer this$0;

    public void acquiringLicense(String s)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).acquiringLicense(s);
        }
    }

    public void drmComplete(String s, Date date, Date date1)
    {
        if (!PrimeTimePlayer.access$1600(PrimeTimePlayer.this))
        {
            if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
            {
                PrimeTimePlayer.access$1000(PrimeTimePlayer.this).drmComplete(s, date, date1);
            }
            PrimeTimePlayer.access$500(PrimeTimePlayer.this).setDrmLatencyEnd(TimeUtil.getClockMonoTonicMillis());
        }
    }

    public void drmFailure(String s, String s1, String s2, Exception exception)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).drmFailure(s, s1, s2, exception);
        }
        PrimeTimePlayer.access$2600(PrimeTimePlayer.this, s, (new StringBuilder()).append("drmFailure: ").append(s1).toString(), null);
    }

    public void offlineDRMComplete(String s, Date date, Date date1, String s1)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).offlineDRMComplete(s, date, date1, s1);
        }
    }

    public void offlineDRMFailure(String s, String s1, String s2)
    {
        if (PrimeTimePlayer.access$1000(PrimeTimePlayer.this) != null)
        {
            PrimeTimePlayer.access$1000(PrimeTimePlayer.this).offlineDRMFailure(s, s1);
        }
        PrimeTimePlayer.access$2600(PrimeTimePlayer.this, s, s1, null);
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
