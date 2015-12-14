// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public abstract class aai
    implements aak
{

    private final aak a;

    public aai(aak aak1)
    {
        a = aak1;
    }

    private void b(Context context, Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        } else
        {
            a(context, obj);
            return;
        }
    }

    protected abstract Object a(Context context);

    public final Object a(Context context, aal aal1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = a(context);
        Object obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        aal1 = ((aal) (a.a(context, aal1)));
_L3:
        b(context, aal1);
        obj = aal1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return obj;
        aal1 = ((aal) (aal1.load(context)));
          goto _L3
        context;
        throw context;
    }

    protected abstract void a(Context context, Object obj);
}
