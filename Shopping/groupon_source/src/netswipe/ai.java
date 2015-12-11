// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.os.Handler;

// Referenced classes of package netswipe:
//            bi, aj, ak, o

class ai extends Thread
{

    final o a;
    private boolean b;
    private bi c;
    private Handler d;

    public ai(o o, bi bi1)
    {
        a = o;
        super();
        b = false;
        c = null;
        d = null;
        d = new Handler();
        c = bi1;
        c.a(-1);
    }

    static bi a(ai ai1)
    {
        return ai1.c;
    }

    public void a(boolean flag)
    {
        b = flag;
        if (!flag && c != null)
        {
            c.a();
        }
    }

    public void run()
    {
        try
        {
            Thread.sleep(3000L);
            for (; !isInterrupted(); Thread.sleep(8000L))
            {
                if (b)
                {
                    d.post(new aj(this));
                }
            }

        }
        catch (InterruptedException interruptedexception)
        {
            d.post(new ak(this));
        }
    }
}
