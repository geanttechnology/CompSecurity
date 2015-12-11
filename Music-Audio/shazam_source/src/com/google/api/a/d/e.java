// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.w;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

// Referenced classes of package com.google.api.a.d:
//            b

public final class e extends b
{

    private final byte c[];
    private final int d = 0;
    private final int e;

    public e(String s, byte abyte0[], int i)
    {
        super(s);
        c = (byte[])com.google.api.a.f.a.a.a.a.c.a(abyte0);
        boolean flag;
        if (i >= 0 && i + 0 <= abyte0.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "offset %s, length %s, array length %s", new Object[] {
            Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(abyte0.length)
        });
        e = i;
    }

    public final long a()
    {
        return (long)e;
    }

    public final volatile b a(String s)
    {
        return (e)super.a(s);
    }

    public final volatile b a(boolean flag)
    {
        return (e)super.a(flag);
    }

    public final InputStream b()
    {
        return new ByteArrayInputStream(c, d, e);
    }

    public final boolean d()
    {
        return true;
    }
}
