// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            fw, iv, ir, ip, 
//            gr, it, ix, io, 
//            ga

public final class iu extends fw
{

    public final ir f;
    private final ix g = new iv(this, (byte)0);
    private final HashMap h = new HashMap();
    private final String i;
    private final String j = null;

    public iu(Context context, c c, d d, String s)
    {
        super(context, c, d, new String[0]);
        f = new ir(context, g);
        i = s;
    }

    static void a(iu iu1)
    {
        iu1.h();
    }

    static IInterface b(iu iu1)
    {
        return iu1.i();
    }

    protected final IInterface a(IBinder ibinder)
    {
        return ip.a(ibinder);
    }

    protected final String a()
    {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final void a(gr gr1, ga ga)
    {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", i);
        gr1.e(ga, 0x40ba50, super.a.getPackageName(), bundle);
    }

    protected final String b()
    {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public final void g()
    {
        ir ir1 = f;
        ir1;
        JVM INSTR monitorenter ;
        Object obj1;
        if (!e())
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj1 = f;
        Object obj = ((ir) (obj1)).d;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = ((ir) (obj1)).d.values().iterator();
_L2:
        it it1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_109;
            }
            it1 = (it)iterator.next();
        } while (it1 == null);
        ((io)((ir) (obj1)).a.b()).a(it1);
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        throw new IllegalStateException(((Throwable) (obj)));
        ir1;
        JVM INSTR monitorexit ;
        throw obj;
        ((ir) (obj1)).d.clear();
        obj;
        JVM INSTR monitorexit ;
        obj = f;
        if (!((ir) (obj)).c)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        ((ir) (obj)).a.a();
        ((io)((ir) (obj)).a.b()).a(false);
        obj.c = false;
        super.g();
        ir1;
        JVM INSTR monitorexit ;
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }
}
