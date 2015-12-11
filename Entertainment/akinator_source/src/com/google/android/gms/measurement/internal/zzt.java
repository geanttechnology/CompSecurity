// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class zzt
{

    private int zzaNA;
    private int zzaNB;
    private boolean zzaNC;
    private final int zzaNv;
    private final int zzaNw;
    private final List zzaNx;
    private final ReentrantLock zzaNy = new ReentrantLock();
    private final Condition zzaNz;

    public zzt(Set set)
    {
        zzx.zzw(set);
        boolean flag;
        if (!set.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzaNz = zzaNy.newCondition();
        zzaNw = set.size();
        if (zzaNw > 10)
        {
            throw new IllegalArgumentException("PrimingBarrier does not support more than 10 specified threads");
        } else
        {
            zzaNv = (1 << zzaNw + 1) - 1;
            zzaNx = new ArrayList(set);
            return;
        }
    }

    private int zzP(long l)
    {
        int j = zzaNx.indexOf(Long.valueOf(l));
        int i = j;
        if (j < 0)
        {
            i = zzaNw;
        }
        return 1 << i;
    }

    private boolean zzc(Thread thread)
    {
        if (zzd(thread))
        {
            return true;
        } else
        {
            zzaNA = zzaNA | zzP(thread.getId());
            return false;
        }
    }

    private boolean zzd(Thread thread)
    {
        return (zzaNA & zzP(thread.getId())) != 0;
    }

    private boolean zze(Thread thread)
    {
        if ((zzaNB & zzP(thread.getId())) != 0)
        {
            return true;
        } else
        {
            zzaNB = zzaNB | zzP(thread.getId());
            return false;
        }
    }

    private boolean zzzZ()
    {
        return zzaNB == zzaNv;
    }

    public void zzb(Thread thread)
    {
        zzx.zzw(thread);
        zzaNy.lock();
        int i = zzP(thread.getId());
        zzaNA = zzaNA & ~i;
        zzaNB = ~i & zzaNB;
        zzaNz.signalAll();
        zzaNy.unlock();
        return;
        thread;
        zzaNy.unlock();
        throw thread;
    }

    public boolean zzzY()
        throws InterruptedException
    {
        zzaNy.lock();
        if (zzaNC)
        {
            throw new IllegalStateException("Tried to await a barrier that has already passed.");
        }
        break MISSING_BLOCK_LABEL_34;
        Object obj;
        obj;
        zzaNy.unlock();
        throw obj;
        if (Thread.interrupted())
        {
            zzb(Thread.currentThread());
            throw new InterruptedException();
        }
        if (!zzc(Thread.currentThread()))
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (zze(Thread.currentThread()))
        {
            if (zzaNx.indexOf(Long.valueOf(Thread.currentThread().getId())) >= 0)
            {
                throw new IllegalStateException("PrimingBarrier thinks current thread is already awaiting.");
            } else
            {
                throw new IllegalStateException("Multiple threads called shutdown on the Scheduler.");
            }
        }
_L1:
        boolean flag;
        if (zzzZ())
        {
            break MISSING_BLOCK_LABEL_184;
        }
        flag = zzd(Thread.currentThread());
        if (!flag)
        {
            zzaNy.unlock();
            return false;
        }
        zzaNz.await();
        if (Thread.interrupted())
        {
            zzb(Thread.currentThread());
            throw new InterruptedException();
        }
          goto _L1
        obj;
        zzb(Thread.currentThread());
        throw obj;
        if (!zzaNC)
        {
            zzaNC = true;
            zzaNz.signalAll();
        }
        zzaNy.unlock();
        return true;
        zzaNy.unlock();
        return false;
    }
}
