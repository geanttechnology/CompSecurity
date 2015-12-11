// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import com.f.a.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.common:
//            g

private class this._cls0
{

    private final List mSnackBars = Collections.synchronizedList(new ArrayList());
    final g this$0;

    public void a()
    {
        List list = mSnackBars;
        list;
        JVM INSTR monitorenter ;
        Iterator iterator = mSnackBars.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            f f1 = (f)iterator.next();
            if (!f1.c())
            {
                f1.a();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_55;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        mSnackBars.clear();
        list;
        JVM INSTR monitorexit ;
    }

    public void a(f f1)
    {
        synchronized (mSnackBars)
        {
            mSnackBars.add(f1);
        }
        return;
        f1;
        list;
        JVM INSTR monitorexit ;
        throw f1;
    }

    public ()
    {
        this$0 = g.this;
        super();
    }
}
