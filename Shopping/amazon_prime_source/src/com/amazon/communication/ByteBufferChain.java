// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChainInputStream, ByteBufferChainOutputStream

public class ByteBufferChain
{

    static final int MAX_BUFFERS_IN_TOSTRING = 30;
    private static final DPLogger log = new DPLogger("TComm.ByteBufferChain");
    private ByteBuffer mBufferArray[];
    private final List mBuffers;
    private int mSavedPositions[];

    public ByteBufferChain()
    {
        mBuffers = new ArrayList();
        mBufferArray = null;
        mSavedPositions = null;
    }

    public ByteBufferChain(ByteBufferChain bytebufferchain)
    {
        if (bytebufferchain.mBuffers != null)
        {
            mBufferArray = new ByteBuffer[bytebufferchain.mBuffers.size()];
            mBuffers = new ArrayList(bytebufferchain.mBuffers.size());
            for (int i = 0; i < mBufferArray.length; i++)
            {
                ByteBuffer bytebuffer = ((ByteBuffer)bytebufferchain.mBuffers.get(i)).duplicate();
                mBufferArray[i] = bytebuffer;
                mBuffers.add(bytebuffer);
            }

        } else
        {
            mBuffers = new ArrayList();
            mBufferArray = null;
        }
        mSavedPositions = bytebufferchain.mSavedPositions;
    }

    public ByteBufferChain(ByteBuffer bytebuffer)
    {
        mBuffers = new ArrayList();
        mBuffers.add(bytebuffer);
        mBufferArray = null;
        mSavedPositions = null;
    }

    public ByteBufferChain(ByteBuffer abytebuffer[])
    {
        mBufferArray = abytebuffer;
        mBuffers = new ArrayList(abytebuffer.length);
        int j = abytebuffer.length;
        for (int i = 0; i < j; i++)
        {
            ByteBuffer bytebuffer = abytebuffer[i];
            mBuffers.add(bytebuffer);
        }

    }

    public int append(InputStream inputstream, int i)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("InputStream can't be null");
        }
        if (i < 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Size upper bound cannot be 0 or negative. upperBoundSize: ").append(i).toString());
        }
        byte abyte0[] = new byte[i];
        int j = inputstream.read(abyte0);
        if (j > 0)
        {
            append(ByteBuffer.wrap(abyte0, 0, j));
        }
        log.debug("append", "finished appending", new Object[] {
            "bytesRead", Integer.valueOf(j), "upperBoundSize", Integer.valueOf(i)
        });
        return j;
    }

    public ByteBufferChain append(ByteBufferChain bytebufferchain)
    {
        if (bytebufferchain == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't append null ByteBufferChain. Chain: ").append(bytebufferchain).toString());
        }
        if (bytebufferchain.getDataSize() == 0)
        {
            log.warn("append", "attempting to append a ByteBufferChain with zero content; skipping", new Object[0]);
        } else
        {
            int i = 0;
            while (i < bytebufferchain.mBuffers.size()) 
            {
                append((ByteBuffer)bytebufferchain.mBuffers.get(i));
                i++;
            }
        }
        return this;
    }

    public ByteBufferChain append(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null || !bytebuffer.hasRemaining())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't append null or empty ByteBuffer. newData: ").append(bytebuffer).toString());
        } else
        {
            mBuffers.add(bytebuffer);
            return this;
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
        obj = (ByteBufferChain)obj;
        if (mBuffers != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ByteBufferChain) (obj)).mBuffers == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mBuffers.equals(((ByteBufferChain) (obj)).mBuffers)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public List getByteBufferList()
    {
        return Collections.unmodifiableList(mBuffers);
    }

    public ByteBuffer[] getByteBuffers()
    {
        if (mBufferArray == null || mBufferArray.length != mBuffers.size())
        {
            mBufferArray = (ByteBuffer[])mBuffers.toArray(new ByteBuffer[mBuffers.size()]);
        }
        return mBufferArray;
    }

    public int getDataSize()
    {
        int j = 0;
        for (int i = 0; i < mBuffers.size(); i++)
        {
            j += ((ByteBuffer)mBuffers.get(i)).remaining();
        }

        return j;
    }

    public ByteBufferChainInputStream getInputStream()
    {
        return new ByteBufferChainInputStream(this);
    }

    public ByteBufferChainOutputStream getOutputStream()
    {
        return new ByteBufferChainOutputStream(this);
    }

    public int hashCode()
    {
        int i;
        if (mBuffers == null)
        {
            i = 0;
        } else
        {
            i = mBuffers.hashCode();
        }
        return i + 31;
    }

    public void loadSavedPositions()
    {
        if (mSavedPositions == null || mBuffers.size() != mSavedPositions.length)
        {
            throw new IllegalStateException("loadSavedPositionsForAll cannot be called without a matching savePositionsForAll being called");
        }
        for (int i = 0; i < mBuffers.size(); i++)
        {
            ((ByteBuffer)mBuffers.get(i)).position(mSavedPositions[i]);
        }

    }

    public void mark()
    {
        for (int i = 0; i < mBuffers.size(); i++)
        {
            ((ByteBuffer)mBuffers.get(i)).mark();
        }

    }

    public ByteBufferChain prepend(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null || !bytebuffer.hasRemaining())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can't prepend null or empty ByteBuffer. newData: ").append(bytebuffer).toString());
        } else
        {
            mBuffers.add(0, bytebuffer);
            return this;
        }
    }

    public void reset()
    {
        for (int i = 0; i < mBuffers.size(); i++)
        {
            ((ByteBuffer)mBuffers.get(i)).reset();
        }

    }

    public void savePositions()
    {
        mSavedPositions = new int[mBuffers.size()];
        for (int i = 0; i < mBuffers.size(); i++)
        {
            mSavedPositions[i] = ((ByteBuffer)mBuffers.get(i)).position();
        }

    }

    public boolean shrinkLimitFromEnd(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Can not shrink negative number of bytes.");
        }
        int j = mBuffers.size() - 1;
        while (i > 0 && j >= 0) 
        {
            ByteBuffer bytebuffer = (ByteBuffer)mBuffers.get(j);
            int k;
            if (bytebuffer.remaining() < i)
            {
                k = bytebuffer.remaining();
            } else
            {
                k = i;
            }
            bytebuffer.limit(bytebuffer.limit() - k);
            i -= k;
            j--;
        }
        return i == 0;
    }

    public boolean skipBytes(int i)
    {
        if (i < 0)
        {
            throw new IllegalArgumentException("Can not skip negative number of bytes.");
        }
        int j = 0;
        while (i > 0 && j < mBuffers.size()) 
        {
            ByteBuffer bytebuffer = (ByteBuffer)mBuffers.get(j);
            int k;
            if (bytebuffer.remaining() < i)
            {
                k = bytebuffer.remaining();
            } else
            {
                k = i;
            }
            bytebuffer.position(bytebuffer.position() + k);
            i -= k;
            j++;
        }
        return i == 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ByteBufferChain [mBuffers=");
        int i = 0;
        for (Iterator iterator = mBuffers.iterator(); iterator.hasNext() && i < 30; i++)
        {
            stringbuilder.append((new StringBuilder()).append(iterator.next()).append(" ").toString());
        }

        if (mBuffers.size() > 30)
        {
            stringbuilder.append((new StringBuilder()).append("(").append(mBuffers.size() - 30).append(" more ...)").toString());
        }
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

}
