// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdStrategy;
import com.pipcamera.application.PIPCameraApplication;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ej
    implements com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener, ku
{

    String a;
    String b;
    String c;
    String d;
    String e;
    long f;
    ek g;
    private Context h;
    private kt i;

    public ej(Context context, String s)
    {
        a = "http://fotorus.fotoable.com/fotorus/index.php?m=Advertise&a=GetAlertAds";
        c = "AlertAd";
        d = "alertTime";
        e = "lastRequestTime";
        f = 0x927c0L;
        h = context;
        b = s;
    }

    public static boolean a(Context context, String s)
    {
        if (s != null)
        {
            try
            {
                context = context.getPackageManager().getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
                Crashlytics.logException(context);
                context = null;
            }
            if (context != null)
            {
                return true;
            }
        }
        return false;
    }

    public String a()
    {
        Object obj = (TelephonyManager)h.getSystemService("phone");
        String s2 = pa.a(((WifiManager)h.getSystemService("wifi")).getConnectionInfo().getMacAddress());
        String s4 = Locale.getDefault().getLanguage();
        String s3 = Locale.getDefault().getLanguage();
        String s5 = Locale.getDefault().getCountry();
        String s1 = Build.MODEL;
        String s = android.os.Build.VERSION.RELEASE;
        Object obj1;
        try
        {
            obj = h.getPackageManager().getPackageInfo(h.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            obj = null;
        }
        if (obj != null)
        {
            obj = ((PackageInfo) (obj)).versionName;
        } else
        {
            obj = null;
        }
        obj1 = a;
        obj1 = (new StringBuilder()).append(((String) (obj1))).append("&appid=").append(b).toString();
        obj1 = (new StringBuilder()).append(((String) (obj1))).append("&os=android").toString();
        if (obj != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj1))).append("&ver=").append(URLEncoder.encode(((String) (obj)), "utf-8")).toString();
        }
        obj = obj1;
        if (s5 != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&countrycode=").append(URLEncoder.encode(s5, "utf-8")).toString();
        }
        obj1 = obj;
        if (s4 != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&langcode=").append(URLEncoder.encode(s4, "utf-8")).toString();
        }
        obj = obj1;
        if (s3 != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&prelang=").append(URLEncoder.encode(s3, "utf-8")).toString();
        }
        obj1 = obj;
        if (s2 != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&openuuid=").append(URLEncoder.encode(s2, "utf-8")).toString();
        }
        obj = obj1;
        if (s1 != null)
        {
            obj = (new StringBuilder()).append(((String) (obj1))).append("&devicetype=").append(URLEncoder.encode(s1, "utf-8")).toString();
        }
        obj1 = obj;
        if (s != null)
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("&deviceVersion=").append(URLEncoder.encode(s, "utf-8")).toString();
        }
        return ((String) (obj1));
    }

    public void a(ek ek1)
    {
        g = ek1;
        if (!FotoAdStrategy.enableNewStrategy(PIPCameraApplication.a.getApplicationContext())) goto _L2; else goto _L1
_L1:
        FotoAdStrategy.addListener(this);
_L4:
        return;
_L2:
        long l;
        try
        {
            ek1 = la.a(h, c, d);
        }
        // Misplaced declaration of an exception variable
        catch (ek ek1)
        {
            ek1.printStackTrace();
            Crashlytics.logException(ek1);
            return;
        }
        if (ek1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        l = Long.parseLong(ek1);
        if ((new Date()).getTime() - l < f) goto _L4; else goto _L3
_L3:
        ek1 = a();
        Log.i("alertUrl", (new StringBuilder()).append("alertUrl : ").append(ek1).toString());
        i = new kt(ek1);
        Log.v("ad request", (new StringBuilder()).append("ad request :").append(ek1).toString());
        i.a(this);
        i.execute(new String[0]);
        l = (new Date()).getTime();
        la.a(h, c, d, String.valueOf(l));
        return;
    }

    public void a(Exception exception)
    {
        exception.printStackTrace();
    }

    public void a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.equals("false"))
        {
            return;
        }
        JSONArray jsonarray = new JSONArray(s);
        int j;
        j = 0;
        s = null;
_L15:
        if (j >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        eh eh1 = eh.a(jsonarray.getJSONObject(j));
        if (eh1 != null) goto _L6; else goto _L5
_L5:
        s = eh1;
          goto _L7
_L6:
        if (!la.c(h, c, (new StringBuilder()).append("").append(eh1.a()).toString())) goto _L9; else goto _L8
_L8:
        s = null;
          goto _L7
_L9:
        long l = la.b(h, c, e);
        if ((new Date()).getTime() - l >= eh1.b()) goto _L11; else goto _L10
_L10:
        s = null;
          goto _L7
_L11:
        if (eh1 == null) goto _L13; else goto _L12
_L12:
        if (eh1.c() == null || !a(h, eh1.c())) goto _L13; else goto _L14
_L14:
        s = null;
          goto _L7
_L4:
        if (g != null && s != null)
        {
            try
            {
                la.a(h, c, e, (new Date()).getTime());
                la.a(h, c, (new StringBuilder()).append("").append(s.a()).toString(), true);
                g.a(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
            Crashlytics.logException(s);
        }
_L2:
        return;
_L7:
        j++;
          goto _L15
_L13:
        s = eh1;
        if (eh1 == null) goto _L7; else goto _L16
_L16:
        s = eh1;
          goto _L4
    }

    public void onAdInReterund(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = new JSONObject(FotoAdStrategy.getMalertInfo());
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((JSONObject) (obj)).isNull("data"))
        {
            return;
        }
        JSONArray jsonarray = ((JSONObject) (obj)).getJSONArray("data");
        int j;
        j = 0;
        obj = null;
_L17:
        if (j >= jsonarray.length()) goto _L6; else goto _L5
_L5:
        eh eh1 = eh.a(jsonarray.getJSONObject(j));
        if (eh1 != null) goto _L8; else goto _L7
_L7:
        obj = eh1;
          goto _L9
_L8:
        if (!la.c(h, c, (new StringBuilder()).append("").append(eh1.a()).toString())) goto _L11; else goto _L10
_L10:
        obj = null;
          goto _L9
_L11:
        long l = la.b(h, c, e);
        if ((new Date()).getTime() - l >= eh1.b()) goto _L13; else goto _L12
_L12:
        obj = null;
          goto _L9
_L13:
        if (eh1 == null) goto _L15; else goto _L14
_L14:
        if (eh1.c() == null || !a(h, eh1.c())) goto _L15; else goto _L16
_L16:
        obj = null;
          goto _L9
_L6:
        if (g != null && obj != null)
        {
            try
            {
                la.a(h, c, e, (new Date()).getTime());
                la.a(h, c, (new StringBuilder()).append("").append(((eh) (obj)).a()).toString(), true);
                g.a(((eh) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((JSONException) (obj)).printStackTrace();
            }
            Crashlytics.logException(((Throwable) (obj)));
            return;
        }
          goto _L4
_L2:
        FlurryAgent.logEvent("");
_L4:
        return;
_L9:
        j++;
          goto _L17
_L15:
        obj = eh1;
        if (eh1 == null) goto _L9; else goto _L18
_L18:
        obj = eh1;
          goto _L6
    }
}
