// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.a;

import android.content.Context;

// Referenced classes of package c.a.a.a.a.a:
//            c

public abstract class b
{

    private final b a;

    public b(b b1)
    {
        a = b1;
    }

    protected abstract Object a();

    public Object a(Context context, c c1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = a();
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        context = ((Context) (a.a(context, c1)));
_L1:
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        throw new NullPointerException();
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
        context = ((Context) (c1.load(context)));
          goto _L1
        a(context);
        obj = context;
        this;
        JVM INSTR monitorexit ;
        return obj;
    }

    protected abstract void a(Object obj);
}
