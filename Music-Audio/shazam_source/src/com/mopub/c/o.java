// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.c.a;
import com.mopub.d.l;
import com.mopub.d.s;

// Referenced classes of package com.mopub.c:
//            k, c

public final class o extends k
    implements n.a
{

    public o(Looper looper)
    {
        super(looper);
    }

    final l a()
    {
        return ((n.b)b).a(this);
    }

    public final void a(s s)
    {
        d.post(new Runnable(s) {

            final s a;
            final o b;

            public final void run()
            {
                try
                {
                    b.c.a(a);
                    b.c();
                    return;
                }
                catch (s s1)
                {
                    com.mopub.common.c.a.b((new StringBuilder("Failed to Scribe events: ")).append(a).toString());
                }
                b.d();
            }

            
            {
                b = o.this;
                a = s1;
                super();
            }
        });
    }

    public final void g_()
    {
        com.mopub.common.c.a.b("Successfully scribed events");
        d.post(new Runnable() {

            final o a;

            public final void run()
            {
                a.d();
            }

            
            {
                a = o.this;
                super();
            }
        });
    }
}
