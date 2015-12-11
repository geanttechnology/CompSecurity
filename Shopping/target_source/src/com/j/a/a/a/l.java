// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import com.j.a.a.d;
import com.j.a.d.e;
import com.j.a.g.m;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

// Referenced classes of package com.j.a.a.a:
//            n, k, d, a, 
//            b, c, h

public class l
{

    private static l e;
    boolean a;
    boolean b;
    boolean c;
    Field d[];
    private ArrayList f;
    private PendingIntent g;
    private Method h;
    private Method i;
    private Class j;
    private Class k;

    public l()
    {
        f = new ArrayList();
        a = false;
        b = false;
        c = false;
        d = null;
    }

    static Class a(l l1, Class class1)
    {
        l1.k = class1;
        return class1;
    }

    static Method a(l l1)
    {
        return l1.h;
    }

    static Method a(l l1, Method method)
    {
        l1.i = method;
        return method;
    }

    public static l b()
    {
        if (e == null)
        {
            e = new l();
        }
        return e;
    }

    static Class b(l l1, Class class1)
    {
        l1.j = class1;
        return class1;
    }

    static Method b(l l1)
    {
        return l1.i;
    }

    static Method b(l l1, Method method)
    {
        l1.h = method;
        return method;
    }

    static Class c(l l1)
    {
        return l1.j;
    }

    static Class d(l l1)
    {
        return l1.k;
    }

    static void e(l l1)
    {
        l1.n();
    }

    private void n()
    {
        Thread thread = com.j.a.g.m.b("GAThread");
        if (thread == null) goto _L2; else goto _L1
_L1:
        Field afield[];
        int j1;
        afield = thread.getClass().getDeclaredFields();
        j1 = afield.length;
        int i1 = 0;
_L3:
        Field field;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        field = afield[i1];
        if (field.getType().equals(java/util/concurrent/LinkedBlockingQueue))
        {
            field.setAccessible(true);
            field.set(thread, new n());
        }
        i1++;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
        w.b("GA Thread", exception);
_L2:
    }

    public ArrayList a()
    {
        return f;
    }

    public void a(Map map)
    {
        if (com.j.a.d.e.e().j()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject(map);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            w.b(getClass().getCanonicalName(), map);
            return;
        }
        obj = null;
        if (map.containsKey("&t") && ((String)map.get("&t")).equals("screenview")) goto _L1; else goto _L3
_L3:
        if (map.containsKey("&ev"))
        {
            obj = map.get("&ev");
        }
        if (!map.containsKey("&ea"))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        map = (String)map.get("&ea");
_L4:
        com.j.a.d.e.e().n().a("googleAnalytics", map, obj, jsonobject);
        return;
        map = "";
          goto _L4
    }

    public Boolean c()
    {
        try
        {
            Class.forName("com.mixpanel.android.mpmetrics.MixpanelAPI");
        }
        catch (Exception exception)
        {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public Boolean d()
    {
        try
        {
            Class.forName("com.flurry.android.FlurryAgent");
        }
        catch (Exception exception)
        {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public Boolean e()
    {
        try
        {
            Class.forName("com.google.android.gms.analytics.a");
        }
        catch (Exception exception)
        {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public void f()
    {
        a = true;
    }

    public void g()
    {
        c = true;
    }

    public void h()
    {
        b = true;
    }

    public void i()
    {
        k k1 = new k(this, null);
        ArrayList aarraylist[] = new ArrayList[1];
        aarraylist[0] = f;
        if (!(k1 instanceof AsyncTask))
        {
            k1.execute(aarraylist);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)k1, aarraylist);
            return;
        }
    }

    public void j()
    {
        com.j.a.a.a.d d1 = new com.j.a.a.a.d(this, null);
        Void avoid[] = new Void[0];
        if (!(d1 instanceof AsyncTask))
        {
            d1.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)d1, avoid);
            return;
        }
    }

    public void k()
    {
        if (a && c().booleanValue())
        {
            f.add(com.j.a.a.a.a.a());
        }
        if (c && e().booleanValue())
        {
            try
            {
                (new Handler()).postDelayed(new b(this), 3000L);
            }
            catch (Exception exception)
            {
                w.b("ExtA GA issues", exception);
            }
        }
        if (b && d().booleanValue())
        {
            (new Handler()).postDelayed(new c(this), 1000L);
        }
        if (f.size() > 0 && a && c().booleanValue())
        {
            AlarmManager alarmmanager = (AlarmManager)com.j.a.d.e.e().o().getSystemService("alarm");
            h h1 = new h(this);
            com.j.a.d.e.e().o().registerReceiver(h1, new IntentFilter("com.taplytics"));
            g = PendingIntent.getBroadcast(com.j.a.d.e.e().o(), 109, new Intent("com.taplytics"), 0);
            alarmmanager.setRepeating(3, 35000L, 52000L, g);
        }
    }

    public void l()
    {
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        ((AlarmManager)com.j.a.d.e.e().o().getSystemService("alarm")).cancel(g);
        return;
        Exception exception;
        exception;
    }

    public void m()
    {
        j();
    }
}
