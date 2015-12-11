// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class cvt extends InputStream
{

    private final RandomAccessFile a;
    private long b;

    public cvt(File file, long l, long l1)
    {
        b.a(file);
        boolean flag;
        if (l <= l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "begin must be less than or equal to end");
        b = (l1 - l) + 1L;
        a = new RandomAccessFile(file, "r");
        a.seek(l);
    }

    public final void close()
    {
        bmo.e(String.format("Stream closed with %d bytes left unread", new Object[] {
            Long.valueOf(b)
        }));
        a.close();
    }

    public final int read()
    {
        if (b > 0L)
        {
            int i = a.read();
            if (i != -1)
            {
                b = b - 1L;
                return i;
            }
        }
        return -1;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (b > 0L)
        {
            i = a.read(abyte0, 0, (int)Math.min(j, b));
            if (i > 0)
            {
                b = b - (long)i;
            }
            return i;
        } else
        {
            return -1;
        }
    }
}
