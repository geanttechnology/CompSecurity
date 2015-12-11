// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.paypal.android.lib.riskcomponent.checker.EmulatorChecker;
import com.paypal.android.lib.riskcomponent.checker.RootAccessChecker;
import com.paypal.android.lib.riskcomponent.utils.PPRiskCDS;
import com.paypal.android.lib.riskcomponent.utils.PPRiskData;
import com.paypal.android.lib.riskcomponent.utils.Util;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.paypal.android.lib.riskcomponent:
//            RiskBlob, Configuration, SourceApp, AppInfo, 
//            Session

public class RiskComponent
{

    private static final String TAG = com/paypal/android/lib/riskcomponent/RiskComponent.getSimpleName();
    private static RiskComponent mInstance;
    private static final Object mLock = new Object();
    private String mApplicationGuid;
    private Configuration mConfig;
    private String mConfigUrl;
    private Context mContext;
    private Location mCurrentLocation;
    private RiskBlob mCurrentRiskBlob;
    private Map mCustomRiskBlobValues;
    private String mPairingID;
    private String mRegistrationId;
    private SourceApp mSourceApp;
    private String mSourceAppVersion;

    private RiskComponent()
    {
    }

    private long getAppFirstInstallTime(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return 0L;
_L2:
        long l;
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0L;
        }
        if (context == null) goto _L1; else goto _L3
_L3:
        l = (new File(context)).lastModified();
        return l;
    }

    private long getAppLastUpdateTime(Context context)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return 0L;
_L2:
        long l;
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            }
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 0L;
        }
        if (context == null) goto _L1; else goto _L3
_L3:
        l = (new File(context)).lastModified();
        return l;
    }

    public static RiskComponent getInstance()
    {
        RiskComponent riskcomponent;
        synchronized (mLock)
        {
            if (mInstance == null)
            {
                mInstance = new RiskComponent();
            }
            riskcomponent = mInstance;
        }
        return riskcomponent;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private RiskBlob getRefreshedRiskBlob()
    {
        if (mContext != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L64:
        return ((RiskBlob) (obj));
_L2:
        Object obj1;
        Object obj2;
        RiskBlob riskblob;
        AppInfo appinfo;
        Object obj3;
        TelephonyManager telephonymanager;
        int i;
        riskblob = new RiskBlob();
        PPRiskCDS ppriskcds;
        Date date;
        boolean flag;
        try
        {
            ppriskcds = mConfig.getCDS();
            telephonymanager = (TelephonyManager)mContext.getSystemService("phone");
            obj = (ConnectivityManager)mContext.getSystemService("connectivity");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Util.logExceptionSliently(TAG, "Unknown error in RiskComponent", ((Throwable) (obj)));
            return riskblob;
        }
        appinfo = null;
        obj3 = null;
        if (!Util.hasPermission(mContext, "android.permission.ACCESS_NETWORK_STATE")) goto _L4; else goto _L3
_L3:
        obj1 = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
_L65:
        SecurityException securityexception;
        if (!Util.hasPermission(mContext, "android.permission.ACCESS_COARSE_LOCATION") && !Util.hasPermission(mContext, "android.permission.ACCESS_FINE_LOCATION"))
        {
            i = 0;
        } else
        {
            i = 1;
        }
        flag = Util.hasPermission(mContext, "android.permission.READ_PHONE_STATE");
        date = new Date();
        telephonymanager.getPhoneType();
        JVM INSTR tableswitch 0 2: default 1808
    //                   0 1567
    //                   1 1598
    //                   2 1638;
           goto _L5 _L6 _L7 _L8
_L5:
        riskblob.phoneType = (new StringBuilder()).append("unknown (").append(telephonymanager.getPhoneType()).append(")").toString();
        obj = appinfo;
        obj2 = obj3;
_L66:
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataPhoneType))
        {
            riskblob.phoneType = null;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAppGuid))
        {
            riskblob.appGuid = mApplicationGuid;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataPairingId))
        {
            riskblob.pairingID = mPairingID;
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSourceApp)) goto _L10; else goto _L9
_L9:
        if (mSourceApp != null) goto _L12; else goto _L11
