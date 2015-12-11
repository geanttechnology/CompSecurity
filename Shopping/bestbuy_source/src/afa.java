// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class afa
{

    private final afj a;
    private final Context b;
    private ContentProviderClient c;
    private boolean d;
    private HashMap e;

    public afa(Context context, afj afj1)
    {
        c = null;
        d = false;
        e = new HashMap();
        b = context;
        a = afj1;
    }

    private afc a(ahx ahx, Looper looper)
    {
        if (looper == null)
        {
            ady.a(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
        }
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        afc afc2 = (afc)e.get(ahx);
        afc afc1;
        afc1 = afc2;
        if (afc2 != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        afc1 = new afc(ahx, looper);
        e.put(ahx, afc1);
        hashmap;
        JVM INSTR monitorexit ;
        return afc1;
        ahx;
        hashmap;
        JVM INSTR monitorexit ;
        throw ahx;
    }

    public void a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = e.values().iterator();
_L2:
        afc afc1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_79;
            }
            afc1 = (afc)iterator.next();
        } while (afc1 == null);
        ((aex)a.c()).a(afc1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalStateException(((Throwable) (obj)));
        }
        e.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(ahx ahx)
    {
        a.a();
        ady.a(ahx, "Invalid null listener");
        HashMap hashmap = e;
        hashmap;
        JVM INSTR monitorenter ;
        ahx = (afc)e.remove(ahx);
        if (c != null && e.isEmpty())
        {
            c.release();
            c = null;
        }
        if (ahx == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ahx.a();
        ((aex)a.c()).a(ahx);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        ahx;
        hashmap;
        JVM INSTR monitorexit ;
        throw ahx;
    }

    public void a(LocationRequest locationrequest, ahx ahx, Looper looper)
    {
        a.a();
        ahx = a(ahx, looper);
        ((aex)a.c()).a(locationrequest, ahx);
    }

    public void a(boolean flag)
    {
        a.a();
        ((aex)a.c()).a(flag);
        d = flag;
    }

    public void b()
    {
        if (!d)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        a(false);
        return;
        RemoteException remoteexception;
        remoteexception;
        throw new IllegalStateException(remoteexception);
    }
}
