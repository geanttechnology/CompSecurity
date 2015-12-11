// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;

import com.pointinside.PIException;

public class RouteException extends PIException
{

    private static final String PREFIX = "Could not complete request. ";

    public RouteException(String s)
    {
        super((new StringBuilder()).append("Could not complete request. ").append(s).toString());
    }

    public RouteException(String s, Throwable throwable)
    {
        super((new StringBuilder()).append("Could not complete request. ").append(s).toString(), throwable);
    }

    public RouteException(Throwable throwable)
    {
        super(throwable);
    }
}
