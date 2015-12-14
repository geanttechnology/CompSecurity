// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.exceptions;


// Referenced classes of package com.amazon.clouddrive.exceptions:
//            NoRetryException

public class NoRetryServiceException extends NoRetryException
{

    public NoRetryServiceException()
    {
    }

    public NoRetryServiceException(String s)
    {
        super(s);
    }

    public NoRetryServiceException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
