// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;

public class ServiceException extends IOException
{

    public ServiceException(String s)
    {
        super(s);
    }

    public ServiceException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable)
    {
        super(throwable);
    }
}
