// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import org.springframework.core.NestedRuntimeException;

public class RestClientException extends NestedRuntimeException
{

    public RestClientException(String s)
    {
        super(s);
    }

    public RestClientException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
