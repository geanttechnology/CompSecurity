// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

// Referenced classes of package cn.jpush.android.util:
//            x

public final class aa
{

    private static final String z;

    private static String a(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            return "";
        }
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(abyte0);
        abyte0 = new ByteArrayOutputStream();
        String s;
        try
        {
            byte abyte1[] = new byte[1024];
            for (; !inflater.finished(); abyte0.write(abyte1, 0, inflater.inflate(abyte1))) { }
            break MISSING_BLOCK_LABEL_86;
        }
        catch (Exception exception) { }
        finally
        {
            inflater.end();
            try
            {
                abyte0.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                x.j();
                return "";
            }
            throw exception1;
        }
        x.j();
        inflater.end();
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            x.j();
            return "";
        }
        return "";
        s = new String(abyte0.toByteArray(), z);
        inflater.end();
        try
        {
            abyte0.close();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            x.j();
            return "";
        }
        return s;
    }

    public static String a(byte abyte0[], int i, int j)
    {
        byte abyte1[] = b(j);
        System.arraycopy(abyte0, i, abyte1, 0, abyte1.length);
        return a(abyte1);
    }

    private static byte[] a(int i)
    {
        byte abyte0[] = new byte[4];
        for (int j = 0; j < 4; j++)
        {
            abyte0[j] = (byte)(i >>> (abyte0.length - 1 - j) * 8 & 0xff);
        }

        return abyte0;
    }

    public static byte[] a(int i, int j)
    {
        boolean flag = false;
        byte abyte0[] = a(i);
        int k = 2;
        byte abyte1[] = new byte[2];
        i = abyte0.length;
        if (2 > abyte0.length)
        {
            j = 2 - abyte0.length;
            k = abyte0.length;
            i = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
            i -= 2;
        }
        System.arraycopy(abyte0, i, abyte1, j, k);
        return abyte1;
    }

    public static byte[] a(byte abyte0[], String s, int i)
    {
        try
        {
            s = s.getBytes();
            System.arraycopy(s, 0, abyte0, i, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public static int b(byte abyte0[], int i, int j)
    {
        byte abyte1[] = b(j);
        System.arraycopy(abyte0, i, abyte1, 0, abyte1.length);
        return (int)b(abyte1);
    }

    private static final long b(byte abyte0[])
    {
        long l = 0L;
        for (int i = 0; i < abyte0.length - 1; i++)
        {
            l += ((long)abyte0[i] & 255L) << (abyte0.length - 1 - i) * 8;
        }

        return l + ((long)abyte0[abyte0.length - 1] & 255L);
    }

    private static byte[] b(int i)
    {
        byte abyte0[] = new byte[i];
        for (i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = 0;
        }

        return abyte0;
    }

    public static long c(byte abyte0[], int i, int j)
    {
        byte abyte1[] = b(8);
        System.arraycopy(abyte0, 21, abyte1, 0, abyte1.length);
        return b(abyte1);
    }

    public static String d(byte abyte0[], int i, int j)
    {
        try
        {
            byte abyte1[] = b(j);
            System.arraycopy(abyte0, i, abyte1, 0, abyte1.length);
            abyte0 = new String(abyte1, z);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            x.j();
            return "";
        }
        return abyte0;
    }

    public static byte[] e(byte abyte0[], int i, int j)
    {
        try
        {
            System.arraycopy(a(i), 0, abyte0, j, 4);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            x.j();
            return null;
        }
        return abyte0;
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = ",nC<\b".toCharArray();
        j = ac.length;
        l = 0;
        i = 0;
        ac1 = ac;
        k = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        l = i;
        k = i;
_L9:
        char c1;
        ac1 = ac;
        c1 = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 135
    //                   1 141
    //                   2 147
    //                   3 152;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_152;
_L3:
        i = 48;
_L10:
label0:
        {
            ac1[k] = (char)(i ^ c1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        k = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            z = (new String(ac1)).intern();
            return;
        }
          goto _L1
_L8:
        i = 121;
          goto _L10
_L5:
        i = 58;
          goto _L10
_L6:
        i = 5;
          goto _L10
        i = 17;
          goto _L10
    }
}
