// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.a.a.a:
//            v

public final class u
{

    public static final byte a[] = new byte[0];
    public static final String b[] = new String[0];
    public static final Charset c = Charset.forName("ISO-8859-1");
    public static final Charset d = Charset.forName("US-ASCII");
    public static final Charset e = Charset.forName("UTF-8");
    private static AtomicReference f = new AtomicReference();

    public static int a(InputStream inputstream)
    {
        int i = -1;
        byte abyte0[] = new byte[1];
        if (inputstream.read(abyte0, 0, 1) != -1)
        {
            i = abyte0[0] & 0xff;
        }
        return i;
    }

    public static int a(String s)
    {
        if ("http".equalsIgnoreCase(s))
        {
            return 80;
        }
        return !"https".equalsIgnoreCase(s) ? -1 : 443;
    }

    private static int a(String s, int i)
    {
        if (i != -1)
        {
            return i;
        } else
        {
            return a(s);
        }
    }

    public static int a(URI uri)
    {
        return a(uri.getScheme(), uri.getPort());
    }

    public static int a(URL url)
    {
        return a(url.getProtocol(), url.getPort());
    }

    public static long a(InputStream inputstream, long l)
    {
        long l2 = 0L;
        if (l == 0L)
        {
            return 0L;
        }
        byte abyte1[] = (byte[])f.getAndSet(null);
        byte abyte0[] = abyte1;
        long l1 = l2;
        if (abyte1 == null)
        {
            abyte0 = new byte[4096];
            l1 = l2;
        }
        int i;
        int j;
        do
        {
            l2 = l1;
            if (l1 >= l)
            {
                break;
            }
            i = (int)Math.min(l - l1, abyte0.length);
            j = inputstream.read(abyte0, 0, i);
            l2 = l1;
            if (j == -1)
            {
                break;
            }
            l2 = l1 + (long)j;
            l1 = l2;
        } while (j >= i);
        f.set(abyte0);
        return l2;
    }

    public static List a(List list)
    {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static void a(int i, int j, int k)
    {
        if ((j | k) < 0 || j > i || i - j < k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
        throw closeable;
        closeable;
    }

    public static void a(Closeable closeable, Closeable closeable1)
    {
        Object obj = null;
        closeable.close();
        closeable = obj;
_L4:
        closeable1.close();
        closeable1 = closeable;
_L2:
        if (closeable1 == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        closeable1 = closeable;
        if (closeable == null)
        {
            closeable1 = throwable;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (closeable1 instanceof IOException)
        {
            throw (IOException)closeable1;
        }
        if (closeable1 instanceof RuntimeException)
        {
            throw (RuntimeException)closeable1;
        }
        if (closeable1 instanceof Error)
        {
            throw (Error)closeable1;
        } else
        {
            throw new AssertionError(closeable1);
        }
        closeable;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder("not a readable directory: ")).append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                a(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder("failed to delete file: ")).append(file).toString());
            }
        }

    }

    public static void a(InputStream inputstream, byte abyte0[])
    {
        a(inputstream, abyte0, 0, abyte0.length);
    }

    public static void a(InputStream inputstream, byte abyte0[], int i, int j)
    {
        if (j != 0)
        {
            if (inputstream == null)
            {
                throw new NullPointerException("in == null");
            }
            if (abyte0 == null)
            {
                throw new NullPointerException("dst == null");
            }
            a(abyte0.length, i, j);
            while (j > 0) 
            {
                int k = inputstream.read(abyte0, i, j);
                if (k < 0)
                {
                    throw new EOFException();
                }
                i += k;
                j -= k;
            }
        }
    }

    public static void a(OutputStream outputstream, int i)
    {
        outputstream.write(new byte[] {
            (byte)(i & 0xff)
        });
    }

    public static boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static ThreadFactory b(String s)
    {
        return new v(s);
    }

    public static void b(InputStream inputstream)
    {
        do
        {
            inputstream.skip(0x7fffffffffffffffL);
        } while (inputstream.read() != -1);
    }

    public static String c(InputStream inputstream)
    {
        StringBuilder stringbuilder = new StringBuilder(80);
        do
        {
            int i = inputstream.read();
            if (i == -1)
            {
                throw new EOFException();
            }
            if (i == 10)
            {
                break;
            }
            stringbuilder.append((char)i);
        } while (true);
        int j = stringbuilder.length();
        if (j > 0 && stringbuilder.charAt(j - 1) == '\r')
        {
            stringbuilder.setLength(j - 1);
        }
        return stringbuilder.toString();
    }

}
