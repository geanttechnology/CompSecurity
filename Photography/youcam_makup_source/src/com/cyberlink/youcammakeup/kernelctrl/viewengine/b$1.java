// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            b

class a
    implements Runnable
{

    final b a;

    public void run()
    {
        while (!b.a(a)) 
        {
            try
            {
                Thread.sleep(b.b(a));
                a.b();
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
