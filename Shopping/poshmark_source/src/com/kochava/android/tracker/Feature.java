// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kochava.android.tracker;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.kochava.android.util.StringUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kochava.android.tracker:
//            Global, KochavaDbAdapter, KochavaWebAdView, ReferralCapture

public class Feature
{
    public final class CURRENCIES
    {

        public static final String AED = "AED";
        public static final String AUD = "AUD";
        public static final String CAD = "CAD";
        public static final String CHF = "CHF";
        public static final String CNY = "CNY";
        public static final String DKK = "DKK";
        public static final String EUR = "EUR";
        public static final String GBP = "GBP";
        public static final String IDR = "IDR";
        public static final String ILS = "ILS";
        public static final String INR = "INR";
        public static final String MXP = "MXP";
        public static final String NOK = "NOK";
        public static final String NZD = "NZD";
        public static final String RUB = "RUB";
        public static final String SAR = "SAR";
        public static final String SEK = "SEK";
        public static final String TRY = "TRY";
        public static final String USD = "USD";
        public static final String YEN = "YEN";
        public static final String ZAR = "ZAR";
        final Feature this$0;

        private CURRENCIES()
        {
            this$0 = Feature.this;
            super();
        }
    }

    public final class INPUTITEMS
    {

        public static final String BIDDER_HOST = "bidder_host";
        public static final String CONTROL_HOST = "control_host";
        public static final String CURRENCY = "currency";
        public static final String IDENTITY_LINK = "identity_link";
        public static final String KOCHAVA_APP_ID = "kochava_app_id";
        public static final String PARTNER_ID = "partner_id";
        public static final String PARTNER_NAME = "partner_name";
        public static final String REQUEST_ATTRIBUTION = "request_attribution";
        final Feature this$0;

        private INPUTITEMS()
        {
            this$0 = Feature.this;
            super();
        }
    }

    public final class PARAMS
    {

        public static final String ANDROID_ID = "android_id";
        public static final String FB_ATTRIBUTION_ID = "fb_attribution_id";
        public static final String IMEI = "imei";
        public static final String MAC = "mac";
        public static final String ODIN = "odin";
        public static final String OPEN_UDID = "open_udid";
        final Feature this$0;

        private PARAMS()
        {
            this$0 = Feature.this;
            super();
        }
    }

    private class TrackTask
        implements Runnable
    {

        final Feature this$0;

        public void run()
        {
            postEvent();
        }

        private TrackTask()
        {
            this$0 = Feature.this;
            super();
        }

        TrackTask(TrackTask tracktask)
        {
            this();
        }
    }


    protected static final String ADLOGTAG = "KochavaAds";
    private static final int AD_CLICK_RESET_TIME = 2500;
    private static final int AD_UNAVAILABLE_CLICK_RESET_TIME = 2500;
    public static final String ATTRIBUTION_DATA = "attributionData";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    protected static final String ATTRIBUTION_PREF_DATA = "attributionData";
    protected static final String ATTRIBUTION_PREF_NAME = "attributionPref";
    private static final String BIDDER_DEFAULT_HOST = "bidder.kochava.com";
    private static final String BIDDER_ENDPOINT = "/adserver/request/";
    private static final int BULK_UPLOAD_LIMIT = 40;
    private static final String CONTROL_DEFAULT_HOST = "control.kochava.com";
    private static final int DATA_EXPIRATION = 0x240c8400;
    private static final int FLUSH_RATE = 60000;
    private static final String HTML_FORMAT = "<html><body style=\"text-align: center; background-color: black; vertical-align: center;\"><img src = \"%s\" /></body></html>";
    private static final String HTTPS_STRING = "https://";
    private static final String HTTP_STRING = "http://";
    private static final String INIT_ENDPOINT = "/track/kvinit";
    private static final int INIT_FORCE_TIME = 0x927c0;
    public static final String LINKIDENTITYBOOL = "linkIdentityBool";
    protected static final String LOGTAG = "KochavaTracker";
    private static final String OPTIONS_ENDPOINT = "/track/kv_options.php";
    protected static final String PREF_APPDATA = "kochavaappdata";
    protected static final String PREF_CUR = "currency";
    protected static final String PREF_INIT = "initBool";
    protected static final String PREF_INIT_DATA = "initData";
    protected static final String PREF_LAT = "mylat";
    protected static final String PREF_LONG = "mylong";
    protected static final String PREF_NAME = "initPrefs";
    protected static final String PREF_TIMESTOPPED = "timeStampStopped";
    protected static final String REQLOGTAG = "KochavaRequirements";
    private static final String SENDONSTART = "sendonstart";
    private static final String STRING_FALSE = "false";
    private static final String STRING_TRUE = "true";
    private static final String TRACKER_ENDPOINT = "/track/kvTracker.php";
    private static String advertisingID;
    protected static Context appContext;
    private static Handler attributionDataHandler;
    private static int first_run = 0;
    private static String hostBidder = "";
    private static String hostControl = "";
    private static Map identityLinkMap;
    private static JSONObject identityLinkMapJSON;
    private static HashMap paramRestrictions = new HashMap() {

            
            {
                put("android_id", Boolean.valueOf(true));
                put("imei", Boolean.valueOf(true));
                put("odin", Boolean.valueOf(true));
                put("mac", Boolean.valueOf(true));
                put("fb_attribution_id", Boolean.valueOf(true));
                put("open_udid", Boolean.valueOf(true));
            }
    };
    private static boolean requestAttributionData = false;
    public static Hashtable webStates;
    public static Hashtable webViews;
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    private Timer adTimer;
    private SharedPreferences attributionDataPrefs;
    private boolean badInit;
    private boolean canSendSession;
    private final ExecutorService executor;
    private Handler initHandler = new Handler() {

        final Feature this$0;

        public void handleMessage(Message message)
        {
            boolean flag;
            flag = message.getData().getBoolean("sendonstart");
            mUserAgent = getUserAgent();
            mCarrier = getCarrier();
            mModel = getModel();
            mAppName = "Default";
            mAppVersionCode = "N/A";
            mAppVersionName = "";
            PackageManager packagemanager = mContext.getApplicationContext().getPackageManager();
            message = packagemanager.getApplicationInfo(mContext.getPackageName(), 0);
_L2:
            Feature feature = Feature.this;
            if (message == null)
            {
                break MISSING_BLOCK_LABEL_921;
            }
            message = packagemanager.getApplicationLabel(message);
_L4:
            feature.mAppName = (String)message;
            if (Global.DEBUG)
            {
                Log.i("KochavaTracker", (new StringBuilder("mAppName now: ")).append(mAppName).toString());
            }
_L3:
            try
            {
                mAppVersionCode = (new StringBuilder(String.valueOf(mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode))).toString();
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("mAppVersionCode now: ")).append(mAppVersionCode).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error gathering app version code ")).append(message.toString()).toString());
                }
            }
            try
            {
                mAppVersionName = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("mAppVersionName now: ")).append(mAppVersionName).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error gathering app version name ")).append(message.toString()).toString());
                }
            }
            try
            {
                message = (WindowManager)mContext.getSystemService("window");
                mDisplayHeight = message.getDefaultDisplay().getHeight();
                mDisplayWidth = message.getDefaultDisplay().getWidth();
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("Height: ")).append(mDisplayHeight).append(" | Width: ").append(mDisplayWidth).toString());
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Error ")).append(message.toString()).toString());
                }
            }
            mAndroidID = android.provider.Settings.Secure.getString(mContext.getContentResolver(), "android_id");
            mDeviceId = getDeviceId();
            prefs = mContext.getSharedPreferences("initPrefs", 0);
            if (prefs.getString("initBool", "").equals(""))
            {
                prefs.edit().putString("initBool", "false").commit();
            }
            if (prefs.getString("kochavaappdata", null) != null)
            {
                message = kDbAdapter.getApplicationData(prefs.getString("kochavaappdata", null));
                String s1 = createAppData();
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("[KOCHAVA] Stored Data: ")).append(message).toString());
                    Log.e("KochavaTracker", (new StringBuilder("[KOCHAVA] Created Data: ")).append(s1).toString());
                }
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                if (message == null)
                {
                    kDbAdapter.insertApplicationData(prefs.getString("kochavaappdata", null), s1);
                    Feature.first_run = 1;
                } else
                if (!message.equals(s1))
                {
                    kDbAdapter.updateApplicationData(prefs.getString("kochavaappdata", null), s1);
                } else
                {
                    if (Global.DEBUG)
                    {
                        Log.e("KochavaTracker", "Set start of life to false");
                    }
                    mIsStartOfLife = false;
                }
            } else
            {
                mIsStartOfLife = false;
            }
            kDbAdapter.cleanupEvents(System.currentTimeMillis() - 0x240c8400L);
            if (mIsStartOfLife || !prefs.getString("initBool", "").equals("") && prefs.getString("initBool", "").equals("false"))
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Initial event has not yet been qued in the database, making initial call");
                }
                fireEvent("initial", null);
            }
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {

                final _cls2 this$1;

                public void run()
                {
                    flush();
                }

            
            {
                this$1 = _cls2.this;
                super();
            }
            }, 0L, 60000L);
            initTimer = new Timer();
            if (!flag)
            {
                initTimer.schedule(new TimerTask() {

                    final _cls2 this$1;

                    public void run()
                    {
                        if (Global.DEBUG)
                        {
                            Log.e("KochavaTracker", "Reached 10 min mark w/o sending initial, sending now.");
                        }
                        queInitial(false);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }, 0x927c0L);
                return;
            } else
            {
                initTimer.schedule(new TimerTask() {

                    final _cls2 this$1;

                    public void run()
                    {
                        if (Global.DEBUG)
                        {
                            Log.e("KochavaTracker", "Scheduling timer to que initial event if needed.");
                        }
                        queInitial(false);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }, 2000L);
                mTimerSendOnBegin = new Timer();
                mTimerSendOnBegin.schedule(new TimerTask() {

                    final _cls2 this$1;

                    public void run()
                    {
                        flush();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }, 4000L);
                return;
            }
            namenotfoundexception;
            s1 = null;
            message = s1;
            if (!Global.DEBUGERROR) goto _L2; else goto _L1
_L1:
            Log.e("KochavaTracker", (new StringBuilder("Error gathering app name ")).append(namenotfoundexception.toString()).toString());
            message = s1;
              goto _L2
            message;
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", (new StringBuilder("Error gathering app name ")).append(message.toString()).toString());
            }
              goto _L3
            message = "(unknown)";
              goto _L4
        }


            
            {
                this$0 = Feature.this;
                super();
            }
    };
    private Timer initTimer;
    private Timer initTimerRepeat;
    private JSONObject initialObject;
    private JSONObject initialPropertiesObject;
    private KochavaDbAdapter kDbAdapter;
    protected JSONObject kvinitdata;
    protected JSONObject kvinitdataholder;
    protected JSONObject kvinitorigdata;
    private long lastCallTime;
    private String mAndroidID;
    private String mAppId;
    private String mAppName;
    private String mAppPackageName;
    private String mAppVersionCode;
    private String mAppVersionName;
    private String mCarrier;
    private Context mContext;
    private String mDeviceId;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private String mEnvDeviceID;
    private String mFbId;
    private String mIMEI;
    private boolean mIsStartOfLife;
    private String mKochDevIDStrategy;
    private String mMacAddr;
    private String mModel;
    private String mOSVersion;
    private Map mSuperProperties;
    private boolean mTestMode;
    private Timer mTimer;
    private Timer mTimerSendOnBegin;
    private String mUserAgent;
    private SharedPreferences prefs;
    private long startTime;

    public Feature(Context context, String s)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        HashMap hashmap = new HashMap();
        if (s != null && s.trim().length() != 0)
        {
            hashmap.put("kochava_app_id", s);
        }
        init(context, true, hashmap);
    }

    public Feature(Context context, String s, String s1)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        HashMap hashmap = new HashMap();
        if (s != null && s.trim().length() != 0)
        {
            hashmap.put("kochava_app_id", s);
        }
        if (s1 != null && s1.trim().length() != 0)
        {
            hashmap.put("currency", s1);
        }
        init(context, true, hashmap);
    }

    public Feature(Context context, String s, boolean flag)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        HashMap hashmap = new HashMap();
        if (s != null && s.trim().length() != 0)
        {
            hashmap.put("kochava_app_id", s);
        }
        init(context, flag, hashmap);
    }

    public Feature(Context context, String s, boolean flag, String s1)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        HashMap hashmap = new HashMap();
        if (s != null && s.trim().length() != 0)
        {
            hashmap.put("kochava_app_id", s);
        }
        if (s1 != null && s1.trim().length() != 0)
        {
            hashmap.put("currency", s1);
        }
        init(context, flag, hashmap);
    }

    public Feature(Context context, HashMap hashmap)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        Log.i("KochavaTracker", (new StringBuilder("is datamap null? ")).append(hashmap).toString());
        init(context, true, hashmap);
    }

    public Feature(Context context, boolean flag, HashMap hashmap)
    {
        lastCallTime = 0L;
        startTime = 0L;
        mTestMode = false;
        mIsStartOfLife = true;
        badInit = false;
        canSendSession = true;
        executor = Executors.newFixedThreadPool(1);
        init(context, flag, hashmap);
    }

    private JSONObject addGlobalProperties(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        jsonobject.put("usertime", (new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000L))).toString());
        jsonobject.put("uptime", (new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000L - startTime))).toString());
        if (lastCallTime == 0L)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        jsonobject.put("updelta", (new StringBuilder(String.valueOf(System.currentTimeMillis() / 1000L - lastCallTime))).toString());
