// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Properties;
import java.util.zip.ZipException;

// Referenced classes of package com.tencent.open.utils:
//            o, p, b

public final class a
{

    private static final o a = new o(0x6054b50L);
    private static final p b = new p(38651);

    static p a()
    {
        return b;
    }

    public static String a(File file)
    {
        return a(file, "channelNo");
    }

    public static String a(File file, String s)
    {
        Object obj = null;
        RandomAccessFile randomaccessfile = new RandomAccessFile(file, "r");
        file = a(randomaccessfile);
        if (file != null) goto _L2; else goto _L1
_L1:
        file = obj;
        if (randomaccessfile != null)
        {
            randomaccessfile.close();
            file = obj;
        }
_L4:
        return file;
_L2:
        b b1 = new b();
        b1.a(file);
        s = b1.a.getProperty(s);
        file = s;
        if (randomaccessfile == null) goto _L4; else goto _L3
_L3:
        randomaccessfile.close();
        return s;
        file;
        s = null;
_L6:
        if (s != null)
        {
            s.close();
        }
        throw file;
        file;
        s = randomaccessfile;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static byte[] a(RandomAccessFile randomaccessfile)
    {
        int i;
        long l;
        boolean flag = true;
        l = randomaccessfile.length() - 22L;
        randomaccessfile.seek(l);
        byte abyte0[] = a.a();
        i = randomaccessfile.read();
        do
        {
            if (i == -1)
            {
                break MISSING_BLOCK_LABEL_161;
            }
            if (i == abyte0[0] && randomaccessfile.read() == abyte0[1] && randomaccessfile.read() == abyte0[2] && randomaccessfile.read() == abyte0[3])
            {
                i = ((flag) ? 1 : 0);
                break MISSING_BLOCK_LABEL_74;
            }
            l--;
            randomaccessfile.seek(l);
            i = randomaccessfile.read();
        } while (true);
_L2:
        if (i == 0)
        {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomaccessfile.seek(16L + l + 4L);
        byte abyte1[] = new byte[2];
        randomaccessfile.readFully(abyte1);
        i = (new p(abyte1)).b();
        if (i == 0)
        {
            return null;
        } else
        {
            byte abyte2[] = new byte[i];
            randomaccessfile.read(abyte2);
            return abyte2;
        }
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
