// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static final class val.toIgnore extends Reader
{

    final Reader val$delegate;
    final CharMatcher val$toIgnore;

    public void close()
        throws IOException
    {
        val$delegate.close();
    }

    public int read()
        throws IOException
    {
        int i;
        do
        {
            i = val$delegate.read();
        } while (i != -1 && val$toIgnore.matches((char)i));
        return i;
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    ion(Reader reader, CharMatcher charmatcher)
    {
        val$delegate = reader;
        val$toIgnore = charmatcher;
        super();
    }
}
