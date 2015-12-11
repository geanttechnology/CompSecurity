// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer

public class zzb
    implements Iterator
{

    protected final DataBuffer zzadi;
    protected int zzadj;

    public zzb(DataBuffer databuffer)
    {
        zzadi = (DataBuffer)zzx.zzw(databuffer);
        zzadj = -1;
    }

    public boolean hasNext()
    {
        return zzadj < zzadi.getCount() - 1;
    }

    public Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException((new StringBuilder("Cannot advance the iterator beyond ")).append(zzadj).toString());
        } else
        {
            DataBuffer databuffer = zzadi;
            int i = zzadj + 1;
            zzadj = i;
            return databuffer.get(i);
        }
    }

    public void remove()
    {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
