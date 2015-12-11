// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import io.presage.ads.d;
import io.presage.int.g;
import io.presage.int.i;
import io.presage.services.PresageServiceImp;
import io.presage.utils.IADHandler;
import io.presage.utils.do.a;
import io.presage.utils.do.b;
import io.presage.utils.e;
import io.presage.utils.f;
import io.presage.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage:
//            b, c, d, e, 
//            a, g

public class Presage
{

    private static Presage b = null;
    Handler a;
    private f c;
    private Application d;
    private io.presage.new.a e;
    private String f;
    private ArrayList g;
    private String h;
    private String i;
    private CopyOnWriteArrayList j;
    private boolean k;
    private final Runnable l = new io.presage.b(this);
    private IADHandler m;
    private Context n;
    private io.presage.services.d o;
    private a p;

    private Presage()
    {
        k = false;
        g = new ArrayList();
        j = new CopyOnWriteArrayList();
        a = new Handler();
    }

    private void callPostitial()
    {
        if (!k)
        {
            return;
        } else
        {
            k = false;
            a.removeCallbacks(l);
            WindowManager windowmanager = (WindowManager)getContext().getSystemService("window");
            FrameLayout framelayout = new FrameLayout(getContext());
            framelayout.setBackgroundColor(0xff000000);
            android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
            layoutparams.width = -1;
            layoutparams.height = -1;
            layoutparams.x = 0;
            layoutparams.y = 0;
            layoutparams.gravity = 51;
            layoutparams.type = 2002;
            layoutparams.format = -3;
            layoutparams.flags = 288;
            windowmanager.addView(framelayout, layoutparams);
            (new Handler(Looper.getMainLooper())).postDelayed(new c(this, framelayout, windowmanager), 5000L);
            adToServe("postitial", new io.presage.d(this, framelayout, windowmanager));
            return;
        }
    }

    public static Presage getInstance()
    {
        if (b == null)
        {
            b = new Presage();
            io.presage.utils.e.b(new String[] {
                "Create instance"
            });
        }
        return b;
    }

    private void getMetas()
    {
        c = new f(getContext().getPackageManager(), getContext().getPackageName());
        c.b();
        Object obj;
        obj = getContext().getPackageManager().getApplicationInfo(getContext().getPackageName(), 128).metaData;
        i = ((Bundle) (obj)).getString("presage_env");
        obj = ((Bundle) (obj)).get("presage_key").toString();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (!((String) (obj)).equals("API_KEY_HERE"))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        throw new IllegalStateException("You must define 'presage_key' in your application meta-data !");
        try
        {
            setKey(((String) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            io.presage.utils.e.d(new String[] {
                "Failed to load meta-data, NameNotFound: ", ((android.content.pm.PackageManager.NameNotFoundException) (obj)).getMessage()
            });
            return;
        }
        catch (NullPointerException nullpointerexception)
        {
            io.presage.utils.e.d(new String[] {
                "Failed to load meta-data, NullPointer: ", nullpointerexception.getMessage()
            });
        }
        return;
    }

    public void adToServe(String s, IADHandler iadhandler)
    {
        adToServe(s, ((Map) (new HashMap())), iadhandler);
    }

    public void adToServe(String s, Map map, IADHandler iadhandler)
    {
        m = iadhandler;
        map.put("type", s);
        if ("postitial".equals(s))
        {
            s = io.presage.utils.do.a.a.b;
        } else
        if ("interstitial".equals(s))
        {
            s = io.presage.utils.do.a.a.a;
        } else
        {
            s = null;
        }
        getWS().a("ad_to_serve", map, new io.presage.e(this), s);
    }

    public String getApiUrl(String s)
    {
        if (getEnv().equals("development"))
        {
            return io.presage.utils.m.a("http://wsback-%s.ogury.local/v1/%s", s);
        }
        if (getEnv().equals("staging"))
        {
            return io.presage.utils.m.a("http://wsback-%s.staging.presage.io/v1/%s", s);
        }
        if (getEnv().equals("production"))
        {
            return io.presage.utils.m.a("http://wsback-%s.presage.io/v1/%s", s);
        } else
        {
            return io.presage.utils.m.a("http://wsback-%s.presage.io/v1/%s", s);
        }
    }

    public ArrayList getAppsPublishers()
    {
        return g;
    }

    public Context getContext()
    {
        return n;
    }

    public String getEnv()
    {
        if (i == null)
        {
            i = "production";
        }
        return i;
    }

    public String getId()
    {
        if (h == null)
        {
            Object obj = getContext().getSharedPreferences("presage", 0);
            h = ((SharedPreferences) (obj)).getString("id", null);
            obj = ((SharedPreferences) (obj)).getString("filters", null);
            if (obj != null)
            {
                io.presage.int.i.a();
                g g1 = io.presage.int.i.a("filters", "filters");
                g1.a((Map)(new Gson()).fromJson(((String) (obj)), java/util/Map));
                g1.a(new io.presage.a(this));
            }
        }
        return h;
    }

    public String getKey()
    {
        return f;
    }

    public f getPackageHelper()
    {
        return c;
    }

    public io.presage.services.d getService()
    {
        return o;
    }

    public a getWS()
    {
        if (p == null)
        {
            p = new b();
        }
        return p;
    }

    public boolean isApplicationSet()
    {
        return d != null;
    }

    public boolean isPredictPostitial()
    {
        return k;
    }

    public void launch()
    {
        launch(((Map) (new HashMap())), null);
    }

    public void launch(Map map, io.presage.utils.do.do.b b1)
    {
        getWS().a("launch", map, b1);
    }

    public void launchWithEula()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "eula");
        launch(hashmap, null);
    }

