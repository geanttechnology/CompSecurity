// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid.net;

import com.comcast.cim.commonscodecandroid.EncoderException;
import com.comcast.cim.commonscodecandroid.binary.StringUtils;
import java.io.UnsupportedEncodingException;

abstract class RFC1522Codec
{

    RFC1522Codec()
    {
    }

    protected abstract byte[] doEncoding(byte abyte0[])
        throws EncoderException;

    protected String encodeText(String s, String s1)
        throws EncoderException, UnsupportedEncodingException
    {
        if (s == null)
        {
            return null;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append("=?");
            stringbuffer.append(s1);
            stringbuffer.append('?');
            stringbuffer.append(getEncoding());
            stringbuffer.append('?');
            stringbuffer.append(StringUtils.newStringUsAscii(doEncoding(s.getBytes(s1))));
            stringbuffer.append("?=");
            return stringbuffer.toString();
        }
    }

    protected abstract String getEncoding();
}
