// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.validate;

import com.amazon.insights.impl.InitializationException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Validator
{

    public SHA256Validator()
    {
    }

    public void validate()
    {
        try
        {
            if (MessageDigest.getInstance("SHA-256").digest("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEF".getBytes("UTF-8")) == null)
            {
                throw new InitializationException("SHA-256 algorithm cannot hash bytes");
            }
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new InitializationException("No valid SHA-256 implementation found", nosuchalgorithmexception);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new InitializationException("UTF-8 encoding is not supported", unsupportedencodingexception);
        }
    }
}
