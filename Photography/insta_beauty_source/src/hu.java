// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.alertad.FotoAlert;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class hu
{

    private static hu a;
    private Context b;
    private String c;
    private List d;
    private ib e;
    private hq f;
    private WeakReference g;
    private com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener h;

    private hu(Context context)
    {
        b = null;
        c = null;
        d = new ArrayList();
        e = null;
        f = null;
        g = null;
        h = new hy(this);
        c(context);
        FotoAdStrategy.addListener(h);
    }

    static Context a(hu hu1, Context context)
    {
        hu1.b = context;
        return context;
    }

    static hq a(hu hu1, hq hq1)
    {
        hu1.f = hq1;
        return hq1;
    }

    static ib a(hu hu1, ib ib)
    {
        hu1.e = ib;
        return ib;
    }

    private String a(Context context, String s)
    {
        Context context1;
        Object obj;
        context1 = null;
        obj = context.getApplicationContext();
        context = ((Context) (obj)).getExternalFilesDir(null);
        if (!context.exists())
        {
            context.mkdir();
        }
        context = context.getAbsolutePath();
_L2:
        context1 = context;
        if (context != null)
        {
            context = (new StringBuilder()).append(context).append("/").append(s).toString();
            s = new File(context);
            context1 = context;
            if (!s.exists())
            {
                s.mkdirs();
                context1 = context;
            }
        }
        return context1;
        context;
        obj = ((Context) (obj)).getCacheDir();
        context = context1;
        if (obj != null)
        {
            context = ((File) (obj)).getAbsolutePath();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(Context context)
    {
        if (a == null)
        {
            a = new hu(context);
        }
    }

    private void a(Context context, FotoAlert fotoalert)
    {
        if (f != null)
        {
            f.dismiss();
            f = null;
        }
        String s = fotoalert.d;
        String s1 = fotoalert.g;
        if (f == null)
        {
            f = (new hr(context)).a(c).a(fotoalert).a(0, new hx(this, s, fotoalert, s1)).b(0, new hw(this)).a();
        }
        if (f == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        f.show();
        return;
        context;
        Log.i("FotoAlertFactory", "Activity exist before fotoalertDialog show!");
        return;
    }

    public static void a(Context context, String s, hz hz)
    {
        if (a != null && s != null && s.length() > 0)
        {
            FotoAlert fotoalert = a.c(s);
            a.g = new WeakReference(hz);
            if (fotoalert != null)
            {
                Log.i("FotoAlertFactory", (new StringBuilder()).append("show alert id ").append(fotoalert.a).toString());
                hz = new HashMap();
                hz.put("alertId", (new StringBuilder()).append("alert_").append(fotoalert.a).toString());
                FlurryAgent.logEvent("FotoAlertShowed", hz);
                fotoalert.b(fotoalert.a);
                a.f(s);
                a.d(s);
                a.a(context, fotoalert);
                return;
            }
        }
    }

    static void a(hu hu1)
    {
        hu1.b();
    }

    static void a(hu hu1, String s)
    {
        hu1.b(s);
    }

    static hq b(hu hu1)
    {
        return hu1.f;
    }

    private void b()
    {
        c = a(b, "fotoalert");
    }

    public static void b(Context context)
    {
        while (a == null || a.g == null) 
        {
            return;
        }
        a.g.clear();
        a.g = null;
    }

    private void b(String s)
    {
        d.clear();
        if (s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ic ic1;
        int i;
        try
        {
            s = new JSONArray(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (s == null) goto _L1; else goto _L3
_L3:
        if (s.length() <= 0) goto _L1; else goto _L4
_L4:
        i = 0;
_L6:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        ic1 = ic.a(aqn.a(s, i), b);
        if (ic1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        d.add(ic1);
        break MISSING_BLOCK_LABEL_89;
        c();
        return;
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Context c(hu hu1)
    {
        return hu1.b;
    }

    private FotoAlert c(String s)
    {
label0:
        {
            if (d.size() <= 0 || c == null)
            {
                break label0;
            }
            Iterator iterator = d.iterator();
            ic ic1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                ic1 = (ic)iterator.next();
            } while (!ic1.a.equalsIgnoreCase(s) || ic1.b >= e(s));
            return ic1.a(c);
        }
        return null;
    }

    private void c()
    {
        if (d.size() > 0 && c != null)
        {
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((ic)iterator.next()).b(c)) { }
        }
    }

    private void c(Context context)
    {
        (new Thread(new hv(this, context))).start();
    }

    static WeakReference d(hu hu1)
    {
        return hu1.g;
    }

    private void d(String s)
    {
        if (d.size() > 0 && c != null)
        {
            Iterator iterator = d.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ic ic1 = (ic)iterator.next();
                if (ic1.a.equalsIgnoreCase(s))
                {
                    ic1.b(c);
                }
            } while (true);
        }
    }

    private long e(String s)
    {
        s = (new StringBuilder()).append("FotoAlertShow_Position_").append(s).toString();
        long l = b.getSharedPreferences("FotoAlertFactoryPreference", 0).getLong(s, 0L);
        return (long)((double)((new Date()).getTime() - l) * 0.001D);
    }

    private void f(String s)
    {
        s = (new StringBuilder()).append("FotoAlertShow_Position_").append(s).toString();
        b.getSharedPreferences("FotoAlertFactoryPreference", 0).edit().putLong(s, (new Date()).getTime()).apply();
    }

    public String a()
    {
        return b.getSharedPreferences("FotoAlertFactoryPreference", 0).getString("alertResultCache", "");
    }

    public void a(String s)
    {
        Log.i("FotoAlertFactory", "saveAlertResult");
        b.getSharedPreferences("FotoAlertFactoryPreference", 0).edit().putString("alertResultCache", s).apply();
    }
}
