// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Encoder

public abstract class ParsingEncoder extends Encoder
{

    private long counts[];
    protected int pos;

    public ParsingEncoder()
    {
        counts = new long[10];
        pos = -1;
    }

    protected final int depth()
    {
        return pos;
    }

    protected final void pop()
    {
        if (counts[pos] != 0L)
        {
            throw new AvroTypeException((new StringBuilder()).append("Incorrect number of items written. ").append(counts[pos]).append(" more required.").toString());
        } else
        {
            pos = pos - 1;
            return;
        }
    }

    protected final void push()
    {
        if (pos == counts.length)
        {
            counts = Arrays.copyOf(counts, pos + 10);
        }
        long al[] = counts;
        int i = pos + 1;
        pos = i;
        al[i] = 0L;
    }

    public void setItemCount(long l)
        throws IOException
    {
        if (counts[pos] != 0L)
        {
            throw new AvroTypeException((new StringBuilder()).append("Incorrect number of items written. ").append(counts[pos]).append(" more required.").toString());
        } else
        {
            counts[pos] = l;
            return;
        }
    }

    public void startItem()
        throws IOException
    {
        long al[] = counts;
        int i = pos;
        al[i] = al[i] - 1L;
    }
}
