// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.open.a.k;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open.utils:
//            HttpUtils, n, m

public class g
{

    private static HashMap a = null;
    private static String b = null;
    private Context c;
    private String d;
    private JSONObject e;
    private long f;
    private int g;
    private boolean h;

    private g(Context context, String s)
    {
        c = null;
        d = null;
        e = null;
        f = 0L;
        g = 0;
        h = true;
        c = context.getApplicationContext();
        d = s;
        a();
        b();
    }

    static int a(g g1, int i)
    {
        g1.g = i;
        return i;
    }

    static Context a(g g1)
    {
        return g1.c;
    }

    public static g a(Context context, String s)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        if (s != null)
        {
            b = s;
        }
        String s1 = s;
        g g1;
        if (s == null)
        {
            if (b != null)
            {
                s1 = b;
            } else
            {
                s1 = "0";
            }
        }
        g1 = (g)a.get(s1);
        s = g1;
        if (g1 == null)
        {
            s = new g(context, s1);
            a.put(s1, s);
        }
        return s;
    }

    private void a()
    {
        String s = c("com.tencent.open.config.json");
        try
        {
            e = new JSONObject(s);
            return;
        }
        catch (JSONException jsonexception)
        {
            e = new JSONObject();
        }
    }

    static void a(g g1, JSONObject jsonobject)
    {
        g1.a(jsonobject);
    }

    private void a(String s, String s1)
    {
        String s2 = s;
        try
        {
            if (d != null)
            {
                s2 = (new StringBuilder()).append(s).append(".").append(d).toString();
            }
            s = new OutputStreamWriter(c.openFileOutput(s2, 0), Charset.forName("UTF-8"));
            s.write(s1);
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    private void a(JSONObject jsonobject)
    {
        d("cgi back, do update");
        e = jsonobject;
        a("com.tencent.open.config.json", jsonobject.toString());
        f = SystemClock.elapsedRealtime();
    }

    private void b()
    {
        if (g != 0)
        {
            d("update thread is running, return");
            return;
        } else
        {
            g = 1;
            Bundle bundle = new Bundle();
            bundle.putString("appid", d);
            bundle.putString("appid_for_getting_config", d);
            bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
            bundle.putString("status_machine", Build.MODEL);
            bundle.putString("status_version", android.os.Build.VERSION.SDK);
            bundle.putString("sdkv", "2.9.1.lite");
            bundle.putString("sdkp", "a");
            (new Thread(bundle) {

                final Bundle a;
                final g b;

                public void run()
                {
                    try
                    {
                        JSONObject jsonobject = m.d(HttpUtils.a(g.a(b), "http://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", "GET", a).a);
                        g.a(b, jsonobject);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    g.a(b, 0);
                }

            
            {
                b = g.this;
                a = bundle;
                super();
            }
            }).start();
            return;
        }
    }

    private String c(String s)
    {
        if (d == null) goto _L2; else goto _L1
_L1:
        Object obj = (new StringBuilder()).append(s).append(".").append(d).toString();
_L6:
        obj = c.openFileInput(((String) (obj)));
        s = ((String) (obj));
_L7:
        Object obj1;
        obj = new BufferedReader(new InputStreamReader(s, Charset.forName("UTF-8")));
        obj1 = new StringBuffer();
_L5:
        String s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null) goto _L4; else goto _L3
_L3:
        ((StringBuffer) (obj1)).append(s1);
          goto _L5
        obj1;
        ((IOException) (obj1)).printStackTrace();
        try
        {
            s.close();
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return "";
_L2:
        obj = s;
          goto _L6
        obj;
        try
        {
            s = c.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
          goto _L7
_L4:
        obj1 = ((StringBuffer) (obj1)).toString();
        try
        {
            s.close();
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return ((String) (obj1));
        }
        return ((String) (obj1));
        Exception exception;
        exception;
        try
        {
            s.close();
            ((BufferedReader) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        throw exception;
          goto _L6
    }

    private void c()
    {
        int j = e.optInt("Common_frequency");
        int i = j;
        if (j == 0)
        {
            i = 1;
        }
        long l = i * 0x36ee80;
        if (SystemClock.elapsedRealtime() - f >= l)
        {
            b();
        }
    }

    private void d(String s)
    {
        if (h)
        {
            k.b("OpenConfig", (new StringBuilder()).append(s).append("; appid: ").append(d).toString());
        }
    }

    public int a(String s)
    {
        d((new StringBuilder()).append("get ").append(s).toString());
        c();
        return e.optInt(s);
    }

    public boolean b(String s)
    {
        d((new StringBuilder()).append("get ").append(s).toString());
        c();
        s = ((String) (e.opt(s)));
        if (s != null)
        {
            if (s instanceof Integer)
            {
                boolean flag;
                if (!s.equals(Integer.valueOf(0)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
            if (s instanceof Boolean)
            {
                return ((Boolean)s).booleanValue();
            }
        }
        return false;
    }

}
