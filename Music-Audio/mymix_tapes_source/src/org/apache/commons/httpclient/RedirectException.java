// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;


// Referenced classes of package org.apache.commons.httpclient:
//            ProtocolException

public class RedirectException extends ProtocolException
{

    public RedirectException()
    {
    }

    public RedirectException(String s)
    {
        super(s);
    }

    public RedirectException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