_L11:
        riskblob.sourceApp = SourceApp.UNKNOWN.getVersion();
_L10:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSourceAppVersion))
        {
            riskblob.sourceAppVersion = mSourceAppVersion;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataNotifToken))
        {
            riskblob.registrationId = mRegistrationId;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAndroidId))
        {
            riskblob.androidId = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "android_id");
        }
        appinfo = Util.getAppInfo(mContext);
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAppId))
        {
            riskblob.appId = appinfo.id;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAppVersion))
        {
            riskblob.appVersion = appinfo.version;
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataBaseStationId)) goto _L14; else goto _L13
_L13:
        if (obj2 != null) goto _L16; else goto _L15
_L15:
        i = -1;
_L69:
        riskblob.baseStationId = i;
_L14:
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataCdmaNetworkId)) goto _L18; else goto _L17
_L17:
        if (obj2 != null) goto _L20; else goto _L19
_L19:
        i = -1;
_L70:
        riskblob.cdmaNetworkId = i;
_L18:
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataCdmaSystemId)) goto _L22; else goto _L21
_L21:
        if (obj2 != null) goto _L24; else goto _L23
_L23:
        i = -1;
_L71:
        riskblob.cdmaSystemId = i;
_L22:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataBssid))
        {
            riskblob.bssid = null;
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataCellId)) goto _L26; else goto _L25
_L25:
        if (obj != null) goto _L28; else goto _L27
_L27:
        i = -1;
_L72:
        riskblob.cellId = i;
_L26:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataNetworkOperator))
        {
            riskblob.networkOperator = telephonymanager.getNetworkOperator();
        }
        riskblob.compVersion = "3.4.3";
        riskblob.confUrl = mConfigUrl;
        if (mConfig != null) goto _L30; else goto _L29
_L29:
        obj2 = null;
_L73:
        riskblob.confVersion = ((String) (obj2));
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataConnType)) goto _L32; else goto _L31
_L31:
        if (obj1 != null) goto _L34; else goto _L33
_L33:
        obj1 = null;
_L74:
        riskblob.connType = ((String) (obj1));
_L32:
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataDeviceId)) goto _L36; else goto _L35
_L35:
        if (!flag) goto _L38; else goto _L37
_L37:
        obj1 = telephonymanager.getDeviceId();
_L79:
        riskblob.deviceId = ((String) (obj1));
_L36:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataDeviceModel))
        {
            riskblob.deviceModel = Build.MODEL;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataDeviceName))
        {
            riskblob.deviceName = Build.DEVICE;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataDeviceUptime))
        {
            riskblob.deviceUptime = SystemClock.uptimeMillis();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataIpAddrs))
        {
            riskblob.ipAddrs = Util.getLocalIpAddress();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataIpAddrs))
        {
            riskblob.ipAddresses = Util.getLocalIpAddresses(true);
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLine1Number)) goto _L40; else goto _L39
_L39:
        if (!flag) goto _L42; else goto _L41
_L41:
        obj1 = telephonymanager.getLine1Number();
_L80:
        riskblob.line1Number = ((String) (obj1));
_L40:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLinkerId))
        {
            riskblob.linkerId = Util.getLinkerId();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLocaleCountry))
        {
            riskblob.localeCountry = Locale.getDefault().getCountry();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLocaleLang))
        {
            riskblob.localeLang = Locale.getDefault().getLanguage();
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLocation)) goto _L44; else goto _L43
_L43:
        if (mCurrentLocation != null) goto _L46; else goto _L45
_L45:
        obj1 = null;
_L75:
        riskblob.location = ((Location) (obj1));
_L44:
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataLocationAreaCode)) goto _L48; else goto _L47
_L47:
        if (obj != null) goto _L50; else goto _L49
_L49:
        i = -1;
_L76:
        riskblob.locationAreaCode = i;
