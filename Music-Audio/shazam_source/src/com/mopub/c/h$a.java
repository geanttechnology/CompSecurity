// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.os.Handler;
import com.mopub.d.l;
import java.util.Map;

// Referenced classes of package com.mopub.c:
//            h

final class _cls1.b
{

    final int a;
    final Handler b;
    final Runnable c;
    final h d;

    er(h h1, l l, int i)
    {
        this(h1, l, i, new Handler());
    }

    private er(h h1, l l, int i, Handler handler)
    {
        d = h1;
        super();
        a = i;
        b = handler;
        c = new Runnable(h1, l) {

            final h a;
            final l b;
            final h.a c;

            public final void run()
            {
                c.d.a.remove(b);
                c.d.b(b);
            }

            
            {
                c = h.a.this;
                a = h1;
                b = l;
                super();
            }
        };
    }
}