_L1:
        lastCallTime = System.currentTimeMillis() / 1000L;
        prefs = mContext.getSharedPreferences("initPrefs", 0);
        if (prefs.getString("mylat", "").equals(""))
        {
            break MISSING_BLOCK_LABEL_227;
        }
        jsonobject.put("geo_lat", prefs.getString("mylat", ""));
        jsonobject.put("geo_lon", prefs.getString("mylong", ""));
        return jsonobject;
        jsonobject.put("updelta", "0");
          goto _L1
        Exception exception;
        exception;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Error adding time properties to a JSON object");
        }
        return jsonobject;
    }

    private String createAppData()
    {
        return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(""))).append(getDeviceId()).append(":::").toString()))).append(getModel()).append(":::").toString()))).append(getCarrier()).append(":::").toString()))).append(getIMEI()).append(":::").toString()))).append(getAppVersion()).append(":::").toString()))).append(getOSVersion()).toString();
    }

    private HttpClient createHttpClient(boolean flag)
    {
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Creating https client.");
        }
        X509HostnameVerifier x509hostnameverifier = SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "ISO-8859-1");
        HttpProtocolParams.setUseExpectContinue(basichttpparams, true);
        if (flag)
        {
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 10000);
        }
        Object obj = SSLSocketFactory.getSocketFactory();
        ((SSLSocketFactory) (obj)).setHostnameVerifier((X509HostnameVerifier)x509hostnameverifier);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
        obj = new ThreadSafeClientConnManager(basichttpparams, schemeregistry);
        HttpsURLConnection.setDefaultHostnameVerifier(x509hostnameverifier);
        return new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj)), basichttpparams);
    }

    public static void enableDebug(boolean flag)
    {
        Global.DEBUG = flag;
    }

    private void eventSession(String s)
    {
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Got event ")).append(s).toString());
        }
        HashMap hashmap = new HashMap();
        hashmap.put("state", s);
        fireEvent("session", hashmap);
    }

    private void fireEvent(String s, Map map)
    {
        JSONObject jsonobject;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("FIRE EVENT*** action:")).append(s).toString());
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("FIRE EVENT*** properties:")).append(map).toString());
        }
        jsonobject = new JSONObject();
        JSONObject jsonobject1;
        jsonobject.put("kochava_app_id", mAppId);
        jsonobject.put("kochava_device_id", getDeviceId());
        jsonobject.put("action", s);
        jsonobject.put("dev_id_strategy", mKochDevIDStrategy);
        jsonobject.put("last_post_time", 0);
        prefs = mContext.getSharedPreferences("initPrefs", 0);
        jsonobject.put("currency", prefs.getString("currency", "USD"));
        jsonobject1 = addGlobalProperties(new JSONObject());
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", (new StringBuilder("fireEvent with properties: ")).append(jsonobject).toString());
        }
        if (!s.equals("initial"))
        {
            break MISSING_BLOCK_LABEL_758;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Event is initial, or initial did not get que'd on first load");
        }
        jsonobject.put("sdk_version", "Android20140428");
        jsonobject1.put("ifdg", advertisingID);
        jsonobject1.put("geid", getGmailAccounts());
        jsonobject1.put("first_run", (new StringBuilder(String.valueOf(first_run))).toString());
        jsonobject1.put("device", (new StringBuilder(String.valueOf(getModel()))).append("-").append(getCarrier()).toString());
        if (((Boolean)paramRestrictions.get("imei")).booleanValue())
        {
            jsonobject1.put("imei", getIMEI());
        }
        jsonobject1.put("disp_h", mDisplayHeight);
        jsonobject1.put("disp_w", mDisplayWidth);
        jsonobject1.put("package_name", getAppPackageName());
        jsonobject1.put("app_version", getAppVersion());
        if (!mAppVersionName.equals(""))
        {
            jsonobject1.put("app_short_string", mAppVersionName);
        }
        if (((Boolean)paramRestrictions.get("android_id")).booleanValue())
        {
            jsonobject1.put("android_id", mAndroidID);
        }
        jsonobject1.put("env_hash", mEnvDeviceID);
        jsonobject1.put("os_version", getOSVersion());
        if (identityLinkMapJSON != null)
        {
            jsonobject1.put("identity_link", identityLinkMapJSON);
        }
        if (((Boolean)paramRestrictions.get("odin")).booleanValue())
        {
            jsonobject1.put("odin", getOdin());
        }
        if (((Boolean)paramRestrictions.get("mac")).booleanValue())
        {
            jsonobject1.put("mac", mMacAddr);
        }
        if (((Boolean)paramRestrictions.get("fb_attribution_id")).booleanValue())
        {
            mFbId = getAttributionId(mContext.getContentResolver());
            if (mFbId != null)
            {
                break MISSING_BLOCK_LABEL_678;
            }
            jsonobject1.put("fb_attribution_id", "");
        }
_L2:
        s = (WindowManager)mContext.getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        s.getDefaultDisplay().getMetrics(displaymetrics);
        initialPropertiesObject = jsonobject1;
        initialObject = jsonobject;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Initial Event, saving until next event. ");
            return;
        }
        break MISSING_BLOCK_LABEL_969;
        jsonobject1.put("fb_attribution_id", mFbId);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        try
        {
            s.printStackTrace();
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "event", s);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "event", s);
                return;
            }
        }
        break MISSING_BLOCK_LABEL_969;
        s;
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", "Error during fireEvent - Please review stack trace");
        }
        s.printStackTrace();
