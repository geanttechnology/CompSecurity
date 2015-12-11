// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metadata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.amazon.identity.auth.device.framework.MAPSmsReceiver;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemPropertiesWrapper;
import com.amazon.identity.auth.device.framework.TelephonyManagerWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.framework.WifiManagerWrapper;
import com.amazon.identity.auth.device.framework.WindowManagerWrapper;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.SignatureHelpers;
import com.amazon.identity.auth.device.utils.StringUtil;
import com.amazon.identity.kcpsdk.common.LocaleUtil;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class DeviceMetadataCollector
{

    private static final String TAG = com/amazon/identity/auth/device/metadata/DeviceMetadataCollector.getName();

    private DeviceMetadataCollector()
    {
    }

    public static void applyFraudMetadataIntoReqeustJSON(String s, JSONObject jsonobject)
        throws JSONException
    {
        if (!TextUtils.isEmpty(s))
        {
            JSONObject jsonobject1 = new JSONObject();
            jsonobject1.put("frc", s);
            jsonobject.put("user_context_map", jsonobject1);
        }
    }

    static String encryptFraudMetadata(JSONObject jsonobject, String s, Tracer tracer)
    {
        if (jsonobject == null)
        {
            Object obj;
            byte abyte0[];
            Object obj1;
            byte abyte1[];
            try
            {
                MAPLog.e(TAG, "The metadata should not be null!");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                MAPLog.logAndReportError(TAG, tracer, (new StringBuilder("Exception happened when encrypting the metadata:")).append(jsonobject.getClass().getName()).toString(), (new StringBuilder("FraudMetaDataEncryption:Exception:")).append(jsonobject.getClass().getName()).toString(), jsonobject);
                return null;
            }
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        MAPLog.logAndReportError(TAG, tracer, "DSN is null, cannot encrypt the fraud metadata", "FraudMetaDataEncryption:DsnMissing");
        return null;
        jsonobject = jsonobject.toString();
        obj = new ByteArrayOutputStream();
        obj1 = new GZIPOutputStream(((java.io.OutputStream) (obj)));
        ((GZIPOutputStream) (obj1)).write(jsonobject.getBytes("UTF-8"));
        ((GZIPOutputStream) (obj1)).close();
        jsonobject = ((ByteArrayOutputStream) (obj)).toByteArray();
        obj = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher) (obj)).init(1, generateKey(s, "AES/CBC/PKCS7Padding"));
        jsonobject = ((Cipher) (obj)).doFinal(jsonobject);
        abyte0 = ((Cipher) (obj)).getIV();
        obj1 = Mac.getInstance("HmacSHA256");
        ((Mac) (obj1)).init(generateKey(s, "HmacSHA256"));
        ((Mac) (obj1)).update(abyte0);
        ((Mac) (obj1)).update(jsonobject);
        s = ((Mac) (obj1)).doFinal();
        abyte1 = new byte[jsonobject.length + 25];
        abyte1[0] = 0;
        System.arraycopy(s, 0, abyte1, 1, 8);
        System.arraycopy(abyte0, 0, abyte1, 9, 16);
        System.arraycopy(jsonobject, 0, abyte1, 25, jsonobject.length);
        jsonobject = Base64.encodeToString(abyte1, 2);
        return jsonobject;
    }

    private static Key generateKey(String s, String s1)
        throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException
    {
        return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(s.toCharArray(), s1.getBytes("UTF-8"), 1000, 128)).getEncoded(), "AES");
    }

    private static String getAndroidId(Context context, Tracer tracer)
    {
        try
        {
            context = context.getContentResolver();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown error happens when collecting android id.", (new StringBuilder("AndroidIdCollection:Exception:")).append(context.getClass().getName()).toString(), context);
            return null;
        }
        if (context == null)
        {
            return null;
        }
        context = android.provider.Settings.Secure.getString(context, "android_id");
        return context;
    }

    private static JSONObject getAppIdentitiferJSON(ServiceWrappingContext servicewrappingcontext, String s)
    {
        JSONArray jsonarray;
        Object obj;
        ServiceWrappingContext servicewrappingcontext1;
        ServiceWrappingContext servicewrappingcontext2;
        Object obj2;
        Object obj3;
        Object obj4;
        android.content.pm.Signature asignature[];
        Object obj5;
        String s1;
        s1 = BuildInfo.getBuildInfo().mBrazilVersion;
        obj3 = null;
        obj4 = null;
        obj2 = null;
        asignature = null;
        obj5 = null;
        jsonarray = null;
        servicewrappingcontext = new TrustedPackageManager(servicewrappingcontext);
        obj = jsonarray;
        servicewrappingcontext1 = asignature;
        servicewrappingcontext2 = obj5;
        PackageInfo packageinfo = servicewrappingcontext.getPackageInfoForTrustedPackage(s, 64);
        obj = jsonarray;
        servicewrappingcontext1 = asignature;
        servicewrappingcontext2 = obj5;
        servicewrappingcontext = Integer.toString(packageinfo.versionCode);
        obj = servicewrappingcontext;
        servicewrappingcontext1 = servicewrappingcontext;
        servicewrappingcontext2 = servicewrappingcontext;
        asignature = packageinfo.signatures;
        obj = servicewrappingcontext;
        servicewrappingcontext1 = servicewrappingcontext;
        servicewrappingcontext2 = servicewrappingcontext;
        jsonarray = new JSONArray();
        int i = 0;
_L2:
        if (i >= asignature.length)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(SignatureHelpers.getSignatureFingerprint("SHA-256", asignature[i]));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).putOpt("package", s);
            ((JSONObject) (obj)).putOpt("SHA-256", jsonarray);
            ((JSONObject) (obj)).putOpt("app_version", servicewrappingcontext);
            ((JSONObject) (obj)).putOpt("map_version", s1);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.e(TAG, "JSONException when building app identifier JSON for map-md cookie");
            return null;
        }
        return ((JSONObject) (obj));
        servicewrappingcontext;
        jsonarray = obj2;
        servicewrappingcontext = ((ServiceWrappingContext) (obj));
