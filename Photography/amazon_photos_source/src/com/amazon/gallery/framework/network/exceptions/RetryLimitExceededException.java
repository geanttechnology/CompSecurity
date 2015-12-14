// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.exceptions;


// Referenced classes of package com.amazon.gallery.framework.network.exceptions:
//            AcceptableTerminalException

public class RetryLimitExceededException extends AcceptableTerminalException
{

    public RetryLimitExceededException(Exception exception)
    {
        super("Maximum number of retries reached", exception);
    }
}