_L12:
        if (mSuperProperties == null) goto _L4; else goto _L3
_L3:
        s = mSuperProperties.entrySet().iterator();
_L9:
        if (s.hasNext()) goto _L5; else goto _L4
_L4:
        if (map == null) goto _L7; else goto _L6
_L6:
        s = map.entrySet().iterator();
_L10:
        if (s.hasNext()) goto _L8; else goto _L7
_L7:
        jsonobject.put("data", jsonobject1);
        queInitial(true);
        int i = kDbAdapter.addEvent(jsonobject);
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("@@@@@ mTestMode = ")).append(mTestMode).toString());
        }
        if (mTestMode || i >= 40)
        {
            flush();
            return;
        }
        break MISSING_BLOCK_LABEL_969;
_L5:
        java.util.Map.Entry entry = (java.util.Map.Entry)s.next();
        jsonobject1.put((String)entry.getKey(), entry.getValue());
          goto _L9
_L8:
        map = (java.util.Map.Entry)s.next();
        jsonobject1.put((String)map.getKey(), map.getValue());
          goto _L10
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void getAd(final WebView adWebview, final Activity context, final int height, final int width)
    {
        ComponentName componentname;
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
            return;
        }
        componentname = new ComponentName(mContext, com/kochava/android/tracker/KochavaWebAdView);
        mContext.getPackageManager().getActivityInfo(componentname, 0);
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Ad activity registered.");
        }
_L2:
        (new Thread() {

            final Feature this$0;
            private final WebView val$adWebview;
            private final Activity val$context;
            private final int val$height;
            private final int val$width;

            public void run()
            {
                final Object fAdUrl;
                String s;
                Object obj1;
                char ac[];
                int i;
                s = "";
                obj1 = context.getPackageManager();
                try
                {
                    fAdUrl = ((PackageManager) (obj1)).getApplicationInfo(getAppPackageName(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (final Object fAdUrl)
                {
                    fAdUrl = null;
                }
                if (fAdUrl != null)
                {
                    fAdUrl = ((PackageManager) (obj1)).getApplicationLabel(((android.content.pm.ApplicationInfo) (fAdUrl)));
                } else
                {
                    fAdUrl = "(unknown)";
                }
                obj1 = (String)fAdUrl;
                fAdUrl = createHttpClient(false);
                if (Feature.hostBidder == null || Feature.hostBidder.trim().isEmpty())
                {
                    Feature.hostBidder = "bidder.kochava.com";
                }
                obj1 = new HttpGet((new StringBuilder("http://")).append(Feature.hostBidder).append("/adserver/request/").append("?w=").append(width).append("&h=").append(height).append("&odin=").append(getOdin()).append("&aid=").append(mAppId).append("&an=").append(((String) (obj1))).append("&av=").append("Android20140428").append("&kochava_device_id=").append(getDeviceId()).toString());
                if (fAdUrl instanceof HttpClient) goto _L2; else goto _L1
_L1:
                fAdUrl = ((HttpClient) (fAdUrl)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
_L7:
                obj1 = ((HttpResponse) (fAdUrl)).getEntity();
                fAdUrl = s;
                if (obj1 == null) goto _L4; else goto _L3
_L3:
                fAdUrl = new InputStreamReader(((HttpEntity) (obj1)).getContent(), "ISO-8859-1");
                obj1 = new StringBuilder();
                ac = new char[1024];
_L8:
                i = ((Reader) (fAdUrl)).read(ac);
                if (i != -1) goto _L6; else goto _L5
_L5:
                fAdUrl = ((StringBuilder) (obj1)).toString();
_L4:
                s = "";
                obj1 = "";
                if (Global.DEBUG)
                {
                    Log.e("KochavaAds", (new StringBuilder("Response:")).append(((String) (fAdUrl))).toString());
                }
                ac = Pattern.compile("href='(.*?)'").matcher(((CharSequence) (fAdUrl)));
                if (ac.find())
                {
                    s = ac.group(1);
                }
                ac = Pattern.compile("src='(.*?)'").matcher(((CharSequence) (fAdUrl)));
                fAdUrl = obj1;
                if (ac.find())
                {
                    fAdUrl = ac.group(1);
                }
                fAdUrl = s. new Thread() {

                    final _cls6 this$1;
                    private final WebView val$adWebview;
                    private final String val$clickUrl;
                    private final Activity val$context;
                    private final String val$fAdUrl;

                    public void run()
                    {
                        adWebview.setVerticalScrollBarEnabled(false);
                        adWebview.setHorizontalScrollBarEnabled(false);
                        adWebview.getSettings().setBuiltInZoomControls(false);
                        adWebview.setOnTouchListener(clickUrl. new android.view.View.OnTouchListener() {

                            final _cls1 this$2;
                            private final String val$clickUrl;
                            private final Activity val$context;

                            public boolean onTouch(View view, MotionEvent motionevent)
                            {
                                int i = (int)motionevent.getRawX();
                                int j = (int)motionevent.getRawY();
                                int ai[] = new int[2];
                                view.getLocationOnScreen(ai);
                                int k = ai[0];
                                int l = view.getWidth();
                                int i1 = ai[1];
                                int j1 = view.getHeight();
                                if (motionevent.getAction() == 1 && i > ai[0] && i < k + l && j > ai[1] && j < i1 + j1)
                                {
                                    view = new Intent(context, com/kochava/android/tracker/KochavaWebAdView);
                                    motionevent = new Bundle();
                                    motionevent.putString("URL", clickUrl);
                                    view.putExtras(motionevent);
                                    context.startActivity(view);
                                    if (context.getResources().getIdentifier("kochava_slide_up", "anim", context.getPackageName()) != 0)
                                    {
                                        context.overridePendingTransition(context.getResources().getIdentifier("kochava_slide_up", "anim", context.getPackageName()), context.getResources().getIdentifier("kochava_stay", "anim", context.getPackageName()));
                                    } else
                                    {
                                        context.overridePendingTransition(0x10a0002, 0x10a0001);
                                    }
                                }
                                return true;
                            }

            
            {
                this$2 = final__pcls1;
                context = activity;
                clickUrl = String.this;
                super();
            }
                        });
                        adWebview.getSettings().setJavaScriptEnabled(true);
                        if (Global.DEBUG)
                        {
                            Log.e("KochavaAds", (new StringBuilder("Loading add ")).append(fAdUrl).toString());
                        }
                        adWebview.loadUrl(fAdUrl);
                    }

            
            {
                this$1 = final__pcls6;
                adWebview = webview;
                fAdUrl = s;
                context = activity;
                clickUrl = String.this;
                super();
            }
                };
                context.runOnUiThread(((Runnable) (fAdUrl)));
                return;
_L2:
                fAdUrl = HttpInstrumentation.execute((HttpClient)fAdUrl, ((org.apache.http.client.methods.HttpUriRequest) (obj1)));
                  goto _L7
_L6:
                ((StringBuilder) (obj1)).append(ac, 0, i);
                  goto _L8
                fAdUrl;
_L10:
                Object obj;
                if (Global.DEBUG)
                {
                    Log.e("KochavaAds", (new StringBuilder("Problem grabbing ad: ")).append(((IOException) (obj)).getMessage()).toString());
                }
                ((IOException) (obj)).printStackTrace();
                obj = s;
                  goto _L4
                obj;
_L9:
                if (Global.DEBUG)
                {
                    Log.e("KochavaAds", (new StringBuilder("Problem grabbing ad: ")).append(((NoSuchAlgorithmException) (obj)).getMessage()).toString());
                }
                ((NoSuchAlgorithmException) (obj)).printStackTrace();
                obj = s;
                  goto _L4
                obj;
                  goto _L9
                obj;
                  goto _L10
            }

            
            {
                this$0 = Feature.this;
                context = activity;
                width = i;
                height = j;
                adWebview = webview;
                super();
            }
        }).start();
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaRequirements", "KOCHAVAWEBADVIEW ACTIVITY REGISTRATION MISSING: com.kochava.android.tracker.KochavaWebAdView");
        }
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaRequirements", "**NOTICE** It appears you are trying to use Kochava ads but have not registered our ad view activity. Please refer to the Kochava documentation for instructions on how to do this.");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private String getAdvertisingId()
    {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.Info info;
        int i;
        try
        {
            i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mContext);
        }
        catch (Exception exception)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", (new StringBuilder("Problem getting Advertising ID ")).append(exception.toString()).toString());
            }
            return "not_available";
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", (new StringBuilder("Problem getting Advertising ID ")).append(GooglePlayServicesUtil.getErrorString(i)).toString());
        }
        return "not_available";
        info = AdvertisingIdClient.getAdvertisingIdInfo(mContext);
        if (!info.isLimitAdTrackingEnabled())
        {
            return info.getId();
        }
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", "User has Google ID disabled.");
        }
        return "user_disabled";
    }

    private String getAppPackageName()
    {
        if (mAppPackageName != null)
        {
            return mAppPackageName;
        } else
        {
            return "Unknown";
        }
    }

    private String getAppVersion()
    {
        return (new StringBuilder(String.valueOf(mAppName))).append(" ").append(mAppVersionCode).toString();
    }

    protected static String getAttributionId(ContentResolver contentresolver)
    {
        Object obj = null;
        contentresolver = contentresolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[] {
            "aid"
        }, null, null, null);
        if (contentresolver == null) goto _L2; else goto _L1
