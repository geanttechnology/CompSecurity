// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import com.a.a.a.u;
import java.io.DataInputStream;
import java.io.InputStream;

// Referenced classes of package com.a.a.a.b:
//            m

final class n extends InputStream
{

    final m a;

    n(m m1)
    {
        a = m1;
        super();
    }

    public final void close()
    {
        a.a.close();
    }

    public final int read()
    {
        return u.a(this);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        j = Math.min(j, a.b);
        i = a.a.read(abyte0, i, j);
        abyte0 = a;
        abyte0.b = ((m) (abyte0)).b - i;
        return i;
    }
}
