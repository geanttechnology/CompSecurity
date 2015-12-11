// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChain

public interface ByteBufferBackedMessage
{

    public abstract int appendPayload(InputStream inputstream, int i)
        throws IOException;

    public abstract void appendPayload(Message message);

    public abstract ByteBufferChain getByteBufferChain();

    public abstract ByteBuffer[] getByteBuffers();

    public abstract InputStream getInputStream();

    public abstract OutputStream getOutputStream();
}
