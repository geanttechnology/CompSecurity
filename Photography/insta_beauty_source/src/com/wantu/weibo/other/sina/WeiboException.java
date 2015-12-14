// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.weibo.other.sina;


public class WeiboException extends Exception
{

    private static final long serialVersionUID = 0x6979ee5a4b2fff8L;
    private int statusCode;

    public WeiboException()
    {
        statusCode = -1;
    }

    public WeiboException(int i)
    {
        statusCode = -1;
        statusCode = i;
    }

    public WeiboException(Exception exception)
    {
        super(exception);
        statusCode = -1;
    }

    public WeiboException(String s)
    {
        super(s);
        statusCode = -1;
    }

    public WeiboException(String s, int i)
    {
        super(s);
        statusCode = -1;
        statusCode = i;
    }

    public WeiboException(String s, Exception exception)
    {
        super(s, exception);
        statusCode = -1;
    }

    public WeiboException(String s, Exception exception, int i)
    {
        super(s, exception);
        statusCode = -1;
        statusCode = i;
    }

    public WeiboException(String s, Throwable throwable)
    {
        super(s, throwable);
        statusCode = -1;
    }

    public WeiboException(Throwable throwable)
    {
        super(throwable);
        statusCode = -1;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }
}
