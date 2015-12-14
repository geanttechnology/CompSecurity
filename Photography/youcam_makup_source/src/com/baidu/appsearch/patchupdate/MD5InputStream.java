// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;

// Referenced classes of package com.baidu.appsearch.patchupdate:
//            MD5

public class MD5InputStream extends FilterInputStream
{

    private MD5 md5;

    public MD5InputStream(InputStream inputstream)
    {
        super(inputstream);
        md5 = new MD5();
    }

    public static void main(String args[])
    {
        String s;
        BufferedInputStream bufferedinputstream;
        MessageDigest messagedigest;
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        try
        {
            s = args[args.length - 1];
        }
        // Misplaced declaration of an exception variable
        catch (String args[])
        {
            args.printStackTrace();
            return;
        }
        i = 0;
        flag1 = true;
        flag = false;
_L3:
        if (i >= args.length - 1)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (args[i].equals("--use-default-md5"))
        {
            flag2 = true;
            break MISSING_BLOCK_LABEL_253;
        }
        flag2 = flag;
        if (args[i].equals("--no-native-lib"))
        {
            flag1 = false;
            flag2 = flag;
        }
        break MISSING_BLOCK_LABEL_253;
        args = new byte[0x10000];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
        messagedigest = MessageDigest.getInstance("MD5");
_L1:
        i = bufferedinputstream.read(args);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        messagedigest.update(args, 0, i);
          goto _L1
        System.out.println((new StringBuilder()).append(MD5.asHex(messagedigest.digest())).append("  ").append(s).toString());
        bufferedinputstream.close();
        return;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        MD5.initNativeLibrary(true);
        MD5InputStream md5inputstream;
        for (md5inputstream = new MD5InputStream(new BufferedInputStream(new FileInputStream(s))); md5inputstream.read(args) != -1;) { }
        System.out.println((new StringBuilder()).append(MD5.asHex(md5inputstream.hash())).append("  ").append(s).toString());
        md5inputstream.close();
        return;
        i++;
        flag = flag2;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public MD5 getMD5()
    {
        return md5;
    }

    public byte[] hash()
    {
        return md5.finalEncode();
    }

    public int read()
    {
        int i = in.read();
        if (i == -1)
        {
            return -1;
        }
        if ((i & 0xffffff00) != 0)
        {
            System.out.println("MD5InputStream.read() got character with (c & ~0xff) != 0)!");
        } else
        {
            md5.update(i);
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
    {
        j = in.read(abyte0, i, j);
        if (j == -1)
        {
            return j;
        } else
        {
            md5.update(abyte0, i, j);
            return j;
        }
    }
}
