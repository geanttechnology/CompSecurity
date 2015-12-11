// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            LambortishClock, DistributedDataStorage

public static class  extends BroadcastReceiver
{

    public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
    {
        return DistributedDataStorage.shouldPlatformUseThisStore(platformwrapper);
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getAction();
        if (!"android.intent.action.TIME_SET".equals(intent))
        {
            MAPLog.formattedError(LambortishClock.access$000(), "Cannot Handle intent with action %s", new Object[] {
                intent
            });
            return;
        }
        context = ServiceWrappingContext.create(context);
        if (!DistributedDataStorage.shouldPlatformUseThisStore((PlatformWrapper)context.getSystemService("sso_platform")))
        {
            LambortishClock.access$000();
            return;
        } else
        {
            LambortishClock.getInstance(context).notifySystemTimeChanged();
            return;
        }
    }

    public ()
    {
    }
}
