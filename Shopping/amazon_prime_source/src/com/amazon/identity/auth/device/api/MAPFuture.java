// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPCallbackErrorException

public interface MAPFuture
{

    public abstract Object get()
        throws MAPCallbackErrorException, InterruptedException, ExecutionException;

    public abstract Object get(long l, TimeUnit timeunit)
        throws MAPCallbackErrorException, InterruptedException, ExecutionException, TimeoutException;
}
