// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Arrays;

// Referenced classes of package com.flurry.sdk:
//            kt, kg, lk, ll, 
//            kn, kx, jq

public class iy extends kt
    implements ll.a
{

    private static final String e = com/flurry/sdk/iy.getSimpleName();
    private static String f = "http://data.flurry.com/aap.do";
    private static String g = "https://data.flurry.com/aap.do";
    private String h;
    private boolean i;

    public iy()
    {
        this(null);
    }

    public iy(kt.a a1)
    {
        super("Analytics", com/flurry/sdk/iy.getSimpleName());
        d = "AnalyticsData_";
        h();
        a(a1);
    }

    static void a(iy iy1)
    {
        iy1.e();
    }

    static void a(iy iy1, String s, String s1)
    {
        iy1.b(s, s1);
    }

    private void b(String s)
    {
        if (s != null && !s.endsWith(".do"))
        {
            kg.a(5, e, "overriding analytics agent report URL without an endpoint, are you sure?");
        }
        h = s;
    }

    static String c()
    {
        return e;
    }

    private void h()
    {
        lk lk1 = lk.a();
        i = ((Boolean)lk1.a("UseHttps")).booleanValue();
        lk1.a("UseHttps", this);
        kg.a(4, e, (new StringBuilder()).append("initSettings, UseHttps = ").append(i).toString());
        String s = (String)lk1.a("ReportUrl");
        lk1.a("ReportUrl", this);
        b(s);
        kg.a(4, e, (new StringBuilder()).append("initSettings, ReportUrl = ").append(s).toString());
    }

    public void a()
    {
        lk.a().b("UseHttps", this);
        lk.a().b("ReportUrl", this);
    }

    public void a(String s, Object obj)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   -239660092: 67
    //                   1650629499: 81;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_81;
_L4:
        switch (byte0)
        {
        default:
            kg.a(6, e, "onSettingUpdate internal error!");
            return;

        case 0: // '\0'
            i = ((Boolean)obj).booleanValue();
            kg.a(4, e, (new StringBuilder()).append("onSettingUpdate, UseHttps = ").append(i).toString());
            return;

        case 1: // '\001'
            s = (String)obj;
            break;
        }
        break MISSING_BLOCK_LABEL_141;
_L2:
        if (s.equals("UseHttps"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("ReportUrl"))
        {
            byte0 = 1;
        }
          goto _L4
        b(s);
        kg.a(4, e, (new StringBuilder()).append("onSettingUpdate, ReportUrl = ").append(s).toString());
        return;
    }

    protected void a(String s, String s1, int j)
    {
        a(((ly) (new _cls2(j))));
        super.a(s, s1, j);
    }

    protected void a(byte abyte0[], String s, String s1)
    {
        String s2 = b();
        kg.a(4, e, (new StringBuilder()).append("FlurryDataSender: start upload data ").append(Arrays.toString(abyte0)).append(" with id = ").append(s).append(" to ").append(s2).toString());
        kn kn1 = new kn();
        kn1.a(s2);
        kn1.d(0x186a0);
        kn1.a(kp.a.c);
        kn1.a("Content-Type", "application/octet-stream");
        kn1.a(new kx());
        kn1.a(abyte0);
        kn1.a(new _cls1(s, s1));
        jq.a().a(this, kn1);
    }

    String b()
    {
        if (h != null)
        {
            return h;
        }
        if (i)
        {
            return g;
        } else
        {
            return f;
        }
    }


    private class _cls2 extends ly
    {

        final int a;
        final iy b;

        public void a()
        {
            if (a == 200)
            {
                hl.a().f();
            }
        }

        _cls2(int j)
        {
            b = iy.this;
            a = j;
            super();
        }
    }


    private class _cls1
        implements kn.a
    {

        final String a;
        final String b;
        final iy c;

        public volatile void a(kn kn1, Object obj)
        {
            a(kn1, (Void)obj);
        }

        public void a(kn kn1, Void void1)
        {
            int j = kn1.h();
            if (j > 0)
            {
                kg.e(iy.c(), "Analytics report sent.");
                kg.a(3, iy.c(), (new StringBuilder()).append("FlurryDataSender: report ").append(a).append(" sent. HTTP response: ").append(j).toString());
                class _cls1
                    implements Runnable
                {

                    final int a;
                    final _cls1 b;

                    public void run()
                    {
                        Toast.makeText(js.a().c(), (new StringBuilder()).append("SD HTTP Response Code: ").append(a).toString(), 0).show();
                    }

                _cls1(int j)
                {
                    b = _cls1.this;
                    a = j;
                    super();
                }
                }

                if (kg.c() <= 3 && kg.d())
                {
                    js.a().a(new _cls1(j));
                }
                c.a(a, b, j);
                iy.a(c);
                return;
            } else
            {
                iy.a(c, a, b);
                return;
            }
        }

        _cls1(String s, String s1)
        {
            c = iy.this;
            a = s;
            b = s1;
            super();
        }
    }

}
