// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import com.shazam.android.ac.a;
import com.shazam.model.preview.MusicPlayerStatus;
import com.shazam.model.preview.PlayerState;
import com.shazam.o.q;

// Referenced classes of package com.shazam.android.service.player:
//            k

public final class l
    implements a
{

    private final long a;
    private final k b;
    private final MusicPlayerStatus c;
    private boolean d;

    public l(k k1, MusicPlayerStatus musicplayerstatus, q q1)
    {
        d = true;
        b = k1;
        c = musicplayerstatus;
        a = -q1.a();
    }

    private void a(long l1)
    {
        boolean flag;
        if (c.a() == PlayerState.PLAYING)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b.b(l1);
            b.a(l1);
        }
    }

    private void b()
    {
        b.a(d);
    }

    public final void a()
    {
        a(a);
        d = true;
        b();
    }

    public final void d()
    {
        if (d)
        {
            a(0L);
        }
        d = false;
        b();
    }
}
