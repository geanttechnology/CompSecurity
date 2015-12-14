// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Timer;

class li
{

    private Timer a;
    private a b;

    li()
    {
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.cancel();
            a = null;
        }
        b = null;
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
        a = new Timer("FlurrySessionTimer");
        b = new a();
        a.schedule(b, l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean b()
    {
        return a != null;
    }

    private class a extends TimerTask
    {

        final li a;

        public void run()
        {
            a.a();
            (new lj()).b();
        }

        a()
        {
            a = li.this;
            super();
        }
    }

}
