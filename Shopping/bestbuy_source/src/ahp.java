// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.google.android.gms.internal.gs;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

class ahp
    implements abh, Runnable
{

    CountDownLatch a;
    private final List b = new Vector();
    private final AtomicReference c = new AtomicReference();
    private ahk d;

    public ahp(ahk ahk1)
    {
        a = new CountDownLatch(1);
        d = ahk1;
        if (aca.b())
        {
            abp.a(this);
            return;
        } else
        {
            run();
            return;
        }
    }

    private Context b(Context context)
    {
        Context context1;
        if (b())
        {
            if ((context1 = context.getApplicationContext()) != null)
            {
                return context1;
            }
        }
        return context;
    }

    private void c()
    {
        if (!b.isEmpty())
        {
            Iterator iterator = b.iterator();
            while (iterator.hasNext()) 
            {
                Object aobj[] = (Object[])iterator.next();
                if (aobj.length == 1)
                {
                    ((abh)c.get()).a((MotionEvent)aobj[0]);
                } else
                if (aobj.length == 3)
                {
                    ((abh)c.get()).a(((Integer)aobj[0]).intValue(), ((Integer)aobj[1]).intValue(), ((Integer)aobj[2]).intValue());
                }
            }
        }
    }

    public String a(Context context)
    {
        if (a())
        {
            abh abh1 = (abh)c.get();
            if (abh1 != null)
            {
                c();
                return abh1.a(b(context));
            }
        }
        return "";
    }

    public String a(Context context, String s)
    {
        if (a())
        {
            abh abh1 = (abh)c.get();
            if (abh1 != null)
            {
                c();
                return abh1.a(b(context), s);
            }
        }
        return "";
    }

    public void a(int i, int j, int k)
    {
        abh abh1 = (abh)c.get();
        if (abh1 != null)
        {
            c();
            abh1.a(i, j, k);
            return;
        } else
        {
            b.add(((Object) (new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
            })));
            return;
        }
    }

    protected void a(abh abh1)
    {
        c.set(abh1);
    }

    public void a(MotionEvent motionevent)
    {
        abh abh1 = (abh)c.get();
        if (abh1 != null)
        {
            c();
            abh1.a(motionevent);
            return;
        } else
        {
            b.add(((Object) (new Object[] {
                motionevent
            })));
            return;
        }
    }

    protected boolean a()
    {
        try
        {
            a.await();
        }
        catch (InterruptedException interruptedexception)
        {
            acb.d("Interrupted during GADSignals creation.", interruptedexception);
            return false;
        }
        return true;
    }

    protected boolean b()
    {
        return abi.n().getBoolean("gads:spam_app_context:enabled", false);
    }

    public void run()
    {
        a(acr.a(d.e.b, b(d.c)));
        a.countDown();
        d = null;
        return;
        Exception exception;
        exception;
        a.countDown();
        d = null;
        throw exception;
    }
}
