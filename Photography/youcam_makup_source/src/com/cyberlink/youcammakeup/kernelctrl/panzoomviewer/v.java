// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.util.SparseArray;

public class v extends SparseArray
{

    private static final Object b = new Object();
    private static v c;
    private static int d = 0;
    v a;

    private v()
    {
    }

    public static v a()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        v v1;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        v1 = c;
        c = v1.a;
        v1.a = null;
        d--;
        return v1;
        obj;
        JVM INSTR monitorexit ;
        return new v();
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        clear();
        synchronized (b)
        {
            if (d < 50)
            {
                a = c;
                c = this;
                d++;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
