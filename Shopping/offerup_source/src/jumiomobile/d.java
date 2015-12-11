// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Handler;

// Referenced classes of package jumiomobile:
//            by, e, f

public class d extends Thread
{

    private boolean a;
    private by b;
    private Handler c;

    public d(by by1)
    {
        a = false;
        b = null;
        c = null;
        c = new Handler();
        b = by1;
    }

    static by a(d d1)
    {
        return d1.b;
    }

    public void a(boolean flag)
    {
        a = flag;
        if (!flag && b != null)
        {
            b.a();
        }
    }

    public void run()
    {
        try
        {
            Thread.sleep(3000L);
            for (; !isInterrupted(); Thread.sleep(8000L))
            {
                if (a)
                {
                    c.post(new e(this));
                }
            }

        }
        catch (InterruptedException interruptedexception)
        {
            c.post(new f(this));
        }
    }
}
