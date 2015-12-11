// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChain

public class ByteBufferChainMessageImpl
    implements Message
{

    private static final DPLogger log = new DPLogger("TComm.ByteBufferChainMessageImpl");
    private final ByteBufferChain mByteBufferChain;
    private int mPayloadSize;
    private InputStream mPreviousPayload;
    private boolean mSavedPositions;

    public ByteBufferChainMessageImpl()
    {
        this(new ByteBufferChain());
    }

    public ByteBufferChainMessageImpl(ByteBufferChain bytebufferchain)
    {
        mSavedPositions = false;
        if (bytebufferchain == null)
        {
            throw new IllegalArgumentException("ByteBufferChain cannot be null");
        } else
        {
            mByteBufferChain = bytebufferchain;
            calculatePayloadSize();
            return;
        }
    }

    public ByteBufferChainMessageImpl(ByteBuffer abytebuffer[])
    {
        mSavedPositions = false;
        mByteBufferChain = new ByteBufferChain(abytebuffer);
        calculatePayloadSize();
    }

    private void calculatePayloadSize()
    {
        mPayloadSize = mByteBufferChain.getDataSize();
    }

    private void resetByteBufferChain()
    {
        if (mSavedPositions)
        {
            mByteBufferChain.loadSavedPositions();
        }
        mByteBufferChain.savePositions();
        mSavedPositions = true;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (ByteBufferChainMessageImpl)obj;
        if (mByteBufferChain != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ByteBufferChainMessageImpl) (obj)).mByteBufferChain == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mByteBufferChain.equals(((ByteBufferChainMessageImpl) (obj)).mByteBufferChain)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public ByteBuffer[] getByteBuffers()
    {
        return mByteBufferChain.getByteBuffers();
    }

    public InputStream getPayload()
    {
        if (mPreviousPayload != null)
        {
            try
            {
                if (mPreviousPayload.available() > 0)
                {
                    throw new IllegalStateException("Unconsumed bytes found in previously returned payload. Not allowed to process multiple InputStreams returned from getPayload concurrently.");
                }
            }
            catch (IOException ioexception)
            {
                log.warn("getPayload", "unexpected exception while trying to find the size of previously returned payload", new Object[] {
                    ioexception
                });
            }
        }
        resetByteBufferChain();
        mPreviousPayload = mByteBufferChain.getInputStream();
        return mPreviousPayload;
    }

    public int getPayloadSize()
    {
        return mPayloadSize;
    }

    public int hashCode()
    {
        int i;
        if (mByteBufferChain == null)
        {
            i = 0;
        } else
        {
            i = mByteBufferChain.hashCode();
        }
        return i + 31;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ByteBufferChainMessageImpl [mByteBufferChain=").append(mByteBufferChain).append("]").toString();
    }

}