_L1:
        if (contentresolver.moveToFirst()) goto _L3; else goto _L2
_L3:
        contentresolver = contentresolver.getString(contentresolver.getColumnIndex("aid"));
_L4:
        return contentresolver;
        Exception exception;
        exception;
        contentresolver = obj;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Problem getting FB attribution ID ")).append(exception.toString()).toString());
            contentresolver = obj;
        }
        if (true) goto _L4; else goto _L2
_L2:
        return null;
    }

    private String getCarrier()
    {
        return Build.BRAND;
    }

    private String getDeviceId()
    {
        if (mMacAddr != null && !"".equals(mMacAddr))
        {
            mKochDevIDStrategy = "1";
            try
            {
                String s = mMacAddr.replaceFirst(":", "k").replaceFirst(":", "o").replaceFirst(":", "c").replaceFirst(":", "h").replaceFirst(":", "a");
                MessageDigest messagedigest = MessageDigest.getInstance("MD5");
                messagedigest.reset();
                messagedigest.update(s.getBytes());
                s = (new BigInteger(1, messagedigest.digest())).toString(16);
                do
                {
                    if (s.length() >= 32)
                    {
                        return (new StringBuilder("KV")).append(s).toString();
                    }
                    s = (new StringBuilder("0")).append(s).toString();
                } while (true);
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                return mMacAddr;
            }
        }
        if (mIMEI != null && !"".equals(mIMEI))
        {
            mKochDevIDStrategy = "2";
            if ("000000000000000".equals(mIMEI))
            {
                return (new StringBuilder("00")).append(mIMEI).toString();
            } else
            {
                return mIMEI;
            }
        } else
        {
            mKochDevIDStrategy = "3";
            return mEnvDeviceID;
        }
    }

    private String getGmailAccounts()
    {
        String s;
        Account aaccount[];
        int i;
        int j;
        s = "";
        if (mContext.checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") != 0)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        aaccount = AccountManager.get(mContext).getAccounts();
        j = aaccount.length;
        i = 0;
_L3:
        if (i < j) goto _L2; else goto _L1
_L1:
        String s1 = s;
        if (s.isEmpty())
        {
            s1 = "not_available";
        }
        return (new StringBuilder("[")).append(s1).append("]").toString();
_L2:
        Account account = aaccount[i];
        String s2 = s;
        if (account.type.equalsIgnoreCase("com.google"))
        {
            s2 = account.name.toLowerCase();
            try
            {
                MessageDigest messagedigest = MessageDigest.getInstance("MD5");
                messagedigest.reset();
                messagedigest.update(s2.getBytes());
                s2 = (new BigInteger(1, messagedigest.digest())).toString(16);
                s2 = (new StringBuilder(String.valueOf(s))).append(s2).append(",").toString();
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                s2 = s;
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", nosuchalgorithmexception.toString());
                    s2 = s;
                }
            }
        }
        if (s2.trim().length() > 0)
        {
            s = s2.substring(0, s2.length() - 1);
        } else
        {
            s = "empty";
        }
        i++;
          goto _L3
        s = "permission_missing";
          goto _L1
    }

    private String getIMEI()
    {
        return mIMEI;
    }

    private String getModel()
    {
        return Build.MODEL;
    }

    private String getOSVersion()
    {
        return (new StringBuilder("Android ")).append(android.os.Build.VERSION.RELEASE).toString();
    }

    private String getOdin()
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        if (mMacAddr == null || "".equals(mMacAddr)) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
        byte abyte1[] = new byte[40];
        messagedigest.update(mMacAddr.getBytes("iso-8859-1"), 0, mMacAddr.length());
        abyte0 = messagedigest.digest();
        stringbuffer = new StringBuffer();
        i = 0;
_L3:
        int j;
        int k;
        if (i >= abyte0.length)
        {
            return stringbuffer.toString();
        }
        k = abyte0[i] >>> 4 & 0xf;
        j = 0;
_L4:
        if (k >= 0 && k <= 9)
        {
            stringbuffer.append((char)(k + 48));
        } else
        {
            stringbuffer.append((char)((k - 10) + 97));
        }
        k = abyte0[i] & 0xf;
        if (j < 1)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return "";
        j++;
          goto _L4
    }

    private String getUserAgent()
    {
        Object obj;
        Object obj3;
        obj3 = "";
        obj = "";
        Object obj2 = (new StringBuilder(String.valueOf(""))).append("\nTrying user agent method 1").toString();
        obj = obj2;
        Object obj4 = System.getProperty("http.agent");
        obj = obj4;
_L2:
        obj3 = obj;
        if (((String) (obj)).isEmpty())
        {
            obj3 = "error";
        }
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", (new StringBuilder("user agent result: ")).append(((String) (obj2))).toString());
        }
        return ((String) (obj3));
        Exception exception1;
        exception1;
        obj2 = new StringWriter();
        exception1.printStackTrace(new PrintWriter(((java.io.Writer) (obj2))));
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", ((StringWriter) (obj2)).toString());
        }
        obj4 = (new StringBuilder(String.valueOf(obj))).append("\nError with user agent first method: ").append(exception1.toString()).append("\n").append(((StringWriter) (obj2)).toString()).toString();
        obj = obj3;
        obj2 = obj4;
        obj4 = (new StringBuilder(String.valueOf(obj4))).append("\nTrying user agent method 2").toString();
        obj = obj3;
        obj2 = obj4;
        obj3 = (new WebView(mContext)).getSettings().getUserAgentString();
        obj = obj3;
        obj2 = obj4;
        obj4 = (new StringBuilder(String.valueOf(obj4))).append("\nMethod 2 successful").toString();
        obj2 = obj4;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        String s;
        Object obj5;
        String s1;
        String s2;
        obj4 = new StringWriter();
        exception.printStackTrace(new PrintWriter(((java.io.Writer) (obj4))));
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", ((StringWriter) (obj4)).toString());
        }
        s2 = (new StringBuilder(String.valueOf(obj2))).append("\nError with user agent second method: ").append(exception1.toString()).append("\n").append(((StringWriter) (obj4)).toString()).append("\n userAgent = error.").toString();
        s1 = null;
        obj5 = null;
        exception = ((Exception) (obj5));
        obj4 = obj;
        s = s2;
        obj2 = s1;
        s2 = (new StringBuilder(String.valueOf(s2))).append("\nTrying user agent method 3").toString();
        exception = ((Exception) (obj5));
        obj4 = obj;
        s = s2;
        obj2 = s1;
        obj5 = android/webkit/WebSettings.getDeclaredConstructor(new Class[] {
            android/content/Context, android/webkit/WebView
        });
        exception = ((Exception) (obj5));
        obj4 = obj;
        s = s2;
        obj2 = obj5;
        ((Constructor) (obj5)).setAccessible(true);
        exception = ((Exception) (obj5));
        obj4 = obj;
        s = s2;
        obj2 = obj5;
        s1 = ((WebSettings)((Constructor) (obj5)).newInstance(new Object[] {
            mContext, null
        })).getUserAgentString();
        exception = ((Exception) (obj5));
        obj4 = s1;
        s = s2;
        obj2 = obj5;
        obj = (new StringBuilder(String.valueOf(s2))).append("\nMethod 3 successful.").toString();
        exception = ((Exception) (obj));
        obj = s1;
        obj2 = exception;
        if (obj5 != null)
        {
            ((Constructor) (obj5)).setAccessible(false);
            obj = s1;
            obj2 = exception;
        }
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        obj2 = exception;
        obj5 = new StringWriter();
        obj2 = exception;
        ((Exception) (obj1)).printStackTrace(new PrintWriter(((java.io.Writer) (obj5))));
        obj2 = exception;
        if (!Global.DEBUGERROR)
        {
            break MISSING_BLOCK_LABEL_593;
        }
        obj2 = exception;
        Log.e("KochavaTracker", ((StringWriter) (obj5)).toString());
        obj2 = exception;
        s = (new StringBuilder(String.valueOf(s))).append("\nError with user agent third method: ").append(((Exception) (obj1)).toString()).append("\n").append(((StringWriter) (obj5)).toString()).append("\n userAgent = error.").toString();
        obj1 = obj4;
        obj2 = s;
        if (exception != null)
        {
            exception.setAccessible(false);
            obj1 = obj4;
            obj2 = s;
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (obj2 != null)
        {
            ((Constructor) (obj2)).setAccessible(false);
        }
        throw obj1;
    }

    private boolean haveAttributionData()
    {
        return attributionDataPrefs != null && !attributionDataPrefs.getAll().isEmpty();
    }

    private void init(Context context, final boolean sendOnStart, HashMap hashmap)
    {
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Feature initialization");
        }
        if (context == null) goto _L2; else goto _L1
