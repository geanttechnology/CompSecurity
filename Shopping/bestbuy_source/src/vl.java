// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;

public final class vl
    implements qo, qp
{

    private final vm a;
    private final vn b;
    private final Object c;

    public vl(Context context, vm vm1)
    {
        this(context, vm1, false);
    }

    vl(Context context, vm vm1, boolean flag)
    {
        c = new Object();
        a = vm1;
        b = new vn(context, this, this, 0x648278);
        if (!flag)
        {
            b.a();
        }
    }

    public void onConnected(Bundle bundle)
    {
        bundle = ug.a();
        Object obj1 = c;
        obj1;
        JVM INSTR monitorenter ;
        Object obj = b.f();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((vo) (obj)).a();
_L6:
        if (b.c())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        bundle = ((Bundle) (obj));
        if (!b.g())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        b.b();
        bundle = ((Bundle) (obj));
_L4:
        obj1;
        JVM INSTR monitorexit ;
        a.a(bundle);
        return;
        obj;
        acb.d("Error when get Gservice values", ((Throwable) (obj)));
        if (b.c() || b.g())
        {
            b.b();
        }
        continue; /* Loop/switch isn't completed */
        obj;
        acb.d("Error when get Gservice values", ((Throwable) (obj)));
        if (b.c() || b.g())
        {
            b.b();
        }
        if (true) goto _L4; else goto _L3
_L3:
        bundle;
        if (b.c() || b.g())
        {
            b.b();
        }
        throw bundle;
        bundle;
        obj1;
        JVM INSTR monitorexit ;
        throw bundle;
_L2:
        obj = bundle;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConnectionFailed(pp pp)
    {
        a.a(ug.a());
    }

    public void onConnectionSuspended(int i)
    {
        acb.a("Disconnected from remote ad request service.");
    }
}
