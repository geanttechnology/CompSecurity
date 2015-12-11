// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            m, v, r, KahunaCoreReceiver

public class w
{

    private static w a = new w();
    private Class b;

    private w()
    {
    }

    protected static void a(Context context)
    {
        a.b(context);
    }

    protected static void a(Context context, Intent intent)
    {
        intent = intent.getExtras();
        if (intent != null)
        {
            String s = intent.getString("KAHUNA_TRACKING_ID");
            if (s != null)
            {
                m.j().b(s);
            }
        }
        if (!m.j().o())
        {
            Intent intent1 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            intent1.setFlags(0x34000000);
            context.getApplicationContext().startActivity(intent1);
        }
        if (a.b != null)
        {
            Intent intent2 = new Intent(context, a.b);
            intent2.setAction("com.kahuna.sdk.push.clicked");
            intent = intent.getBundle("KAHUNA_LANDING_EXTRAS_ID");
            if (intent != null)
            {
                intent2.putExtra("landing_extras_id", intent);
            }
            context.sendBroadcast(intent2);
        }
    }

    protected static void a(Context context, Bundle bundle)
    {
        String s = null;
        if (bundle != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        obj = bundle.getString("alert");
        obj1 = bundle.getString("k");
        s = ((String) (obj1));
_L11:
        if (!bundle.containsKey("nid")) goto _L4; else goto _L3
_L3:
        obj1 = bundle.get("nid");
        if (!(obj1 instanceof String)) goto _L6; else goto _L5
_L5:
        int i = Integer.parseInt((String)obj1);
_L12:
        if (bundle.containsKey("k"))
        {
            bundle.remove("k");
        }
        if (bundle.containsKey("nid"))
        {
            bundle.remove("nid");
        }
        if (bundle.containsKey("collapse_key"))
        {
            bundle.remove("collapse_key");
        }
        if (bundle.containsKey("from"))
        {
            bundle.remove("from");
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Kahuna Message: ").append(((String) (obj))).toString());
        }
        if (obj == null || s == null) goto _L1; else goto _L7
_L7:
        if (!bundle.containsKey("k_internal")) goto _L9; else goto _L8
_L8:
        obj1 = bundle.getString("k_internal");
        String s1;
        if (v.a(((String) (obj1))))
        {
            break MISSING_BLOCK_LABEL_292;
        }
        obj1 = JSONObjectInstrumentation.init(((String) (obj1)));
        s1 = ((JSONObject) (obj1)).optString("gid");
        if (v.a(s1))
        {
            break MISSING_BLOCK_LABEL_292;
        }
        if (a.a(context, s1))
        {
            break MISSING_BLOCK_LABEL_499;
        }
        if (!m.a) goto _L1; else goto _L10
_L10:
        Log.w("Kahuna", (new StringBuilder()).append("Received another push with displayId: ").append(s1).append(" within the cooldown period. Ignoring push.").toString());
        return;
_L13:
        bundle.remove("k_internal");
_L9:
        if (a.b != null)
        {
            obj1 = new Intent(context, a.b);
            ((Intent) (obj1)).setAction("com.kahuna.sdk.push.received");
            ((Intent) (obj1)).putExtra("alert", ((String) (obj)));
            if (bundle != null)
            {
                ((Intent) (obj1)).putExtra("landing_extras_id", bundle);
            }
            context.sendBroadcast(((Intent) (obj1)));
        }
        try
        {
            if (m.j().p() && !m.q())
            {
                break MISSING_BLOCK_LABEL_525;
            }
            if (m.a)
            {
                Log.d("Kahuna", "Hiding Kahuna Push notification because user is generating notification separately.");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Kahuna", "KahunaSDK wasn't initialized in onAppCreate(), please initialized Kahuna correctly to prevent strange behavior");
            context.printStackTrace();
            return;
        }
          goto _L1
        obj;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception reading message from Push Notification Manager: ").append(obj).toString());
        }
        obj = null;
          goto _L11
_L6:
        try
        {
            i = ((Integer)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception reading push message notification id: ").append(obj1).toString());
            }
            i = -1;
        }
          goto _L12
_L4:
        i = -1;
          goto _L12
        try
        {
            long l = ((JSONObject) (obj1)).optLong("ex_offset", -1L);
            a.a(context, s1, l);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            if (m.a)
            {
                Log.e("Kahuna", (new StringBuilder()).append("Caught JSON Exception trying to parse Kahuna internal payload: ").append(obj1).toString());
            }
        }
          goto _L13
        a(context, ((String) (obj)), s, i, bundle);
        return;
          goto _L11
    }

    private void a(Context context, String s, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = System.currentTimeMillis() / 1000L;
        Map map;
        if (l > -1L)
        {
            l = l1 + l;
        } else
        {
            l = l1 + 43200L;
        }
        map = r.k(context);
        map.put(s, Long.valueOf(l));
        r.d(map, context);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Updated recevied push group id: ").append(s).append(" with expire time: ").append(l).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static void a(Context context, String s, String s1, int i, Bundle bundle)
    {
        Object obj;
        int j;
        boolean flag;
        flag = true;
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        try
        {
            obj = context.getString(applicationinfo.labelRes);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception trying to retrieve Application label:  ").append(obj).toString());
            }
            obj = "";
        }
        j = applicationinfo.icon;
        if (m.j().n() > 0)
        {
            j = m.j().n();
        }
        if (!"".equals(obj) && j != 0) goto _L2; else goto _L1
_L1:
        if (m.a)
        {
            Log.d("Kahuna", "Recieved push, but app has no icon or app name label, NOT showing notification");
        }
_L3:
        return;
_L2:
        Intent intent;
        Throwable throwable;
        long l;
        if (i == -1)
        {
            i = 1964;
        }
        l = System.currentTimeMillis();
        intent = new Intent(context, com/kahuna/sdk/KahunaCoreReceiver);
        intent.setAction("KAHUNA_PUSH_CLICKED");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        intent.putExtra("KAHUNA_TRACKING_ID", s1);
        intent.putExtra("KAHUNA_NID", i);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        intent.putExtra("KAHUNA_LANDING_EXTRAS_ID", bundle);
        s1 = PendingIntent.getBroadcast(context, 0, intent, 0x8000000);
        bundle = (NotificationManager)context.getSystemService("notification");
        android.support.v4.app.v.d d = (new android.support.v4.app.v.d(context)).a(j).a(((CharSequence) (obj))).b(s).b(5).c(s).a((new android.support.v4.app.v.c()).a(s));
        d.a(s1);
        d.a(true);
        bundle.notify(i, d.a());
_L4:
        if (!flag)
        {
            try
            {
                Notification notification = new Notification(j, s, l);
                notification.defaults = notification.defaults | 5;
                notification.setLatestEventInfo(context, ((CharSequence) (obj)), s, s1);
                notification.flags = notification.flags | 0x10;
                bundle.notify(i, notification);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Caught generic exception trying to build push notification:  ").append(context).toString());
                return;
            }
        }
          goto _L3
        throwable;
        Log.w("Kahuna", "You should add the support library to your application");
        flag = false;
          goto _L4
    }

    protected static void a(Class class1)
    {
        a.b = class1;
    }

    private boolean a(Context context, String s)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        l = System.currentTimeMillis() / 1000L;
        context = r.k(context);
        if (!context.containsKey(s)) goto _L2; else goto _L1
_L1:
        long l1 = ((Long)context.get(s)).longValue();
        if (l1 <= l) goto _L2; else goto _L3
_L3:
        boolean flag = false;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = true;
        if (true) goto _L5; else goto _L4
_L4:
        context;
        throw context;
    }

    private void b(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        long l = System.currentTimeMillis() / 1000L;
        Object obj = r.k(context);
        hashmap = new HashMap();
        obj = ((Map) (obj)).entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            if (((Long)entry.getValue()).longValue() > l)
            {
                hashmap.put(entry.getKey(), entry.getValue());
            }
        } while (true);
        break MISSING_BLOCK_LABEL_104;
        context;
        throw context;
        r.d(hashmap, context);
        this;
        JVM INSTR monitorexit ;
    }

}
