// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import com.sina.weibo.sdk.exception.WeiboException;

class result
{

    private WeiboException error;
    private Object result;

    public WeiboException getError()
    {
        return error;
    }

    public Object getResult()
    {
        return result;
    }

    public (WeiboException weiboexception)
    {
        error = weiboexception;
    }

    public error(Object obj)
    {
        result = obj;
    }
}
