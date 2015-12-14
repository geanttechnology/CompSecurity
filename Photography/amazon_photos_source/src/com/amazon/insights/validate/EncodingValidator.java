// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.validate;

import com.amazon.insights.impl.InitializationException;
import java.io.UnsupportedEncodingException;

public class EncodingValidator
{

    private final String encoding;

    public EncodingValidator(String s)
    {
        encoding = s;
    }

    public void validate()
    {
        try
        {
            "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".getBytes(encoding);
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new InitializationException((new StringBuilder()).append(encoding).append(" encoding is not supported").toString(), unsupportedencodingexception);
        }
    }
}
