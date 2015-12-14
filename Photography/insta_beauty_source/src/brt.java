// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class brt
{

    public static String a = "https://api.weibo.com/2/";
    public static String b = "http://api.t.sina.com.cn/oauth/request_token";
    public static String c = "http://api.t.sina.com.cn/oauth/authorize";
    public static String d = "http://api.t.sina.com.cn/oauth/access_token";
    public static String e = "http://api.t.sina.com.cn/oauth/authenticate";
    public static String f = "https://api.weibo.com/oauth2/access_token";
    public static String g = "https://api.weibo.com/oauth2/authorize";
    private static String h = "";
    private static String i = "";
    private static brt j = null;
    private brp k;
    private brm l;
    private String m;

    private brt()
    {
        k = null;
        l = null;
        brq.a("Accept-Encoding", "gzip");
        brq.a(l);
        m = "wbconnect://success";
    }

    public static brt a()
    {
        brt;
        JVM INSTR monitorenter ;
        brt brt1;
        if (j == null)
        {
            j = new brt();
        }
        brt1 = j;
        brt;
        JVM INSTR monitorexit ;
        return brt1;
        Exception exception;
        exception;
        throw exception;
    }

    public static String b()
    {
        return h;
    }

    public static String c()
    {
        return i;
    }

    public bri a(Context context, brm brm1)
    {
        brq.a(new brj());
        brm1 = new bru();
        brm1.a("oauth_verifier", l.b());
        brm1.a("source", h);
        context = new bri(brq.a(context, d, "POST", brm1, l));
        k = context;
        return context;
    }

    public brm a(Context context, String s, String s1, String s2)
    {
        brq.a(new brn());
        s = new bru();
        s.a("oauth_callback", s2);
        context = new brm(brq.a(context, b, "POST", s, null));
        l = context;
        return context;
    }

    public String a(Context context, String s, String s1)
    {
        bru bru1 = new bru();
        bru1.a("source", b());
        bru1.a("pic", s1);
        bru1.a("status", s);
        return brq.a(context, (new StringBuilder()).append(a).append("statuses/upload.json").toString(), "POST", bru1, k);
    }

    public void a(bri bri1)
    {
        k = bri1;
        brq.a(new brl());
    }

    public void a(String s)
    {
        l.a(s);
    }

    public void a(String s, String s1)
    {
        h = s;
        i = s1;
    }

}