    public void notifyAds(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = j.iterator(); iterator.hasNext(); ((d)iterator.next()).a(s, s1)) { }
        break MISSING_BLOCK_LABEL_43;
        s;
        throw s;
        this;
        JVM INSTR monitorexit ;
    }

    public void pause()
    {
        if (getService() != null)
        {
            getService().c();
        }
    }

    public void pushAd(d d1)
    {
        j.add(d1);
    }

    public void removeAd(d d1)
    {
        j.remove(d1);
    }

    public void restart()
    {
        if (getService() != null)
        {
            getService().b();
            return;
        } else
        {
            start();
            return;
        }
    }

    public void runOnUiThread(Runnable runnable)
    {
        a.post(runnable);
    }

    public void setApplication(Application application)
    {
        if (getContext() == null)
        {
            setContext(application.getBaseContext());
        }
        d = application;
        if (android.os.Build.VERSION.SDK_INT >= 14 && d != null && e == null && c.a(8))
        {
            e = new io.presage.new.do.b(d, new io.presage.g(this));
            e.a();
        }
    }

    public void setContext(Context context)
    {
        n = context.getApplicationContext();
        getMetas();
    }

    public void setEnv(String s)
    {
        i = s;
    }

    public void setId(String s)
    {
        h = s;
        android.content.SharedPreferences.Editor editor = getContext().getSharedPreferences("presage", 0).edit();
        editor.putString("id", s);
        editor.commit();
    }

    public void setKey(String s)
    {
        f = s;
        if (g.size() <= 0)
        {
            g = new ArrayList();
            g.add(f);
        }
    }

    public void setPredictPostitial(boolean flag)
    {
        k = flag;
        a.removeCallbacks(l);
        if (k)
        {
            a.postDelayed(l, 0x1b7740L);
        }
    }

    public void setService(io.presage.services.d d1)
    {
        o = d1;
    }

    public void setWS(a a1)
    {
        p = a1;
    }

    public void start()
    {
        io.presage.utils.e.b(new String[] {
            "start"
        });
        if (!getWS().a())
        {
            io.presage.utils.e.d(new String[] {
                "Start stopped because your Android Version is too old (< 11) or you just got killed!"
            });
            return;
        }
        Object obj = new Intent();
        ((Intent) (obj)).setClass(getContext(), io/presage/services/PresageServiceImp);
        getContext().startService(((Intent) (obj)));
        if (getService() != null)
        {
            getService().b();
        }
        obj = new Intent("io.presage.receivers.BootReceiver.RESTART_SERVICE");
        obj = PendingIntent.getBroadcast(getContext(), 0, ((Intent) (obj)), 0);
        ((AlarmManager)getContext().getSystemService("alarm")).setRepeating(0, System.currentTimeMillis(), 0x927c0L, ((PendingIntent) (obj)));
        getContext().sendBroadcast((new Intent("android.intent.action.MAIN")).addCategory("android.intent.category.HOME"));
    }



/*
    static boolean access$002(Presage presage, boolean flag)
    {
        presage.k = flag;
        return flag;
    }

*/




}
