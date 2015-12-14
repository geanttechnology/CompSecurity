// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            HttpException

public class HttpContentTooLargeException extends HttpException
{

    private int maxlen;

    public HttpContentTooLargeException(String s, int i)
    {
        super(s);
        maxlen = i;
    }

    public int getMaxLength()
    {
        return maxlen;
    }
}
