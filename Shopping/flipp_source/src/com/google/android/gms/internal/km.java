// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            kj, kd

final class km
    implements kj
{

    private kd a;
    private byte b[];
    private final int c = 239;

    public km()
    {
        a();
    }

    public final void a()
    {
        b = new byte[c];
        byte abyte0[] = b;
        a = kd.a(abyte0, abyte0.length);
    }

    public final void a(int i, long l)
    {
        kd kd1 = a;
        kd1.a(i, 0);
        kd1.a(l);
    }

    public final void a(int i, String s)
    {
        a.a(i, s);
    }

    public final byte[] b()
    {
        int i = a.a();
        if (i < 0)
        {
            throw new IOException();
        }
        if (i == 0)
        {
            return b;
        } else
        {
            byte abyte0[] = new byte[b.length - i];
            System.arraycopy(b, 0, abyte0, 0, abyte0.length);
            return abyte0;
        }
    }
}
