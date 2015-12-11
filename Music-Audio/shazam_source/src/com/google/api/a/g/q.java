// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.g:
//            p

public final class q extends FilterInputStream
{

    private final p a;

    public q(InputStream inputstream, Logger logger, Level level, int i)
    {
        super(inputstream);
        a = new p(logger, level, i);
    }

    public final void close()
    {
        a.close();
        super.close();
    }

    public final int read()
    {
        int i = super.read();
        a.write(i);
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        j = super.read(abyte0, i, j);
        if (j > 0)
        {
            a.write(abyte0, i, j);
        }
        return j;
    }
}
