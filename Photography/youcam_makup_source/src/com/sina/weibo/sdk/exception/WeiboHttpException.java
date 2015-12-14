// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.exception;


// Referenced classes of package com.sina.weibo.sdk.exception:
//            WeiboException

public class WeiboHttpException extends WeiboException
{

    private static final long serialVersionUID = 1L;
    private final int mStatusCode;

    public WeiboHttpException(String s, int i)
    {
        super(s);
        mStatusCode = i;
    }

    public int getStatusCode()
    {
        return mStatusCode;
    }
}
