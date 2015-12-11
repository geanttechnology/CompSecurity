// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import java.io.IOException;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            ByteArrayQueueListener

public interface ByteArrayQueue
{

    public abstract void add(byte abyte0[], boolean flag)
        throws IOException;

    public abstract void addListener(ByteArrayQueueListener bytearrayqueuelistener);

    public abstract long getNumEntriesInQueue();

    public abstract String getQueueName();

    public abstract byte[] remove()
        throws IOException;

    public abstract void removeListener(ByteArrayQueueListener bytearrayqueuelistener);

    public abstract void setQueueName(String s);

    public abstract void shutdown();
}
