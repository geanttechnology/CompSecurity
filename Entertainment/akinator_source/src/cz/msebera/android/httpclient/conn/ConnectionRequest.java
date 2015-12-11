// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            ConnectionPoolTimeoutException

public interface ConnectionRequest
    extends Cancellable
{

    public abstract HttpClientConnection get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException;
}
