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

    final Object zzazb = new Object();
    private Handler zzazc;
    private boolean zzazd;
    private HashMap zzaze;
    private int zzazf;

    public EventIncrementCache(Looper looper, int i)
    {
        zzazc = new Handler(looper);
        zzaze = new HashMap();
        zzazf = i;
    }

    static void zza(EventIncrementCache eventincrementcache)
    {
        eventincrementcache.zzvj();
    }

    private void zzvj()
    {
        synchronized (zzazb)
        {
            zzazd = false;
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
        Object obj = zzazb;
        obj;
        JVM INSTR monitorenter ;
        java.util.Map.Entry entry;
        for (Iterator iterator = zzaze.entrySet().iterator(); iterator.hasNext(); zzs((String)entry.getKey(), ((AtomicInteger)entry.getValue()).get()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_72;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzaze.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    protected abstract void zzs(String s, int i);

    public void zzw(String s, int i)
    {
        Object obj = zzazb;
        obj;
        JVM INSTR monitorenter ;
        AtomicInteger atomicinteger1;
        if (!zzazd)
        {
            zzazd = true;
            zzazc.postDelayed(new Runnable() {

                final EventIncrementCache zzazg;

                public void run()
                {
                    EventIncrementCache.zza(zzazg);
                }

            
            {
                zzazg = EventIncrementCache.this;
                super();
            }
            }, zzazf);
        }
        atomicinteger1 = (AtomicInteger)zzaze.get(s);
        AtomicInteger atomicinteger;
        atomicinteger = atomicinteger1;
        if (atomicinteger1 != null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        atomicinteger = new AtomicInteger();
        zzaze.put(s, atomicinteger);
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
