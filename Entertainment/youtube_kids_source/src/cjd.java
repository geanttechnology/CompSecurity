// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class cjd
    implements ckl
{

    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    private final bmi b;

    public cjd(bmi bmi1)
    {
        b = (bmi)b.a(bmi1);
    }

    public final void a()
    {
    }

    public final void a(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((Handler)iterator.next()).sendEmptyMessage(i)) { }
    }

    public final void a(Handler handler)
    {
        a.add(handler);
    }

    public final void a(Message message)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), message.what, message.arg1, message.arg2, message.obj).sendToTarget()) { }
    }

    public final void a(bwb bwb, bwb bwb1, bwb bwb2, bwv abwv[], String as[], int i)
    {
        bwb = new cjq(bwb, bwb1, bwb2, abwv, as, i);
        for (bwb1 = a.iterator(); bwb1.hasNext(); Message.obtain((Handler)bwb1.next(), 11, bwb).sendToTarget()) { }
    }

    public final void a(cia cia1)
    {
        cia1.a(b.b());
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 14, cia1).sendToTarget()) { }
    }

    public final void a(cnd cnd)
    {
        b.a(cnd);
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 8, cnd).sendToTarget()) { }
    }

    public final void a(boolean flag)
    {
        Iterator iterator;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        for (iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 13, i, 0).sendToTarget()) { }
    }

    public final void b()
    {
    }

    public final void b(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 9, i, 0).sendToTarget()) { }
    }

    public final void c(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 10, i, 0).sendToTarget()) { }
    }

    public final void d(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 15, i, 0).sendToTarget()) { }
    }

    public final void e(int i)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); Message.obtain((Handler)iterator.next(), 12, i, 0).sendToTarget()) { }
    }
}
