// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import org.apache.http.HttpEntity;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task:
//            b

public class ay extends b
{

    private static final String y = com/cyberlink/youcammakeup/kernelctrl/networkmanager/task/ay.getSimpleName();
    final long d = -1L;
    final String e;
    final String f;
    final String g;
    final String h;
    final String i;
    final String j;
    final String k;
    final String l;
    final String m;
    final int n = -1;
    final int o = -1;
    final int p = -1;
    final int q = -1;
    final int r = -1;
    final long s = -1L;
    final long t = -1L;
    final long u = -1L;
    final long v = -1L;
    final long w = -1L;
    final String x;

    public ay(HttpEntity httpentity)
    {
        super(httpentity);
        if (c != com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus.a)
        {
            d = -1L;
            e = null;
            f = null;
            g = null;
            h = null;
            i = null;
            j = null;
            k = null;
            l = null;
            m = null;
            n = -1;
            o = -1;
            p = -1;
            q = -1;
            r = -1;
            s = -1L;
            t = -1L;
            u = -1L;
            v = -1L;
            w = -1L;
            x = null;
            return;
        }
        httpentity = b;
        e = httpentity.getString("testbeddomain");
        f = httpentity.getString("productiondomain");
        g = httpentity.getString("adDomain");
        h = httpentity.getString("adTestbedDomain");
        i = httpentity.getString("feedbackdomain");
        j = httpentity.getString("feedbacktestbeddomain");
        k = httpentity.getString("perfectcorpdomain");
        l = httpentity.getString("perfectcorptestbeddomain");
        m = httpentity.optString("sendFeedback");
        httpentity = ((HttpEntity) (httpentity.opt("appVersion")));
        if (httpentity == null)
        {
            x = null;
            return;
        } else
        {
            x = httpentity.toString();
            return;
        }
    }

    public long a()
    {
        return d;
    }

    public String b()
    {
        return e;
    }

    public String c()
    {
        return f;
    }

    public com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.ResponseStatus d()
    {
        return c;
    }

    public String e()
    {
        return g;
    }

    public String f()
    {
        return h;
    }

    public int g()
    {
        return n;
    }

    public int h()
    {
        return o;
    }

    public int i()
    {
        return r;
    }

    public long j()
    {
        return t;
    }

    public String k()
    {
        return i;
    }

    public String l()
    {
        return j;
    }

    public String m()
    {
        return k;
    }

    public String n()
    {
        return l;
    }

    public String o()
    {
        return x;
    }

}
