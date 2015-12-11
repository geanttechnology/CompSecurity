// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter;

import org.springframework.core.NestedRuntimeException;

public class HttpMessageConversionException extends NestedRuntimeException
{

    public HttpMessageConversionException(String s)
    {
        super(s);
    }

    public HttpMessageConversionException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
