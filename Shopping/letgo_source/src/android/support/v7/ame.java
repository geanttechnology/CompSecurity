// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;

// Referenced classes of package android.support.v7:
//            amg, amh

public abstract class ame
    implements amg
{

    private final amg a;

    public ame(amg amg1)
    {
        a = amg1;
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

    public final Object a(Context context, amh amh1)
        throws Exception
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
        amh1 = ((amh) (a.a(context, amh1)));
_L3:
        b(context, amh1);
        obj = amh1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return obj;
        amh1 = ((amh) (amh1.load(context)));
          goto _L3
        context;
        throw context;
    }

    protected abstract void a(Context context, Object obj);
}
