// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.shazam.android.activities.streaming.b;
import com.shazam.android.util.s;
import com.shazam.i.b.au.d;
import com.shazam.i.b.c;
import com.shazam.i.b.z.a;

// Referenced classes of package com.shazam.android.an:
//            e

public final class o
    implements e
{

    private final Handler b = com.shazam.i.b.z.a.a();
    private final Resources c = com.shazam.i.b.c.a().getResources();
    private final s d = com.shazam.i.b.au.d.a();
    private final b e;

    public o(b b1)
    {
        e = b1;
    }

    static s a(o o1)
    {
        return o1.d;
    }

    private String a(int i)
    {
        return c.getString(i, new Object[] {
            c.getString(e.d)
        });
    }

    private void a(String s)
    {
        b.post(new Runnable(s) {

            final String a;
            final o b;

            public final void run()
            {
                s s1 = com.shazam.android.an.o.a(b);
                com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
                a1.b = a;
                a1.c = 1;
                s1.a(a1.a());
            }

            
            {
                b = o.this;
                a = s1;
                super();
            }
        });
    }

    public final void a()
    {
        a(a(0x7f09012e));
    }

    public final void b()
    {
        a(a(0x7f09012d));
    }
}
