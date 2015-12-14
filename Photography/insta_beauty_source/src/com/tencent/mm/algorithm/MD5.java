// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public final class MD5
{

    private MD5()
    {
    }

    public static String getMD5(File file)
    {
        return getMD5(file, 0x19000);
    }

    public static String getMD5(File file, int i)
    {
        if (file == null || i <= 0 || !file.exists())
        {
            return null;
        }
        Object obj = new FileInputStream(file);
        long l = i;
        if (l > file.length()) goto _L2; else goto _L1
_L1:
        l = i;
_L4:
        file = getMD5(((FileInputStream) (obj)), (int)l);
        ((FileInputStream) (obj)).close();
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return file;
        }
        return file;
_L2:
        l = file.length();
        if (true) goto _L4; else goto _L3
_L3:
        file;
        file = null;
_L8:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return null;
        file;
        obj = null;
_L6:
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw file;
        file;
        if (true) goto _L6; else goto _L5
_L5:
        file;
        file = ((File) (obj));
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String getMD5(File file, int i, int j)
    {
        if (file == null || !file.exists() || i < 0 || j <= 0)
        {
            return null;
        }
        file = new FileInputStream(file);
        String s;
        s = getMD5(((FileInputStream) (file)), 0x19000, i, j);
        file.close();
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return s;
        }
        return s;
        file;
        file = null;
_L4:
        Object obj;
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        return null;
        obj;
        file = null;
_L2:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        throw obj;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static final String getMD5(FileInputStream fileinputstream, int i)
    {
        boolean flag;
        flag = false;
        if (fileinputstream == null || i <= 0)
        {
            return null;
        }
        StringBuilder stringbuilder;
        MessageDigest messagedigest;
        byte abyte0[];
        messagedigest = MessageDigest.getInstance("MD5");
        stringbuilder = new StringBuilder(32);
        abyte0 = new byte[i];
_L1:
        i = fileinputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (FileInputStream fileinputstream)
            {
                return null;
            }
        }
          goto _L1
        fileinputstream = messagedigest.digest();
        i = ((flag) ? 1 : 0);
_L3:
        if (i >= fileinputstream.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(Integer.toString((fileinputstream[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        fileinputstream = stringbuilder.toString();
        return fileinputstream;
    }

    public static final String getMD5(FileInputStream fileinputstream, int i, int j, int k)
    {
        boolean flag = false;
        if (fileinputstream != null && i > 0 && j >= 0 && k > 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        long l = j;
        if (fileinputstream.skip(l) < (long)j) goto _L1; else goto _L3
_L3:
        StringBuilder stringbuilder;
        MessageDigest messagedigest;
        byte abyte0[];
        messagedigest = MessageDigest.getInstance("MD5");
        stringbuilder = new StringBuilder(32);
        abyte0 = new byte[i];
        i = 0;
_L4:
        try
        {
            j = fileinputstream.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (FileInputStream fileinputstream)
        {
            return null;
        }
        if (j == -1 || i >= k)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (i + j > k)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        messagedigest.update(abyte0, 0, j);
        i += j;
          goto _L4
        messagedigest.update(abyte0, 0, k - i);
        i = k;
          goto _L4
        fileinputstream = messagedigest.digest();
        i = ((flag) ? 1 : 0);
_L6:
        if (i >= fileinputstream.length)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(Integer.toString((fileinputstream[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        fileinputstream = stringbuilder.toString();
        return fileinputstream;
    }

    public static String getMD5(String s)
    {
        if (s != null)
        {
            if ((s = new File(s)).exists())
            {
                return getMD5(((File) (s)), 0x19000);
            }
        }
        return null;
    }

    public static String getMD5(String s, int i, int j)
    {
        if (s != null)
        {
            if ((s = new File(s)).exists())
            {
                return getMD5(((File) (s)), i, j);
            }
        }
        return null;
    }

    public static final String getMessageDigest(byte abyte0[])
    {
_L2:
        abyte0 = new String(ac1);
        return abyte0;
        int i = 0;
        char ac[] = new char[16];
        ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        char ac1[];
        int j;
        int k;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
            k = abyte0.length;
            ac1 = new char[k * 2];
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        j = 0;
        while (i < k) 
        {
            byte byte0 = abyte0[i];
            int l = j + 1;
            ac1[j] = ac[byte0 >>> 4 & 0xf];
            j = l + 1;
            ac1[l] = ac[byte0 & 0xf];
            i++;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final byte[] getRawDigest(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }
}
