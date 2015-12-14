// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.datasource;

import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.datasource:
//            DataSubscriber

public interface DataSource
{

    public abstract boolean close();

    public abstract Throwable getFailureCause();

    public abstract float getProgress();

    public abstract Object getResult();

    public abstract boolean hasFailed();

    public abstract boolean hasResult();

    public abstract boolean isClosed();

    public abstract boolean isFinished();

    public abstract void subscribe(DataSubscriber datasubscriber, Executor executor);
}
