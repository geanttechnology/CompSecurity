// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class av
{

    public static byte[] a(String s)
    {
        s = new RandomAccessFile(s, "r");
        long l = s.length();
        int i;
        i = (int)l;
        if ((long)i == l)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        throw new IOException("File size >= 2 GB");
        Exception exception;
        exception;
        s.close();
        throw exception;
        byte abyte0[];
        abyte0 = new byte[i];
        s.readFully(abyte0);
        s.close();
        return abyte0;
    }

    public static boolean b(String s)
    {
        s = new File(s);
        if (s.exists())
        {
            return s.delete();
        } else
        {
            return false;
        }
    }
}
