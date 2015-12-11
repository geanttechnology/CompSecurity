// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.service;

import java.util.concurrent.Callable;

// Referenced classes of package commonlib.service:
//            WakeLockExecutorService

protected class delegate
    implements Callable
{

    private Callable _flddelegate;
    final WakeLockExecutorService this$0;

    public Object call()
        throws Exception
    {
        Object obj = _flddelegate.call();
        releaseLock();
        return obj;
        Exception exception;
        exception;
        releaseLock();
        throw exception;
    }

    public (Callable callable)
    {
        this$0 = WakeLockExecutorService.this;
        super();
        _flddelegate = callable;
    }
}
