// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util;

import android.os.Handler;

// Referenced classes of package com.shazam.android.util:
//            s, q

public final class l
    implements s
{

    final s a;
    private final Handler b;

    public l(Handler handler, s s1)
    {
        b = handler;
        a = s1;
    }

    public final void a(q q)
    {
        b.post(new Runnable(q) {

            final q a;
            final l b;

            public final void run()
            {
                b.a.a(a);
            }

            
            {
                b = l.this;
                a = q;
                super();
            }
        });
    }
}
