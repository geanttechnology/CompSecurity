// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.ArrayList;

public abstract class axk
{

    private Object a;
    private boolean b;
    private axi c;

    public axk(axi axi1, Object obj)
    {
        c = axi1;
        super();
        a = obj;
        b = false;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = a;
        if (b)
        {
            Log.w("GmsClient", (new StringBuilder("Callback proxy ")).append(this).append(" being reused. This is not safe.").toString());
        }
        this;
        JVM INSTR monitorexit ;
        Object obj1;
        if (obj != null)
        {
            try
            {
                a(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw obj1;
            }
        }
        this;
        JVM INSTR monitorenter ;
        b = true;
        this;
        JVM INSTR monitorexit ;
        b();
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

    protected abstract void a(Object obj);

    public final void b()
    {
        c();
        synchronized (axi.b(c))
        {
            axi.b(c).remove(this);
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c()
    {
        this;
        JVM INSTR monitorenter ;
        a = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
