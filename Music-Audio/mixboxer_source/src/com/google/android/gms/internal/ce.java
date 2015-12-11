// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            ct, aq, ci, cb, 
//            cg, bz, v, cf, 
//            cs, cu, ch, co, 
//            x, cw, cx, am

public final class ce extends cd.a
{

    private static final Object hC = new Object();
    private static ce hD;
    private final aq hE;
    private final Context mContext;

    private ce(Context context, aq aq1)
    {
        mContext = context;
        hE = aq1;
    }

    private static cb a(Context context, aq aq1, bz bz1)
    {
        ct.r("Starting ad request from service.");
        aq1.init();
        ci ci1 = new ci(context);
        if (ci1.ik == -1)
        {
            ct.r("Device is offline.");
            return new cb(2);
        }
        cg cg1 = new cg(bz1.applicationInfo.packageName);
        if (bz1.hr.extras != null)
        {
            String s = bz1.hr.extras.getString("_ad");
            if (s != null)
            {
                return cf.a(context, bz1, s);
            }
        }
        aq1 = cf.a(bz1, ci1, aq1.a(250L));
        if (aq1 == null)
        {
            return new cb(0);
        }
        cs.iI.post(new Runnable(context, bz1, cg1, aq1) {

            final Context hF;
            final bz hG;
            final cg hH;
            final String hI;

            public void run()
            {
                cw cw1 = cw.a(hF, new x(), false, false, null, hG.ej);
                cw1.setWillNotDraw(true);
                hH.b(cw1);
                cx cx1 = cw1.aC();
                cx1.a("/invalidRequest", hH.hM);
                cx1.a("/loadAdURL", hH.hN);
                cx1.a("/log", am.fs);
                ct.r("Getting the ad request URL.");
                cw1.loadDataWithBaseURL("http://googleads.g.doubleclick.net", (new StringBuilder()).append("<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(").append(hI).append(");</script></head><body></body></html>").toString(), "text/html", "UTF-8", null);
            }

            
            {
                hF = context;
                hG = bz1;
                hH = cg1;
                hI = s;
                super();
            }
        });
        aq1 = cg1.ap();
        if (TextUtils.isEmpty(aq1))
        {
            return new cb(cg1.getErrorCode());
        } else
        {
            return a(context, bz1.ej.iJ, ((String) (aq1)));
        }
    }

    public static cb a(Context context, String s, String s1)
    {
        HttpURLConnection httpurlconnection;
        ch ch1;
        Map map;
        int i;
        int j;
        try
        {
            ch1 = new ch();
            s1 = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ct.v((new StringBuilder()).append("Error while connecting to ad server: ").append(context.getMessage()).toString());
            return new cb(2);
        }
        i = 0;
        httpurlconnection = (HttpURLConnection)Instrumentation.openConnection(s1.openConnection());
        co.a(context, s, false, httpurlconnection);
        j = httpurlconnection.getResponseCode();
        map = httpurlconnection.getHeaderFields();
        if (j < 200 || j >= 300)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        context = s1.toString();
        s = co.a(new InputStreamReader(httpurlconnection.getInputStream()));
        a(((String) (context)), map, s, j);
        ch1.a(context, map, s);
        context = ch1.aq();
        httpurlconnection.disconnect();
        return context;
        a(s1.toString(), map, null, j);
        if (j < 300 || j >= 400)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        s1 = httpurlconnection.getHeaderField("Location");
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        ct.v("No location header to follow redirect.");
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        s1 = new URL(s1);
        i++;
        if (i <= 5)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        ct.v("Too many redirects.");
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        ct.v((new StringBuilder()).append("Received error HTTP response code: ").append(j).toString());
        context = new cb(0);
        httpurlconnection.disconnect();
        return context;
        ch1.d(map);
        httpurlconnection.disconnect();
        break MISSING_BLOCK_LABEL_21;
        context;
        httpurlconnection.disconnect();
        throw context;
    }

    public static ce a(Context context, aq aq1)
    {
        synchronized (hC)
        {
            if (hD == null)
            {
                hD = new ce(context.getApplicationContext(), aq1);
            }
            context = hD;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static void a(String s, Map map, String s1, int i)
    {
        if (ct.n(2))
        {
            ct.u((new StringBuilder()).append("Http Response: {\n  URL:\n    ").append(s).append("\n  Headers:").toString());
            if (map != null)
            {
                for (s = map.keySet().iterator(); s.hasNext();)
                {
                    Object obj = (String)s.next();
                    ct.u((new StringBuilder()).append("    ").append(((String) (obj))).append(":").toString());
                    obj = ((List)map.get(obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        String s2 = (String)((Iterator) (obj)).next();
                        ct.u((new StringBuilder()).append("      ").append(s2).toString());
                    }
                }

            }
            ct.u("  Body:");
            if (s1 != null)
            {
                for (int j = 0; j < Math.min(s1.length(), 0x186a0); j += 1000)
                {
                    ct.u(s1.substring(j, Math.min(s1.length(), j + 1000)));
                }

            } else
            {
                ct.u("    null");
            }
            ct.u((new StringBuilder()).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    public cb b(bz bz1)
    {
        return a(mContext, hE, bz1);
    }

}
