// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.system;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.android.util.system:
//            Installation

public class AndroidDevice
{

    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/android/util/system/AndroidDevice);
    private final String appId;
    protected final Application application;
    protected final Resources resources;
    protected final TelephonyManager telephonyManager;

    public AndroidDevice(Application application1, Resources resources1, TelephonyManager telephonymanager, String s)
    {
        application = application1;
        resources = resources1;
        telephonyManager = telephonymanager;
        appId = s;
    }

    private static String getBrandDeviceAndModelDescription()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Build.BRAND);
        stringbuilder.append(" ");
        stringbuilder.append(Build.DEVICE);
        stringbuilder.append(" ");
        stringbuilder.append(Build.MODEL);
        return stringbuilder.toString();
    }

    public String getAndroidPrefixedBuildVersionRelease()
    {
        return (new StringBuilder()).append("Android ").append(getBuildVersionRelease()).toString();
    }

    public String getAppId()
    {
        return appId;
    }

    public String getBuildVersionRelease()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    public String getCarrier()
    {
        return telephonyManager.getNetworkOperatorName();
    }

    public float getDensity()
    {
        return resources.getDisplayMetrics().density;
    }

    public String getDeviceDisplayName()
    {
        return (new StringBuilder()).append(Build.BRAND).append(" ").append(Build.MODEL).toString().trim();
    }

    public String getDeviceId()
    {
        if (telephonyManager.getDeviceId() == null) goto _L2; else goto _L1
_L1:
        String s = telephonyManager.getDeviceId();
_L4:
        return s;
_L2:
        String s1;
        s1 = android.provider.Settings.Secure.getString(application.getContentResolver(), "android_id");
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = s1;
        if (!s1.contains("0123456789")) goto _L4; else goto _L3
_L3:
        return Installation.id(application);
    }

    public String getDeviceName()
    {
        return getDeviceId();
    }

    public int getDevicePhysicalSize()
    {
        return resources.getConfiguration().screenLayout & 0xf;
    }

    public String getDeviceType()
    {
        return getBrandDeviceAndModelDescription();
    }

    public int getLandscapeOrientation()
    {
        return 6;
    }

    public int getPortraitOrientation()
    {
        return 7;
    }

    public String getPropertyOsVersion()
    {
        return System.getProperty("os.version");
    }

    public int getScreenWidth()
    {
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        if (displaymetrics.widthPixels > displaymetrics.heightPixels)
        {
            return displaymetrics.widthPixels;
        } else
        {
            return displaymetrics.heightPixels;
        }
    }

    public boolean isDebuggable()
    {
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag = false;
        boolean flag1 = flag3;
        boolean flag2 = flag4;
        Signature asignature[];
        CertificateFactory certificatefactory;
        int i;
        try
        {
            asignature = application.getPackageManager().getPackageInfo(application.getPackageName(), 64).signatures;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return flag2;
        }
        catch (CertificateException certificateexception)
        {
            return flag1;
        }
        flag1 = flag3;
        flag2 = flag4;
        certificatefactory = CertificateFactory.getInstance("X.509");
        i = 0;
_L2:
        flag3 = flag;
        flag1 = flag;
        flag2 = flag;
        if (i >= asignature.length)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        flag1 = flag;
        flag2 = flag;
        flag = ((X509Certificate)certificatefactory.generateCertificate(new ByteArrayInputStream(asignature[i].toByteArray()))).getSubjectX500Principal().equals(DEBUG_DN);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        flag3 = flag;
        return flag3;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean isKindle()
    {
        return Build.MANUFACTURER.equalsIgnoreCase("amazon");
    }

    public boolean isKindleOrFromAmazonStore()
    {
        boolean flag1 = isKindle();
        String s = application.getPackageManager().getInstallerPackageName(application.getPackageName());
        boolean flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (s != null)
            {
                flag = s.equalsIgnoreCase("com.amazon.venezia");
            }
        }
        return flag;
    }

    public boolean isTabletDevice()
    {
        return resources.getBoolean(com.comcast.cim.cmasl.android.util.R.bool.isTablet);
    }

    public boolean wantsStaticBitrate()
    {
        return Build.MODEL.equals("KFJWI") || Build.MODEL.equals("KFJWA") || Build.MODEL.equals("Transformer TF101");
    }

}
