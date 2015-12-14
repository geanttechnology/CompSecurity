// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Timer;

// Referenced classes of package com.flurry.sdk:
//            kg, kp

public class ko
{

    private static final String a = com/flurry/sdk/ko.getSimpleName();
    private Timer b;
    private a c;
    private kp d;

    public ko(kp kp)
    {
        d = kp;
    }

    static kp a(ko ko1)
    {
        return ko1.d;
    }

    static String c()
    {
        return a;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            b.cancel();
            b = null;
            kg.a(3, a, "HttpRequestTimeoutTimer stopped.");
        }
        c = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (b())
        {
            a();
        }
        b = new Timer("HttpRequestTimeoutTimer");
        c = new a(null);
        b.schedule(c, l);
        kg.a(3, a, (new StringBuilder()).append("HttpRequestTimeoutTimer started: ").append(l).append("MS").toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean b()
    {
        return b != null;
    }


    private class a extends TimerTask
    {

        final ko a;

        public void run()
        {
            kg.a(3, ko.c(), "HttpRequest timed out. Cancelling.");
            ko.a(a).k();
        }

        private a()
        {
            a = ko.this;
            super();
        }

        a(_cls1 _pcls1)
        {
            this();
        }
    }

}
