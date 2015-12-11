// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.c;

import com.gimbal.internal.proximity.core.sighting.c;
import com.gimbal.internal.proximity.core.sighting.h;

// Referenced classes of package com.gimbal.internal.proximity.core.c:
//            h, c, b, n

final class b
    implements Runnable
{

    private byte a[];
    private int b;
    private com.gimbal.internal.proximity.core.c.h c;

    public final void run()
    {
        Object obj = h.a(c).a(a);
        if (obj != null)
        {
            com.gimbal.internal.proximity.core.c.h h1;
            switch (a[((b) (obj)).a.ordinal()])
            {
            default:
                h.i();
                return;

            case 1: // '\001'
                h1 = c;
                break;
            }
            int i = b;
            obj = ((b) (obj)).b;
            obj = h1.b.a(((j) (obj)), i);
            h1.a.a.a(((com.gimbal.internal.proximity.core.sighting.Sighting) (obj)));
            return;
        } else
        {
            h.i();
            return;
        }
    }

    ng.h(com.gimbal.internal.proximity.core.c.h h1, byte abyte0[], int i)
    {
        c = h1;
        a = abyte0;
        b = i;
        super();
    }
}