_L48:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataMacAddrs))
        {
            riskblob.macAddrs = null;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataOsType))
        {
            riskblob.osVersion = android.os.Build.VERSION.RELEASE;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataRiskCompSessionId))
        {
            riskblob.riskCompSessionId = Session.getId();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataRoaming))
        {
            riskblob.roaming = Boolean.valueOf((new ServiceState()).getRoaming());
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSimOperatorName))
        {
            riskblob.simOperatorName = getSimOperatorName(telephonymanager);
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSerialNumber)) goto _L52; else goto _L51
_L51:
        if (!flag) goto _L54; else goto _L53
_L53:
        obj = telephonymanager.getSimSerialNumber();
_L77:
        riskblob.simSerialNumber = ((String) (obj));
_L52:
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            riskblob.serialNumber = Build.SERIAL;
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSmsEnabled))
        {
            riskblob.smsEnabled = Boolean.valueOf(mContext.getPackageManager().hasSystemFeature("android.hardware.telephony"));
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSsid))
        {
            riskblob.ssid = null;
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataSubscriberId)) goto _L56; else goto _L55
_L55:
        if (!flag) goto _L58; else goto _L57
_L57:
        obj = telephonymanager.getSubscriberId();
_L78:
        riskblob.subscriberId = ((String) (obj));
_L56:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataTimestamp))
        {
            riskblob.timestamp = System.currentTimeMillis();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataTotalStorageSpace))
        {
            riskblob.totalStorageSpace = Util.getTotalStorageSpace();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataTzName))
        {
            riskblob.tzName = TimeZone.getDefault().getDisplayName(TimeZone.getDefault().inDaylightTime(date), 1, Locale.ENGLISH);
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataIsDaylightSaving))
        {
            riskblob.ds = Boolean.valueOf(TimeZone.getDefault().inDaylightTime(date));
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataTimeZoneOffset))
        {
            riskblob.tz = Integer.valueOf(TimeZone.getDefault().getOffset(date.getTime()));
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataIsEmulator))
        {
            riskblob.isEmulator = Boolean.valueOf(EmulatorChecker.isEmulator());
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataIsRooted))
        {
            riskblob.isRooted = Boolean.valueOf(RootAccessChecker.isRooted());
        }
        if (!ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataKnownApps)) goto _L60; else goto _L59
_L59:
        obj1 = new ArrayList();
        if (mConfig == null) goto _L62; else goto _L61
_L61:
        obj = mConfig.getAppsToCheck();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj2 = (String)((Iterator) (obj)).next();
            if (Util.isCallable(mContext.getPackageManager(), (new Intent()).setComponent(ComponentName.unflattenFromString(((String) (obj2))))))
            {
                ((List) (obj1)).add(obj2);
            }
        } while (true);
          goto _L62
        obj;
        Util.logExceptionSliently(TAG, "knownApps error", null);
_L62:
        obj = obj1;
        if (((List) (obj1)).size() == 0)
        {
            obj = null;
        }
        riskblob.knownApps = ((List) (obj));
_L60:
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAppFirstInstallTime))
        {
            riskblob.appFirstInstallTime = getAppFirstInstallTime(mContext);
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAppLastUpdateTime))
        {
            riskblob.appLastUpdateTime = getAppLastUpdateTime(mContext);
        }
        riskblob.customValues = mCustomRiskBlobValues;
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataGsfId))
        {
            riskblob.gsfId = Util.getGsfAndroidId(mContext);
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataVPNSetting))
        {
            riskblob.vpnSetting = Util.getVPNSetting();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataProxySetting))
        {
            riskblob.proxySetting = Util.getProxySetting();
        }
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataAdvertisingIdentifier))
        {
            riskblob.advertisingId = Util.getAdvertisingId(mContext, riskblob);
        }
        obj = riskblob;
        if (ppriskcds.isCDSEnabled(PPRiskData.PPRiskDataOsType)) goto _L64; else goto _L63
_L63:
        riskblob.osType = null;
        return riskblob;
