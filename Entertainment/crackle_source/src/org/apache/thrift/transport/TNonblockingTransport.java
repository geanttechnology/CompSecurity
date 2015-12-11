// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.transport;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

// Referenced classes of package org.apache.thrift.transport:
//            TTransport

public abstract class TNonblockingTransport extends TTransport
{

    public TNonblockingTransport()
    {
    }

    public abstract int read(ByteBuffer bytebuffer)
        throws IOException;

    public abstract SelectionKey registerSelector(Selector selector, int i)
        throws IOException;

    public abstract int write(ByteBuffer bytebuffer)
        throws IOException;
}
