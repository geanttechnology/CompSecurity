// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.net.HttpURLConnection;

// Referenced classes of package jumiomobile:
//            ai

class ak
    implements Runnable
{

    final ai a;

    ak(ai ai1)
    {
        a = ai1;
        super();
    }

    public void run()
    {
        try
        {
            if (a.a != null)
            {
                a.a.disconnect();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }
}
