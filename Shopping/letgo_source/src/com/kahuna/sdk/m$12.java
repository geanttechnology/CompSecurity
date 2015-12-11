// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            m, c

class it>
    implements Runnable
{

    final m a;

    public void run()
    {
        try
        {
            m.p(a);
            m.a(a, new c("k_user_logout"));
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.logout(): ").append(exception).toString());
            exception.printStackTrace();
            return;
        }
    }

    der(m m1)
    {
        a = m1;
        super();
    }
}
