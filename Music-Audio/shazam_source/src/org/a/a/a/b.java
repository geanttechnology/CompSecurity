// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import org.a.a.a.a.a;

// Referenced classes of package org.a.a.a:
//            a

public final class b
{

    public static final char a;
    public static final String b;

    private static long a(Reader reader, Writer writer, char ac[])
    {
        long l = 0L;
        do
        {
            int i = reader.read(ac);
            if (-1 != i)
            {
                writer.write(ac, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    private static void a(Closeable closeable)
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
        a(((Closeable) (inputstream)));
    }

    public static void a(OutputStream outputstream)
    {
        a(((Closeable) (outputstream)));
    }

    public static void a(Reader reader)
    {
        a(((Closeable) (reader)));
    }

    public static void a(Writer writer)
    {
        a(((Closeable) (writer)));
    }

    public static String b(InputStream inputstream)
    {
        Charset charset = Charset.defaultCharset();
        a a1 = new a();
        a(new InputStreamReader(inputstream, a(charset)), a1, new char[4096]);
        return a1.toString();
    }

    static 
    {
        a = File.separatorChar;
        a a1 = new a((byte)0);
        PrintWriter printwriter = new PrintWriter(a1);
        printwriter.println();
        b = a1.toString();
        printwriter.close();
    }
}
