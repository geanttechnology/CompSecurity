// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import java.util.concurrent.Future;

public class RequestHandle
{

    private final Future request;

    public RequestHandle(Future future)
    {
        request = future;
    }

    public boolean cancel(boolean flag)
    {
        return request != null && request.cancel(flag);
    }

    public boolean isCancelled()
    {
        return request != null && request.isCancelled();
    }

    public boolean isFinished()
    {
        return request == null || request.isDone();
    }
}
