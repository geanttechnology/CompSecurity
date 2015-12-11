// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.primetime.android.events.PlayerEventManager;
import java.util.Date;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            PlayerPlatformAPI

class r extends AbstractDrmLicenseEventListener
{

    final PlayerPlatformAPI this$0;

    public void acquiringLicense(String s)
    {
        if (PlayerPlatformAPI.access$600(PlayerPlatformAPI.this) != null)
        {
            PlayerPlatformAPI.access$600(PlayerPlatformAPI.this).acquiringLicense(s);
        }
    }

    public void offlineDRMComplete(String s, Date date, Date date1, String s1)
    {
        if (PlayerPlatformAPI.access$600(PlayerPlatformAPI.this) != null)
        {
            PlayerPlatformAPI.access$600(PlayerPlatformAPI.this).offlineDRMComplete(s, date, date1, s1);
        }
    }

    public void offlineDRMFailure(String s, String s1, String s2)
    {
        if (PlayerPlatformAPI.access$600(PlayerPlatformAPI.this) != null)
        {
            PlayerPlatformAPI.access$600(PlayerPlatformAPI.this).offlineDRMFailure(s, s1);
        }
        if (PlayerPlatformAPI.access$600(PlayerPlatformAPI.this) != null)
        {
            PlayerPlatformAPI.access$600(PlayerPlatformAPI.this).mediaFailed(s, s1);
        }
    }

    r()
    {
        this$0 = PlayerPlatformAPI.this;
        super();
    }
}