_L1:
        mContext = context;
        Object obj;
        Object obj1;
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        Object obj2;
        String s5;
        String s6;
        String s7;
        String s8;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean flag;
        boolean flag1;
        boolean flag2;
        try
        {
            mFbId = getAttributionId(mContext.getContentResolver());
        }
        catch (Exception exception1) { }
        obj = new TraceFieldInterface() {

            public Trace _nr_trace;
            final Feature this$0;

            public void _nr_setTrace(Trace trace)
            {
                try
                {
                    _nr_trace = trace;
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Trace trace)
                {
                    return;
                }
            }

            protected volatile transient Object doInBackground(Object aobj[])
            {
                TraceMachine.enterMethod(_nr_trace, "Feature$3#doInBackground", null);
_L1:
                aobj = doInBackground((Void[])aobj);
                TraceMachine.exitMethod();
                TraceMachine.unloadTraceContext(this);
                return ((Object) (aobj));
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "Feature$3#doInBackground", null);
                  goto _L1
            }

            protected transient String doInBackground(Void avoid[])
            {
                return getAdvertisingId();
            }

            protected volatile void onPostExecute(Object obj6)
            {
                TraceMachine.enterMethod(_nr_trace, "Feature$3#onPostExecute", null);
_L1:
                onPostExecute((String)obj6);
                TraceMachine.exitMethod();
                return;
                NoSuchFieldError nosuchfielderror;
                nosuchfielderror;
                TraceMachine.enterMethod(null, "Feature$3#onPostExecute", null);
                  goto _L1
            }

            protected void onPostExecute(String s9)
            {
                Feature.advertisingID = s9;
            }

            
            {
                this$0 = Feature.this;
                super();
            }
        };
        obj1 = new Void[0];
        if (!(obj instanceof AsyncTask))
        {
            ((AsyncTask) (obj)).execute(((Object []) (obj1)));
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)obj, ((Object []) (obj1)));
        }
        kDbAdapter = new KochavaDbAdapter(mContext);
        try
        {
            mAppPackageName = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).packageName;
        }
        catch (Exception exception) { }
        kvinitdata = new JSONObject();
        kvinitdataholder = new JSONObject();
        kvinitorigdata = new JSONObject();
        obj3 = null;
        obj1 = null;
        obj4 = null;
        s = null;
        obj2 = null;
        s1 = null;
        s8 = null;
        s2 = null;
        s5 = null;
        s3 = null;
        s6 = null;
        s4 = null;
        s7 = null;
        obj5 = null;
        if (hashmap == null) goto _L4; else goto _L3
_L3:
        obj = obj1;
        if (hashmap.get("partner_id") != null)
        {
            obj = obj1;
            if (hashmap.get("partner_id").getClass().equals(java/lang/String))
            {
                obj = (String)hashmap.get("partner_id");
            }
        }
        obj1 = s;
        if (hashmap.get("partner_name") != null)
        {
            obj1 = s;
            if (hashmap.get("partner_name").getClass().equals(java/lang/String))
            {
                obj1 = (String)hashmap.get("partner_name");
            }
        }
        s = s1;
        if (hashmap.get("kochava_app_id") != null)
        {
            s = s1;
            if (hashmap.get("kochava_app_id").getClass().equals(java/lang/String))
            {
                s = (String)hashmap.get("kochava_app_id");
            }
        }
        s1 = s2;
        if (hashmap.get("currency") != null)
        {
            s1 = s2;
            if (hashmap.get("currency").getClass().equals(java/lang/String))
            {
                s1 = (String)hashmap.get("currency");
            }
        }
        s2 = s3;
        if (hashmap.get("request_attribution") != null)
        {
            s2 = s3;
            if (hashmap.get("request_attribution").getClass().equals(java/lang/String))
            {
                s2 = (String)hashmap.get("request_attribution");
            }
        }
        s3 = s4;
        if (hashmap.get("bidder_host") != null)
        {
            s3 = s4;
            if (hashmap.get("bidder_host").getClass().equals(java/lang/String))
            {
                s3 = (String)hashmap.get("bidder_host");
            }
        }
        s4 = obj5;
        if (hashmap.get("control_host") != null)
        {
            s4 = obj5;
            if (hashmap.get("control_host").getClass().equals(java/lang/String))
            {
                s4 = (String)hashmap.get("control_host");
            }
        }
        obj2 = s;
        s5 = s2;
        s6 = s3;
        s7 = s4;
        s8 = s1;
        obj3 = obj;
        obj4 = obj1;
        if (hashmap.get("identity_link") == null) goto _L4; else goto _L5
_L5:
        obj2 = s;
        s5 = s2;
        s6 = s3;
        s7 = s4;
        s8 = s1;
        obj3 = obj;
        obj4 = obj1;
        if (!(hashmap.get("identity_link") instanceof HashMap)) goto _L4; else goto _L6
_L6:
        identityLinkMap = (HashMap)hashmap.get("identity_link");
        identityLinkMapJSON = new JSONObject();
        hashmap = identityLinkMap.entrySet().iterator();
_L19:
        flag2 = hashmap.hasNext();
        if (flag2) goto _L8; else goto _L7
_L7:
        obj4 = obj1;
        obj3 = obj;
        s8 = s1;
        s7 = s4;
        s6 = s3;
        s5 = s2;
        obj2 = s;
_L4:
        if (s7 != null && s7.trim().length() != 0)
        {
            hostControl = s7;
        }
        if (s6 != null && s6.trim().length() != 0)
        {
            hostBidder = s6;
        }
        if (s8 != null && s8.length() != 0)
        {
            setCurrency(s8);
        }
        prefs = mContext.getSharedPreferences("initPrefs", 0);
        if (s5 != null && s5.equalsIgnoreCase("true"))
        {
            setRequestAttributionData(true);
        }
        attributionDataPrefs = mContext.getSharedPreferences("attributionPref", 0);
        if (obj3 == null) goto _L10; else goto _L9
_L9:
        if (((String) (obj3)).trim().length() != 0) goto _L11; else goto _L10
_L10:
        if (obj4 == null) goto _L13; else goto _L12
_L12:
        if (((String) (obj4)).trim().length() != 0) goto _L11; else goto _L13
_L13:
        if (obj2 == null) goto _L15; else goto _L14
_L14:
        if (((String) (obj2)).trim().length() != 0) goto _L16; else goto _L15
_L15:
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", "Kochava requires that you pass either a kochava app id, or a partner id and a partner name into the datamap during initialization.");
        }
_L18:
        return;
_L2:
        if (!Global.DEBUGERROR) goto _L18; else goto _L17
_L17:
        Log.e("KochavaTracker", "Context you passed was null, cannot initialize.");
        return;
_L8:
        obj2 = (java.util.Map.Entry)hashmap.next();
        identityLinkMapJSON.put((String)((java.util.Map.Entry) (obj2)).getKey(), (String)((java.util.Map.Entry) (obj2)).getValue());
        hashmap.remove();
          goto _L19
        hashmap;
        obj2 = s;
        s5 = s2;
        s6 = s3;
        s7 = s4;
        s8 = s1;
        obj3 = obj;
        obj4 = obj1;
          goto _L4
_L16:
        mAppId = ((String) (obj2));
        kvinitdataholder.put("kochava_app_id", obj2);
        kvinitorigdata.put("kochava_app_id", obj2);
        if (prefs.getString("kochavaappdata", "").equals(""))
        {
            prefs.edit().putString("kochavaappdata", ((String) (obj2))).commit();
        }
_L22:
        kvinitdata.put("package", getAppPackageName());
        kvinitdata.put("platform", "android");
        kvinitdata.put("session_tracking", "full");
        kvinitdata.put("currency", prefs.getString("currency", "USD"));
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", (new StringBuilder("Do we have attribution data? ")).append(haveAttributionData()).toString());
        }
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", (new StringBuilder("Did we request attribution data? ")).append(requestAttributionData).toString());
        }
        if (!haveAttributionData() && requestAttributionData)
        {
            if (Global.DEBUG)
            {
                Log.i("KochavaTracker", "Requesting attribution data...");
            }
            kvinitdata.put("request_attribution", "true");
        }
        kvinitorigdata.put("currency", prefs.getString("currency", "USD"));
        kvinitorigdata.put("session_tracking", "full");
        kvinitorigdata.put("currency", prefs.getString("currency", "USD"));
        kvinitdataholder.put("sdk_version", "Android20140428");
        kvinitdataholder.put("sdk_protocol", "3");
        kvinitdataholder.put("data", kvinitdata);
        kvinitdataholder.put("data_orig", kvinitorigdata);
_L21:
        if (appContext == null)
        {
            appContext = context.getApplicationContext();
        }
        startTime = System.currentTimeMillis() / 1000L;
        flag1 = false;
        hashmap = "";
        context = new ComponentName(mContext, com/kochava/android/tracker/ReferralCapture);
        mContext.getPackageManager().getReceiverInfo(context, 0);
        flag = flag1;
        context = hashmap;
        if (!Global.DEBUG)
        {
            break MISSING_BLOCK_LABEL_1420;
        }
        Log.e("KochavaTracker", "Receiver registered.");
        context = hashmap;
        flag = flag1;
