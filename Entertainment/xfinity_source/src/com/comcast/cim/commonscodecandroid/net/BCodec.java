// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.net;

import com.comcast.cim.commonscodecandroid.EncoderException;
import com.comcast.cim.commonscodecandroid.StringDecoder;
import com.comcast.cim.commonscodecandroid.StringEncoder;
import com.comcast.cim.commonscodecandroid.binary.Base64;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.comcast.cim.commonscodecandroid.net:
//            RFC1522Codec

public class BCodec extends RFC1522Codec
    implements StringDecoder, StringEncoder
{

    private final String charset;

    public BCodec()
    {
        this("UTF-8");
    }

    public BCodec(String s)
    {
        charset = s;
    }

    protected byte[] doEncoding(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return Base64.encodeBase64(abyte0);
        }
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
            throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using BCodec");
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
        return "B";
    }
}
