// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            av

public final class aw extends bd.a
{

    private ay.a fP;
    private av fQ;
    private final Object fx = new Object();

    public aw()
    {
    }

    public void a(av av1)
    {
        synchronized (fx)
        {
            fQ = av1;
        }
        return;
        av1;
        obj;
        JVM INSTR monitorexit ;
        throw av1;
    }

    public void a(ay.a a1)
    {
        synchronized (fx)
        {
            fP = a1;
        }
        return;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public void onAdClosed()
    {
        synchronized (fx)
        {
            if (fQ != null)
            {
                fQ.D();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onAdFailedToLoad(int i)
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        if (fP == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        Exception exception;
        if (i == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        fP.f(i);
        fP = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onAdLeftApplication()
    {
        synchronized (fx)
        {
            if (fQ != null)
            {
                fQ.E();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onAdLoaded()
    {
label0:
        {
            synchronized (fx)
            {
                if (fP == null)
                {
                    break label0;
                }
                fP.f(0);
                fP = null;
            }
            return;
        }
        if (fQ != null)
        {
            fQ.G();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onAdOpened()
    {
        synchronized (fx)
        {
            if (fQ != null)
            {
                fQ.F();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void w()
    {
        synchronized (fx)
        {
            if (fQ != null)
            {
                fQ.C();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
