// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class ajs
{
    public static interface a
    {

        public abstract boolean a(int i, int j);
    }


    public static void a(Closeable closeable)
    {
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            return;
        }
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

    private static boolean a(a a1, int i, int j)
    {
        return a1 != null && !a1.a(i, j) && (i * 100) / j < 75;
    }

    public static boolean a(InputStream inputstream, OutputStream outputstream, a a1, int i)
        throws IOException
    {
        int k = inputstream.available();
        int j = k;
        if (k <= 0)
        {
            j = 0x7d000;
        }
        byte abyte0[] = new byte[i];
        if (a(a1, 0, j))
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
                if (a(a1, l, j))
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
