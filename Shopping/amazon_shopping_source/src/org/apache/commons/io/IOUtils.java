// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.io.output.StringBuilderWriter;

public class IOUtils
{

    public static final char DIR_SEPARATOR;
    public static final String LINE_SEPARATOR;

    public IOUtils()
    {
    }

    public static int copy(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        long l = copyLarge(inputstream, outputstream);
        if (l > 0x7fffffffL)
        {
            return -1;
        } else
        {
            return (int)l;
        }
    }

    public static int copy(Reader reader, Writer writer)
        throws IOException
    {
        long l = copyLarge(reader, writer);
        if (l > 0x7fffffffL)
        {
            return -1;
        } else
        {
            return (int)l;
        }
    }

    public static void copy(InputStream inputstream, Writer writer)
        throws IOException
    {
        copy(((Reader) (new InputStreamReader(inputstream))), writer);
    }

    public static void copy(InputStream inputstream, Writer writer, String s)
        throws IOException
    {
        if (s == null)
        {
            copy(inputstream, writer);
            return;
        } else
        {
            copy(((Reader) (new InputStreamReader(inputstream, s))), writer);
            return;
        }
    }

    public static long copyLarge(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[4096];
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (-1 != i)
            {
                outputstream.write(abyte0, 0, i);
                l += i;
            } else
            {
                return l;
            }
        } while (true);
    }

    public static long copyLarge(Reader reader, Writer writer)
        throws IOException
    {
        char ac[] = new char[4096];
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

    public static byte[] toByteArray(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        copy(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public static String toString(InputStream inputstream)
        throws IOException
    {
        return toString(inputstream, null);
    }

    public static String toString(InputStream inputstream, String s)
        throws IOException
    {
        StringBuilderWriter stringbuilderwriter = new StringBuilderWriter();
        copy(inputstream, stringbuilderwriter, s);
        return stringbuilderwriter.toString();
    }

    static 
    {
        DIR_SEPARATOR = File.separatorChar;
        StringBuilderWriter stringbuilderwriter = new StringBuilderWriter(4);
        PrintWriter printwriter = new PrintWriter(stringbuilderwriter);
        printwriter.println();
        LINE_SEPARATOR = stringbuilderwriter.toString();
        printwriter.close();
    }
}