_L23:
        hashmap = context;
        if (mContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", mContext.getPackageName()) < 0)
        {
            flag = true;
            hashmap = (new StringBuilder(String.valueOf(context))).append("\n    PERMMISION MISSING: android.permission.ACCESS_NETWORK_STATE").toString();
        }
        context = hashmap;
        if (mContext.getPackageManager().checkPermission("android.permission.INTERNET", mContext.getPackageName()) < 0)
        {
            flag = true;
            context = (new StringBuilder(String.valueOf(hashmap))).append("\n    PERMMISION MISSING: android.permission.INTERNET").toString();
        }
        hashmap = context;
        if (mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", mContext.getPackageName()) < 0)
        {
            flag = true;
            hashmap = (new StringBuilder(String.valueOf(context))).append("\n    PERMMISION MISSING: android.permission.ACCESS_WIFI_STATE").toString();
        }
        if (flag)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaRequirements", "**NOTICE** The following items may not have been implemented correctly. Please refer to the Kochava SDK documentation to resolve these issues:");
            }
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaRequirements", hashmap);
            }
        }
        try
        {
            mIMEI = ((TelephonyManager)mContext.getSystemService("phone")).getDeviceId();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", (new StringBuilder("Couldn't gather IMEI: ")).append(context.toString()).toString());
            }
        }
        try
        {
            mMacAddr = ((WifiManager)mContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        mEnvDeviceID = UUID.randomUUID().toString().replaceAll("-", "");
        try
        {
            kvinitdataholder.put("kochava_device_id", getDeviceId());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        context = new Runnable() {

            final Feature this$0;
            private final boolean val$sendOnStart;

            public void run()
            {
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", "getKVinit thread started.");
                }
                if (!Global.DEBUG) goto _L2; else goto _L1
_L1:
                Object obj6;
                Object obj7;
                obj7 = new StringBuilder("getKVinit post: ");
                obj6 = kvinitdataholder;
                if (obj6 instanceof JSONObject) goto _L4; else goto _L3
_L3:
                obj6 = ((JSONObject) (obj6)).toString();
_L12:
                Log.i("KochavaTracker", ((StringBuilder) (obj7)).append(((String) (obj6))).toString());
_L2:
                Object obj8;
                obj7 = createHttpClient(true);
                HttpProtocolParams.setUserAgent(((HttpClient) (obj7)).getParams(), mUserAgent);
                if (Feature.hostControl == null || Feature.hostControl.trim().isEmpty())
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "KVinit - hostControl was empty, using default");
                    }
                    Feature.hostControl = "control.kochava.com";
                }
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("KVinit - posting to ")).append("https://").append(Feature.hostControl).append("/track/kvinit").toString());
                }
                obj8 = new HttpPost((new StringBuilder("https://")).append(Feature.hostControl).append("/track/kvinit").toString());
                obj6 = kvinitdataholder;
                if (obj6 instanceof JSONObject) goto _L6; else goto _L5
_L5:
                obj6 = ((JSONObject) (obj6)).toString();
_L13:
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("kvinit data:")).append(((String) (obj6))).toString());
                }
                obj6 = new StringEntity(((String) (obj6)), "UTF-8");
                BasicHeader basicheader = new BasicHeader("Content-Type", "application/xml");
                ((HttpPost) (obj8)).getParams().setBooleanParameter("http.protocol.expect-continue", false);
                ((StringEntity) (obj6)).setContentType(basicheader);
                ((HttpPost) (obj8)).setEntity(((HttpEntity) (obj6)));
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Trying to post to KVinit.");
                }
                if (obj7 instanceof HttpClient) goto _L8; else goto _L7
_L7:
                obj6 = ((HttpClient) (obj7)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj8)));
_L14:
                obj6 = ((HttpResponse) (obj6)).getEntity();
                if (obj6 != null) goto _L10; else goto _L9
_L9:
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", "Could not get a response entity from KVinit.");
                    return;
                }
                  goto _L11
_L4:
                obj6 = JSONObjectInstrumentation.toString((JSONObject)obj6);
                  goto _L12
_L6:
                obj6 = JSONObjectInstrumentation.toString((JSONObject)obj6);
                  goto _L13
_L8:
                obj6 = HttpInstrumentation.execute((HttpClient)obj7, ((org.apache.http.client.methods.HttpUriRequest) (obj8)));
                  goto _L14
_L10:
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "(KVinit) Grabbing Result...");
                }
                obj7 = StringUtils.inputStreamToString(((HttpEntity) (obj6)).getContent());
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("(KVinit) Result: ")).append(((String) (obj7))).toString());
                }
                obj6 = null;
                obj7 = JSONObjectInstrumentation.init(((String) (obj7)));
_L48:
                if (obj7 == null) goto _L16; else goto _L15
_L15:
                if (!Global.DEBUG) goto _L18; else goto _L17
_L17:
                obj8 = new StringBuilder("(KVinit) Parsed result: ");
                if (obj7 instanceof JSONObject) goto _L20; else goto _L19
_L19:
                obj6 = ((JSONObject) (obj7)).toString();
_L49:
                Log.e("KochavaTracker", ((StringBuilder) (obj8)).append(((String) (obj6))).toString());
_L18:
                obj8 = null;
                obj6 = ((JSONObject) (obj7)).getJSONObject("attribution");
_L51:
                if (!Global.DEBUG) goto _L22; else goto _L21
_L21:
                obj8 = new StringBuilder("attribution data null? ");
                Object obj9;
                StringBuilder stringbuilder;
                int i;
                boolean flag3;
                if (obj6 == null)
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                Log.i("KochavaTracker", ((StringBuilder) (obj8)).append(flag3).toString());
_L22:
                if (obj6 == null) goto _L24; else goto _L23
_L23:
                if (((JSONObject) (obj6)).length() <= 0) goto _L24; else goto _L25
_L25:
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", "Found attribution data");
                }
                if (!Global.DEBUG) goto _L27; else goto _L26
_L26:
                obj9 = new StringBuilder("attribution data: ");
                if (obj6 instanceof JSONObject) goto _L29; else goto _L28
_L28:
                obj8 = ((JSONObject) (obj6)).toString();
_L52:
                Log.i("KochavaTracker", ((StringBuilder) (obj9)).append(((String) (obj8))).toString());
_L27:
                obj9 = attributionDataPrefs.edit();
                if (obj6 instanceof JSONObject) goto _L31; else goto _L30
_L30:
                obj8 = ((JSONObject) (obj6)).toString();
_L53:
                ((android.content.SharedPreferences.Editor) (obj9)).putString("attributionData", ((String) (obj8))).commit();
                if (Feature.attributionDataHandler == null) goto _L24; else goto _L32
_L32:
                obj8 = Message.obtain();
                obj9 = new Bundle();
                if (obj6 instanceof JSONObject) goto _L34; else goto _L33
_L33:
                obj6 = ((JSONObject) (obj6)).toString();
_L54:
                ((Bundle) (obj9)).putString("attributionData", ((String) (obj6)));
                ((Message) (obj8)).setData(((Bundle) (obj9)));
                Feature.attributionDataHandler.sendMessage(((Message) (obj8)));
_L24:
                obj6 = null;
                obj8 = ((JSONObject) (obj7)).getJSONObject("flags");
                obj9 = obj8;
                obj6 = obj8;
                if (!Global.DEBUG) goto _L36; else goto _L35
_L35:
                obj6 = obj8;
                stringbuilder = new StringBuilder("Flags: ");
                obj6 = obj8;
                if (obj8 instanceof JSONObject) goto _L38; else goto _L37
_L37:
                obj6 = obj8;
                obj9 = ((JSONObject) (obj8)).toString();
_L55:
                obj6 = obj8;
                Log.i("KochavaTracker", stringbuilder.append(((String) (obj9))).toString());
                obj9 = obj8;
_L36:
                if (obj9 == null) goto _L40; else goto _L39
_L39:
                obj6 = ((JSONObject) (obj9)).getString("kochava_app_id");
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("kochava_app_id: ")).append(((String) (obj6)).toString()).toString());
                }
                mAppId = ((String) (obj6));
_L58:
                if (((JSONObject) (obj9)).get("session_tracking").equals("none"))
                {
                    canSendSession = false;
                }
_L60:
                JSONException jsonexception;
                int j;
                try
                {
                    obj6 = ((String)((JSONObject) (obj9)).get("currency")).toUpperCase();
                    if (Global.DEBUG)
                    {
                        Log.e("KochavaTracker", (new StringBuilder("setting currency to: ")).append(((String) (obj6))).toString());
                    }
                    setCurrency(((String) (obj6)));
                }
                catch (Exception exception3) { }
                try
                {
                    if (((JSONObject) (obj9)).get("resend_initial").equals("true") || ((JSONObject) (obj9)).get("resend_initial").equals("detailed"))
                    {
                        if (Global.DEBUG)
                        {
                            Log.e("KochavaTracker", "resend_initial flag triggered.");
                        }
                        prefs = mContext.getSharedPreferences("initPrefs", 0);
                        prefs.edit().putString("initBool", "false").commit();
                    }
                }
                catch (Exception exception2) { }
_L40:
                obj8 = ((JSONObject) (obj7)).getJSONArray("blacklist");
                if (!Global.DEBUG) goto _L42; else goto _L41
_L41:
                obj9 = new StringBuilder("blacklist: ");
                if (obj8 instanceof JSONArray) goto _L44; else goto _L43
_L43:
                obj6 = ((JSONArray) (obj8)).toString();
_L61:
                Log.i("KochavaTracker", ((StringBuilder) (obj9)).append(((String) (obj6))).toString());
                  goto _L42
_L64:
                j = ((JSONArray) (obj8)).length();
                if (i < j) goto _L46; else goto _L45
_L45:
                obj6 = ((JSONObject) (obj7)).getString("error");
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", (new StringBuilder("There was a problem getting the KVinit response: ")).append(((String) (obj6))).toString());
                }
_L16:
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", "getKVinit thread ended, sending message to initHandler.");
                }
                obj6 = Message.obtain();
                obj7 = new Bundle();
                ((Bundle) (obj7)).putBoolean("sendonstart", sendOnStart);
                ((Message) (obj6)).setData(((Bundle) (obj7)));
                initHandler.sendMessage(((Message) (obj6)));
                return;
                obj8;
                obj7 = obj6;
                if (!Global.DEBUGERROR) goto _L48; else goto _L47
