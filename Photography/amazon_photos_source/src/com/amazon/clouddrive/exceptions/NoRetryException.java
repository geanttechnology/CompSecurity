// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.exceptions;


// Referenced classes of package com.amazon.clouddrive.exceptions:
//            CloudDriveException

public class NoRetryException extends CloudDriveException
{

    public NoRetryException()
    {
    }

    public NoRetryException(String s)
    {
        super(s);
    }

    public NoRetryException(String s, String s1, String s2)
    {
        super(s, s1, s2);
    }

    public NoRetryException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
