// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.AmazonIntentService;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DatabaseCleaner, DistributedDataStorage

public static class setContext extends AmazonIntentService
{

    private Context mContext;

    public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
    {
        return DistributedDataStorage.shouldPlatformUseThisStore(platformwrapper);
    }

    protected void protectedOnHandleIntent(Intent intent)
    {
        if (!isValidOnThisPlatform((PlatformWrapper)mContext.getSystemService("sso_platform")))
        {
            MAPLog.e(TAG, "Ignoring Database cleaning request because this platform does not use distributed data storage");
            return;
        }
        MAPLog.i(TAG, "Cleaning database of unneeded items");
        intent = new DatabaseCleaner(mContext);
        intent.cleanDatabase();
        intent.scheduleDatabaseClean();
        return;
        Exception exception;
        exception;
        intent.scheduleDatabaseClean();
        throw exception;
    }

    public void setContext(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
    }

    public ()
    {
        super(com/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService.getName());
        setContext(this);
    }
}
