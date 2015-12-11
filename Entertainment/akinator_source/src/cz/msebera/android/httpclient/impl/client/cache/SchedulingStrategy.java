// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import java.io.Closeable;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            AsynchronousValidationRequest

public interface SchedulingStrategy
    extends Closeable
{

    public abstract void schedule(AsynchronousValidationRequest asynchronousvalidationrequest);
}
