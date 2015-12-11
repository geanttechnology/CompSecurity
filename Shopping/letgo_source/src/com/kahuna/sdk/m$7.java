// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;

// Referenced classes of package com.kahuna.sdk:
//            m, r, c

class nit>
    implements Runnable
{

    final m a;

    public void run()
    {
        if (!m.b(a))
        {
            Log.e("Kahuna", "You need to call onAppCreate() before any other call to the SDK. Ignoring disablePush request");
        } else
        if (m.l(a))
        {
            m.a(a, false);
            r.a(m.l(a), m.a(a));
            m.a(a, new c("k_push_disabled"));
            return;
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
