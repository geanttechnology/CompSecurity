// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.wearable.internal:
//            ap, AddListenerRequest, x, ao, 
//            RemoveListenerRequest

final class y
{
    private static final class a extends an.a
    {

        private WeakReference a;
        private WeakReference b;

        public final void a(Status status)
        {
            Map map;
            Object obj;
            map = (Map)a.get();
            obj = b.get();
            if (status.b() || map == null || obj == null) goto _L2; else goto _L1
_L1:
            map;
            JVM INSTR monitorenter ;
            obj = (ap)map.remove(obj);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_55;
            }
            ((ap) (obj)).a();
            map;
            JVM INSTR monitorexit ;
_L2:
            a(status);
            return;
            status;
            map;
            JVM INSTR monitorexit ;
            throw status;
        }

        a(Map map, Object obj, com.google.android.gms.common.api.k.b b1)
        {
            super(b1);
            a = new WeakReference(map);
            b = new WeakReference(obj);
        }
    }


    final Map a = new HashMap();

    y()
    {
    }

    public final void a(IBinder ibinder)
    {
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        an.c c;
        Iterator iterator;
        ibinder = x.a.a(ibinder);
        c = new an.c();
        iterator = a.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        ap ap1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_168;
        }
        entry = (java.util.Map.Entry)iterator.next();
        ap1 = (ap)entry.getValue();
        ibinder.a(c, new AddListenerRequest(ap1));
        if (Log.isLoggable("WearableClient", 2))
        {
            (new StringBuilder("onPostInitHandler: added: ")).append(entry.getKey()).append("/").append(ap1);
        }
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        (new StringBuilder("onPostInitHandler: Didn't add: ")).append(entry.getKey()).append("/").append(ap1);
          goto _L1
        ibinder;
        map;
        JVM INSTR monitorexit ;
        throw ibinder;
        map;
        JVM INSTR monitorexit ;
    }

    public final void a(ao ao1)
    {
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        an.c c;
        Iterator iterator;
        c = new an.c();
        iterator = a.entrySet().iterator();
_L2:
        java.util.Map.Entry entry;
        ap ap1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_190;
            }
            entry = (java.util.Map.Entry)iterator.next();
            ap1 = (ap)entry.getValue();
        } while (ap1 == null);
        boolean flag;
        ap1.a();
        flag = ao1.e();
        if (!flag) goto _L2; else goto _L1
_L1:
        ((x)ao1.m()).a(c, new RemoveListenerRequest(ap1));
        if (Log.isLoggable("WearableClient", 2))
        {
            (new StringBuilder("disconnect: removed: ")).append(entry.getKey()).append("/").append(ap1);
        }
          goto _L2
        RemoteException remoteexception;
        remoteexception;
        (new StringBuilder("disconnect: Didn't remove: ")).append(entry.getKey()).append("/").append(ap1);
          goto _L2
        ao1;
        map;
        JVM INSTR monitorexit ;
        throw ao1;
        a.clear();
        map;
        JVM INSTR monitorexit ;
    }
}
