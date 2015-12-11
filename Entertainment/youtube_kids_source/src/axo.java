// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public final class axo extends axk
{

    private int a;
    private Bundle b;
    private IBinder c;
    private axi d;

    public axo(axi axi1, int i, IBinder ibinder, Bundle bundle)
    {
        d = axi1;
        super(axi1, Boolean.valueOf(true));
        a = i;
        c = ibinder;
        b = bundle;
    }

    protected final void a(Object obj)
    {
        if ((Boolean)obj == null)
        {
            axi.a(d, 1);
            return;
        }
        a;
        JVM INSTR lookupswitch 2: default 48
    //                   0: 154
    //                   10: 326;
           goto _L1 _L2 _L3
_L1:
        axp axp1;
        if (b != null)
        {
            obj = (PendingIntent)b.getParcelable("pendingIntent");
        } else
        {
            obj = null;
        }
        if (axi.d(d) != null)
        {
            axs.a(axi.e(d)).b(d.e(), axi.d(d));
            axi.a(d, null);
        }
        axi.a(d, 1);
        axi.a(d, null);
        axi.a(d).a(new avq(a, ((PendingIntent) (obj))));
        return;
_L2:
        obj = c.getInterfaceDescriptor();
        if (!d.f().equals(obj))
        {
            break MISSING_BLOCK_LABEL_252;
        }
        axi.a(d, d.a(c));
        if (axi.c(d) == null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        axi.a(d, 3);
        axp1 = axi.a(d);
        synchronized (axp1.b)
        {
            axp1.a(axp1.a.h_());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        axs.a(axi.e(d)).b(d.e(), axi.d(d));
        axi.a(d, null);
        axi.a(d, 1);
        axi.a(d, null);
        axi.a(d).a(new avq(8, null));
        return;
_L3:
        axi.a(d, 1);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }
}
