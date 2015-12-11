// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.settings;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.util.Log;
import com.amazon.dcp.framework.UnitTestUtils;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.dcp.settings:
//            BackgroundSynchronizer, SettingsCacheUpdater, SettingsMap, SettingsNamespace

public final class SettingsCache
{
    public static interface IListener
    {

        public abstract void onCacheUpdated();
    }


    private static final SettingsCache INSTANCE = new SettingsCache();
    private static final AtomicBoolean NEVER_SYNC_WITH_PROVIDER = new AtomicBoolean(false);
    private static final String TAG = com/amazon/dcp/settings/SettingsCache.getName();
    private SettingsCacheUpdater mSettingsCacheUpdater;
    private BackgroundSynchronizer mSynchronizer;

    private SettingsCache()
    {
        clear();
    }

    private static boolean dcpReadPermissionExists(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        boolean flag;
        if (packagemanager.checkSignatures(packagemanager.getPermissionInfo("com.amazon.dcp.settings.permission.READ_SETTINGS", 128).packageName, context.getPackageName()) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            try
            {
                Log.e(TAG, "Somebody is trying something sneaky. The package that owns the permission to read device settings does not have the same signature as this application");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w(TAG, "Permission to read device settings doesn't exist. This is normal on third-party devices.");
                return false;
            }
            return false;
        } else
        {
            return true;
        }
    }

    private static void enforceReadPermission(Context context)
    {
        if (context.getPackageManager().checkPermission("com.amazon.dcp.settings.permission.READ_SETTINGS", context.getPackageName()) != 0)
        {
            throw new SecurityException((new StringBuilder()).append(context.getPackageName()).append(" does not have the permission to read device settings").toString());
        } else
        {
            return;
        }
    }

    static void forceSetContext(Context context)
    {
        NEVER_SYNC_WITH_PROVIDER.set(false);
        INSTANCE.forceSetContextImpl(context.getApplicationContext());
    }

    private void forceSetContextImpl(Context context)
    {
        if (mSynchronizer != null)
        {
            if (!UnitTestUtils.isRunningInUnitTest())
            {
                Log.e(TAG, "Attempted to set context on SettingsCache more than once.");
                return;
            }
            clear();
        }
        mSynchronizer = new BackgroundSynchronizer(mSettingsCacheUpdater, context);
        mSynchronizer.init();
    }

    public static SettingsCache getInstance()
    {
        return INSTANCE;
    }

    public static void setContext(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null");
        }
        if (UnitTestUtils.isRunningInUnitTest() || !dcpReadPermissionExists(context))
        {
            NEVER_SYNC_WITH_PROVIDER.set(true);
            Log.i(TAG, "Always use default values for settings");
            return;
        } else
        {
            enforceReadPermission(context);
            forceSetContext(context);
            return;
        }
    }

    public static void waitForInitialSync()
    {
        INSTANCE.waitForInitialSyncImpl();
    }

    private void waitForInitialSyncImpl()
    {
        if (!NEVER_SYNC_WITH_PROVIDER.get())
        {
            if (INSTANCE.mSynchronizer == null && !UnitTestUtils.isRunningInUnitTest())
            {
                throw new IllegalStateException("Must call SettingsCache.setContext before using SettingsCache.");
            }
            if (mSynchronizer != null)
            {
                mSynchronizer.waitForInitialSync();
                return;
            }
        }
    }

    public void addListener(IListener ilistener)
    {
        mSettingsCacheUpdater.addListener(ilistener);
    }

    void clear()
    {
        mSettingsCacheUpdater = new SettingsCacheUpdater();
        if (mSynchronizer != null)
        {
            mSynchronizer.destroy();
        }
        mSynchronizer = null;
    }

    public String getValue(SettingsNamespace settingsnamespace, String s, String s1)
    {
        waitForInitialSync();
        return mSettingsCacheUpdater.getMap().getValue(settingsnamespace, s, s1);
    }

}
