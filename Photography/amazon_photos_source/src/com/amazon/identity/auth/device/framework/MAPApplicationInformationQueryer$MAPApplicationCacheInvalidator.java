// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            MAPApplicationInformationQueryer

public static class  extends BroadcastReceiver
{

    private static final AtomicReference CACHE_INVALIDATOR_RECIVER = new AtomicReference();

    public static boolean isRegistered()
    {
        return CACHE_INVALIDATOR_RECIVER.get() != null;
    }

    public static void registerReceiver(Context context)
    {
        CACHE_INVALIDATOR_RECIVER cache_invalidator_reciver = new <init>();
        if (!CACHE_INVALIDATOR_RECIVER.compareAndSet(null, cache_invalidator_reciver))
        {
            MAPLog.formattedInfo(MAPApplicationInformationQueryer.access$000(), "%s is already registered", new Object[] {
                com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator.getSimpleName()
            });
            return;
        }
        MAPApplicationInformationQueryer.access$000();
        com/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer$MAPApplicationCacheInvalidator.getSimpleName();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentfilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentfilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentfilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentfilter.addDataScheme("package");
        try
        {
            context.getApplicationContext().registerReceiver(cache_invalidator_reciver, intentfilter);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.w(MAPApplicationInformationQueryer.access$000(), "Failed to register receiver", context);
        }
    }

    public void onReceive(Context context, Intent intent)
    {
        MAPApplicationInformationQueryer.access$000();
        String.format("Notified by action %s to invalidate app cache", new Object[] {
            intent.getAction()
        });
        MAPApplicationInformationQueryer.getInstance(context).invalidateCache();
    }


    public ()
    {
    }
}
