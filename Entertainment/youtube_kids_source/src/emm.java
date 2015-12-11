// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class emm
{

    public static int a(InputStream inputstream, byte abyte0[], int i, int j)
    {
        f.b(inputstream);
        f.b(abyte0);
        if (j < 0)
        {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int k = 0;
        do
        {
            if (k >= j)
            {
                break;
            }
            int l = inputstream.read(abyte0, i + k, j - k);
            if (l == -1)
            {
                break;
            }
            k += l;
        } while (true);
        return k;
    }

    public static long a(InputStream inputstream, OutputStream outputstream)
    {
        f.b(inputstream);
        f.b(outputstream);
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    public static byte[] a(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a(inputstream, ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }

    static 
    {
        new emn();
    }
}
