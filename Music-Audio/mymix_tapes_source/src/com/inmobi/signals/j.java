// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.c.e;
import com.inmobi.commons.core.network.c;
import com.inmobi.commons.core.network.d;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.signals:
//            k

public class j
{

    private static final String a = com/inmobi/signals/j.getSimpleName();
    private k b;

    public j(k k)
    {
        b = k;
    }

    static k a(j j1)
    {
        return j1.b;
    }

    static String b()
    {
        return a;
    }

    public void a()
    {
        (new Thread(new Runnable() {

            final j a;

            public void run()
            {
                int i = 0;
label0:
                do
                {
label1:
                    {
                        if (i <= com.inmobi.signals.j.a(a).b())
                        {
                            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "Attempting to send samples to server.");
                            if (!(new d(com.inmobi.signals.j.a(a))).a().a())
                            {
                                break label0;
                            }
                            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "Sending samples to server failed.");
                            i++;
                            if (i <= com.inmobi.signals.j.a(a).b())
                            {
                                break label1;
                            }
                            com.inmobi.commons.core.c.a.a().a(new e("signals", "RetryCountExceeded"));
                        }
                        return;
                    }
                    try
                    {
                        Thread.sleep(com.inmobi.signals.j.a(a).c() * 1000);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "User data network client interrupted while sleeping.", interruptedexception);
                    }
                } while (true);
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, j.b(), "Sending samples to server succeeded.");
            }

            
            {
                a = j.this;
                super();
            }
        })).start();
    }

}
