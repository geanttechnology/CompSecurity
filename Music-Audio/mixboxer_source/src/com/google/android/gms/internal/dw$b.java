// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            dw

protected abstract class pm
{

    private Object mListener;
    final dw pl;
    private boolean pm;

    protected abstract void aL();

    protected abstract void b(Object obj);

    public void bR()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = mListener;
        if (pm)
        {
            Log.w("GmsClient", (new StringBuilder()).append("Callback proxy ").append(this).append(" being reused. This is not safe.").toString());
        }
        this;
        JVM INSTR monitorexit ;
        Object obj1;
        if (obj != null)
        {
            try
            {
                b(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                aL();
                throw obj1;
            }
        } else
        {
            aL();
        }
        this;
        JVM INSTR monitorenter ;
        pm = true;
        this;
        JVM INSTR monitorexit ;
        unregister();
        return;
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void bS()
    {
        this;
        JVM INSTR monitorenter ;
        mListener = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void unregister()
    {
        bS();
        synchronized (dw.c(pl))
        {
            dw.c(pl).remove(this);
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (dw dw1, Object obj)
    {
        pl = dw1;
        super();
        mListener = obj;
        pm = false;
    }
}
