// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.amazon.identity.auth.accounts.MultipleAccountType;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.ReflectionHelper;
import com.amazon.identity.auth.device.utils.SerialNumber;
import com.amazon.identity.auth.device.utils.VersionUtils;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class PlatformUtils
{

    public static final String CANARY_PACKAGE_NAME = "com.amazon.canary";
    private static final Set GEN6_TABLET;
    private static final Set GEN7_TABLET;
    public static final String GROVER_PACKAGE_NAME = "com.amazon.fv";
    private static final Object IS_POST_CONGO_AMAZON_DEVICE_LOCK = new Object();
    private static final Set NEW_CENTRAL_PACKAGES;
    private static final Set OLD_SSO_PACKAGES;
    private static final AtomicReference STATIC_IS_AMAZON_DEVICE = new AtomicReference(null);
    private static final String TAG = com/amazon/identity/platform/util/PlatformUtils.getName();
    private static ConcurrentHashMap sHasContentProviderWithAuthority = new ConcurrentHashMap();
    private static ConcurrentHashMap sHasServiceWithAction = new ConcurrentHashMap();
    private static volatile Boolean sIsPostCongoAmazonDevice = null;

    private PlatformUtils()
    {
    }

    public static boolean doesPlatformSupportsMultipleProfiles(Context context)
    {
        return isAmazonDevice(context) && android.os.Build.VERSION.SDK_INT >= 17;
    }

    public static boolean isAmazonAuthenticatorPresent(Context context)
    {
        return CentralApkUtils.isAmazonAuthenticatorPresent(context);
    }

    public static boolean isAmazonDevice(Context context)
    {
        boolean flag1 = false;
        if (STATIC_IS_AMAZON_DEVICE.get() == null)
        {
            boolean flag;
            if (Build.MANUFACTURER.equalsIgnoreCase("Amazon"))
            {
                flag = true;
            } else
            if ((new ReflectionHelper()).getHiddenClass("com.amazon.acos.util.AmazonBuild") != null)
            {
                String s = TAG;
                flag = true;
            } else
            {
                String s1 = TAG;
                flag = false;
            }
            if (flag || PlatformSettings.getInstance(context).getSettingBoolean("is_amazon_device", false))
            {
                flag1 = true;
            }
            STATIC_IS_AMAZON_DEVICE.compareAndSet(null, Boolean.valueOf(flag1));
        }
        return ((Boolean)STATIC_IS_AMAZON_DEVICE.get()).booleanValue();
    }

    public static boolean isBackedByAccountManager(Context context)
    {
        return CentralApkUtils.hasCentralAPK(context);
    }

    public static boolean isFullMAPR5(Context context)
    {
        context = CentralApkUtils.getCentralApkInfo(context);
        if (context == null)
        {
            return true;
        } else
        {
            return NEW_CENTRAL_PACKAGES.contains(((com.amazon.identity.auth.device.utils.CentralApkUtils.CentralApkDescription) (context)).mPackageName);
        }
    }

    public static boolean isGen6Tablet(Context context)
    {
        return GEN6_TABLET.contains(Build.PRODUCT.toLowerCase(Locale.US));
    }

    public static boolean isGen7Tablet(Context context)
    {
        return GEN7_TABLET.contains(Build.PRODUCT.toLowerCase(Locale.US));
    }

    public static boolean isNonAmazonDeviceWithCentralSSO(Context context)
    {
        return !isAmazonDevice(context) && CentralApkUtils.hasCentralAPK(context);
    }

    public static boolean isOtter(Context context)
    {
        context = SerialNumber.getAmazonSerial(context);
        return context != null && context.startsWith("D01E") && Build.MODEL.toLowerCase(Locale.US).equals("kindle fire");
    }

    public static boolean isPostCongoAmazonDevice(Context context)
    {
        boolean flag1 = true;
        if (sIsPostCongoAmazonDevice != null) goto _L2; else goto _L1
_L1:
        Object obj = IS_POST_CONGO_AMAZON_DEVICE_LOCK;
        obj;
        JVM INSTR monitorenter ;
        if (sIsPostCongoAmazonDevice != null) goto _L4; else goto _L3
_L3:
        if (isAmazonDevice(context)) goto _L6; else goto _L5
_L5:
        boolean flag = flag1;
_L8:
        sIsPostCongoAmazonDevice = Boolean.valueOf(flag);
_L4:
        obj;
        JVM INSTR monitorexit ;
_L2:
        return sIsPostCongoAmazonDevice.booleanValue();
_L6:
        com.amazon.identity.auth.device.utils.CentralApkUtils.CentralApkDescription centralapkdescription = CentralApkUtils.getCentralApkInfo(context);
        if (centralapkdescription == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        flag = flag1;
        if (!"com.amazon.dcp".equals(centralapkdescription.mPackageName))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = VersionUtils.getAmazonPackageVersion(context, "com.amazon.dcp");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        int i = context.intValue();
        flag = flag1;
        if (1570 <= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if (true) goto _L8; else goto _L7
_L7:
        context;
        throw context;
    }

    public static boolean isPostMergeDevice(Context context)
    {
        for (context = CentralApkUtils.getCentralApkInfo(context); context == null || OLD_SSO_PACKAGES.contains(((com.amazon.identity.auth.device.utils.CentralApkUtils.CentralApkDescription) (context)).mPackageName);)
        {
            return false;
        }

        return true;
    }

    public static boolean isPreMergeDevice(Context context)
    {
        context = CentralApkUtils.getCentralApkInfo(context);
        if (context == null)
        {
            return false;
        } else
        {
            return OLD_SSO_PACKAGES.contains(((com.amazon.identity.auth.device.utils.CentralApkUtils.CentralApkDescription) (context)).mPackageName);
        }
    }

    public static boolean isThirdPartyDevice(Context context)
    {
        return !CentralApkUtils.hasCentralAPK(context);
    }

    public static boolean shouldUseProfiles(Context context)
    {
        MultipleAccountType multipleaccounttype = MultipleAccountType.getCurrentProfileType(context);
        return MultipleAccountType.Profile == multipleaccounttype || doesPlatformSupportsMultipleProfiles(context);
    }

    public static boolean unSecureCheckHasContentProviderWithAuthority(Context context, Uri uri)
    {
        boolean flag1 = false;
        Boolean boolean1 = (Boolean)sHasContentProviderWithAuthority.get(uri);
        Object obj = boolean1;
        if (boolean1 == null)
        {
            boolean flag = flag1;
            if (uri != null)
            {
                flag = flag1;
                if ((new TrustedPackageManager(context)).getAmazonOwnedContentProvider(uri, 0) != null)
                {
                    flag = true;
                }
            }
            context = (Boolean)sHasContentProviderWithAuthority.putIfAbsent(uri, Boolean.valueOf(flag));
            obj = context;
            if (context == null)
            {
                obj = Boolean.valueOf(flag);
            }
        }
        return ((Boolean) (obj)).booleanValue();
    }

    public static boolean unSecureCheckHasServiceWithAction(Context context, String s)
    {
        boolean flag = false;
        Boolean boolean1 = (Boolean)sHasServiceWithAction.get(s);
        Object obj = boolean1;
        if (boolean1 == null)
        {
            if ((new TrustedPackageManager(context)).queryIntentServices(new Intent(s), 0).size() > 0)
            {
                flag = true;
            }
            context = (Boolean)sHasServiceWithAction.putIfAbsent(s, Boolean.valueOf(flag));
            obj = context;
            if (context == null)
            {
                obj = Boolean.valueOf(flag);
            }
        }
        return ((Boolean) (obj)).booleanValue();
    }

    static 
    {
        HashSet hashset = new HashSet();
        OLD_SSO_PACKAGES = hashset;
        hashset.addAll(Arrays.asList(new String[] {
            "com.amazon.dcp", "com.amazon.sso", "com.amazon.canary", "com.amazon.fv"
        }));
        hashset = new HashSet();
        NEW_CENTRAL_PACKAGES = hashset;
        hashset.addAll(Arrays.asList(new String[] {
            "com.amazon.imp"
        }));
        hashset = new HashSet();
        GEN6_TABLET = hashset;
        hashset.addAll(Arrays.asList(new String[] {
            "soho", "apollo", "thor"
        }));
        hashset = new HashSet();
        GEN7_TABLET = hashset;
        hashset.addAll(Arrays.asList(new String[] {
            "full_ariel", "saturn"
        }));
    }
}
