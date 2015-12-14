// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache
{

    final Object zzawC = new Object();
    private Handler zzawD;
    private boolean zzawE;
    private HashMap zzawF;
    private int zzawG;

    public EventIncrementCache(Looper looper, int i)
    {
        zzawD = new Handler(looper);
        zzawF = new HashMap();
        zzawG = i;
    }

    static void zza(EventIncrementCache eventincrementcache)
    {
        eventincrementcache.zzut();
    }

    private void zzut()
    {
        synchronized (zzawC)
        {
            zzawE = false;
            flush();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void flush()
    {
        Object obj = zzawC;
        obj;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = zzawF.entrySet().iterator(); iterator.hasNext(); zzt((String)entry.getKey(), ((AtomicInteger)entry.getValue()).get()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzawF.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    protected abstract void zzt(String s, int i);

    public void zzx(String s, int i)
    {
        Object obj = zzawC;
        obj;
        JVM INSTR monitorenter ;
        AtomicInteger atomicinteger1;
        if (!zzawE)
        {
            zzawE = true;
            zzawD.postDelayed(new Runnable() {

                final EventIncrementCache zzawH;

                public void run()
                {
                    EventIncrementCache.zza(zzawH);
                }

            
            {
                zzawH = EventIncrementCache.this;
                super();
            }
            }, zzawG);
        }
        atomicinteger1 = (AtomicInteger)zzawF.get(s);
        AtomicInteger atomicinteger;
        atomicinteger = atomicinteger1;
        if (atomicinteger1 != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        atomicinteger = new AtomicInteger();
        zzawF.put(s, atomicinteger);
        atomicinteger.addAndGet(i);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }
}