_L4:
        obj1 = null;
          goto _L65
_L6:
        riskblob.phoneType = "none";
        obj2 = obj3;
        obj = appinfo;
          goto _L66
_L7:
        riskblob.phoneType = "gsm";
        obj2 = obj3;
        obj = appinfo;
        if (i == 0) goto _L66; else goto _L67
_L67:
        obj = (GsmCellLocation)Util.castOrNull(telephonymanager.getCellLocation(), android/telephony/gsm/GsmCellLocation);
        obj2 = obj3;
          goto _L66
_L8:
        riskblob.phoneType = "cdma";
        obj2 = obj3;
        obj = appinfo;
        if (i == 0) goto _L66; else goto _L68
_L68:
        obj2 = (CdmaCellLocation)Util.castOrNull(telephonymanager.getCellLocation(), android/telephony/cdma/CdmaCellLocation);
        obj = appinfo;
          goto _L66
_L12:
        riskblob.sourceApp = mSourceApp.getVersion();
          goto _L10
_L16:
        i = ((CdmaCellLocation) (obj2)).getBaseStationId();
          goto _L69
_L20:
        i = ((CdmaCellLocation) (obj2)).getNetworkId();
          goto _L70
_L24:
        i = ((CdmaCellLocation) (obj2)).getSystemId();
          goto _L71
_L28:
        i = ((GsmCellLocation) (obj)).getCid();
          goto _L72
_L30:
        obj2 = mConfig.getConfVersion();
          goto _L73
_L34:
        obj1 = ((NetworkInfo) (obj1)).getTypeName();
          goto _L74
_L46:
        obj1 = new Location(mCurrentLocation);
          goto _L75
_L50:
        i = ((GsmCellLocation) (obj)).getLac();
          goto _L76
_L54:
        obj = null;
          goto _L77
_L58:
        obj = null;
          goto _L78
        obj;
        obj2 = obj3;
        obj = appinfo;
          goto _L66
        securityexception;
        obj2 = obj3;
        securityexception = appinfo;
          goto _L66
_L38:
        obj1 = null;
          goto _L79
