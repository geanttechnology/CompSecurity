// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

public final class DiskLruCacheUtil
{

    static final Charset US_ASCII = Charset.forName("US-ASCII");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    private DiskLruCacheUtil()
    {
    }

    static void closeQuietly(Closeable closeable)
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

    static void deleteContents(File file)
        throws IOException
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("not a readable directory: ").append(file).toString());
        }
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            file = afile[i];
            if (file.isDirectory())
            {
                deleteContents(file);
            }
            if (!file.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file).toString());
            }
        }

    }

    static String readFully(Reader reader)
        throws IOException
    {
        Object obj;
        char ac[];
        obj = new StringWriter();
        ac = new char[1024];
_L1:
        int i = reader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        ((StringWriter) (obj)).write(ac, 0, i);
          goto _L1
        obj;
        reader.close();
        throw obj;
        obj = ((StringWriter) (obj)).toString();
        reader.close();
        return ((String) (obj));
    }

}
