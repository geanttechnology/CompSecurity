// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class c
{

    private String a;
    private Context b;
    private String c;
    private String d;
    private boolean e;
    private f f = new f() {

        public final e a()
        {
            return new au();
        }

    };
    private boolean g;

    private c()
    {
        g = true;
        c = "https://mobile.eum-appdynamics.com";
        d = "https://mobile-config.eum-appdynamics.com";
        e = false;
    }

    c(b._cls1 _pcls1)
    {
        this();
    }

    public b a()
    {
        if (f == null)
        {
            throw new NullPointerException("collectorChannelFactory may not be null");
        } else
        {
            return new b(a, b, c, d, e, f, g);
        }
    }

    public c a(Context context)
    {
        b = context;
        return this;
    }

    public c a(String s)
    {
        a = s;
        return this;
    }
}
