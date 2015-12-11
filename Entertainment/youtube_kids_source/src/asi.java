// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Looper;
import java.util.concurrent.ExecutorService;

public final class asi
{

    public final ExecutorService a;
    ask b;
    public boolean c;

    public asi(String s)
    {
        a = atp.a(s);
    }

    public final void a()
    {
        a.b(c);
        ask ask1 = b;
        ask1.a.d();
        if (ask1.b != null)
        {
            ask1.b.interrupt();
        }
    }

    public final void a(asl asl1, asj asj)
    {
        boolean flag1 = false;
        Looper looper = Looper.myLooper();
        boolean flag;
        if (looper != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        flag = flag1;
        if (!c)
        {
            flag = true;
        }
        a.b(flag);
        c = true;
        b = new ask(this, looper, asl1, asj);
        a.submit(b);
    }
}
