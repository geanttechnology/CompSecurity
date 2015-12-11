// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            mw

public class mx
{

    private final Object a = new Object();
    private int b;
    private List c;

    public mx()
    {
        c = new LinkedList();
    }

    public mw a()
    {
        mw mw1;
label0:
        {
            mw1 = null;
            synchronized (a)
            {
                if (c.size() != 0)
                {
                    break label0;
                }
                zzb.zzaC("Queue empty");
            }
            return null;
        }
        if (c.size() < 2)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        int i = 0x80000000;
        Iterator iterator = c.iterator();
_L1:
        mw mw2;
        int j;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        mw2 = (mw)iterator.next();
        j = mw2.g();
        if (j > i)
        {
            mw1 = mw2;
            i = j;
        }
          goto _L1
        c.remove(mw1);
        obj;
        JVM INSTR monitorexit ;
        return mw1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception = (mw)c.get(0);
        exception.c();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }

    public boolean a(mw mw1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (c.contains(mw1))
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        mw1;
        obj;
        JVM INSTR monitorexit ;
        throw mw1;
    }

    public boolean b(mw mw1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L2:
        mw mw2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            mw2 = (mw)iterator.next();
        } while (mw1 == mw2);
        if (!mw2.b().equals(mw1.b())) goto _L2; else goto _L1
_L1:
        iterator.remove();
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        mw1;
        obj;
        JVM INSTR monitorexit ;
        throw mw1;
    }

    public void c(mw mw1)
    {
        synchronized (a)
        {
            if (c.size() >= 10)
            {
                zzb.zzaC((new StringBuilder()).append("Queue is full, current size = ").append(c.size()).toString());
                c.remove(0);
            }
            int i = b;
            b = i + 1;
            mw1.a(i);
            c.add(mw1);
        }
        return;
        mw1;
        obj;
        JVM INSTR monitorexit ;
        throw mw1;
    }
}
