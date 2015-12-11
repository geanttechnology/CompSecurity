// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPProxyDaemon

static class closeWriteBuffer
{

    public boolean closeWriteBuffer;
    ArrayDeque writeBuffer;

    public void add(ByteBuffer bytebuffer)
    {
        if (closeWriteBuffer)
        {
            throw new IllegalStateException("Can't add buffer to a closed write buffer");
        } else
        {
            writeBuffer.add(bytebuffer);
            return;
        }
    }

    public boolean isEmpty()
    {
        return writeBuffer.isEmpty();
    }

    public ByteBuffer peek()
    {
        return (ByteBuffer)writeBuffer.peekFirst();
    }

    public void remove()
    {
        writeBuffer.remove();
    }

    public A()
    {
        writeBuffer = new ArrayDeque();
        closeWriteBuffer = false;
    }
}
