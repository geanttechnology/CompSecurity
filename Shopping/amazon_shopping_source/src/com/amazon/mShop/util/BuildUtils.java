// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

// Referenced classes of package com.amazon.mShop.util:
//            AttributionUtils, Util, UpgradeUtil

public class BuildUtils
{

    private static final String PARTNER_NAME = "partnerName";
    private static final String TAG = "Amazon";

    public BuildUtils()
    {
    }

    public static String getBetaName(Context context)
    {
        context = AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.beta_name);
        if (Util.isEmpty(context))
        {
            Log.w("Amazon", "missing build beta name");
        }
        return context;
    }

    public static String getPartnerName(Context context)
    {
        String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("partnerName");
        if (!Util.isEmpty(s))
        {
            return s;
        }
        context = getPartnerNameIfEmptyInDataStore(context);
        if (!Util.isEmpty(context))
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("partnerName", context);
        }
        return context;
    }

    private static String getPartnerNameIfEmptyInDataStore(Context context)
    {
        String s;
        String s1;
        s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.config_oemConfigFileName);
        if (!(new File(s)).exists())
        {
            return AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.partner_name);
        }
        s1 = AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.distribution);
        if (!"oem".equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        context = new Properties();
        context.load(new FileInputStream(s));
        context = context.getProperty("partnerName");
        if (Util.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        context = context.trim();
        return context;
        context;
        Log.w("Amazon", context);
_L4:
        return null;
_L2:
        if ("market".equalsIgnoreCase(s1))
        {
            return AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.partner_name);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getRevisionNumber(Context context)
    {
        context = AttributionUtils.readStringFromRawResourceFile(context, com.amazon.mShop.android.lib.R.raw.build_revision);
        if (Util.isEmpty(context))
        {
            Log.w("Amazon", "missing build revision number");
        }
        return context;
    }

    public static int getVersionCode(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Amazon", "Package name is unknown");
            return -1;
        }
        return i;
    }

    public static String getVersionName(Context context)
    {
        Object obj = context.getPackageManager();
        int i;
        try
        {
            obj = ((PackageManager) (obj)).getPackageInfo(context.getPackageName(), 0).versionName;
            i = ((String) (obj)).indexOf('_');
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Amazon", "Package name is unknown");
            return null;
        }
        context = ((Context) (obj));
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        context = ((String) (obj)).substring(0, i);
        return context;
    }

    public static boolean isAssociatesTagUpdate(Context context)
    {
        context = AttributionUtils.getAssociatesTag(context);
        return isStringValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("associatesTagCheckChange"), context, "associatesTagCheckChange");
    }

    public static boolean isGlobalVersionUpdate(Context context)
    {
        int i = getVersionCode(context);
        return isIntValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("globalApplicationVersion"), i, "globalApplicationVersion");
    }

    public static boolean isHardwareIdentifierUpdate(Context context)
    {
        context = (new StringBuilder()).append(Build.MANUFACTURER).append(" ").append(Build.MODEL).toString();
        return isStringValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("hardwareIdentifier"), context, "hardwareIdentifier");
    }

    public static boolean isIntValueUpdate(int i, int j, String s)
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (i != j)
        {
            datastore.putInt(s, j);
        }
        return i != j;
    }

    public static boolean isKiangUpdateActivated(Context context)
    {
        boolean flag = isAssociatesTagUpdate(context);
        boolean flag1 = isGlobalVersionUpdate(context);
        boolean flag2 = isOSVersionUpdate(context);
        boolean flag3 = isHardwareIdentifierUpdate(context);
        boolean flag4 = isUBIDUpdate(context);
        boolean flag5 = isLocaleChanged(context);
        return flag || flag1 || flag2 || flag3 || flag4 || flag5;
    }

    public static boolean isLocaleChanged(Context context)
    {
        context = AppLocale.getInstance().getCurrentLocaleName();
        return isStringValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentLocaleName"), context, "currentLocaleName");
    }

    public static boolean isOSVersionUpdate(Context context)
    {
        context = android.os.Build.VERSION.RELEASE;
        return isStringValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("osVersion"), context, "osVersion");
    }

    public static boolean isStringValueUpdate(String s, String s1, String s2)
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (Util.isEmpty(s1) || s1.equals(s))
        {
            return false;
        } else
        {
            datastore.putString(s2, s1);
            return true;
        }
    }

    public static boolean isUBIDUpdate(Context context)
    {
        context = CookieBridge.getUbidCookie(context);
        return isStringValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("Ubid"), context, "Ubid");
    }

    public static boolean isVersionUpdate(Context context)
    {
        int i = getVersionCode(context);
        boolean flag = isIntValueUpdate(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("applicationVersion"), i, "applicationVersion");
        if (flag)
        {
            UpgradeUtil.clearNewUpgradeInfo();
        }
        return flag;
    }
}
