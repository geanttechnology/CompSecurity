// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.TimeZone;
import org.apache.http.conn.util.InetAddressUtils;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog, XcpMsgContextReq

class TPUtility
{

    private static String LOG_TAG = "TPUtility";
    private static int XCP_BATTERY_STATE_CHARGING = 2;
    private static int XCP_BATTERY_STATE_FULL = 3;
    private static int XCP_BATTERY_STATE_UNKNOWN = 0;
    private static int XCP_BATTERY_STATE_UNPLUGGED = 1;
    private static int XCP_DEVICE_TYPE_ANDROID = 50;
    private static int XCP_NETWORK_TYPE_3G = 2;
    private static int XCP_NETWORK_TYPE_HSPA = 6;
    private static int XCP_NETWORK_TYPE_HSPA_PLUS = 7;
    private static int XCP_NETWORK_TYPE_LTE = 5;
    private static int XCP_NETWORK_TYPE_MAX = 8;
    private static int XCP_NETWORK_TYPE_WIFI = 1;
    static TPUtility tpUtility;
    private Context appContext;
    int battery_level;
    int battery_state;
    String bssid;
    String bundle_id;
    String carrierCI;
    int carrier_mcc;
    int carrier_mnc;
    String carrier_name;
    String cell_ipaddress;
    String country;
    String device;
    short inuseRAM;
    double latitude;
    double longitude;
    String network_detail;
    int network_type;
    String os_version;
    String systemVersion;
    String time_zone;
    short totalRAM;
    String wifi_ipaddress;

    TPUtility()
    {
        carrier_name = "";
        carrierCI = "";
        systemVersion = "";
        device = "";
        country = "";
        time_zone = "";
        network_detail = "";
        cell_ipaddress = "";
        wifi_ipaddress = "";
        bssid = "";
        os_version = "";
        bundle_id = "";
    }

    private void getBundleId()
    {
        bundle_id = appContext.getPackageName();
    }

    private void getCarrierInformation()
    {
        TelephonyManager telephonymanager;
        telephonymanager = (TelephonyManager)appContext.getSystemService("phone");
        telephonymanager.getPhoneType();
        telephonymanager.getPhoneType();
        JVM INSTR tableswitch 1 2: default 242
    //                   1 81
    //                   2 81;
           goto _L1 _L2 _L2
_L1:
        carrier_mcc = 0;
        carrier_mnc = 0;
_L3:
        systemVersion = telephonymanager.getDeviceSoftwareVersion();
_L5:
        country = telephonymanager.getNetworkCountryIso();
        time_zone = TimeZone.getDefault().getID();
        return;
_L2:
        try
        {
            carrier_name = telephonymanager.getNetworkOperatorName();
            if (carrier_name == null || carrier_name.equalsIgnoreCase(""))
            {
                carrier_name = "unknown";
            }
            carrierCI = telephonymanager.getNetworkCountryIso();
            if (telephonymanager.getNetworkOperator() != null && !telephonymanager.getNetworkOperator().isEmpty() && telephonymanager.getNetworkOperator().length() > 3)
            {
                carrier_mcc = Integer.parseInt(telephonymanager.getNetworkOperator().substring(0, 3));
                carrier_mnc = Integer.parseInt(telephonymanager.getNetworkOperator().substring(3));
            }
        }
        catch (Exception exception)
        {
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, "Error getting carrier information, returning zeros");
            }
            carrier_mcc = 0;
            carrier_mnc = 0;
            return;
        }
          goto _L3
        SecurityException securityexception;
        securityexception;
        if (!TPLog.LOG10.isLoggable(LOG_TAG)) goto _L5; else goto _L4
