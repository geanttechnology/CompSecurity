// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TadvertiseUtil
{

    static final String AD_PROVIDER_TEXT = "ad by madvertise";
    static final String ANIMATION_TYPE_DEFAULT = "fade";
    static final String ANIMATION_TYPE_FADE = "fade";
    static final String ANIMATION_TYPE_LEFT_TO_RIGHT = "left_to_right";
    static final String ANIMATION_TYPE_TOP_DOWN = "top_down";
    static final int BACKGROUND_COLOR_DEFAULT = 0;
    static final int BANNER_HEIGHT_DEFAULT = 53;
    static final String BANNER_TYPE_ALL = "all";
    static final String BANNER_TYPE_DEFAULT = "mma";
    static final String BANNER_TYPE_FULLSCREEN = "fullscreen";
    static final String BANNER_TYPE_LANDSCAPE = "landscape";
    static final String BANNER_TYPE_LEADERBOARD = "leaderboard";
    static final String BANNER_TYPE_MEDIUM_RECTANGLE = "medium_rectangle";
    static final String BANNER_TYPE_MMA = "mma";
    static final String BANNER_TYPE_PORTRAIT = "portrait";
    static final String BANNER_TYPE_RICH_MEDIA = "rich_media";
    static final String BANNER_TYPE_RICH_MEDIA_SHORT = "rm";
    static final int BANNER_WIDTH_DEFAULT = 320;
    static final int CONNECTION_TIMEOUT = 5000;
    static final boolean DELIVER_ONLY_TEXT_DEFAULT = false;
    static final String ENCODING = "UTF-8";
    static final int FULLSCREEN_BANNER_HEIGHT = 768;
    static final int FULLSCREEN_BANNER_WIDTH = 768;
    static final int LANDSCAPE_BANNER_HEIGHT = 66;
    static final int LANDSCAPE_BANNER_WIDTH = 1024;
    static final int LEADERBOARD_BANNER_HEIGHT = 90;
    static final int LEADERBOARD_BANNER_WIDTH = 728;
    static final String LOG = "MAD_LOG";
    private static final String MADVERTISE_SITE_TOKEN = "madvertise_site_token";
    static final String MAD_SERVER = "http://fotorus.fotoable.com";
    static final int MEDIUM_RECTANGLE_BANNER_HEIGHT = 250;
    static final int MEDIUM_RECTANGLE_BANNER_WIDTH = 300;
    static final int MMA_BANNER_HEIGHT = 53;
    static final int MMA_BANNER_WIDTH = 320;
    public static final int PLACEMENT_TYPE_INLINE = 0;
    public static final int PLACEMENT_TYPE_INTERSTITIAL = 1;
    static final int PORTRAIT_BANNER_HEIGHT = 66;
    static final int PORTRAIT_BANNER_WIDTH = 766;
    static final boolean PRINT_LOG = true;
    static final int SECONDS_TO_REFRESH_AD_DEFAULT = 45;
    static final int SECONDS_TO_REFRESH_LOCATION = 900;
    static final int TEXT_COLOR_DEFAULT = -1;
    static final int TEXT_SIZE_DEFAULT = 18;
    static final int TEXT_SIZE_PROVIDER = 10;
    private static Location sCurrentLocation = null;
    private static long sLocationUpdateTimestamp = 0L;
    private static String sUA;

    public TadvertiseUtil()
    {
    }

    private static void checkEmptyJson(JSONObject jsonobject, String s)
    {
        if (jsonobject == null || s.equals(""))
        {
            throw new JSONException("Empty JSON or key");
        } else
        {
            return;
        }
    }

    public static boolean checkPermissionGranted(String s, Context context)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public static String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    public static String getAllHeadersAsString(Header aheader[])
    {
        String s = "";
        for (int i = 0; i < aheader.length; i++)
        {
            s = (new StringBuilder()).append(s).append("<< ").append(aheader[i].getName()).append(" : ").append(aheader[i].getValue()).append(" >>").toString();
        }

        return s;
    }

    public static String getApplicationName(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(context.getPackageName(), 128)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static String getApplicationVersion(Context context)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return "";
        }
        return context;
    }

    public static String getHash(String s, HashType hashtype)
    {
        com/fotoable/adbuttonlib/TadvertiseUtil;
        JVM INSTR monitorenter ;
        hashtype = MessageDigest.getInstance(hashtype.toString());
        byte abyte0[];
        StringBuffer stringbuffer;
        hashtype.update(s.getBytes());
        abyte0 = hashtype.digest();
        stringbuffer = new StringBuffer();
        int i = 0;
_L2:
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        hashtype = Integer.toHexString(abyte0[i] & 0xff);
        s = hashtype;
        if (hashtype.length() < 2)
        {
            s = (new StringBuilder()).append("0").append(hashtype).toString();
        }
        stringbuffer.append(s);
        i++;
        if (true) goto _L2; else goto _L1
        s;
        s.printStackTrace();
        logMessage(null, 3, "Could not create hash value");
        s = "";
_L4:
        com/fotoable/adbuttonlib/TadvertiseUtil;
        JVM INSTR monitorexit ;
        return s;
_L1:
        s = stringbuffer.toString();
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static String getHashedAndroidID(Context context, HashType hashtype)
    {
        context = android.provider.Settings.Secure.getString(context.getApplicationContext().getContentResolver(), "android_id");
        if (context == null)
        {
            return "";
        } else
        {
            return getHash(context, hashtype);
        }
    }

    public static String getHashedMacAddress(Context context, HashType hashtype)
    {
        String s = null;
        if (checkPermissionGranted("android.permission.ACCESS_WIFI_STATE", context))
        {
            s = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (s == null)
        {
            return "";
        } else
        {
            return getHash(s, hashtype);
        }
    }

    private static ArrayList getInstalledApps(boolean flag, Context context)
    {
        ArrayList arraylist = new ArrayList();
        List list = context.getPackageManager().getInstalledPackages(0);
        int i = 0;
        while (i < list.size()) 
        {
            PackageInfo packageinfo = (PackageInfo)list.get(i);
            if (flag || packageinfo.versionName != null)
            {
                PInfo pinfo = new PInfo();
                pinfo.appname = packageinfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                pinfo.pname = packageinfo.packageName;
                pinfo.versionName = packageinfo.versionName;
                pinfo.versionCode = packageinfo.versionCode;
                pinfo.icon = packageinfo.applicationInfo.loadIcon(context.getPackageManager());
                arraylist.add(pinfo);
            }
            i++;
        }
        return arraylist;
    }

    public static JSONArray getJSONArray(JSONObject jsonobject, String s)
    {
        checkEmptyJson(jsonobject, s);
        if (jsonobject.has(s))
        {
            return jsonobject.getJSONArray(s);
        } else
        {
            return new JSONArray();
        }
    }

    public static boolean getJSONBoolean(JSONObject jsonobject, String s)
    {
        checkEmptyJson(jsonobject, s);
        if (jsonobject.has(s))
        {
            return jsonobject.getBoolean(s);
        } else
        {
            return false;
        }
    }

    public static int getJSONInt(JSONObject jsonobject, String s)
    {
        checkEmptyJson(jsonobject, s);
        if (jsonobject.has(s))
        {
            return jsonobject.getInt(s);
        } else
        {
            return 0;
        }
    }

    public static JSONObject getJSONObject(JSONObject jsonobject, String s)
    {
        checkEmptyJson(jsonobject, s);
        if (jsonobject.has(s))
        {
            return jsonobject.getJSONObject(s);
        } else
        {
            return null;
        }
    }

    public static String getJSONValue(JSONObject jsonobject, String s)
    {
        checkEmptyJson(jsonobject, s);
        if (jsonobject.has(s))
        {
            return jsonobject.getString(s);
        } else
        {
            return "";
        }
    }

    public static String getLocalIpAddress(TAdButton.TAdButtonCallbackListener tadbuttoncallbacklistener)
    {
        Object obj = NetworkInterface.getNetworkInterfaces();
_L2:
        Enumeration enumeration;
        if (!((Enumeration) (obj)).hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
_L4:
        if (!enumeration.hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if (inetaddress.isLoopbackAddress() || !(inetaddress instanceof Inet4Address)) goto _L4; else goto _L3
_L3:
        obj = inetaddress.getHostAddress().toString();
        return ((String) (obj));
        SocketException socketexception;
        socketexception;
        if (tadbuttoncallbacklistener != null)
        {
            tadbuttoncallbacklistener.onError(socketexception);
        }
        socketexception.printStackTrace();
        if (tadbuttoncallbacklistener != null)
        {
            tadbuttoncallbacklistener.onError(new IllegalArgumentException("Couldn't obtain the local ip address"));
        }
        return "";
    }

    public static Location getLocation()
    {
        return sCurrentLocation;
    }

    public static ArrayList getPackages(Context context)
    {
        context = getInstalledApps(false, context);
        int j = context.size();
        for (int i = 0; i < j; i++)
        {
            ((PInfo)context.get(i)).prettyPrint();
        }

        return context;
    }

    public static String getToken(Context context, TAdButton.TAdButtonCallbackListener tadbuttoncallbacklistener)
    {
        PackageManager packagemanager = context.getPackageManager();
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 128).metaData.getString("madvertise_site_token");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context == null)
        {
            logMessage(null, 3, "Could not fetch \"madvertise_site_token\" from AndroidManifest.xml");
            if (tadbuttoncallbacklistener != null)
            {
                tadbuttoncallbacklistener.onError(new IllegalArgumentException("Could not fetch \"madvertise_site_token\" from AndroidManifest.xml"));
            }
        }
        return context;
    }

    public static String getUA()
    {
        if (sUA != null)
        {
            return sUA;
        }
        StringBuffer stringbuffer = new StringBuffer();
        Object obj = android.os.Build.VERSION.RELEASE;
        String s;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append(((String) (obj)));
        } else
        {
            stringbuffer.append("1.0");
        }
        stringbuffer.append("; ");
        obj = Locale.getDefault();
        s = ((Locale) (obj)).getLanguage();
        if (s != null)
        {
            stringbuffer.append(s.toLowerCase());
            obj = ((Locale) (obj)).getCountry();
            if (obj != null)
            {
                stringbuffer.append("-");
                stringbuffer.append(((String) (obj)).toLowerCase());
            }
        } else
        {
            stringbuffer.append("de");
        }
        obj = Build.MODEL;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append("; ");
            stringbuffer.append(((String) (obj)));
        }
        obj = Build.ID;
        if (((String) (obj)).length() > 0)
        {
            stringbuffer.append(" Build/");
            stringbuffer.append(((String) (obj)));
        }
        sUA = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2", new Object[] {
            stringbuffer
        });
        return sUA;
    }

    public static boolean isConnectionAvailable()
    {
        boolean flag;
        try
        {
            class _cls1NetworkCheckTask extends AsyncTask
            {

                protected transient Boolean doInBackground(Void avoid[])
                {
                    try
                    {
                        avoid = (HttpURLConnection)(new URL("http://fotorus.fotoable.com")).openConnection();
                        avoid.setConnectTimeout(999);
                        avoid.setRequestMethod("GET");
                        avoid.setDoInput(true);
                        avoid.connect();
                        if (avoid.getResponseCode() == 200)
                        {
                            return Boolean.valueOf(true);
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        return Boolean.valueOf(false);
                    }
                    return Boolean.valueOf(false);
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

            _cls1NetworkCheckTask()
            {
            }
            }

            _cls1NetworkCheckTask _lcls1networkchecktask = new _cls1NetworkCheckTask();
            _lcls1networkchecktask.execute(new Void[0]);
            flag = ((Boolean)_lcls1networkchecktask.get()).booleanValue();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public static void logMessage(String s, int i, String s1)
    {
        String s2 = s;
        if (s == null)
        {
            s2 = "MAD_LOG";
        }
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        s1 = Thread.currentThread().getStackTrace()[3].getClassName();
        s1 = s1.substring(s1.lastIndexOf(".") + 1);
        int j = Thread.currentThread().getStackTrace()[3].getLineNumber();
        Log.println(i, s2, (new StringBuilder()).append("(").append(s1).append(":").append(j).append(") : ").append(s).toString());
    }

    public static String printRequestParameters(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        NameValuePair namevaluepair;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append((new StringBuilder()).append(namevaluepair.getName()).append("=").append(namevaluepair.getValue()).append("\n").toString()))
        {
            namevaluepair = (NameValuePair)list.next();
        }

        return stringbuilder.toString();
    }

    public static void refreshCoordinates(Context context)
    {
        Object obj;
        obj = null;
        logMessage(null, 3, "Trying to refresh location");
        if (context == null)
        {
            logMessage(null, 3, "Context not set - quit location refresh");
            return;
        }
        if (sLocationUpdateTimestamp + 0xdbba0L > System.currentTimeMillis())
        {
            logMessage(null, 3, "It's not time yet for refreshing the location");
            return;
        }
        context;
        JVM INSTR monitorenter ;
        if (sLocationUpdateTimestamp + 0xdbba0L <= System.currentTimeMillis())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        logMessage(null, 3, "Another thread updated the loation already");
        context;
        JVM INSTR monitorexit ;
        return;
        obj;
        context;
        JVM INSTR monitorexit ;
        throw obj;
        boolean flag;
        boolean flag1;
        flag = checkPermissionGranted("android.permission.ACCESS_COARSE_LOCATION", context);
        flag1 = checkPermissionGranted("android.permission.ACCESS_FINE_LOCATION", context);
        if (flag || flag1)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        logMessage(null, 3, "No permissions for requesting the location");
        context;
        JVM INSTR monitorexit ;
        return;
        final LocationManager finalizedLocationManager = (LocationManager)context.getSystemService("location");
        if (finalizedLocationManager != null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        logMessage(null, 3, "Unable to fetch a location manger");
        context;
        JVM INSTR monitorexit ;
        return;
        Criteria criteria;
        criteria = new Criteria();
        criteria.setCostAllowed(false);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        criteria.setAccuracy(2);
        obj = finalizedLocationManager.getBestProvider(criteria, true);
        Object obj1;
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        obj1 = obj;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        criteria.setAccuracy(1);
        obj1 = finalizedLocationManager.getBestProvider(criteria, true);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        logMessage(null, 3, "Unable to fetch a location provider");
        context;
        JVM INSTR monitorexit ;
        return;
        sLocationUpdateTimestamp = System.currentTimeMillis();
        finalizedLocationManager.requestLocationUpdates(((String) (obj1)), 0L, 0.0F, new LocationListener() {

            final LocationManager val$finalizedLocationManager;

            public void onLocationChanged(Location location)
            {
                TadvertiseUtil.logMessage(null, 3, "Refreshing location");
                TadvertiseUtil.sCurrentLocation = location;
                TadvertiseUtil.sLocationUpdateTimestamp = System.currentTimeMillis();
                finalizedLocationManager.removeUpdates(this);
            }

            public void onProviderDisabled(String s)
            {
            }

            public void onProviderEnabled(String s)
            {
            }

            public void onStatusChanged(String s, int i, Bundle bundle)
            {
            }

            
            {
                finalizedLocationManager = locationmanager;
                super();
            }
        }, context.getMainLooper());
        context;
        JVM INSTR monitorexit ;
    }



/*
    static Location access$002(Location location)
    {
        sCurrentLocation = location;
        return location;
    }

*/


/*
    static long access$102(long l)
    {
        sLocationUpdateTimestamp = l;
        return l;
    }

*/

    private class HashType extends Enum
    {

        private static final HashType $VALUES[];
        public static final HashType MD5;
        public static final HashType SHA1;

        public static HashType valueOf(String s)
        {
            return (HashType)Enum.valueOf(com/fotoable/adbuttonlib/TadvertiseUtil$HashType, s);
        }

        public static HashType[] values()
        {
            return (HashType[])$VALUES.clone();
        }

        static 
        {
            MD5 = new HashType("MD5", 0);
            SHA1 = new HashType("SHA1", 1);
            $VALUES = (new HashType[] {
                MD5, SHA1
            });
        }

        private HashType(String s, int i)
        {
            super(s, i);
        }
    }


    private class PInfo
    {

        private String appname;
        private Drawable icon;
        private String pname;
        private int versionCode;
        private String versionName;

        private void prettyPrint()
        {
            TadvertiseUtil.logMessage(null, 3, (new StringBuilder()).append(appname).append("\t ").append(pname).append("\t ").append(versionName).append("\t ").append(versionCode).toString());
        }

        public String getappname()
        {
            return appname;
        }

        public String getpname()
        {
            return pname;
        }

        public int getversionCode()
        {
            return versionCode;
        }

        public String getversionName()
        {
            return versionName;
        }



/*
        static String access$302(PInfo pinfo, String s)
        {
            pinfo.appname = s;
            return s;
        }

*/


/*
        static String access$402(PInfo pinfo, String s)
        {
            pinfo.pname = s;
            return s;
        }

*/


/*
        static String access$502(PInfo pinfo, String s)
        {
            pinfo.versionName = s;
            return s;
        }

*/


/*
        static int access$602(PInfo pinfo, int i)
        {
            pinfo.versionCode = i;
            return i;
        }

*/


/*
        static Drawable access$702(PInfo pinfo, Drawable drawable)
        {
            pinfo.icon = drawable;
            return drawable;
        }

*/

        PInfo()
        {
            appname = "";
            pname = "";
            versionName = "";
            versionCode = 0;
        }
    }

}
