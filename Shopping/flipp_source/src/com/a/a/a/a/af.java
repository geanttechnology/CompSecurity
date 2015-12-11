// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import java.io.InputStream;
import java.net.CacheRequest;

// Referenced classes of package com.a.a.a.a:
//            a, h

final class af extends a
{

    private boolean d;

    af(InputStream inputstream, CacheRequest cacherequest, h h)
    {
        super(inputstream, h, cacherequest);
    }

    public final int available()
    {
        a();
        if (a == null)
        {
            return 0;
        } else
        {
            return a.available();
        }
    }

    public final void close()
    {
        if (!c)
        {
            c = true;
            if (!d)
            {
                c();
                return;
            }
        }
    }

    public final int read(byte abyte0[], int i, int j)
    {
        u.a(abyte0.length, i, j);
        a();
        if (a == null || d)
        {
            return -1;
        }
        j = a.read(abyte0, i, j);
        if (j == -1)
        {
            d = true;
            b();
            return -1;
        } else
        {
            a(abyte0, i, j);
            return j;
        }
    }
}
