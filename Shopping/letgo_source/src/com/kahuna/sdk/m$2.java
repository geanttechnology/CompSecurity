// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            m, c

class nit>
    implements Runnable
{

    final c a;
    final m b;

    public void run()
    {
        try
        {
            m.a(b, a);
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackEvent(): ").append(exception).toString());
        }
    }

    (m m1, c c)
    {
        b = m1;
        a = c;
        super();
    }
}
