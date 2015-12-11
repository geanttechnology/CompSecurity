// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import java.util.Locale;

public class ClientMetadata
{
    public static final class MoPubNetworkType extends Enum
    {

        private static final MoPubNetworkType $VALUES[];
        public static final MoPubNetworkType ETHERNET;
        public static final MoPubNetworkType MOBILE;
        public static final MoPubNetworkType UNKNOWN;
        public static final MoPubNetworkType WIFI;
        private final int mId;

        private static MoPubNetworkType fromAndroidNetworkType(int i)
        {
            switch (i)
            {
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            default:
                return UNKNOWN;

            case 9: // '\t'
                return ETHERNET;

            case 1: // '\001'
                return WIFI;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                return MOBILE;
            }
        }

        public static MoPubNetworkType valueOf(String s)
        {
            return (MoPubNetworkType)Enum.valueOf(com/mopub/common/ClientMetadata$MoPubNetworkType, s);
        }

        public static MoPubNetworkType[] values()
        {
            return (MoPubNetworkType[])$VALUES.clone();
        }

        public int getId()
        {
            return mId;
        }

        public String toString()
        {
            return Integer.toString(mId);
        }

        static 
        {
            UNKNOWN = new MoPubNetworkType("UNKNOWN", 0, 0);
            ETHERNET = new MoPubNetworkType("ETHERNET", 1, 1);
            WIFI = new MoPubNetworkType("WIFI", 2, 2);
            MOBILE = new MoPubNetworkType("MOBILE", 3, 3);
            $VALUES = (new MoPubNetworkType[] {
                UNKNOWN, ETHERNET, WIFI, MOBILE
            });
        }


        private MoPubNetworkType(String s, int i, int j)
        {
            super(s, i);
            mId = j;
        }
    }


    private static final String DEVICE_ORIENTATION_LANDSCAPE = "l";
    private static final String DEVICE_ORIENTATION_PORTRAIT = "p";
    private static final String DEVICE_ORIENTATION_SQUARE = "s";
    private static final String DEVICE_ORIENTATION_UNKNOWN = "u";
    private static final String IFA_PREFIX = "ifa:";
    private static final String SHA_PREFIX = "sha:";
    private static final int TYPE_ETHERNET = 9;
    private static final int UNKNOWN_NETWORK = -1;
    private static volatile ClientMetadata sInstance;
    private boolean mAdvertisingInfoSet;
    private String mAppName;
    private final String mAppPackageName;
    private final String mAppVersion;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final String mDeviceManufacturer;
    private final String mDeviceModel;
    private final String mDeviceOsVersion;
    private final String mDeviceProduct;
    private boolean mDoNotTrack;
    private final String mIsoCountryCode;
    private final String mNetworkOperator;
    private String mNetworkOperatorForUrl;
    private String mNetworkOperatorName;
    private final String mSdkVersion = "3.10.0";
    private final String mSimIsoCountryCode;
    private String mSimOperator;
    private String mSimOperatorName;
    private String mUdid;

