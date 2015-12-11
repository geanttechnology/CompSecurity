// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class axp
{

    final axr a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d;
    public final ArrayList e = new ArrayList();
    private final Handler f;

    public axp(Looper looper, axr axr1)
    {
        d = false;
        a = axr1;
        f = new axq(this, looper);
    }

    public final void a(int i)
    {
        f.removeMessages(1);
        ArrayList arraylist = b;
        arraylist;
        JVM INSTR monitorenter ;
        d = true;
        Iterator iterator = (new ArrayList(b)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            awk awk1 = (awk)iterator.next();
            if (!a.i_())
            {
                break;
            }
            if (b.contains(awk1))
            {
                awk1.a(i);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_95;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
        d = false;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public final void a(Bundle bundle)
    {
        boolean flag1 = true;
        ArrayList arraylist = b;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator;
        boolean flag;
        if (!d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.c(flag);
        f.removeMessages(1);
        d = true;
        if (c.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a.c(flag);
        iterator = (new ArrayList(b)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            awk awk1 = (awk)iterator.next();
            if (!a.i_() || !a.c())
            {
                break;
            }
            if (!c.contains(awk1))
            {
                awk1.a(bundle);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_156;
        bundle;
        arraylist;
        JVM INSTR monitorexit ;
        throw bundle;
        c.clear();
        d = false;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public final void a(avq avq)
    {
        f.removeMessages(1);
        ArrayList arraylist = e;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = (new ArrayList(e)).iterator();
_L2:
        avt avt1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        avt1 = (avt)iterator.next();
        if (!a.i_())
        {
            return;
        }
        if (e.contains(avt1))
        {
            avt1.a(avq);
        }
        if (true) goto _L2; else goto _L1
_L1:
        avq;
        arraylist;
        JVM INSTR monitorexit ;
        throw avq;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public final void a(avt avt1)
    {
        a.d(avt1);
        ArrayList arraylist = e;
        arraylist;
        JVM INSTR monitorenter ;
        if (!e.contains(avt1))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionFailedListener(): listener ")).append(avt1).append(" is already registered").toString());
_L2:
        return;
        e.add(avt1);
        if (true) goto _L2; else goto _L1
_L1:
        avt1;
        arraylist;
        JVM INSTR monitorexit ;
        throw avt1;
    }

    public final void a(awk awk1)
    {
        a.d(awk1);
        ArrayList arraylist = b;
        arraylist;
        JVM INSTR monitorenter ;
        if (!b.contains(awk1))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionCallbacks(): listener ")).append(awk1).append(" is already registered").toString());
_L2:
        if (a.c())
        {
            f.sendMessage(f.obtainMessage(1, awk1));
        }
        return;
        b.add(awk1);
        if (true) goto _L2; else goto _L1
_L1:
        awk1;
        arraylist;
        JVM INSTR monitorexit ;
        throw awk1;
    }
}
