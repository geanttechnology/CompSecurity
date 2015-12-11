// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.binary;

import com.comcast.cim.commonscodecandroid.BinaryDecoder;
import com.comcast.cim.commonscodecandroid.BinaryEncoder;
import com.comcast.cim.commonscodecandroid.EncoderException;

public class BinaryCodec
    implements BinaryDecoder, BinaryEncoder
{

    private static final int BITS[] = {
        1, 2, 4, 8, 16, 32, 64, 128
    };
    private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
    private static final char EMPTY_CHAR_ARRAY[] = new char[0];

    public BinaryCodec()
    {
    }

    private static boolean isEmpty(byte abyte0[])
    {
        return abyte0 == null || abyte0.length == 0;
    }

    public static char[] toAsciiChars(byte abyte0[])
    {
        if (!isEmpty(abyte0)) goto _L2; else goto _L1
_L1:
        char ac[] = EMPTY_CHAR_ARRAY;
_L4:
        return ac;
_L2:
        char ac1[] = new char[abyte0.length << 3];
        int j = 0;
        int i = ac1.length - 1;
        do
        {
            ac = ac1;
            if (j >= abyte0.length)
            {
                continue;
            }
            int k = 0;
            while (k < BITS.length) 
            {
                if ((abyte0[j] & BITS[k]) == 0)
                {
                    ac1[i - k] = '0';
                } else
                {
                    ac1[i - k] = '1';
                }
                k++;
            }
            j++;
            i -= 8;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (!(obj instanceof byte[]))
        {
            throw new EncoderException("argument not a byte array");
        } else
        {
            return toAsciiChars((byte[])(byte[])obj);
        }
    }

}
