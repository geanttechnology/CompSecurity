// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Locale;
import javax.crypto.spec.IvParameterSpec;

public final class cvp extends InputStream
{

    private final RandomAccessFile a;
    private long b;
    private long c;
    private final byte d[] = new byte[1];
    private final Key e;
    private final IvParameterSpec f;

    public cvp(File file, long l, long l1, Key key)
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
        b.a(key);
        c = (l1 - l) + 1L;
        b = l;
        a = new RandomAccessFile(file, "r");
        a.seek(l);
        e = key;
        f = a.m(file.getName());
    }

    public final void close()
    {
        bmo.e(String.format(Locale.US, "Stream closed with %d bytes left unread", new Object[] {
            Long.valueOf(c)
        }));
        a.close();
    }

    public final int read()
    {
        byte byte0 = -1;
        int i = byte0;
        if (c > 0L)
        {
            int j = a.read();
            i = byte0;
            if (j != -1)
            {
                d[0] = (byte)j;
                try
                {
                    a.a(d, 0, 1, e, f, b);
                }
                catch (GeneralSecurityException generalsecurityexception)
                {
                    throw new IOException(generalsecurityexception.toString());
                }
                b = b + 1L;
                c = c - 1L;
                i = d[0] & 0xff;
            }
        }
        return i;
    }

    public final int read(byte abyte0[], int i, int j)
    {
        if (c > 0L)
        {
            j = a.read(abyte0, i, (int)Math.min(j, c));
            if (j > 0)
            {
                try
                {
                    a.a(abyte0, i, j, e, f, b);
                }
                // Misplaced declaration of an exception variable
                catch (byte abyte0[])
                {
                    throw new IOException(abyte0.toString());
                }
                c = c - (long)j;
                b = b + (long)j;
            }
            return j;
        } else
        {
            return -1;
        }
    }
}