    public ClientMetadata(Context context)
    {
        mDoNotTrack = false;
        mAdvertisingInfoSet = false;
        mContext = context.getApplicationContext();
        mConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
        mDeviceManufacturer = Build.MANUFACTURER;
        mDeviceModel = Build.MODEL;
        mDeviceProduct = Build.PRODUCT;
        mDeviceOsVersion = android.os.Build.VERSION.RELEASE;
        mAppVersion = getAppVersionFromContext(mContext);
        PackageManager packagemanager = mContext.getPackageManager();
        Object obj = null;
        mAppPackageName = context.getPackageName();
        try
        {
            context = packagemanager.getApplicationInfo(mAppPackageName, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = obj;
        }
        if (context != null)
        {
            mAppName = (String)packagemanager.getApplicationLabel(context);
        }
        context = (TelephonyManager)mContext.getSystemService("phone");
        mNetworkOperatorForUrl = context.getNetworkOperator();
        mNetworkOperator = context.getNetworkOperator();
        if (context.getPhoneType() == 2 && context.getSimState() == 5)
        {
            mNetworkOperatorForUrl = context.getSimOperator();
            mSimOperator = context.getSimOperator();
        }
        mIsoCountryCode = context.getNetworkCountryIso();
        mSimIsoCountryCode = context.getSimCountryIso();
        try
        {
            mNetworkOperatorName = context.getNetworkOperatorName();
            if (context.getSimState() == 5)
            {
                mSimOperatorName = context.getSimOperatorName();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mNetworkOperatorName = null;
            mSimOperatorName = null;
        }
        mUdid = getDeviceIdFromContext(mContext);
    }

    public static void clearForTesting()
    {
        sInstance = null;
    }

    private static String getAppVersionFromContext(Context context)
    {
        try
        {
            String s = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(s, 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MoPubLog.d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
        return context;
    }

    private static String getDeviceIdFromContext(Context context)
    {
        context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (context == null)
        {
            context = "";
        } else
        {
            context = Utils.sha1(context);
        }
        return (new StringBuilder()).append("sha:").append(context).toString();
    }

    public static ClientMetadata getInstance()
    {
        Object obj;
        obj = sInstance;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorenter ;
        obj = sInstance;
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        return ((ClientMetadata) (obj));
        obj;
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        throw obj;
        return ((ClientMetadata) (obj));
    }

    public static ClientMetadata getInstance(Context context)
    {
        ClientMetadata clientmetadata = sInstance;
        if (clientmetadata != null) goto _L2; else goto _L1
_L1:
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorenter ;
        ClientMetadata clientmetadata1 = sInstance;
        clientmetadata = clientmetadata1;
        if (clientmetadata1 != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        clientmetadata = new ClientMetadata(context);
        sInstance = clientmetadata;
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        return clientmetadata;
_L4:
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        throw context;
        context;
        continue; /* Loop/switch isn't completed */
_L2:
        return clientmetadata;
        context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void setInstance(ClientMetadata clientmetadata)
    {
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorenter ;
        sInstance = clientmetadata;
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        return;
        clientmetadata;
        com/mopub/common/ClientMetadata;
        JVM INSTR monitorexit ;
        throw clientmetadata;
    }

    public MoPubNetworkType getActiveNetworkType()
    {
        int i = -1;
        if (mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)
        {
            NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkinfo != null)
            {
                i = networkinfo.getType();
            } else
            {
                i = -1;
            }
        }
        return MoPubNetworkType.fromAndroidNetworkType(i);
    }

    public String getAppName()
    {
        return mAppName;
    }

    public String getAppPackageName()
    {
        return mAppPackageName;
    }

    public String getAppVersion()
    {
        return mAppVersion;
    }

    public float getDensity()
    {
        return mContext.getResources().getDisplayMetrics().density;
    }

    public Point getDeviceDimensions()
    {
        if (Preconditions.NoThrow.checkNotNull(mContext))
        {
            return DeviceUtils.getDeviceDimensions(mContext);
        } else
        {
            return new Point(0, 0);
        }
    }

    public String getDeviceId()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mUdid;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public Locale getDeviceLocale()
    {
        return mContext.getResources().getConfiguration().locale;
    }

    public String getDeviceManufacturer()
    {
        return mDeviceManufacturer;
    }

    public String getDeviceModel()
    {
        return mDeviceModel;
    }

    public String getDeviceOsVersion()
    {
        return mDeviceOsVersion;
    }

    public String getDeviceProduct()
    {
        return mDeviceProduct;
    }

    public int getDeviceScreenHeightDip()
    {
        return Dips.screenHeightAsIntDips(mContext);
    }

    public int getDeviceScreenWidthDip()
    {
        return Dips.screenWidthAsIntDips(mContext);
    }

    public String getIsoCountryCode()
    {
        return mIsoCountryCode;
    }

    public String getNetworkOperator()
    {
        return mNetworkOperator;
    }

    public String getNetworkOperatorForUrl()
    {
        return mNetworkOperatorForUrl;
    }

    public String getNetworkOperatorName()
    {
        return mNetworkOperatorName;
    }

    public String getOrientationString()
    {
        int i = mContext.getResources().getConfiguration().orientation;
        String s = "u";
        if (i == 1)
        {
            s = "p";
        } else
        {
            if (i == 2)
            {
                return "l";
            }
            if (i == 3)
            {
                return "s";
            }
        }
        return s;
    }

    public String getSdkVersion()
    {
        return mSdkVersion;
    }

    public String getSimIsoCountryCode()
    {
        return mSimIsoCountryCode;
    }

    public String getSimOperator()
    {
        return mSimOperator;
    }

    public String getSimOperatorName()
    {
        return mSimOperatorName;
    }

    public boolean isAdvertisingInfoSet()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mAdvertisingInfoSet;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isDoNotTrackSet()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mDoNotTrack;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAdvertisingInfo(String s, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        mUdid = (new StringBuilder()).append("ifa:").append(s).toString();
        mDoNotTrack = flag;
        mAdvertisingInfoSet = true;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
