// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.util:
//            Util, BuildUtils

public class ShortcutUtil
{

    private static final String TAG = com/amazon/mShop/util/ShortcutUtil.getSimpleName();

    public ShortcutUtil()
    {
    }

    public static int getAppStartCountInCurrentVersion(Context context)
    {
        if (!isVersionUpToDate(context))
        {
            updateVersion(context);
        }
        return AndroidPlatform.getInstance().getDataStore().getInt("app_start_count_of_current_version");
    }

    public static void increaseAppStartCountInCurrentVersion(Context context)
    {
        if (!isVersionUpToDate(context))
        {
            updateVersion(context);
        }
        context = AndroidPlatform.getInstance().getDataStore();
        context.putInt("app_start_count_of_current_version", context.getInt("app_start_count_of_current_version") + 1);
    }

    public static void installShortcut(Activity activity)
    {
        if (activity == null || activity.getApplicationInfo() == null)
        {
            return;
        } else
        {
            int i = activity.getApplicationInfo().labelRes;
            Intent intent = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            intent.setFlags(0x10200000);
            Intent intent1 = new Intent();
            intent1.putExtra("android.intent.extra.shortcut.INTENT", intent);
            intent1.putExtra("android.intent.extra.shortcut.NAME", activity.getString(i));
            intent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", android.content.Intent.ShortcutIconResource.fromContext(activity, com.amazon.mShop.android.lib.R.drawable.amzn_icon_android));
            intent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
            activity.sendBroadcast(intent1);
            AndroidPlatform.getInstance().getDataStore().putBoolean("is_shortcut_installed", true);
            return;
        }
    }

    public static boolean isAbleToInstallShortcut(Context context)
    {
        Object obj;
        Object obj1;
        Object obj2;
        ContentResolver contentresolver;
        boolean flag1;
        if (context == null)
        {
            return false;
        }
        obj = context.getPackageManager();
        obj2 = context.getPackageName();
        obj1 = null;
        try
        {
            obj2 = ((PackageManager) (obj)).getApplicationInfo(((String) (obj2)), 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        obj = ((PackageManager) (obj)).getApplicationLabel(((ApplicationInfo) (obj2)));
        if (obj != null)
        {
            obj1 = obj.toString();
        }
        if (Util.isEmpty(((String) (obj1))))
        {
            return false;
        }
        obj2 = Uri.parse("content://com.android.launcher2.settings/favorites?notify=true");
        contentresolver = context.getContentResolver();
        flag1 = false;
        obj = null;
        context = null;
        obj1 = contentresolver.query(((Uri) (obj2)), null, "title=?", new String[] {
            obj1
        }, null);
        boolean flag;
        flag = flag1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        flag = flag1;
        context = ((Context) (obj1));
        obj = obj1;
        if (((Cursor) (obj1)).getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        context = ((Context) (obj1));
        obj = obj1;
        if (!DebugSettings.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_140;
        }
        context = ((Context) (obj1));
        obj = obj1;
        Log.d(TAG, "found shortcut in launcher home screen");
        flag = true;
        flag1 = flag;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
            flag1 = flag;
        }
_L1:
        Exception exception;
        return !flag1;
        exception;
        flag = false;
        obj = context;
        exception.printStackTrace();
        flag1 = flag;
        if (context != null)
        {
            context.close();
            flag1 = flag;
        }
          goto _L1
        context;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw context;
    }

    public static boolean isShortcutInstalled(Context context)
    {
        if (!isVersionUpToDate(context))
        {
            updateVersion(context);
        }
        return AndroidPlatform.getInstance().getDataStore().getBoolean("is_shortcut_installed", false);
    }

    private static boolean isVersionUpToDate(Context context)
    {
        return BuildUtils.getVersionName(context).equals(AndroidPlatform.getInstance().getDataStore().getString("shortcut_install_current_version"));
    }

    private static void updateVersion(Context context)
    {
        context = BuildUtils.getVersionName(context);
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        if (!Util.isEmpty(datastore.getString("shortcut_install_current_version")))
        {
            datastore.putInt("app_start_count_of_current_version", 0);
        }
        datastore.putString("shortcut_install_current_version", context);
    }

}