_L47:
                Log.e("KochavaTracker", (new StringBuilder("Error while parsing result json: ")).append(((JSONException) (obj8)).toString()).toString());
                obj7 = obj6;
                  goto _L48
                obj6;
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj6)));
                    return;
                }
                  goto _L11
                obj6;
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj6)));
                    return;
                }
                  goto _L11
_L20:
                obj6 = JSONObjectInstrumentation.toString((JSONObject)obj7);
                  goto _L49
                obj6;
                obj6 = obj8;
                if (!Global.DEBUG) goto _L51; else goto _L50
_L50:
                Log.e("KochavaTracker", "KVinit response did not contain attribution data (or it was not requested).");
                obj6 = obj8;
                  goto _L51
                obj6;
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj6)));
                    return;
                }
                  goto _L11
                obj6;
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj6)));
                    return;
                }
                  goto _L11
_L29:
                obj8 = JSONObjectInstrumentation.toString((JSONObject)obj6);
                  goto _L52
_L31:
                obj8 = JSONObjectInstrumentation.toString((JSONObject)obj6);
                  goto _L53
_L34:
                obj6 = JSONObjectInstrumentation.toString((JSONObject)obj6);
                  goto _L54
_L38:
                obj6 = obj8;
                obj9 = JSONObjectInstrumentation.toString((JSONObject)obj8);
                  goto _L55
                obj8;
                obj9 = obj6;
                if (!Global.DEBUG) goto _L36; else goto _L56
_L56:
                Log.e("KochavaTracker", "KVinit response did not contain flags.");
                obj9 = obj6;
                  goto _L36
                obj6;
                if (Global.DEBUGERROR)
                {
                    Log.e("KochavaTracker", "Unexpected error during KVinit communication.", ((Throwable) (obj6)));
                }
                  goto _L16
                obj6;
                if (!Global.DEBUG) goto _L58; else goto _L57
_L57:
                Log.e("KochavaTracker", "KVinit response did not contain a kochava_app_id.");
                  goto _L58
                obj6;
                if (!Global.DEBUG) goto _L60; else goto _L59
_L59:
                Log.e("KochavaTracker", "KVinit response did not contain flags.");
                  goto _L60
_L44:
                obj6 = JSONArrayInstrumentation.toString((JSONArray)obj8);
                  goto _L61
_L46:
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("android_id"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: android_id");
                    }
                    Feature.paramRestrictions.put("android_id", Boolean.valueOf(false));
                    break MISSING_BLOCK_LABEL_1831;
                }
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("fb_attribution_id"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: fb_attribution_id");
                    }
                    Feature.paramRestrictions.put("fb_attribution_id", Boolean.valueOf(false));
                    break MISSING_BLOCK_LABEL_1831;
                }
                break MISSING_BLOCK_LABEL_1581;
                jsonexception;
                if (!Global.DEBUG) goto _L45; else goto _L62
_L62:
                Log.e("KochavaTracker", "KVinit response did not contain a blacklist.");
                  goto _L45
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("imei"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: imei");
                    }
                    Feature.paramRestrictions.put("imei", Boolean.valueOf(false));
                    break MISSING_BLOCK_LABEL_1831;
                }
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("mac"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: mac");
                    }
                    Feature.paramRestrictions.put("mac", Boolean.valueOf(false));
                    break MISSING_BLOCK_LABEL_1831;
                }
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("odin"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: odin");
                    }
                    Feature.paramRestrictions.put("odin", Boolean.valueOf(false));
                    break MISSING_BLOCK_LABEL_1831;
                }
                if (((JSONArray) (obj8)).get(i).toString().toLowerCase().equals("open_udid"))
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "disabling: open_udid");
                    }
                    Feature.paramRestrictions.put("open_udid", Boolean.valueOf(false));
                }
                break MISSING_BLOCK_LABEL_1831;
                jsonexception;
                if (!Global.DEBUG) goto _L16; else goto _L63
_L63:
                Log.e("KochavaTracker", "KVinit response did not contain an error.");
                  goto _L16
                Exception exception4;
                exception4;
                  goto _L24
_L11:
                return;
_L42:
                i = 0;
                  goto _L64
                i++;
                  goto _L64
            }

            
            {
                this$0 = Feature.this;
                sendOnStart = flag;
                super();
            }
        };
        worker.schedule(context, 5L, TimeUnit.SECONDS);
        return;
_L11:
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj3)).trim().length() == 0 || obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj4)).trim().length() != 0)
        {
            break MISSING_BLOCK_LABEL_1787;
        }
        if (!Global.DEBUGERROR) goto _L18; else goto _L20
_L20:
        Log.e("KochavaTracker", "Please make sure that you have passed both a partner id and a partner name.");
        return;
        hashmap;
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", (new StringBuilder("Error building KVinit json object: ")).append(hashmap.toString()).toString());
        }
          goto _L21
        kvinitdata.put("partner_id", obj3);
        kvinitdata.put("partner_name", obj4);
        if (prefs.getString("kochavaappdata", "").equals(""))
        {
            prefs.edit().putString("kochavaappdata", (new StringBuilder(String.valueOf(obj3))).append(((String) (obj4))).toString()).commit();
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_1927;
        }
        if (((String) (obj2)).trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_1927;
        }
        mAppId = ((String) (obj2));
        kvinitdataholder.put("kochava_app_id", obj2);
        kvinitorigdata.put("kochava_app_id", obj2);
          goto _L22
        mAppId = (new StringBuilder("_p:")).append(((String) (obj4))).append(":").append(((String) (obj3))).toString();
          goto _L22
        context;
        flag = true;
        context = (new StringBuilder(String.valueOf(""))).append("\n    BROADCAST RECEIVER REGISTRATION MISSING: com.android.kochava.tracker.ReferralCapture").toString();
          goto _L23
    }

    private String postEvent()
    {
        Object obj = kDbAdapter.generateDataString();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = "";
_L5:
        return ((String) (obj));
_L2:
        Object obj2;
        HttpPost httppost;
        boolean flag;
        long l;
        obj = new StringTokenizer(((String) (obj)), "=");
        l = Long.parseLong(((StringTokenizer) (obj)).nextToken());
        obj2 = ((StringTokenizer) (obj)).nextToken();
        obj = obj2;
        if (((String) (obj2)).startsWith("["))
        {
            obj = ((String) (obj2)).substring(1);
        }
        obj2 = obj;
        if (((String) (obj)).endsWith("]"))
        {
            obj2 = ((String) (obj)).substring(0, ((String) (obj)).length() - 1);
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Post The Data 3>>>>>>")).append(((String) (obj2))).toString());
        }
        flag = false;
        if (((String) (obj2)).contains("\"action\":\"initial\""))
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "Post Data: Event is initial, look at response");
            }
            flag = true;
        }
        obj = createHttpClient(false);
        HttpProtocolParams.setUserAgent(((HttpClient) (obj)).getParams(), mUserAgent);
        if (hostControl == null || hostControl.trim().isEmpty())
        {
            if (Global.DEBUG)
            {
                Log.i("KochavaTracker", "postEvent - hostControl was empty, using default");
            }
            hostControl = "control.kochava.com";
        }
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", (new StringBuilder("postEvent - posting to ")).append("https://").append(hostControl).append("/track/kvTracker.php").toString());
        }
        httppost = new HttpPost((new StringBuilder("https://")).append(hostControl).append("/track/kvTracker.php").toString());
        obj2 = new StringEntity((new StringBuilder("[")).append(((String) (obj2))).append("]").toString(), "UTF-8");
        BasicHeader basicheader = new BasicHeader("Content-Type", "application/xml");
        httppost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        ((StringEntity) (obj2)).setContentType(basicheader);
        httppost.setEntity(((HttpEntity) (obj2)));
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Trying to post an event.");
        }
        if (obj instanceof HttpClient)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        obj = ((HttpClient) (obj)).execute(httppost);
_L3:
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj == null)
        {
            return "";
        }
        break MISSING_BLOCK_LABEL_404;
        Object obj1;
        try
        {
            obj = HttpInstrumentation.execute((HttpClient)obj, httppost);
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "TrackTask", clientprotocolexception);
            }
            return "";
        }
        catch (IOException ioexception)
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "TrackTask", ioexception);
            }
            return "";
        }
          goto _L3
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Grabbing Result...");
        }
        obj2 = StringUtils.inputStreamToString(((HttpEntity) (obj)).getContent());
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Result: ")).append(((String) (obj2))).toString());
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_521;
        }
        obj = obj2;
        if (!((String) (obj2)).contains("\"success\":\"1\"")) goto _L5; else goto _L4
_L4:
        if (Global.DEBUG)
        {
            Log.i("KochavaTracker", "Got success response, cleaning database.");
        }
        kDbAdapter.cleanupEvents(l);
        return ((String) (obj2));
        obj1;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj1)));
        }
        return "";
        kDbAdapter.cleanupEvents(l);
        return ((String) (obj2));
        obj1;
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj1)));
        }
        return "";
    }

    private void queInitial(boolean flag)
    {
        if (!prefs.getString("initBool", "").equals("false") || initialPropertiesObject == null || initialObject == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Initial properties: ")).append(initialPropertiesObject).toString());
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Initital Oject: ")).append(initialObject).toString());
        }
        if (prefs.getString("initData", "noData").equals("noData")) goto _L2; else goto _L1
_L1:
        initialPropertiesObject.put("conversion_type", "gplay");
        initialPropertiesObject.put("conversion_data", prefs.getString("initData", ""));
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", (new StringBuilder("Got referral, attaching: ")).append(prefs.getString("initData", "")).toString());
        }
