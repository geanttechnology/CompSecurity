// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.net.HttpURLConnection;

// Referenced classes of package com.flurry.sdk:
//            kp

class it> extends Thread
{

    final kp a;

    public void run()
    {
        try
        {
            if (kp.a(a) != null)
            {
                kp.a(a).disconnect();
            }
            return;
        }
        catch (Throwable throwable)
        {
            return;
        }
    }

    ection(kp kp1)
    {
        a = kp1;
        super();
    }
}