_L5:
        MAPLog.e(TAG, "NameNotFoundException when building app identifier JSON for map-md cookie");
          goto _L1
        servicewrappingcontext;
        jsonarray = obj3;
        servicewrappingcontext = servicewrappingcontext1;
_L4:
        MAPLog.e(TAG, "SecurityException when building app identifier JSON for map-md cookie");
          goto _L1
        servicewrappingcontext;
        jsonarray = obj4;
        servicewrappingcontext = servicewrappingcontext2;
_L3:
        MAPLog.e(TAG, "GeneralSecurityException when building app identifier JSON for map-md cookie");
          goto _L1
        Object obj1;
        obj1;
          goto _L3
        obj1;
          goto _L4
        obj1;
          goto _L5
    }

    private static JSONObject getAppInfoJSON(ServiceWrappingContext servicewrappingcontext, MAPSmsReceiver mapsmsreceiver)
    {
        boolean flag = mapsmsreceiver.isSmsPermissionGranted(servicewrappingcontext);
        servicewrappingcontext = new JSONObject();
        if (!Boolean.valueOf(flag).booleanValue())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        servicewrappingcontext.putOpt("auto_pv", Integer.valueOf(1));
        return servicewrappingcontext;
        try
        {
            servicewrappingcontext.putOpt("auto_pv", Integer.valueOf(0));
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.e(TAG, "JSONException when building app info JSON for map-md cookie");
            return null;
        }
        return servicewrappingcontext;
    }

    static String getCarrier(Context context, Tracer tracer)
    {
        boolean flag;
        try
        {
            context = ((TelephonyManagerWrapper)context.getSystemService("sso_telephony_service")).getNetworkOperatorName();
            flag = TextUtils.isEmpty(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unkown exception happened when try to get Carrier", (new StringBuilder("CarrierCollection:Exception:")).append(context.getClass().getName()).toString(), context);
            return null;
        }
        if (flag)
        {
            context = null;
        }
        return context;
    }

    private static JSONObject getDeviceDataJSON(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        String s;
        s = getPhoneNumber(servicewrappingcontext, tracer);
        servicewrappingcontext = getSimCountryISO(servicewrappingcontext, tracer);
        if (s == null && servicewrappingcontext == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        tracer = new JSONObject();
        tracer.putOpt("mobile_number", s);
        tracer.putOpt("mobile_sim_country_iso", servicewrappingcontext);
        return tracer;
        servicewrappingcontext;
        MAPLog.e(TAG, "JSONException when building device data JSON for map-md coookie");
        return null;
    }

    public static JSONObject getDeviceMetadataJSON(Context context, String s, String s1, Tracer tracer)
    {
        JSONObject jsonobject;
        ServiceWrappingContext servicewrappingcontext;
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            if (tracer != null)
            {
                tracer.incrementCounter("DeviceMetadata:RequiredParameterNull:DeviceTypeAndDSN");
            }
            return null;
        }
        if (TextUtils.isEmpty(s))
        {
            if (tracer != null)
            {
                tracer.incrementCounter("DeviceMetadata:RequiredParameterNull:DeviceType");
            }
            return null;
        }
        if (TextUtils.isEmpty(s1))
        {
            if (tracer != null)
            {
                tracer.incrementCounter("DeviceMetadata:RequiredParameterNull:DSN");
            }
            return null;
        }
        servicewrappingcontext = ServiceWrappingContext.create(context);
        jsonobject = new JSONObject();
        jsonobject.put("device_os_family", "android");
        jsonobject.put("device_type", s);
        jsonobject.put("device_serial", s1);
        jsonobject.putOpt("mac_address", getMACAddress(servicewrappingcontext, tracer));
        jsonobject.putOpt("imei", getIMEI(servicewrappingcontext, tracer));
        jsonobject.putOpt("manufacturer", Build.MANUFACTURER);
        jsonobject.putOpt("model", Build.MODEL);
        jsonobject.putOpt("os_version", Integer.toString(android.os.Build.VERSION.SDK_INT));
        jsonobject.putOpt("android_id", getAndroidId(context, tracer));
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        context = Build.SERIAL;
_L1:
        jsonobject.putOpt("build_serial", context);
        jsonobject.putOpt("product", Build.PRODUCT);
        return jsonobject;
        context;
        MAPLog.e(TAG, "JSONException happened when trying to build device metadata", context);
        return null;
        context = null;
          goto _L1
        context;
        MAPLog.e(TAG, "An unexpected error occurred while building the device metadata JSONObject");
        MetricsHelper.incrementCounter("MetadataCollection:UnexpectedException", new String[] {
            (new StringBuilder("ExceptionType:")).append(context.getClass().getName()).toString()
        });
        return null;
    }

    static String getDeviceOSVersion(Tracer tracer)
    {
        Object obj = new SystemPropertiesWrapper();
        try
        {
            obj = ((SystemPropertiesWrapper) (obj)).get("ro.build.fingerprint");
        }
        catch (Exception exception)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown error when try to get device finger print", (new StringBuilder("DeviceOSVersionCollection:Exception:")).append(exception.getClass().getName()).toString(), exception);
            return null;
        }
        tracer = ((Tracer) (obj));
        obj = tracer;
        if (TextUtils.isEmpty(tracer))
        {
            obj = null;
        }
        return ((String) (obj));
    }

    private static JSONObject getDeviceRegistrationDataJSON()
    {
        String s = BuildInfo.getMAPSWVersion();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.putOpt("software_version", s);
        }
        catch (JSONException jsonexception)
        {
            MAPLog.e(TAG, "JSONException when building device registration JSON for map-md cookie");
            return null;
        }
        return jsonobject;
    }

    static JSONObject getFraudMetaDataJSON(Context context, Tracer tracer)
    {
        ServiceWrappingContext servicewrappingcontext = ServiceWrappingContext.create(context);
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("ApplicationName", servicewrappingcontext.getPackageName());
            context = PackageUtils.getPackageVersion(servicewrappingcontext, servicewrappingcontext.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, "JSONException happened when construct the fraud meta data", context);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown error happens when generating fraud meta data.", (new StringBuilder("FraudMetaDataCollection:Exception:")).append(context.getClass().getName()).toString(), context);
            return null;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        context = Integer.toString(context.intValue());
_L1:
        jsonobject.put("ApplicationVersion", context);
        jsonobject.put("DeviceOSVersion", getDeviceOSVersion(tracer));
        jsonobject.put("DeviceName", String.format("%s/%s/%s", new Object[] {
            Build.HARDWARE, Build.MANUFACTURER, Build.MODEL
        }));
        jsonobject.put("ThirdPartyDeviceId", getAndroidId(servicewrappingcontext, tracer));
        jsonobject.put("ScreenWidthPixels", getScreenWidthPixels(servicewrappingcontext, tracer));
        jsonobject.put("ScreenHeightPixels", getScreenHeightPixels(servicewrappingcontext, tracer));
        jsonobject.put("DeviceLanguage", LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault()));
        jsonobject.put("TimeZone", getTimeZone(tracer));
        jsonobject.put("Carrier", getCarrier(servicewrappingcontext, tracer));
        jsonobject.put("PhoneNumber", getPhoneNumber(servicewrappingcontext, tracer));
        jsonobject.put("IpAddress", getIpAddress(tracer));
        (new StringBuilder("Finish generating meta data:")).append(jsonobject.toString());
        return jsonobject;
        context = null;
          goto _L1
    }

    public static String getFraudMetadata(Context context, String s, Tracer tracer)
    {
        return encryptFraudMetadata(getFraudMetaDataJSON(context, tracer), s, tracer);
    }

    private static String getIMEI(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        servicewrappingcontext = ((TelephonyManagerWrapper)servicewrappingcontext.getSystemService("sso_telephony_service")).getDeviceId();
        if (TextUtils.isEmpty(servicewrappingcontext))
        {
            return null;
        }
        try
        {
            servicewrappingcontext = StringUtil.hashSHA256ToHex(servicewrappingcontext);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown error happens when collecting IMEI.", (new StringBuilder("IMEICollection:Exception:")).append(servicewrappingcontext.getClass().getName()).toString(), servicewrappingcontext);
            return null;
        }
        return servicewrappingcontext;
    }

    static String getIpAddress(Tracer tracer)
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        MAPLog.e(TAG, "Network interfaces is null, this should be a bug!");
        return null;
        obj = Collections.list(((java.util.Enumeration) (obj)));
        Object obj1 = null;
        Iterator iterator = ((List) (obj)).iterator();
