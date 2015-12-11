// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

// Referenced classes of package com.google.common.io:
//            ByteSource, MultiInputStream

private static final class sources extends ByteSource
{

    final Iterable sources;

    public boolean isEmpty()
        throws IOException
    {
        for (Iterator iterator = sources.iterator(); iterator.hasNext();)
        {
            if (!((ByteSource)iterator.next()).isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    public InputStream openStream()
        throws IOException
    {
        return new MultiInputStream(sources.iterator());
    }

    public long size()
        throws IOException
    {
        long l = 0L;
        for (Iterator iterator = sources.iterator(); iterator.hasNext();)
        {
            l += ((ByteSource)iterator.next()).size();
        }

        return l;
    }

    public Optional sizeIfKnown()
    {
        long l = 0L;
        for (Iterator iterator = sources.iterator(); iterator.hasNext();)
        {
            Optional optional = ((ByteSource)iterator.next()).sizeIfKnown();
            if (!optional.isPresent())
            {
                return Optional.absent();
            }
            l += ((Long)optional.get()).longValue();
        }

        return Optional.of(Long.valueOf(l));
    }

    public String toString()
    {
        String s = String.valueOf(sources);
        return (new StringBuilder(String.valueOf(s).length() + 19)).append("ByteSource.concat(").append(s).append(")").toString();
    }

    (Iterable iterable)
    {
        sources = (Iterable)Preconditions.checkNotNull(iterable);
    }
}
