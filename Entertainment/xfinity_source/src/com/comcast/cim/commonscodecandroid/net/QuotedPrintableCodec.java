// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.net;

import com.comcast.cim.commonscodecandroid.BinaryDecoder;
import com.comcast.cim.commonscodecandroid.BinaryEncoder;
import com.comcast.cim.commonscodecandroid.EncoderException;
import com.comcast.cim.commonscodecandroid.StringDecoder;
import com.comcast.cim.commonscodecandroid.StringEncoder;
import com.comcast.cim.commonscodecandroid.binary.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

public class QuotedPrintableCodec
    implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{

    private static final BitSet PRINTABLE_CHARS;
    private final String charset;

    public QuotedPrintableCodec()
    {
        this("UTF-8");
    }

    public QuotedPrintableCodec(String s)
    {
        charset = s;
    }

    private static final void encodeQuotedPrintable(int i, ByteArrayOutputStream bytearrayoutputstream)
    {
        bytearrayoutputstream.write(61);
        char c = Character.toUpperCase(Character.forDigit(i >> 4 & 0xf, 16));
        i = Character.toUpperCase(Character.forDigit(i & 0xf, 16));
        bytearrayoutputstream.write(c);
        bytearrayoutputstream.write(i);
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitset, byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        BitSet bitset1 = bitset;
        if (bitset == null)
        {
            bitset1 = PRINTABLE_CHARS;
        }
        bitset = new ByteArrayOutputStream();
        int i = 0;
        while (i < abyte0.length) 
        {
            byte byte0 = abyte0[i];
            int j = byte0;
            if (byte0 < 0)
            {
                j = byte0 + 256;
            }
            if (bitset1.get(j))
            {
                bitset.write(j);
            } else
            {
                encodeQuotedPrintable(j, ((ByteArrayOutputStream) (bitset)));
            }
            i++;
        }
        return bitset.toByteArray();
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof byte[])
        {
            return encode((byte[])(byte[])obj);
        }
        if (obj instanceof String)
        {
            return encode((String)obj);
        } else
        {
            throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
        }
    }

    public String encode(String s)
        throws EncoderException
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = encode(s, getDefaultCharset());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new EncoderException(s.getMessage(), s);
        }
        return s;
    }

    public String encode(String s, String s1)
        throws UnsupportedEncodingException
    {
        if (s == null)
        {
            return null;
        } else
        {
            return StringUtils.newStringUsAscii(encode(s.getBytes(s1)));
        }
    }

    public byte[] encode(byte abyte0[])
    {
        return encodeQuotedPrintable(PRINTABLE_CHARS, abyte0);
    }

    public String getDefaultCharset()
    {
        return charset;
    }

    static 
    {
        PRINTABLE_CHARS = new BitSet(256);
        for (int i = 33; i <= 60; i++)
        {
            PRINTABLE_CHARS.set(i);
        }

        for (int j = 62; j <= 126; j++)
        {
            PRINTABLE_CHARS.set(j);
        }

        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
    }
}
