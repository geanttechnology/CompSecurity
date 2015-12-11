// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;

// Referenced classes of package com.vandalsoftware.io:
//            UnsafeByteSequence

public final class IoUtils
{

    public static final String UTF_8 = "UTF-8";

    private IoUtils()
    {
    }

    public static void closeQuietly(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void closeQuietly(Socket socket)
    {
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        socket.close();
        return;
        socket;
    }

    public static void deleteContents(File file)
        throws IOException
    {
        if (!file.isDirectory())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("not a directory: ").append(file).toString());
        }
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(file);
        file = new ArrayList();
        do
        {
            if (linkedlist.isEmpty())
            {
                break;
            }
            File file1 = (File)linkedlist.remove();
            File afile[] = file1.listFiles();
            if (afile != null)
            {
                int k = afile.length;
                int i = 0;
                while (i < k) 
                {
                    File file2 = afile[i];
                    if (file2.isDirectory())
                    {
                        linkedlist.add(file2);
                    } else
                    {
                        deleteFileOrThrow(file2);
                    }
                    i++;
                }
                file.add(file1);
            }
        } while (true);
        for (int j = file.size() - 1; j >= 0; j--)
        {
            deleteFileOrThrow((File)file.get(j));
        }

    }

    public static void deleteFileOrThrow(File file)
        throws IOException
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file).toString());
        } else
        {
            return;
        }
    }

    public static byte[] readFileAsByteArray(String s)
        throws IOException
    {
        return readFileAsBytes(s).toByteArray();
    }

    private static UnsafeByteSequence readFileAsBytes(String s)
        throws IOException
    {
        Object obj = null;
        s = new RandomAccessFile(s, "r");
        byte abyte0[];
        obj = new UnsafeByteSequence((int)s.length());
        abyte0 = new byte[8192];
_L1:
        int i = s.read(abyte0);
        if (i == -1)
        {
            closeQuietly(s);
            return ((UnsafeByteSequence) (obj));
        }
        ((UnsafeByteSequence) (obj)).write(abyte0, 0, i);
          goto _L1
        obj;
_L3:
        closeQuietly(s);
        throw obj;
        Exception exception;
        exception;
        s = ((String) (obj));
        obj = exception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public static String readFileAsString(String s)
        throws IOException
    {
        return readFileAsBytes(s).toString("UTF-8");
    }

    public static void renameFileOrThrow(File file, File file1)
        throws IOException
    {
        if (!file.renameTo(file1))
        {
            throw new IOException((new StringBuilder()).append("file not renamed ").append(file).append(" ").append(file1).toString());
        } else
        {
            return;
        }
    }
}
