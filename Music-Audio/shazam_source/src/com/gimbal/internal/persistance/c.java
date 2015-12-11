// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.persistance;

import com.gimbal.android.util.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class c
    implements Iterable
{

    private List a;

    public c()
    {
        a = new ArrayList();
    }

    public void a()
    {
    }

    public final void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        a.add(new WeakReference(obj));
        if (a.size() == 1)
        {
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public void b()
    {
    }

    public final void b(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (a.size() <= 0) goto _L2; else goto _L1
_L1:
        ListIterator listiterator = a.listIterator();
_L8:
        if (!listiterator.hasNext()) goto _L4; else goto _L3
_L3:
        Object obj1 = ((WeakReference)listiterator.next()).get();
        if (obj1 != obj) goto _L6; else goto _L5
_L5:
        listiterator.remove();
_L4:
        if (a.size() == 0)
        {
            b();
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (obj1 != null) goto _L8; else goto _L7
_L7:
        listiterator.remove();
          goto _L8
        obj;
        throw obj;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i = a.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public Iterator iterator()
    {
        this;
        JVM INSTR monitorenter ;
        b b1 = new b(a);
        this;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }
}
