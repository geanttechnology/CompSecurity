// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            m, e

class nit>
    implements Runnable
{

    final String a;
    final boolean b;
    final int c;
    final int d;
    final m e;

    public void run()
    {
        try
        {
            e e1 = new e(a);
            if (b)
            {
                e1.a(c, d);
            }
            m.a(e, e1.a());
            return;
        }
        catch (Exception exception)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.trackEvent(): ").append(exception).toString());
        }
    }

    (m m1, String s, boolean flag, int i, int j)
    {
        e = m1;
        a = s;
        b = flag;
        c = i;
        d = j;
        super();
    }
}
