// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.client;


// Referenced classes of package com.penthera.virtuososdk.client:
//            ClientException

public class ServiceException extends ClientException
{

    public ServiceException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable)
    {
        super(throwable);
    }
}
