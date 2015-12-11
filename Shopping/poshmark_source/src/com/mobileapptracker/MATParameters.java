// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONArray;

// Referenced classes of package com.mobileapptracker:
//            d, MATEncryption

public class MATParameters
{

    private static MATParameters b = null;
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private Location X;
    private String Y;
    private String Z;
    private Context a;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private String aE;
    private String aF;
    private String aG;
    private String aH;
    private String aI;
    private String aJ;
    private String aK;
    private String aL;
    private String aM;
    private String aN;
    private String aO;
    private String aP;
    private String aQ;
    private String aR;
    private String aS;
    private String aT;
    private String aU;
    private String aV;
    private String aW;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private String ah;
    private String ai;
    private String aj;
    private String ak;
    private String al;
    private String am;
    private String an;
    private String ao;
    private String ap;
    private String aq;
    private String ar;
    private String as;
    private String at;
    private String au;
    private String av;
    private String aw;
    private String ax;
    private String ay;
    private JSONArray az;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public MATParameters()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = null;
        C = null;
        D = null;
        E = null;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = null;
        L = null;
        M = null;
        N = null;
        O = null;
        P = null;
        Q = null;
        R = null;
        S = null;
        T = null;
        U = null;
        V = null;
        W = null;
        X = null;
        Y = null;
        Z = null;
        aa = null;
        ab = null;
        ac = null;
        ad = null;
        ah = null;
        ai = null;
        aj = null;
        ak = null;
        al = null;
        am = null;
        an = null;
        ao = null;
        ap = null;
        aq = null;
        ar = null;
        as = null;
        at = null;
        au = null;
        av = null;
        az = null;
        aD = null;
        aE = null;
        aF = null;
        aG = null;
        aH = null;
        aI = null;
        aJ = null;
        aK = null;
        aL = null;
        aM = null;
        aN = null;
        aO = null;
        aP = null;
        aQ = null;
        aR = null;
        aS = null;
        aT = null;
        aU = null;
        aV = null;
        aW = null;
    }

    private String a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = a.getSharedPreferences("com.mobileapptracking", 0).getString(s1, "");
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    static void a(MATParameters matparameters, String s1)
    {
        matparameters.av = s1;
    }

    private void a(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        a.getSharedPreferences("com.mobileapptracking", 0).edit().putString(s1, s2).commit();
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private boolean a(Context context, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        PackageManager packagemanager;
        setAdvertiserId(s1.trim());
        setCurrencyCode("USD");
        (new Handler(Looper.getMainLooper())).post(new d(this, a));
        s1 = a.getPackageName();
        setPackageName(s1);
        packagemanager = a.getPackageManager();
        PackageInfo packageinfo;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        int i1;
        int j1;
        boolean flag;
        try
        {
            setAppName(packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(s1, 0)).toString());
            setInstallDate(Long.toString((new Date((new File(packagemanager.getApplicationInfo(s1, 0).sourceDir)).lastModified())).getTime() / 1000L));
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1) { }
        packageinfo = packagemanager.getPackageInfo(s1, 0);
        setAppVersion(Integer.toString(packageinfo.versionCode));
        setAppVersionName(packageinfo.versionName);
_L5:
        setInstaller(packagemanager.getInstallerPackageName(s1));
        setDeviceModel(Build.MODEL);
        setDeviceBrand(Build.MANUFACTURER);
        setDeviceCpuType(System.getProperty("os.arch"));
        setOsVersion(android.os.Build.VERSION.RELEASE);
        setScreenDensity(Float.toString(context.getResources().getDisplayMetrics().density));
        context = (WindowManager)context.getSystemService("window");
        if (android.os.Build.VERSION.SDK_INT < 13) goto _L2; else goto _L1
_L1:
        s1 = new Point();
        context.getDefaultDisplay().getSize(s1);
        j1 = ((Point) (s1)).x;
        i1 = ((Point) (s1)).y;
_L7:
        setScreenWidth(Integer.toString(j1));
        setScreenHeight(Integer.toString(i1));
        if (!((ConnectivityManager)a.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) goto _L4; else goto _L3
_L3:
        setConnectionType("WIFI");
_L8:
        setLanguage(Locale.getDefault().getDisplayLanguage(Locale.US));
        context = (TelephonyManager)a.getSystemService("phone");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        if (context.getNetworkCountryIso() != null)
        {
            setCountryCode(context.getNetworkCountryIso());
        }
        setDeviceCarrier(context.getNetworkOperatorName());
        s1 = context.getNetworkOperator();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        try
        {
            context = s1.substring(0, 3);
            s1 = s1.substring(3);
            setMCC(context);
            setMNC(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        context = getMatId();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_408;
        }
        if (context.length() != 0)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        setMatId(UUID.randomUUID().toString());
        flag = true;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
        namenotfoundexception;
        setAppVersion("0");
          goto _L5
_L9:
        Log.d("MobileAppTracker", "MobileAppTracker initialization failed");
        context.printStackTrace();
        flag = false;
          goto _L6
_L2:
        j1 = context.getDefaultDisplay().getWidth();
        i1 = context.getDefaultDisplay().getHeight();
          goto _L7
_L4:
        setConnectionType("mobile");
          goto _L8
        try
        {
            setCountryCode(Locale.getDefault().getCountry());
            break MISSING_BLOCK_LABEL_392;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            throw context;
        }
          goto _L9
    }

    public static MATParameters getInstance()
    {
        return b;
    }

    public static void init(Context context, String s1, String s2)
    {
        if (b == null)
        {
            s2 = new MATParameters();
            b = s2;
            s2.a = context;
            b.a(context, s1);
        }
    }

    public void clear()
    {
        b = null;
    }

    public String getAction()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = c;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = d;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubAd()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aK;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubAdgroup()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aJ;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubCampaign()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aI;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubKeyword()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aL;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubPublisher()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aG;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdvertiserSubSite()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aH;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAge()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = e;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAllowDuplicates()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = f;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAltitude()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = g;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAndroidId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = h;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAndroidIdMd5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = i;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAndroidIdSha1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = j;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAndroidIdSha256()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = k;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAppAdTrackingEnabled()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = l;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAppName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = m;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAppVersion()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = n;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAppVersionName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = o;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getConnectionType()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = p;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCountryCode()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = q;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCurrencyCode()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = r;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceBrand()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = s;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceCarrier()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = t;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceCpuSubtype()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = v;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceCpuType()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = u;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = w;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceModel()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = x;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventAttribute1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = y;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventAttribute2()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = z;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventAttribute3()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = A;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventAttribute4()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = B;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventAttribute5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = C;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventContentId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = D;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventContentType()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = E;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventDate1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = F;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventDate2()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = G;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = H;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventLevel()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = I;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = J;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventQuantity()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = K;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventRating()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = L;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getEventSearchString()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = M;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getExistingUser()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = N;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getFacebookUserId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = O;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getGender()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = P;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getGoogleAdTrackingLimited()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = R;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getGoogleAdvertisingId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = Q;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getGoogleUserId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = S;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getInstallDate()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = T;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getInstallReferrer()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_referrer");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getInstaller()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = U;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getIsPayingUser()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_is_paying_user");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLanguage()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = V;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLastOpenLogId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_log_id_last_open");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLatitude()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = W;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public Location getLocation()
    {
        this;
        JVM INSTR monitorenter ;
        Location location = X;
        this;
        JVM INSTR monitorexit ;
        return location;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLongitude()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = Y;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getMCC()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aa;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getMNC()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ab;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getMacAddress()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = Z;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getMatId()
    {
        this;
        JVM INSTR monitorenter ;
        if (!a.getSharedPreferences("mat_id", 0).contains("mat_id")) goto _L2; else goto _L1
_L1:
        String s1 = a.getSharedPreferences("mat_id", 0).getString("mat_id", "");
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = a("mat_id");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getOfferId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aD;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getOpenLogId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_log_id_open");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getOsVersion()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ac;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPackageName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ad;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPhoneNumber()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_phone_number");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPhoneNumberMd5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ae;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPhoneNumberSha1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = af;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPhoneNumberSha256()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ag;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPluginName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ah;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aE;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherReferenceId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aF;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSub1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aS;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSub2()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aT;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSub3()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aU;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSub4()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aV;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSub5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aW;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubAd()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aQ;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubAdgroup()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aP;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubCampaign()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aO;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubKeyword()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aR;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubPublisher()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aM;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSubSite()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aN;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPurchaseStatus()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ai;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getRefId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = am;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getReferralSource()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aj;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getReferralUrl()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ak;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getReferrerDelay()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = al;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getRevenue()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = an;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getScreenDensity()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ao;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getScreenHeight()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ap;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getScreenWidth()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aq;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSdkVersion()
    {
        this;
        JVM INSTR monitorenter ;
        return "3.8";
    }

    public String getSiteId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ar;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getTRUSTeId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = at;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getTrackingId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = as;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getTwitterUserId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = au;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserAgent()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = av;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserEmail()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_user_email");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserEmailMd5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aw;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserEmailSha1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ax;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserEmailSha256()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = ay;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public JSONArray getUserEmails()
    {
        this;
        JVM INSTR monitorenter ;
        JSONArray jsonarray = az;
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserId()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_user_id");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserName()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = a("mat_user_name");
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserNameMd5()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aA;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserNameSha1()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aB;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getUserNameSha256()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = aC;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAction(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        c = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        d = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubAd(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aK = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubAdgroup(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aJ = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubCampaign(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aI = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubKeyword(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aL = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubPublisher(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aG = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAdvertiserSubSite(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aH = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAge(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        e = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAllowDuplicates(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        f = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAltitude(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        g = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAndroidId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        h = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAndroidIdMd5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        i = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAndroidIdSha1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        j = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAndroidIdSha256(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        k = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAppAdTrackingEnabled(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        l = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAppName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        m = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAppVersion(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        n = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setAppVersionName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        o = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setConnectionType(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        p = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setCountryCode(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        q = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setCurrencyCode(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        r = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceBrand(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceCarrier(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        t = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceCpuSubtype(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        v = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceCpuType(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        u = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        w = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setDeviceModel(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        x = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventAttribute1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        y = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventAttribute2(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        z = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventAttribute3(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        A = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventAttribute4(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        B = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventAttribute5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        C = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventContentId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        D = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventContentType(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        E = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventDate1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        F = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventDate2(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        G = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        H = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventLevel(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        I = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        J = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventQuantity(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        K = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventRating(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        L = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setEventSearchString(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        M = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setExistingUser(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        N = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setFacebookUserId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        O = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setGender(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        P = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setGoogleAdTrackingLimited(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        R = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setGoogleAdvertisingId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Q = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setGoogleUserId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        S = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setInstallDate(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        T = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setInstallReferrer(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_referrer", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setInstaller(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        U = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setIsPayingUser(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_is_paying_user", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setLanguage(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        V = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setLastOpenLogId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_log_id_last_open", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setLatitude(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        W = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setLocation(Location location)
    {
        this;
        JVM INSTR monitorenter ;
        X = location;
        this;
        JVM INSTR monitorexit ;
        return;
        location;
        throw location;
    }

    public void setLongitude(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Y = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setMCC(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aa = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setMNC(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ab = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setMacAddress(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Z = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setMatId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_id", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setOfferId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aD = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setOpenLogId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_log_id_open", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setOsVersion(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ac = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPackageName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ad = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPhoneNumber(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_phone_number", s1);
        setPhoneNumberMd5(MATEncryption.md5(s1));
        setPhoneNumberSha1(MATEncryption.sha1(s1));
        setPhoneNumberSha256(MATEncryption.sha256(s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPhoneNumberMd5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ae = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPhoneNumberSha1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        af = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPhoneNumberSha256(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ag = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPluginName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ah = null;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aE = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherReferenceId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aF = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSub1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aS = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSub2(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aT = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSub3(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aU = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSub4(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aV = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSub5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aW = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubAd(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aQ = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubAdgroup(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aP = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubCampaign(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aO = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubKeyword(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aR = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubPublisher(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aM = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPublisherSubSite(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aN = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setPurchaseStatus(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ai = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setRefId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        am = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setReferralSource(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aj = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setReferralUrl(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ak = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setReferrerDelay(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        al = Long.toString(l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setRevenue(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        an = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setScreenDensity(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ao = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setScreenHeight(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ap = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setScreenWidth(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aq = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setSiteId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ar = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setTRUSTeId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        at = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setTrackingId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        as = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setTwitterUserId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        au = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserEmail(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_user_email", s1);
        setUserEmailMd5(MATEncryption.md5(s1));
        setUserEmailSha1(MATEncryption.sha1(s1));
        setUserEmailSha256(MATEncryption.sha256(s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserEmailMd5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aw = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserEmailSha1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ax = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserEmailSha256(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ay = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserEmails(String as1[])
    {
        this;
        JVM INSTR monitorenter ;
        az = new JSONArray();
        int i1 = 0;
_L2:
        if (i1 >= as1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        az.put(as1[i1]);
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        as1;
        throw as1;
    }

    public void setUserId(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_user_id", s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserName(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a("mat_user_name", s1);
        setUserNameMd5(MATEncryption.md5(s1));
        setUserNameSha1(MATEncryption.sha1(s1));
        setUserNameSha256(MATEncryption.sha256(s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserNameMd5(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aA = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserNameSha1(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aB = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void setUserNameSha256(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        aC = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

}
