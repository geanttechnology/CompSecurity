// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class so
    implements sq
{

    private final Object a = new Object();
    private final WeakHashMap b = new WeakHashMap();
    private final ArrayList c = new ArrayList();

    public so()
    {
    }

    public sp a(Context context, ay ay, abd abd1, View view, gs gs)
    {
label0:
        {
            synchronized (a)
            {
                if (!a(abd1))
                {
                    break label0;
                }
                context = (sp)b.get(abd1);
            }
            return context;
        }
        context = new sp(context, ay, abd1, view, gs);
        context.a(this);
        b.put(abd1, context);
        c.add(context);
        obj;
        JVM INSTR monitorexit ;
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public sp a(ay ay, abd abd1)
    {
        return a(abd1.b.getContext(), ay, abd1, ((View) (abd1.b)), abd1.b.i());
    }

    public void a()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((sp)iterator.next()).k()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(sp sp1)
    {
        synchronized (a)
        {
            if (!sp1.f())
            {
                c.remove(sp1);
            }
        }
        return;
        sp1;
        obj;
        JVM INSTR monitorexit ;
        throw sp1;
    }

    public boolean a(abd abd1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        abd1 = (sp)b.get(abd1);
        if (abd1 == null) goto _L2; else goto _L1
_L1:
        if (!abd1.f()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        abd1;
        obj;
        JVM INSTR monitorexit ;
        throw abd1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void b()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((sp)iterator.next()).l()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void b(abd abd1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        abd1 = (sp)b.get(abd1);
        if (abd1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        abd1.d();
        obj;
        JVM INSTR monitorexit ;
        return;
        abd1;
        obj;
        JVM INSTR monitorexit ;
        throw abd1;
    }

    public void c()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((sp)iterator.next()).m()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }
}
