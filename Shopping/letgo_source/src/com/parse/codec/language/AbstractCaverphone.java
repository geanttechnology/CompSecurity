// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.codec.language;

import com.parse.codec.EncoderException;
import com.parse.codec.StringEncoder;

public abstract class AbstractCaverphone
    implements StringEncoder
{

    public AbstractCaverphone()
    {
    }

    public Object encode(Object obj)
        throws EncoderException
    {
        if (!(obj instanceof String))
        {
            throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
        } else
        {
            return encode((String)obj);
        }
    }

    public boolean isEncodeEqual(String s, String s1)
        throws EncoderException
    {
        return encode(s).equals(encode(s1));
    }
}
