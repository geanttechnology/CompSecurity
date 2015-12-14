// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.dp.logger.DPLogger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChainInputStream

public class ByteBufferChain
{

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

    public void savePositions()
    {
        mSavedPositions = new int[mBuffers.size()];
        for (int i = 0; i < mBuffers.size(); i++)
        {
            mSavedPositions[i] = ((ByteBuffer)mBuffers.get(i)).position();
        }

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
