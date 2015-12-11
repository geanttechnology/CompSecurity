// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.internal.ar;
import com.google.android.gms.wearable.internal.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

abstract class ave
{

    private final HashMap a = new HashMap();

    ave()
    {
    }

    abstract awd a(Object obj, IntentFilter aintentfilter[]);

    public void a(IBinder ibinder)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        awa awa1;
        Iterator iterator;
        ibinder = avc.a(ibinder);
        awa1 = new awa();
        iterator = a.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        awd awd1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_188;
        }
        entry = (java.util.Map.Entry)iterator.next();
        awd1 = (awd)entry.getValue();
        ibinder.a(awa1, new b(awd1));
        if (Log.isLoggable("WearableClient", 2))
        {
            Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: added: ").append(entry.getKey()).append("/").append(awd1).toString());
        }
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        Log.d("WearableClient", (new StringBuilder()).append("onPostInitHandler: Didn't add: ").append(entry.getKey()).append("/").append(awd1).toString());
          goto _L1
        ibinder;
        hashmap;
        JVM INSTR monitorexit ;
        throw ibinder;
        hashmap;
        JVM INSTR monitorexit ;
    }

    public void a(awc awc1)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        awa awa1;
        Iterator iterator;
        awa1 = new awa();
        iterator = a.entrySet().iterator();
_L2:
        java.util.Map.Entry entry;
        awd awd1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_210;
            }
            entry = (java.util.Map.Entry)iterator.next();
            awd1 = (awd)entry.getValue();
        } while (awd1 == null);
        boolean flag;
        awd1.a();
        flag = awc1.c();
        if (!flag) goto _L2; else goto _L1
_L1:
        ((avb)awc1.j()).a(awa1, new ar(awd1));
        if (Log.isLoggable("WearableClient", 2))
        {
            Log.d("WearableClient", (new StringBuilder()).append("disconnect: removed: ").append(entry.getKey()).append("/").append(awd1).toString());
        }
          goto _L2
        RemoteException remoteexception;
        remoteexception;
        Log.w("WearableClient", (new StringBuilder()).append("disconnect: Didn't remove: ").append(entry.getKey()).append("/").append(awd1).toString());
          goto _L2
        awc1;
        hashmap;
        JVM INSTR monitorexit ;
        throw awc1;
        a.clear();
        hashmap;
        JVM INSTR monitorexit ;
    }

    public void a(awc awc1, qk qk1, Object obj)
    {
        HashMap hashmap = a;
        hashmap;
        JVM INSTR monitorenter ;
        awd awd1 = (awd)a.remove(obj);
        if (awd1 != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        qk1.a(new Status(4002));
        hashmap;
        JVM INSTR monitorexit ;
        return;
        awd1.a();
        ((avb)awc1.j()).a(new avj(a, obj, qk1), new ar(awd1));
        hashmap;
        JVM INSTR monitorexit ;
        return;
        awc1;
        hashmap;
        JVM INSTR monitorexit ;
        throw awc1;
    }

    public void a(awc awc1, qk qk1, Object obj, IntentFilter aintentfilter[])
    {
        awd awd1;
label0:
        {
            awd1 = a(obj, aintentfilter);
            synchronized (a)
            {
                if (a.get(obj) == null)
                {
                    break label0;
                }
                qk1.a(new Status(4001));
            }
            return;
        }
        a.put(obj, awd1);
        ((avb)awc1.j()).a(new avf(a, obj, qk1), new b(awd1));
        aintentfilter;
        JVM INSTR monitorexit ;
        return;
        awc1;
        aintentfilter;
        JVM INSTR monitorexit ;
        throw awc1;
        awc1;
        a.remove(obj);
        throw awc1;
    }
}
