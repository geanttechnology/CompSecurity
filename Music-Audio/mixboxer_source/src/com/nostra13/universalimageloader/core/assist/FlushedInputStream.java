// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FlushedInputStream extends FilterInputStream
{

    public FlushedInputStream(InputStream inputstream)
    {
        super(inputstream);
    }

    public long skip(long l)
        throws IOException
    {
        long l1 = 0L;
        do
        {
            long l2;
label0:
            {
label1:
                {
                    if (l1 < l)
                    {
                        long l3 = in.skip(l - l1);
                        l2 = l3;
                        if (l3 != 0L)
                        {
                            break label0;
                        }
                        if (read() >= 0)
                        {
                            break label1;
                        }
                    }
                    return l1;
                }
                l2 = 1L;
            }
            l1 += l2;
        } while (true);
    }
}
