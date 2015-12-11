// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import java.io.IOException;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static final class val.afterEveryChars
    implements Appendable
{

    int charsUntilSeparator;
    final int val$afterEveryChars;
    final Appendable val$delegate;
    final String val$separator;

    public Appendable append(char c)
        throws IOException
    {
        if (charsUntilSeparator == 0)
        {
            val$delegate.append(val$separator);
            charsUntilSeparator = val$afterEveryChars;
        }
        val$delegate.append(c);
        charsUntilSeparator = charsUntilSeparator - 1;
        return this;
    }

    public Appendable append(CharSequence charsequence)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public Appendable append(CharSequence charsequence, int i, int j)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    ion(int i, Appendable appendable, String s)
    {
        val$afterEveryChars = i;
        val$delegate = appendable;
        val$separator = s;
        super();
        charsUntilSeparator = val$afterEveryChars;
    }
}
