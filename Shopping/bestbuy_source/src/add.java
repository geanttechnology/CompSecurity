// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public final class add extends ada
{

    public final int b;
    public final Bundle c;
    public final IBinder d;
    final acy e;

    public add(acy acy1, int i, IBinder ibinder, Bundle bundle)
    {
        e = acy1;
        super(acy1, Boolean.valueOf(true));
        b = i;
        d = ibinder;
        c = bundle;
    }

    protected void a()
    {
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            acy.a(e, 1, null);
            return;
        }
        b;
        JVM INSTR lookupswitch 2: default 44
    //                   0: 142
    //                   10: 269;
           goto _L1 _L2 _L3
_L1:
        if (c != null)
        {
            boolean1 = (PendingIntent)c.getParcelable("pendingIntent");
        } else
        {
            boolean1 = null;
        }
        if (acy.c(e) != null)
        {
            adh.a(acy.d(e)).b(e.d(), acy.c(e));
            acy.a(e, null);
        }
        acy.a(e, 1, null);
        acy.a(e).a(new pp(b, boolean1));
        return;
_L2:
        boolean1 = d.getInterfaceDescriptor();
        if (!e.e().equals(boolean1)) goto _L5; else goto _L4
_L4:
        boolean1 = e.b(d);
        if (boolean1 != null)
        {
            try
            {
                acy.a(e, 3, boolean1);
                acy.a(e).a();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Boolean boolean1) { }
        }
_L5:
        adh.a(acy.d(e)).b(e.d(), acy.c(e));
        acy.a(e, null);
        acy.a(e, 1, null);
        acy.a(e).a(new pp(8, null));
        return;
_L3:
        acy.a(e, 1, null);
        throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
    }

    protected void a(Object obj)
    {
        a((Boolean)obj);
    }
}
