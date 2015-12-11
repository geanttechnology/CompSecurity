// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.j.a.d.aj;
import com.j.a.d.e;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;

// Referenced classes of package com.j.a.g:
//            w, b

public class m
{

    private static Random a;

    public static double a(double d)
    {
        if (a == null)
        {
            a = new Random();
        }
        return a.nextDouble() * d;
    }

    public static String a()
    {
        String s;
        try
        {
            s = e.e().o().getPackageManager().getPackageInfo(e.e().o().getPackageName(), 0).versionName;
        }
        catch (Exception exception)
        {
            w.b("appVersion error", exception);
            return "";
        }
        return s;
    }

    public static void a(Runnable runnable)
    {
        if (e.e().p() != null)
        {
            e.e().p().runOnUiThread(runnable);
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
            return;
        }
    }

    public static void a(Map map, StringBuilder stringbuilder)
    {
        if (map != null && stringbuilder != null)
        {
            boolean flag = stringbuilder.toString().contains("\\?");
            Iterator iterator = map.entrySet().iterator();
            map = Integer.valueOf(0);
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (map.intValue() == 0 && !flag)
                {
                    stringbuilder.append("?");
                } else
                {
                    stringbuilder.append("&");
                }
                stringbuilder.append((String)entry.getKey()).append("=").append(entry.getValue().toString());
                map = Integer.valueOf(map.intValue() + 1);
            }
        }
    }

    public static boolean a(Context context, String s)
    {
        return context.checkCallingOrSelfPermission(s) == 0;
    }

    public static boolean a(b b1)
    {
        return aj.a().b().contains(b1.a());
    }

    public static boolean a(String s)
    {
        try
        {
            JSONObjectInstrumentation.init(s);
        }
        catch (JSONException jsonexception)
        {
            try
            {
                JSONArrayInstrumentation.init(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        }
        return true;
    }

    public static int b()
    {
        int i;
        try
        {
            i = e.e().o().getPackageManager().getPackageInfo(e.e().o().getPackageName(), 0).versionCode;
        }
        catch (Exception exception)
        {
            w.b("appVersion error", exception);
            return 0;
        }
        return i;
    }

    public static Thread b(String s)
    {
        for (Iterator iterator = Thread.getAllStackTraces().keySet().iterator(); iterator.hasNext();)
        {
            Thread thread = (Thread)iterator.next();
            if (thread.getName().equals(s))
            {
                return thread;
            }
        }

        return null;
    }
}
