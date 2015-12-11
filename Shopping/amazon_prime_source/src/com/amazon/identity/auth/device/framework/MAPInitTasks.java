// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.amazon.identity.auth.accounts.SessionUserChangedToAccountForPackageChangedAdpater;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.storage.DirtyDataSyncingService;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.UnitTestUtils;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ServiceWrappingContext, PlatformWrapper

public final class MAPInitTasks
{

    private static final String TAG = com/amazon/identity/auth/device/framework/MAPInitTasks.getName();
    private final Context mContext;
    private final PlatformWrapper mPlatform;

    public MAPInitTasks(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mPlatform = new PlatformWrapper(context);
    }

    public static int getMAPInitVersion(Context context)
    {
        return context.getSharedPreferences("SSOInfo.config", 0).getInt("SSOInfo.config", 0);
    }

    private void setComponentStatus(Class class1, int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (i == 2)
        {
            s = "Disabling ";
        } else
        {
            s = "Enabling ";
        }
        stringbuilder.append(s).append(class1.getSimpleName());
        try
        {
            mContext.getPackageManager().setComponentEnabledSetting(new ComponentName(mContext, class1), i, 1);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            class1.getSimpleName();
        }
    }

    static void setMAPInitVersion(Context context, int i)
    {
        context.getSharedPreferences("SSOInfo.config", 0).edit().putInt("SSOInfo.config", i).commit();
    }

    public void performInitOperations()
    {
        if (UnitTestUtils.isRunningInUnitTest())
        {
            MAPLog.e(TAG, "Not migrating because we are running unit tests");
            return;
        }
        if (ThreadUtils.isRunningOnMainThread())
        {
            MAPLog.e(TAG, "Cannot do MAP init tasks on the main thread!");
            throw new IllegalStateException("Cannot do MAP init tasks on the main thread!");
        }
        Object obj = (DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory");
        MAPLog.i(TAG, "Get DataStorage instance for initialization");
        obj = ((DataStorageFactory) (obj)).getDataStorage();
        MAPLog.i(TAG, "Initialize DataStorage instance");
        ((DataStorage) (obj)).initialize();
        MAPLog.i(TAG, "Setup DataStorage instance");
        ((DataStorage) (obj)).setup();
        setMAPInitVersion(mContext, 3);
        if (com.amazon.identity.auth.device.storage.LambortishClock.ChangeTimestampsBroadcastReceiver.isValidOnThisPlatform(mPlatform))
        {
            setComponentStatus(com/amazon/identity/auth/device/storage/LambortishClock$ChangeTimestampsBroadcastReceiver, 1);
        }
        if (!DirtyDataSyncingService.isValidOnThisPlatform(mPlatform))
        {
            setComponentStatus(com/amazon/identity/auth/device/storage/DirtyDataSyncingService, 2);
        }
        if (!com.amazon.identity.auth.device.storage.DatabaseCleaner.DatabaseCleaningService.isValidOnThisPlatform(mPlatform))
        {
            setComponentStatus(com/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService, 2);
        }
        if (!SessionUserChangedToAccountForPackageChangedAdpater.isValidOnThisPlatform(mPlatform))
        {
            setComponentStatus(com/amazon/identity/auth/accounts/SessionUserChangedToAccountForPackageChangedAdpater, 2);
        }
        setMAPInitVersion(mContext, 4);
    }

}