_L4:
        Log.w(LOG_TAG, "Current process does not have android.permission.READ_PHONE_STATE");
          goto _L5
    }

    private void getDevice()
    {
        device = (new StringBuilder()).append(Build.MANUFACTURER).append("-").append(Build.MODEL).toString();
    }

    public static TPUtility getInstance()
    {
        com/twinprime/TwinPrimeSDK/TPUtility;
        JVM INSTR monitorenter ;
        TPUtility tputility;
        if (tpUtility == null)
        {
            tpUtility = new TPUtility();
        }
        tputility = tpUtility;
        com/twinprime/TwinPrimeSDK/TPUtility;
        JVM INSTR monitorexit ;
        return tputility;
        Exception exception;
        exception;
        throw exception;
    }

    private void getOsVersion()
    {
        Object obj;
        int i;
        int j;
        byte byte0;
        try
        {
            os_version = (new StringBuilder()).append("Android-").append(android.os.Build.VERSION.CODENAME).append("-").append(android.os.Build.VERSION.RELEASE).toString();
            return;
        }
        catch (Exception exception) { }
        Field afield[];
        String s;
        Field field;
        IllegalArgumentException illegalargumentexception;
        int k;
        try
        {
            obj = new StringBuilder();
            afield = android/os/Build$VERSION_CODES.getFields();
            k = afield.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            os_version = "Android-unknown";
            return;
        }
        i = 0;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        field = afield[i];
        s = field.getName();
        byte0 = -1;
        j = field.getInt(new Object());
_L3:
        if (j == android.os.Build.VERSION.SDK_INT)
        {
            ((StringBuilder) (obj)).append(s);
            ((StringBuilder) (obj)).append("-");
            ((StringBuilder) (obj)).append(android.os.Build.VERSION.RELEASE);
        }
        break MISSING_BLOCK_LABEL_223;
        illegalargumentexception;
        j = byte0;
        if (!TPLog.LOG10.isLoggable(LOG_TAG))
        {
            continue; /* Loop/switch isn't completed */
        }
        illegalargumentexception.printStackTrace();
        j = byte0;
        continue; /* Loop/switch isn't completed */
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        j = byte0;
        if (!TPLog.LOG10.isLoggable(LOG_TAG))
        {
            continue; /* Loop/switch isn't completed */
        }
        illegalaccessexception.printStackTrace();
        j = byte0;
        if (true) goto _L3; else goto _L2
_L2:
        os_version = (new StringBuilder()).append("Android-").append(((StringBuilder) (obj)).toString()).toString();
        return;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    int getBatteryLevel()
    {
        try
        {
            Intent intent = appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            battery_level = (int)(((float)intent.getIntExtra("level", -1) / (float)intent.getIntExtra("scale", -1)) * 100F);
        }
        catch (Exception exception)
        {
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, "Error reading battery level.  Return 100%");
            }
            battery_level = 100;
        }
        return battery_level;
    }

    int getBatteryState()
    {
        appContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
        JVM INSTR tableswitch 2 5: default 131
    //                   2 111
    //                   3 68
    //                   4 68
    //                   5 121;
           goto _L1 _L2 _L3 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_121;
_L1:
        battery_state = XCP_BATTERY_STATE_UNKNOWN;
_L5:
        return battery_state;
_L3:
        try
        {
            battery_state = XCP_BATTERY_STATE_UNPLUGGED;
        }
        catch (Exception exception)
        {
            if (TPLog.LOG10.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, "Error getting battery state, returning unknown");
            }
            battery_state = XCP_BATTERY_STATE_UNKNOWN;
        }
          goto _L5