_L4:
        initialObject.put("data", initialPropertiesObject);
        kDbAdapter.addEvent(initialObject);
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Sending Initial");
        }
        prefs.edit().putString("initBool", "true").commit();
        if (flag)
        {
            try
            {
                initTimer.cancel();
                return;
            }
            catch (JSONException jsonexception)
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "An error occured during que initial.", jsonexception);
                }
                jsonexception.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_318;
_L2:
        if (!Global.DEBUG) goto _L4; else goto _L3
_L3:
        Log.e("KochavaTracker", "Did not get referral data.");
          goto _L4
    }

    public static void setAttributionHandler(Handler handler)
    {
        attributionDataHandler = handler;
    }

    private void setCurrency(String s)
    {
        if (s != null && Global.CURRENCYLIST.contains(s))
        {
            prefs = mContext.getSharedPreferences("initPrefs", 0);
            prefs.edit().putString("currency", s).commit();
        } else
        if (Global.DEBUGERROR)
        {
            Log.e("KochavaTracker", (new StringBuilder("Trying to set currency, but ")).append(s).append(" is not a valid currency.").toString());
            return;
        }
    }

    public static void setErrorDebug(boolean flag)
    {
        Global.DEBUGERROR = flag;
    }

    public static void setRequestAttributionData(boolean flag)
    {
        requestAttributionData = flag;
    }

    public void clearSuperProperties()
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
            return;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "clearSuperProperties");
        }
        mSuperProperties = null;
    }

    public void enableTestMode()
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
            return;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "enableTestMode");
        }
        mTestMode = true;
    }

    public void endSession()
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
        } else
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "Called End");
            }
            if (canSendSession)
            {
                eventSession("exit");
                return;
            }
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "Session events disabled by server.");
                return;
            }
        }
    }

    public void event(String s, String s1)
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
        } else
        {
            try
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Got event ")).append(s).toString());
                }
                HashMap hashmap = new HashMap();
                hashmap.put("event_name", s);
                hashmap.put("event_data", s1);
                fireEvent("event", hashmap);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", (new StringBuilder("Error in event call: ")).append(s).toString());
                return;
            }
        }
    }

    public void eventSpatial(String s, double d, double d1, double d2, 
            String s1)
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
        } else
        {
            try
            {
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("Got event ")).append(s).toString());
                }
                HashMap hashmap = new HashMap();
                hashmap.put("event_name", s);
                s = new DecimalFormat("#.##");
                hashmap.put("x", Double.valueOf(s.format(d)).toString());
                hashmap.put("y", Double.valueOf(s.format(d1)).toString());
                hashmap.put("z", Double.valueOf(s.format(d2)).toString());
                hashmap.put("event_data", s1);
                fireEvent("spatial", hashmap);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", (new StringBuilder("Error in event call: ")).append(s).toString());
                return;
            }
        }
    }

    public void flush()
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
            return;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "flush");
        }
        executor.submit(new TrackTask(null));
    }

    public String getAttributionData()
    {
        if (attributionDataPrefs != null)
        {
            return attributionDataPrefs.getString("attributionData", "");
        } else
        {
            return "";
        }
    }

    public void linkIdentity(Map map)
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
            return;
        }
        if (Global.DEBUG)
        {
            Log.e("KochavaTracker", "Mapping identity");
        }
        fireEvent("identityLink", map);
    }

    public void registerSuperProperties(Map map)
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
        } else
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "registerSuperProperties");
            }
            if (mSuperProperties == null)
            {
                mSuperProperties = map;
                return;
            }
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                mSuperProperties.put((String)entry.getKey(), (String)entry.getValue());
            }
        }
    }

    public void setAppLimitTracking(final boolean shouldLimit)
    {
        (new Thread() {

            final Feature this$0;
            private final boolean val$shouldLimit;

            public void run()
            {
                Object obj;
                Object obj1;
                obj1 = new JSONObject();
                ((JSONObject) (obj1)).put("action", "options");
                obj = new JSONObject();
                if (!shouldLimit) goto _L2; else goto _L1
_L1:
                ((JSONObject) (obj)).put("app_limit_tracking", "1");
_L18:
                ((JSONObject) (obj)).put("device_limit_tracking", "0");
                ((JSONObject) (obj1)).put("data", obj);
                ((JSONObject) (obj1)).put("kochava_app_id", mAppId);
                ((JSONObject) (obj1)).put("kochava_device_id", getDeviceId());
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", "kv_options thread started.");
                }
                if (!Global.DEBUG) goto _L4; else goto _L3
_L3:
                Object obj2 = new StringBuilder("kv_options post: ");
                if (obj1 instanceof JSONObject) goto _L6; else goto _L5
_L5:
                obj = ((JSONObject) (obj1)).toString();
_L14:
                Log.i("KochavaTracker", ((StringBuilder) (obj2)).append(((String) (obj))).toString());
_L4:
                HttpPost httppost;
                obj2 = createHttpClient(true);
                HttpProtocolParams.setUserAgent(((HttpClient) (obj2)).getParams(), mUserAgent);
                if (Feature.hostControl == null || Feature.hostControl.trim().isEmpty())
                {
                    if (Global.DEBUG)
                    {
                        Log.i("KochavaTracker", "setAppLimitTracking - hostControl was empty, using default");
                    }
                    Feature.hostControl = "control.kochava.com";
                }
                if (Global.DEBUG)
                {
                    Log.i("KochavaTracker", (new StringBuilder("setAppLimitTracking - posting to ")).append("https://").append(Feature.hostControl).append("/track/kv_options.php").toString());
                }
                httppost = new HttpPost((new StringBuilder("https://")).append(Feature.hostControl).append("/track/kv_options.php").toString());
                if (obj1 instanceof JSONObject) goto _L8; else goto _L7
_L7:
                obj = ((JSONObject) (obj1)).toString();
_L15:
                obj = new StringEntity(((String) (obj)), "UTF-8");
                obj1 = new BasicHeader("Content-Type", "application/xml");
                httppost.getParams().setBooleanParameter("http.protocol.expect-continue", false);
                ((StringEntity) (obj)).setContentType(((org.apache.http.Header) (obj1)));
                httppost.setEntity(((HttpEntity) (obj)));
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "Trying to post to kv_options.");
                }
                if (obj2 instanceof HttpClient) goto _L10; else goto _L9
_L9:
                obj = ((HttpClient) (obj2)).execute(httppost);
_L16:
                obj = ((HttpResponse) (obj)).getEntity();
                if (obj != null) goto _L12; else goto _L11
_L11:
                try
                {
                    if (Global.DEBUGERROR)
                    {
                        Log.e("KochavaTracker", "Could not get a response entity from kv_options.");
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (Global.DEBUG)
                    {
                        Log.e("KochavaTracker", "TrackTask", ((Throwable) (obj)));
                        return;
                    }
                }
                catch (IOException ioexception)
                {
                    if (Global.DEBUG)
                    {
                        Log.e("KochavaTracker", "TrackTask", ioexception);
                        return;
                    }
                }
                catch (Exception exception)
                {
                    if (Global.DEBUGERROR)
                    {
                        Log.e("KochavaTracker", "Unexpected error during kv_options communication.", exception);
                    }
                }
                  goto _L13
_L2:
                ((JSONObject) (obj)).put("app_limit_tracking", "0");
                continue; /* Loop/switch isn't completed */
_L6:
                obj = JSONObjectInstrumentation.toString((JSONObject)obj1);
                  goto _L14
_L8:
                obj = JSONObjectInstrumentation.toString((JSONObject)obj1);
                  goto _L15
_L10:
                obj = HttpInstrumentation.execute((HttpClient)obj2, httppost);
                  goto _L16
_L12:
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", "(kv_options) Grabbing Result...");
                }
                obj = StringUtils.inputStreamToString(((HttpEntity) (obj)).getContent());
                if (Global.DEBUG)
                {
                    Log.e("KochavaTracker", (new StringBuilder("(kv_options) Result: ")).append(((String) (obj))).toString());
                    return;
                }
_L13:
                return;
                if (true) goto _L18; else goto _L17
_L17:
            }

            
            {
                this$0 = Feature.this;
                shouldLimit = flag;
                super();
            }
        }).start();
    }

    public void setLatlong(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Trying to set lat/long, but one/both of the parameters where null.");
            }
            return;
        } else
        {
            prefs = mContext.getSharedPreferences("initPrefs", 0);
            prefs.edit().putString("mylat", s).commit();
            prefs.edit().putString("mylong", s1).commit();
            return;
        }
    }

    public void setVersion(String s)
    {
        mAppVersionName = s;
    }

    public void startSession()
    {
        if (badInit)
        {
            if (Global.DEBUGERROR)
            {
                Log.e("KochavaTracker", "Kochava library was not initialized properly (Unexpected parameters). Until it is, this method cannot be used.");
            }
        } else
        {
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "Called Start");
            }
            startTime = System.currentTimeMillis() / 1000L;
            if (canSendSession)
            {
                eventSession("launch");
                return;
            }
            if (Global.DEBUG)
            {
                Log.e("KochavaTracker", "Session events disabled by server.");
                return;
            }
        }
    }























































}
