// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;


// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            m

class a
    implements Runnable
{

    final m a;

    public void run()
    {
        while (!m.a(a)) 
        {
            try
            {
                Thread.sleep(m.b(a));
                m.c(a);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
