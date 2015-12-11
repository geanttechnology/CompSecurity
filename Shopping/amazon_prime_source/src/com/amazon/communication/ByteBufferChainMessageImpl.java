// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferBackedMessage, ByteBufferChain, InputStreamMessageImpl

public class ByteBufferChainMessageImpl
    implements Message, ByteBufferBackedMessage
{

    public static final int MAX_BYTE_BUFFER_BYTES_FROM_INPUTSTREAM = 16384;
    private static final DPLogger log = new DPLogger("TComm.ByteBufferChainMessageImpl");
    private final ByteBufferChain mByteBufferChain;
    private int mPayloadSize;
    private InputStream mPreviousPayload;
    private boolean mSavedPositions;

    public ByteBufferChainMessageImpl()
    {
        this(new ByteBufferChain());
    }

    public ByteBufferChainMessageImpl(Message message)
    {
        mSavedPositions = false;
        mByteBufferChain = new ByteBufferChain();
        appendPayload(message);
        calculatePayloadSize();
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

    public ByteBufferChainMessageImpl(InputStream inputstream, int i)
        throws IOException
    {
        mSavedPositions = false;
        mByteBufferChain = new ByteBufferChain();
        appendPayload(inputstream, i);
        calculatePayloadSize();
    }

    public ByteBufferChainMessageImpl(ByteBuffer bytebuffer)
    {
        mSavedPositions = false;
        mByteBufferChain = new ByteBufferChain(bytebuffer);
        calculatePayloadSize();
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

    private void enforceSavedPositions()
    {
        if (mSavedPositions)
        {
            throw new IllegalStateException("Message can't be modified once getPayload is called.");
        } else
        {
            return;
        }
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

    public int appendPayload(InputStream inputstream, int i)
        throws IOException
    {
        enforceSavedPositions();
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream can't be null");
        }
        if (i < 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Payload bytes can't be 0 or negative. payloadBytes: ").append(i).toString());
        }
        int j;
        int k;
        try
        {
            j = inputstream.available();
            k = mByteBufferChain.append(inputstream, i);
        }
        catch (IOException ioexception)
        {
            log.error("appendPayload", "IOException when reading data from InputStream", new Object[] {
                "inputStream", inputstream, "payloadBytes", Integer.valueOf(i), ioexception
            });
            throw ioexception;
        }
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        calculatePayloadSize();
        log.debug("appendPayload", "finished appending", new Object[] {
            "bytesRead", Integer.valueOf(k), "availableBytes", Integer.valueOf(j), "mByteBufferChain.getDataSize", Integer.valueOf(mByteBufferChain.getDataSize()), "payloadBytes", Integer.valueOf(i)
        });
        return k;
    }

    public void appendPayload(Message message)
    {
        enforceSavedPositions();
        if (message.getPayloadSize() == 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        if (!(message instanceof ByteBufferBackedMessage)) goto _L2; else goto _L1
_L1:
        mByteBufferChain.append(((ByteBufferBackedMessage)message).getByteBufferChain());
_L4:
        calculatePayloadSize();
        return;
_L2:
        if (!(message instanceof InputStreamMessageImpl))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        message = message.getPayload();
        if (appendPayload(((InputStream) (message)), 16384) != 16384 || message.available() <= 0 || message.read() == -1) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException("InputStreamMessageImpl has more bytes than our limit. Can't make copy");
        message;
        throw new UnsupportedOperationException("IOException when reading data from InputStreamMessageImpl", message);
        throw new IllegalArgumentException("Message is not backed up by ByteBuffers or InputStream. Something wrong here.");
        log.verbose("appendPayload", "attempting to append a Message with zero content", new Object[0]);
        return;
    }

    public void appendPayload(ByteBuffer bytebuffer)
    {
        enforceSavedPositions();
        if (bytebuffer != null && bytebuffer.hasRemaining())
        {
            mByteBufferChain.append(bytebuffer);
            calculatePayloadSize();
            return;
        } else
        {
            log.verbose("appendPayload", "attempting to append a ByteBuffer with zero content", new Object[0]);
            return;
        }
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

    public Message extractPayload()
    {
        return new ByteBufferChainMessageImpl(new ByteBufferChain(mByteBufferChain));
    }

    public ByteBufferChain getByteBufferChain()
    {
        return mByteBufferChain;
    }

    public ByteBuffer[] getByteBuffers()
    {
        return mByteBufferChain.getByteBuffers();
    }

    public InputStream getInputStream()
    {
        return mByteBufferChain.getInputStream();
    }

    public OutputStream getOutputStream()
    {
        return mByteBufferChain.getOutputStream();
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

    public void prependPayload(ByteBuffer bytebuffer)
    {
        enforceSavedPositions();
        if (bytebuffer != null && bytebuffer.hasRemaining())
        {
            mByteBufferChain.prepend(bytebuffer);
            calculatePayloadSize();
            return;
        } else
        {
            log.verbose("prependPayload", "attempting to prepend a ByteBuffer with zero content", new Object[0]);
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("ByteBufferChainMessageImpl [mByteBufferChain=").append(mByteBufferChain).append("]").toString();
    }

}
