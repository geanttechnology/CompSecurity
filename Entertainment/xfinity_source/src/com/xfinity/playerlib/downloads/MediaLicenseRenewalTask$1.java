// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.google.common.util.concurrent.SettableFuture;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            MediaLicenseRenewalTask

class val.platformAPIFuture
    implements Runnable
{

    final MediaLicenseRenewalTask this$0;
    final SettableFuture val$platformAPIFuture;

    public void run()
    {
        val$platformAPIFuture.set(new PlayerPlatformAPI(MediaLicenseRenewalTask.access$000(MediaLicenseRenewalTask.this), MediaLicenseRenewalTask.access$100(MediaLicenseRenewalTask.this)));
    }

    PlatformAPI()
    {
        this$0 = final_medialicenserenewaltask;
        val$platformAPIFuture = SettableFuture.this;
        super();
    }
}
