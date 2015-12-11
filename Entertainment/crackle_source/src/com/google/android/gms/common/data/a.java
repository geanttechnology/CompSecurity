// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.internal.eg;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer

public final class a
    implements Iterator
{

    private final DataBuffer mDataBuffer;
    private int nF;

    public a(DataBuffer databuffer)
    {
        mDataBuffer = (DataBuffer)eg.f(databuffer);
        nF = -1;
    }

    public boolean hasNext()
    {
        return nF < mDataBuffer.getCount() - 1;
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder()).append("Cannot advance the iterator beyond ").append(nF).toString());
        } else
        {
            DataBuffer databuffer = mDataBuffer;
            int i = nF + 1;
            nF = i;
            return databuffer.get(i);
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