_L2:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_142;
        }
        iterator1 = Collections.list(((NetworkInterface)iterator.next()).getInetAddresses()).iterator();
        obj = obj1;
_L4:
        obj1 = obj;
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        obj1 = (InetAddress)iterator1.next();
        if (((InetAddress) (obj1)).isLoopbackAddress())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        s = ((InetAddress) (obj1)).getHostAddress().toUpperCase(Locale.US);
        obj1 = s;
        if (InetAddressUtils.isIPv4Address(s))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        if (!InetAddressUtils.isIPv6Address(s)) goto _L4; else goto _L3
_L3:
        return s;
        obj = ((InetAddress) (obj1)).getHostAddress().toUpperCase(Locale.US);
          goto _L4
        return ((String) (obj1));
        Exception exception;
        exception;
        MAPLog.logAndReportError(TAG, tracer, "Exception happened when tring to get ip address.", (new StringBuilder("IpAddressCollection:Exception:")).append(exception.getClass().getName()).toString(), exception);
        obj1 = null;
        return ((String) (obj1));
    }

    private static String getMACAddress(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        servicewrappingcontext = ((WifiManagerWrapper)servicewrappingcontext.getSystemService("dcp_wifi")).getMACAddress();
        if (TextUtils.isEmpty(servicewrappingcontext))
        {
            return null;
        }
        try
        {
            servicewrappingcontext = StringUtil.hashSHA256ToHex(servicewrappingcontext);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown error happens when collecting mac address", (new StringBuilder("MACAddressCollection:Exception:")).append(servicewrappingcontext.getClass().getName()).toString(), servicewrappingcontext);
            return null;
        }
        return servicewrappingcontext;
    }

    public static String getMapToAuthPortalMetadataCookie(ServiceWrappingContext servicewrappingcontext, MAPSmsReceiver mapsmsreceiver, String s, Tracer tracer)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.putOpt("device_data", getDeviceDataJSON(servicewrappingcontext, tracer));
            jsonobject.putOpt("device_registration_data", getDeviceRegistrationDataJSON());
            jsonobject.putOpt("app_identifier", getAppIdentitiferJSON(servicewrappingcontext, s));
            jsonobject.putOpt("app_info", getAppInfoJSON(servicewrappingcontext, mapsmsreceiver));
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.e(TAG, "JSONException when adding data to map-md cookie");
        }
        if (jsonobject.length() == 0)
        {
            return null;
        }
        try
        {
            servicewrappingcontext = Base64.encodeToString(jsonobject.toString().getBytes("UTF-8"), 2);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.e(TAG, "This platform doesn't support UTF-8, this should never happen.");
            return null;
        }
        (new StringBuilder("Setting map to authportal metadata cookie:")).append(jsonobject.toString());
        return servicewrappingcontext;
    }

    public static String getPhoneNumber(Context context, Tracer tracer)
    {
        boolean flag;
        context = ((TelephonyManagerWrapper)context.getSystemService("sso_telephony_service")).getLine1Number();
        flag = TextUtils.isEmpty(context);
        if (flag)
        {
            context = null;
        }
        return context;
        context;
        MAPLog.w(TAG, "Cannot read the phone state on this device, mainly because the client app lacks the permission");
_L2:
        return null;
        context;
        MAPLog.logAndReportError(TAG, tracer, "Unknown exception happened why try to read phone state", (new StringBuilder("PhoneNumberCollection:Exception:")).append(context.getClass().getName()).toString(), context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String getScreenHeightPixels(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        try
        {
            servicewrappingcontext = Integer.toString(((WindowManagerWrapper)servicewrappingcontext.getSystemService("sso_window_manager")).getWindowMetric().heightPixels);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unkown exception happened when try to get screen height", (new StringBuilder("ScreenSizeCollection:Exception:")).append(servicewrappingcontext.getClass().getName()).toString(), servicewrappingcontext);
            return null;
        }
        return servicewrappingcontext;
    }

    static String getScreenWidthPixels(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        try
        {
            servicewrappingcontext = Integer.toString(((WindowManagerWrapper)servicewrappingcontext.getSystemService("sso_window_manager")).getWindowMetric().widthPixels);
        }
        // Misplaced declaration of an exception variable
        catch (ServiceWrappingContext servicewrappingcontext)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unkown exception happened when try to get screen width", (new StringBuilder("ScreenSizeCollection:Exception:")).append(servicewrappingcontext.getClass().getName()).toString(), servicewrappingcontext);
            return null;
        }
        return servicewrappingcontext;
    }

    public static String getSimCountryISO(Context context, Tracer tracer)
    {
        boolean flag;
        try
        {
            context = ((TelephonyManagerWrapper)context.getSystemService("sso_telephony_service")).getSimCountryISO();
            flag = TextUtils.isEmpty(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unknown exception happened why try to read country ISO", (new StringBuilder("SimCountryISOCollection:Exception:")).append(context.getClass().getName()).toString(), context);
            return null;
        }
        if (flag)
        {
            context = null;
        }
        return context;
    }

    static String getTimeZone(Tracer tracer)
    {
        Object obj;
        try
        {
            obj = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
            obj = (new SimpleDateFormat("Z")).format(((Calendar) (obj)).getTime());
            obj = (new StringBuilder()).append(((String) (obj)).substring(0, 3)).append(":").append(((String) (obj)).substring(3, 5)).toString();
        }
        catch (Exception exception)
        {
            MAPLog.logAndReportError(TAG, tracer, "Unkown exception happened when try to get time zone", (new StringBuilder("TimeZoneCollection:Exception:")).append(exception.getClass().getName()).toString(), exception);
            return null;
        }
        return ((String) (obj));
    }

}