_L42:
        obj1 = null;
          goto _L80
    }

    private String getSimOperatorName(TelephonyManager telephonymanager)
    {
        try
        {
            telephonymanager = telephonymanager.getSimOperatorName();
        }
        // Misplaced declaration of an exception variable
        catch (TelephonyManager telephonymanager)
        {
            Util.logExceptionSliently(TAG, "Known SecurityException on some devices", telephonymanager);
            return null;
        }
        return telephonymanager;
    }

    private boolean isLegalPairingId(String s)
    {
        int i;
        if (s != null)
        {
            if ((i = s.trim().length()) >= 10 && i <= 32)
            {
                return true;
            }
        }
        return false;
    }

    private String pairingIdAlgorithm()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    protected String buildBeaconRequestUrl(String s)
    {
        android.net.Uri.Builder builder = Uri.parse(s).buildUpon();
        String s1;
        if (TextUtils.isEmpty(mPairingID))
        {
            s = "Beacon pairing id empty";
        } else
        {
            s = mPairingID;
        }
        builder.appendQueryParameter("p", s);
        s1 = Util.getLocalIpAddress();
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = "0.0.0.0";
        }
        builder.appendQueryParameter("i", s);
        builder.appendQueryParameter("t", String.valueOf(System.currentTimeMillis() / 1000L));
        builder.appendQueryParameter("a", String.valueOf(mSourceApp.getVersion()));
        return builder.toString();
    }

    public byte[] getBeaconRequestBody()
    {
        return null;
    }

    public Map getBeaconRequestHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("accept-language", "en-us");
        return hashmap;
    }

    public String getBeaconRequestMethod()
    {
        return "GET";
    }

    public URL getBeaconRequestUrl()
        throws MalformedURLException
    {
        return new URL(buildBeaconRequestUrl("https://www.paypalobjects.com/webstatic/risk/dyson_config_android_v3.json"));
    }

    public String getBeaconRequestUserAgent(Context context)
    {
        context = Util.getAppInfo(context);
        return String.format("%s/%s/%s/%s/Android", new Object[] {
            ((AppInfo) (context)).id, ((AppInfo) (context)).version, mSourceAppVersion, mApplicationGuid
        });
    }

    public String getConfigUrl()
    {
        return mConfigUrl;
    }

    public String getLibraryVersion()
    {
        return String.format(Locale.US, "Dyson/%S (%S %S)", new Object[] {
            "3.4.3", "Android", android.os.Build.VERSION.RELEASE
        });
    }

    public byte[] getLogRiskMetadataRequestBody()
        throws UnsupportedEncodingException
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.appendQueryParameter("appGuid", mApplicationGuid);
        builder.appendQueryParameter("libraryVersion", getLibraryVersion());
        builder.appendQueryParameter("additionalData", getRiskPayload().toString());
        return builder.build().getEncodedQuery().getBytes();
    }

    public Map getLogRiskMetadataRequestHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("x-paypal-response-data-format", "JSON");
        hashmap.put("x-paypal-request-data-format", "NV");
        hashmap.put("x-paypal-service-version", "1.0.0");
        return hashmap;
    }

    public String getLogRiskMetadataRequestMethod()
    {
        return "POST";
    }

    public URL getLogRiskMetadataRequestUrl()
        throws MalformedURLException
    {
        Object obj = null;
        URL url = obj;
        if (mConfig != null)
        {
            url = obj;
            if (!TextUtils.isEmpty(mConfig.getEndpointUrl()))
            {
                url = new URL(mConfig.getEndpointUrl());
            }
        }
        return url;
    }

    public String getPairingID()
    {
        return mPairingID;
    }

    public JSONObject getRiskPayload()
    {
        Session.createNew();
        mCurrentRiskBlob = getRefreshedRiskBlob();
        if (mCurrentRiskBlob == null)
        {
            return null;
        } else
        {
            return mCurrentRiskBlob.toJSONObject();
        }
    }

    public String init(Context context, String s, SourceApp sourceapp, String s1, Map map)
    {
        String s2 = Util.optStringFromMap(map, "RISK_MANAGER_CONF_URL", null);
        String s3 = Util.optStringFromMap(map, "RISK_MANAGER_PAIRING_ID", null);
        mRegistrationId = Util.optStringFromMap(map, "RISK_MANAGER_NOTIF_TOKEN", null);
        mCurrentLocation = Util.optLocationFromMap(map, "RISK_MANAGER_LOCATION", null);
        mContext = context;
        mApplicationGuid = s;
        boolean flag;
        if (sourceapp == null)
        {
            mSourceApp = SourceApp.UNKNOWN;
        } else
        {
            mSourceApp = sourceapp;
        }
        mSourceAppVersion = s1;
        mCurrentRiskBlob = null;
        mCustomRiskBlobValues = new HashMap();
        flag = true;
        if (s3 == null || s3.trim().length() == 0)
        {
            mPairingID = pairingIdAlgorithm();
        } else
        {
            Util.logExternal(3, "PRD", "Using custom pairing id");
            mPairingID = s3.trim();
            if (!isLegalPairingId(mPairingID))
            {
                mPairingID = pairingIdAlgorithm();
                flag = false;
            }
        }
        try
        {
            setConfigUrl(s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Util.logExceptionSliently(TAG, null, context);
        }
        if (!flag)
        {
            Util.logExternal(6, "PRD", "Provided pairingID is invalid. Please provide a 10-32 char length string if needed.");
        }
        return mPairingID;
    }

    public void setConfigUrl(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "https://www.paypalobjects.com/webstatic/risk/dyson_config_android_v3.json";
        }
        mConfigUrl = s1;
    }

    public void setConfiguration(Configuration configuration)
    {
        if (configuration == null)
        {
            throw new IllegalArgumentException("configuration cannot be null or empty");
        } else
        {
            mConfig = configuration;
            return;
        }
    }

}
