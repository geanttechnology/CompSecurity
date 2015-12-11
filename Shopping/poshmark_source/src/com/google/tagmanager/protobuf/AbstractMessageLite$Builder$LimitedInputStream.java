// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.tagmanager.protobuf:
//            AbstractMessageLite

static final class limit extends FilterInputStream
{

    private int limit;

    public int available()
        throws IOException
    {
        return Math.min(super.available(), limit);
    }

    public int read()
        throws IOException
    {
        int i;
        if (limit <= 0)
        {
            i = -1;
        } else
        {
            int j = super.read();
            i = j;
            if (j >= 0)
            {
                limit = limit - 1;
                return j;
            }
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (limit <= 0)
        {
            i = -1;
        } else
        {
            j = super.read(abyte0, i, Math.min(j, limit));
            i = j;
            if (j >= 0)
            {
                limit = limit - j;
                return j;
            }
        }
        return i;
    }

    public long skip(long l)
        throws IOException
    {
        l = super.skip(Math.min(l, limit));
        if (l >= 0L)
        {
            limit = (int)((long)limit - l);
        }
        return l;
    }

    (InputStream inputstream, int i)
    {
        super(inputstream);
        limit = i;
    }
}
