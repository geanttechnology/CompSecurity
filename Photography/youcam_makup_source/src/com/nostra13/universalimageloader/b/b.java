// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.b;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.nostra13.universalimageloader.b:
//            c

public final class b
{

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void a(InputStream inputstream)
    {
        byte abyte0[] = new byte[32768];
        int i;
        do
        {
            i = inputstream.read(abyte0, 0, 32768);
        } while (i != -1);
        a(((Closeable) (inputstream)));
        return;
        Object obj;
        obj;
        a(((Closeable) (inputstream)));
        return;
        obj;
        a(((Closeable) (inputstream)));
        throw obj;
    }

    private static boolean a(c c1, int i, int j)
    {
        return c1 != null && !c1.a(i, j) && (i * 100) / j < 75;
    }

    public static boolean a(InputStream inputstream, OutputStream outputstream, c c1, int i)
    {
        int k = inputstream.available();
        int j = k;
        if (k <= 0)
        {
            j = 0x7d000;
        }
        byte abyte0[] = new byte[i];
        if (a(c1, 0, j))
        {
            return false;
        }
        k = 0;
        do
        {
            int l = inputstream.read(abyte0, 0, i);
            if (l != -1)
            {
                outputstream.write(abyte0, 0, l);
                l = k + l;
                k = l;
                if (a(c1, l, j))
                {
                    return false;
                }
            } else
            {
                outputstream.flush();
                return true;
            }
        } while (true);
    }
}
