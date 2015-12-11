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

public class URLCodec
    implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{

    protected static byte ESCAPE_CHAR = 37;
    protected static final BitSet WWW_FORM_URL;
    protected String charset;

    public URLCodec()
    {
        this("UTF-8");
    }

    public URLCodec(String s)
    {
        charset = s;
    }

    public static final byte[] encodeUrl(BitSet bitset, byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        }
        BitSet bitset1 = bitset;
        if (bitset == null)
        {
            bitset1 = WWW_FORM_URL;
        }
        bitset = new ByteArrayOutputStream();
        int j = 0;
        while (j < abyte0.length) 
        {
            byte byte0 = abyte0[j];
            int i = byte0;
            if (byte0 < 0)
            {
                i = byte0 + 256;
            }
            if (bitset1.get(i))
            {
                int k = i;
                if (i == 32)
                {
                    k = 43;
                }
                bitset.write(k);
            } else
            {
                bitset.write(ESCAPE_CHAR);
                char c = Character.toUpperCase(Character.forDigit(i >> 4 & 0xf, 16));
                i = Character.toUpperCase(Character.forDigit(i & 0xf, 16));
                bitset.write(c);
                bitset.write(i);
            }
            j++;
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
            throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be URL encoded");
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
        return encodeUrl(WWW_FORM_URL, abyte0);
    }

    public String getDefaultCharset()
    {
        return charset;
    }

    public String getEncoding()
    {
        return charset;
    }

    static 
    {
        WWW_FORM_URL = new BitSet(256);
        for (int i = 97; i <= 122; i++)
        {
            WWW_FORM_URL.set(i);
        }

        for (int j = 65; j <= 90; j++)
        {
            WWW_FORM_URL.set(j);
        }

        for (int k = 48; k <= 57; k++)
        {
            WWW_FORM_URL.set(k);
        }

        WWW_FORM_URL.set(45);
        WWW_FORM_URL.set(95);
        WWW_FORM_URL.set(46);
        WWW_FORM_URL.set(42);
        WWW_FORM_URL.set(32);
    }
}
