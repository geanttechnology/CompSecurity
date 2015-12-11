// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.rsc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.rio.j2me.client.rsc:
//            ServiceCall

public interface ClientRequestReply
{

    public abstract void cancelled(ServiceCall servicecall);

    public abstract void communicationError(Exception exception, ServiceCall servicecall);

    public abstract void consumeReply(InputStream inputstream, ServiceCall servicecall)
        throws IOException;

    public abstract void internalError(Exception exception, ServiceCall servicecall);

    public abstract void produceRequestData(OutputStream outputstream, ServiceCall servicecall)
        throws IOException;
}
