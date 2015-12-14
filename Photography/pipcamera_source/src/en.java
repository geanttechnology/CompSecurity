// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.DialogInterface;
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

public class en
{

    private static en a;
    private Context b;
    private String c;
    private List d;
    private eq e;
    private el f;
    private WeakReference g;
    private com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener h;

    private en(Context context)
    {
        b = null;
        c = null;
        d = new ArrayList();
        e = null;
        f = null;
        g = null;
        h = new com.fotoable.ad.FotoAdStrategy.FotoAdStrategyListener() {

            final en a;

            public void onAdInReterund(boolean flag)
            {
                if (flag)
                {
                    String s1 = FotoAdStrategy.getMadFotoAlertInfo();
                    String s = s1;
                    if (s1 == null)
                    {
                        s = "";
                    }
                    a.a(s);
                    en.a(a, s);
                }
            }

            
            {
                a = en.this;
                super();
            }
        };
        c(context);
        FotoAdStrategy.addListener(h);
    }

    static Context a(en en1, Context context)
    {
        en1.b = context;
        return context;
    }

    static el a(en en1, el el1)
    {
        en1.f = el1;
        return el1;
    }

    static eq a(en en1, eq eq)
    {
        en1.e = eq;
        return eq;
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
            a = new en(context);
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
            f = (new em(context)).a(c).a(fotoalert).a(0, new android.content.DialogInterface.OnClickListener(s, fotoalert, s1) {

                final String a;
                final FotoAlert b;
                final String c;
                final en d;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (a.startsWith("market://"))
                    {
                        es.a(en.c(d), a);
                    } else
                    if (en.d(d) != null)
                    {
                        dialoginterface = new HashMap();
                        dialoginterface.put("alertId", (new StringBuilder()).append("alert_").append(b.a).toString());
                        FlurryAgent.logEvent("FotoAlertClicked", dialoginterface);
                        dialoginterface = (eo)en.d(d).get();
                        if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertUpdate)
                        {
                            dialoginterface.a(a);
                        } else
                        if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertApp)
                        {
                            dialoginterface.a(a);
                        } else
                        if (b.h == com.fotoable.alertad.FotoAlert.FotoAlertType.FotoAlertFun)
                        {
                            dialoginterface.b(c);
                        } else
                        {
                            Log.i("FotoAlertFactory", "unknow alert type");
                        }
                    } else
                    {
                        Log.i("fotoAlertFactory", "fotoAlertShowLisener is null!");
                    }
                    en.b(d).dismiss();
                    en.a(d, null);
                }

            
            {
                d = en.this;
                a = s;
                b = fotoalert;
                c = s1;
                super();
            }
            }).b(0, new android.content.DialogInterface.OnClickListener() {

                final en a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    en.b(a).dismiss();
                    en.a(a, null);
                }

            
            {
                a = en.this;
                super();
            }
            }).a();
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

    public static void a(Context context, String s, eo eo)
    {
        if (a != null && s != null && s.length() > 0)
        {
            FotoAlert fotoalert = a.c(s);
            a.g = new WeakReference(eo);
            if (fotoalert != null)
            {
                Log.i("FotoAlertFactory", (new StringBuilder()).append("show alert id ").append(fotoalert.a).toString());
                eo = new HashMap();
                eo.put("alertId", (new StringBuilder()).append("alert_").append(fotoalert.a).toString());
                FlurryAgent.logEvent("FotoAlertShowed", eo);
                fotoalert.b(fotoalert.a);
                a.f(s);
                a.d(s);
                a.a(context, fotoalert);
                return;
            }
        }
    }

    static void a(en en1)
    {
        en1.b();
    }

    static void a(en en1, String s)
    {
        en1.b(s);
    }

    static el b(en en1)
    {
        return en1.f;
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
        er er1;
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
        er1 = er.a(kv.a(s, i), b);
        if (er1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        d.add(er1);
        break MISSING_BLOCK_LABEL_89;
        c();
        return;
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Context c(en en1)
    {
        return en1.b;
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
            er er1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                er1 = (er)iterator.next();
            } while (!er1.a.equalsIgnoreCase(s) || er1.b >= e(s));
            return er1.a(c);
        }
        return null;
    }

    private void c()
    {
        if (d.size() > 0 && c != null)
        {
            for (Iterator iterator = d.iterator(); iterator.hasNext(); ((er)iterator.next()).b(c)) { }
        }
    }

    private void c(Context context)
    {
        (new Thread(new Runnable(context) {

            final Context a;
            final en b;

            public void run()
            {
                en.a(b, a);
                en.a(b, eq.a(a));
                en.a(b);
                String s = b.a();
                en.a(b, s);
            }

            
            {
                b = en.this;
                a = context;
                super();
            }
        })).start();
    }

    static WeakReference d(en en1)
    {
        return en1.g;
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
                er er1 = (er)iterator.next();
                if (er1.a.equalsIgnoreCase(s))
                {
                    er1.b(c);
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
