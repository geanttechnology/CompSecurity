// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.os.Handler;

// Referenced classes of package com.helpshift.i:
//            m

class it>
    implements Runnable
{

    final m a;

    public void run()
    {
        m.a(a).sendMessage(m.a(a).obtainMessage());
        m.a(a).postDelayed(a.a, (long)m.b(a));
        if (m.c(a).booleanValue())
        {
            a.a(m.b(a));
        }
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