_L2:
        battery_state = XCP_BATTERY_STATE_CHARGING;
          goto _L5
        battery_state = XCP_BATTERY_STATE_FULL;
          goto _L5
    }

    void getLastKnownLocation()
    {
        Location location = ((LocationManager)appContext.getSystemService("location")).getLastKnownLocation("network");
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        latitude = location.getLatitude();
        longitude = location.getLongitude();
_L1:
        return;
        SecurityException securityexception;
        securityexception;
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            Log.w(LOG_TAG, "Current process does not have ACCESS_FINE_LOCATION nor ACCESS_COARSE_LOCATION permissions");
            return;
        }
          goto _L1
    }

    void getNetworkInfo()
    {
        Object obj;
        network_type = XCP_NETWORK_TYPE_3G;
        obj = (ConnectivityManager)appContext.getSystemService("connectivity");
        if (((ConnectivityManager) (obj)).getActiveNetworkInfo() == null) goto _L2; else goto _L1
_L1:
        ((ConnectivityManager) (obj)).getActiveNetworkInfo().getType();
        JVM INSTR lookupswitch 3: default 739
    //                   0: 278
    //                   1: 68
    //                   6: 264;
           goto _L2 _L3 _L4 _L5
_L4:
        network_type = XCP_NETWORK_TYPE_WIFI;
        obj = (WifiManager)appContext.getSystemService("wifi");
        int i;
        obj = ((WifiManager) (obj)).getConnectionInfo();
        i = ((WifiInfo) (obj)).getIpAddress();
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        byte abyte0[] = BigInteger.valueOf(i).toByteArray();
        i = 0;
_L7:
        if (i >= abyte0.length / 2)
        {
            break; /* Loop/switch isn't completed */
        }
        byte byte0 = abyte0[i];
        abyte0[i] = abyte0[abyte0.length - i - 1];
        abyte0[abyte0.length - i - 1] = byte0;
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        wifi_ipaddress = InetAddress.getByAddress(abyte0).getHostAddress();
        cell_ipaddress = wifi_ipaddress;
_L8:
        if (obj != null)
        {
            try
            {
                bssid = ((WifiInfo) (obj)).getBSSID();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            try
            {
                if (TPLog.LOG10.isLoggable(LOG_TAG))
                {
                    Log.w(LOG_TAG, "Current process does not have android.permission.ACCESS_WIFI_STATE");
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (TPLog.LOG10.isLoggable(LOG_TAG))
                {
                    Log.w(LOG_TAG, "Current process does not have android.permission.ACCESS_NETWORK_STATE");
                    return;
                }
            }
        }
        break; /* Loop/switch isn't completed */
        UnknownHostException unknownhostexception;
        unknownhostexception;
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            unknownhostexception.printStackTrace();
        }
        if (true) goto _L8; else goto _L2
_L5:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "WIMAX";
_L3:
        ((ConnectivityManager) (obj)).getActiveNetworkInfo().getSubtype();
        JVM INSTR tableswitch 0 15: default 740
    //                   0 722
    //                   1 593
    //                   2 508
    //                   3 705
    //                   4 491
    //                   5 542
    //                   6 559
    //                   7 474
    //                   8 610
    //                   9 661
    //                   10 627
    //                   11 678
    //                   12 576
    //                   13 695
    //                   14 525
    //                   15 644;
           goto _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25
_L9:
        ((ConnectivityManager)appContext.getSystemService("connectivity")).getActiveNetworkInfo();
        for (Enumeration enumeration = NetworkInterface.getNetworkInterfaces(); enumeration.hasMoreElements();)
        {
            Enumeration enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
            while (enumeration1.hasMoreElements()) 
            {
                InetAddress inetaddress = (InetAddress)enumeration1.nextElement();
                if (!inetaddress.isLoopbackAddress() && InetAddressUtils.isIPv4Address(inetaddress.getHostAddress()))
                {
                    cell_ipaddress = inetaddress.getHostAddress().toString();
                }
            }
        }

          goto _L2
        Exception exception;
        exception;
        Log.e(LOG_TAG, exception.toString());
        return;
_L17:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "1xRTT";
          goto _L9
_L14:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "CDMA";
          goto _L9
_L12:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "EDGE";
          goto _L9
_L24:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "EHRPD";
          goto _L9
_L15:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "EVDO_0";
          goto _L9
_L16:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "EVDO_A";
          goto _L9
_L22:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "EVDO_B";
          goto _L9
_L11:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "GPRS";
          goto _L9
_L18:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "HSDPA";
          goto _L9
_L20:
        network_type = XCP_NETWORK_TYPE_HSPA;
        network_detail = "HSPA";
          goto _L9
_L25:
        network_type = XCP_NETWORK_TYPE_HSPA_PLUS;
        network_detail = "HSPAP";
          goto _L9
_L19:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "HSUPA";
          goto _L9
_L21:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "IDEN";
          goto _L9
_L23:
        network_type = XCP_NETWORK_TYPE_LTE;
          goto _L9
_L13:
        network_type = XCP_NETWORK_TYPE_HSPA;
        network_detail = "UMTS";
          goto _L9
_L10:
        network_type = XCP_NETWORK_TYPE_3G;
        network_detail = "UNKNOWN";
          goto _L9
_L2:
    }

    void getRAMInfo()
    {
        android.app.ActivityManager.MemoryInfo memoryinfo;
        long l1;
        long l2;
        memoryinfo = new android.app.ActivityManager.MemoryInfo();
        ((ActivityManager)appContext.getSystemService("activity")).getMemoryInfo(memoryinfo);
        l2 = memoryinfo.availMem / 0x100000L;
        l1 = 0L;
        long l = memoryinfo.totalMem / 0x100000L;
_L2:
        totalRAM = (short)(int)l;
        inuseRAM = (short)(int)(l - l2);
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        l = l1;
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            Log.w(LOG_TAG, "Not able to retrieve total memory. API is lower than 16");
            l = l1;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public XcpMsgContextReq getXcpMsgContextReq()
    {
        XcpMsgContextReq xcpmsgcontextreq = new XcpMsgContextReq();
        xcpmsgcontextreq.network_type = network_type;
        xcpmsgcontextreq.mcc = carrier_mcc;
        xcpmsgcontextreq.mnc = carrier_mnc;
        xcpmsgcontextreq.longitude = longitude;
        xcpmsgcontextreq.latitude = latitude;
        xcpmsgcontextreq.battery_level = battery_level;
        xcpmsgcontextreq.battery_state = battery_state;
        xcpmsgcontextreq.totalRAM = totalRAM;
        xcpmsgcontextreq.inuseRAM = inuseRAM;
        xcpmsgcontextreq.time_zone = time_zone;
        xcpmsgcontextreq.device = device;
        xcpmsgcontextreq.carrier_name = carrier_name;
        xcpmsgcontextreq.os_version = os_version;
        xcpmsgcontextreq.bundle_id = bundle_id;
        xcpmsgcontextreq.cell_ipaddress = cell_ipaddress;
        xcpmsgcontextreq.bssid = bssid;
        xcpmsgcontextreq.network_detail = network_detail;
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, xcpmsgcontextreq.toString());
        }
        return xcpmsgcontextreq;
    }

    protected void initDeviceInfo(Context context)
    {
        appContext = context;
        getCarrierInformation();
        battery_level = getBatteryLevel();
        battery_state = getBatteryState();
        getRAMInfo();
        getNetworkInfo();
        getLastKnownLocation();
        getDevice();
        getBundleId();
        getOsVersion();
_L1:
        return;
        context;
        if (TPLog.LOG10.isLoggable(LOG_TAG))
        {
            context.printStackTrace();
            return;
        }
          goto _L1
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("TPUtility:\n");
        stringbuffer.append((new StringBuilder()).append("\tnetwork_type [").append(network_type).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tmcc [").append(carrier_mcc).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tmnc [").append(carrier_mnc).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tlongitude [").append(longitude).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tlatitude [").append(latitude).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tbattery_level [").append(battery_level).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tbattery_state [").append(battery_state).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\ttotalRAM [").append(totalRAM).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tinuseRAM [").append(inuseRAM).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\ttime_zone [").append(time_zone).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tdevice [").append(device).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tcarrier_name [").append(carrier_name).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tbundle_id [").append(bundle_id).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tcell_ipaddress [").append(cell_ipaddress).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\twifi_ipaddress [").append(wifi_ipaddress).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tbssid [").append(bssid).append("]\n").toString());
        stringbuffer.append((new StringBuilder()).append("\tos_version[").append(os_version).append("]\n").toString());
        return stringbuffer.toString();
    }

}
