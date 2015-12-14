// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;

public class cp
{

    private short a;

    public cp(short word0)
    {
        a = word0;
    }

    public static int a(int i)
    {
        if (i <= 127)
        {
            return 1;
        }
        if (i <= 255)
        {
            return 2;
        }
        return i > 65535 ? 5 : 3;
    }

    public static int a(byte abyte0[], int i)
    {
        int k = abyte0[i] & 0xff;
        int j;
        if (k == 129)
        {
            j = abyte0[i + 1] & 0xff;
        } else
        {
            if (k == 130)
            {
                return ((abyte0[i + 1] & 0xff) << 8) + (abyte0[i + 2] & 0xff);
            }
            j = k;
            if (k == 132)
            {
                return ((abyte0[i + 1] & 0xff) << 24) + ((abyte0[i + 2] & 0xff) << 16) + ((abyte0[i + 3] & 0xff) << 8) + (abyte0[i + 4] & 0xff);
            }
        }
        return j;
    }

    public final byte[] a(byte abyte0[])
    {
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(a & 0xff);
        if (abyte0.length <= 65535) goto _L2; else goto _L1
_L1:
        bytearrayoutputstream.write(132);
        bytearrayoutputstream.write(abyte0.length >>> 24);
        bytearrayoutputstream.write(abyte0.length >> 16 & 0xff);
        bytearrayoutputstream.write(abyte0.length >> 8 & 0xff);
        bytearrayoutputstream.write(abyte0.length & 0xff);
_L4:
        bytearrayoutputstream.write(abyte0, 0, abyte0.length);
        return bytearrayoutputstream.toByteArray();
_L2:
        if (abyte0.length > 255)
        {
            bytearrayoutputstream.write(130);
            bytearrayoutputstream.write(abyte0.length >> 8 & 0xff);
            bytearrayoutputstream.write(abyte0.length & 0xff);
        } else
        if (abyte0.length > 127)
        {
            bytearrayoutputstream.write(129);
            bytearrayoutputstream.write(abyte0.length);
        } else
        if (abyte0.length >= 0)
        {
            bytearrayoutputstream.write(abyte0.length);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final short c()
    {
        return a;
    }
}
