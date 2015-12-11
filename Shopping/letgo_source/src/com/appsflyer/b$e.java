// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.je;
import android.support.v7.jf;
import android.util.Log;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.appsflyer:
//            b, c, h

private static class ntext
    implements Runnable
{

    Map a;
    boolean b;
    private String c;
    private WeakReference d;

    public void run()
    {
        String s1 = com.appsflyer.b.a(a);
        Object obj = (Context)d.get();
        if (obj == null) goto _L2; else goto _L1
_L1:
        String s = com.appsflyer.c.a().a(((Context) (obj)));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (s.length() > 0 && a.get("referrer") == null)
        {
            a.put("referrer", s);
        }
        Map map;
        boolean flag1;
        flag1 = "true".equals(((Context) (obj)).getSharedPreferences("appsflyer-data", 0).getString("sentSuccessfully", ""));
        s = (String)a.get("eventName");
        map = a;
        Object obj1;
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.put("counter", Integer.toString(com.appsflyer.b.a(((Context) (obj)), flag)));
        map = a;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.put("iaecounter", Integer.toString(com.appsflyer.b.b(((Context) (obj)), flag)));
        a.put("timepassedsincelastlaunch", Long.toString(com.appsflyer.b.e(((Context) (obj)))));
        flag = flag1;
_L5:
        obj = a;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Map) (obj)).put("isFirstCall", Boolean.toString(flag));
        s = (String)a.get("appsflyerKey");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        Log.d(s1, "Not sending data yet, waiting for dev key");
        return;
        obj = (new h()).a(a);
        a.put("af_v", obj);
        obj = com.appsflyer.b.b(a);
        try
        {
            com.appsflyer.b.a(c, ((String) (obj)), s, d, null, s1, b);
            return;
        }
        catch (IOException ioexception)
        {
            s = ((String) (obj));
            obj1 = ioexception;
        }
_L3:
        if (s != null && d != null && !c.contains("&isCachedRequest=true"))
        {
            Log.e(s1, ((IOException) (obj1)).getMessage(), ((Throwable) (obj1)));
            je.a().a(new jf(c, s, "1.18"), (Context)d.get());
            return;
        } else
        {
            return;
        }
        obj1;
        Log.e(s1, ((Throwable) (obj1)).getMessage(), ((Throwable) (obj1)));
        return;
        obj1;
        s = null;
          goto _L3
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private ntext(String s, Map map, Context context, boolean flag)
    {
        d = null;
        c = s;
        a = map;
        d = new WeakReference(context);
        b = flag;
    }

    ntext(String s, Map map, Context context, boolean flag, ntext ntext)
    {
        this(s, map, context, flag);
    }
}
