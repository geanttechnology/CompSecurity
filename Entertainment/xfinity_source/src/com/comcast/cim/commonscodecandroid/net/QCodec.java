// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.net;

import com.comcast.cim.commonscodecandroid.EncoderException;
import com.comcast.cim.commonscodecandroid.StringDecoder;
import com.comcast.cim.commonscodecandroid.StringEncoder;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

// Referenced classes of package com.comcast.cim.commonscodecandroid.net:
//            RFC1522Codec, QuotedPrintableCodec

public class QCodec extends RFC1522Codec
    implements StringDecoder, StringEncoder
{

    private static final BitSet PRINTABLE_CHARS;
    private final String charset;
    private boolean encodeBlanks;

    public QCodec()
    {
        this("UTF-8");
    }

    public QCodec(String s)
    {
        encodeBlanks = false;
        charset = s;
    }

    protected byte[] doEncoding(byte abyte0[])
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        abyte0 = null;
_L4:
        return abyte0;
_L2:
        byte abyte1[] = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, abyte0);
        abyte0 = abyte1;
        if (!encodeBlanks)
        {
            continue;
        }
        int i = 0;
        do
        {
            abyte0 = abyte1;
            if (i >= abyte1.length)
            {
                continue;
            }
            if (abyte1[i] == 32)
            {
                abyte1[i] = 95;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof String)
        {
            return encode((String)obj);
        } else
        {
            throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using Q codec");
        }
    }

    public String encode(String s)
        throws EncoderException
    {
        if (s == null)
        {
            return null;
        } else
        {
            return encode(s, getDefaultCharset());
        }
    }

    public String encode(String s, String s1)
        throws EncoderException
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = encodeText(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new EncoderException(s.getMessage(), s);
        }
        return s;
    }

    public String getDefaultCharset()
    {
        return charset;
    }

    protected String getEncoding()
    {
        return "Q";
    }

    public boolean isEncodeBlanks()
    {
        return encodeBlanks;
    }

    public void setEncodeBlanks(boolean flag)
    {
        encodeBlanks = flag;
    }

    static 
    {
        PRINTABLE_CHARS = new BitSet(256);
        PRINTABLE_CHARS.set(32);
        PRINTABLE_CHARS.set(33);
        PRINTABLE_CHARS.set(34);
        PRINTABLE_CHARS.set(35);
        PRINTABLE_CHARS.set(36);
        PRINTABLE_CHARS.set(37);
        PRINTABLE_CHARS.set(38);
        PRINTABLE_CHARS.set(39);
        PRINTABLE_CHARS.set(40);
        PRINTABLE_CHARS.set(41);
        PRINTABLE_CHARS.set(42);
        PRINTABLE_CHARS.set(43);
        PRINTABLE_CHARS.set(44);
        PRINTABLE_CHARS.set(45);
        PRINTABLE_CHARS.set(46);
        PRINTABLE_CHARS.set(47);
        for (int i = 48; i <= 57; i++)
        {
            PRINTABLE_CHARS.set(i);
        }

        PRINTABLE_CHARS.set(58);
        PRINTABLE_CHARS.set(59);
        PRINTABLE_CHARS.set(60);
        PRINTABLE_CHARS.set(62);
        PRINTABLE_CHARS.set(64);
        for (int j = 65; j <= 90; j++)
        {
            PRINTABLE_CHARS.set(j);
        }

        PRINTABLE_CHARS.set(91);
        PRINTABLE_CHARS.set(92);
        PRINTABLE_CHARS.set(93);
        PRINTABLE_CHARS.set(94);
        PRINTABLE_CHARS.set(96);
        for (int k = 97; k <= 122; k++)
        {
            PRINTABLE_CHARS.set(k);
        }

        PRINTABLE_CHARS.set(123);
        PRINTABLE_CHARS.set(124);
        PRINTABLE_CHARS.set(125);
        PRINTABLE_CHARS.set(126);
    }
}
