// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import com.fotoable.ad.FotoAdStrategy;
import com.instabeauty.application.InstaBeautyApplication;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class ho
    implements aqm, com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener
{

    String a;
    String b;
    String c;
    String d;
    long e;
    hp f;
    private final Context g;
    private aql h;

    public ho(Context context, String s)
    {
        a = "http://fotorus.fotoable.com/fotorus/index.php?m=Advertise&a=GetAlertAds";
        c = "AlertAd";
        d = "alertTime";
        e = 0x124f80L;
        g = context;
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
        g.getSystemService("phone");
        String s2 = axv.a(((WifiManager)g.getSystemService("wifi")).getConnectionInfo().getMacAddress());
        String s4 = Locale.getDefault().getLanguage();
        String s3 = Locale.getDefault().getLanguage();
        String s5 = Locale.getDefault().getCountry();
        String s1 = Build.MODEL;
        String s = android.os.Build.VERSION.RELEASE;
        Object obj;
        Object obj1;
        try
        {
            obj = g.getPackageManager().getPackageInfo(g.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
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

    public void a(hp hp1)
    {
        f = hp1;
        if (!FotoAdStrategy.enableNewStrategy(InstaBeautyApplication.a().b().getApplicationContext())) goto _L2; else goto _L1
_L1:
        FotoAdStrategy.addListener(this);
_L4:
        return;
_L2:
        long l;
        try
        {
            hp1 = aqx.b(g, c, d);
        }
        // Misplaced declaration of an exception variable
        catch (hp hp1)
        {
            hp1.printStackTrace();
            return;
        }
        if (hp1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        l = Long.parseLong(hp1);
        if ((new Date()).getTime() - l < e) goto _L4; else goto _L3
_L3:
        hp1 = a();
        Log.i("alertUrl", hp1);
        Log.v("THttpAlertAdRequest", (new StringBuilder()).append("THttpAlertAdRequest url:").append(hp1).toString());
        h = new aql(hp1);
        h.a(this);
        h.execute(new String[0]);
        l = (new Date()).getTime();
        aqx.a(g, c, d, String.valueOf(l));
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
        String s1;
        int i;
        i = 0;
        s1 = null;
_L11:
        s = s1;
        if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
        s = hk.a(jsonarray.getJSONObject(i));
        if (s != null) goto _L6; else goto _L5
_L5:
        s1 = s;
          goto _L7
_L6:
        s1 = s;
        if (s.b() == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        s1 = s;
        if (aqx.b(g, c, s.b()) != null)
        {
            s1 = null;
        }
        s = s1;
        if (s1 == null) goto _L9; else goto _L8
_L8:
        s = s1;
        if (s1.c() == null) goto _L9; else goto _L10
_L10:
        s = s1;
        if (a(g, s1.c()))
        {
            s = null;
        }
          goto _L9
_L4:
        if (f != null && s != null)
        {
            try
            {
                aqx.a(g, c, s.b(), s.b());
                f.a(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
_L2:
        return;
_L7:
        i++;
          goto _L11
_L9:
        s1 = s;
        if (s == null) goto _L7; else goto _L4
    }

    public void onAdInReterund(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = new JSONObject(FotoAdStrategy.getMalertInfo());
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (((JSONObject) (obj)).isNull("data"))
        {
            return;
        }
        JSONArray jsonarray = ((JSONObject) (obj)).getJSONArray("data");
        Object obj1;
        int i;
        i = 0;
        obj1 = null;
_L13:
        obj = obj1;
        if (i >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        obj1 = hk.a(jsonarray.getJSONObject(i));
        if (obj1 != null) goto _L7; else goto _L6
_L7:
        if (!aqx.e(g, c, (new StringBuilder()).append("").append(((hk) (obj1)).a()).toString())) goto _L9; else goto _L8
_L8:
        obj1 = null;
          goto _L6
_L9:
        obj = obj1;
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        obj = obj1;
        if (((hk) (obj1)).c() == null) goto _L11; else goto _L12
_L12:
        obj = obj1;
        if (a(g, ((hk) (obj1)).c()))
        {
            obj = null;
        }
          goto _L11
_L5:
        if (f != null && obj != null)
        {
            try
            {
                aqx.b(g, c, (new StringBuilder()).append("").append(((hk) (obj)).a()).toString(), true);
                f.a(((hk) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
            }
        }
_L2:
        return;
_L6:
        i++;
          goto _L13
_L11:
        obj1 = obj;
        if (obj == null) goto _L6; else goto _L5
    }
}
