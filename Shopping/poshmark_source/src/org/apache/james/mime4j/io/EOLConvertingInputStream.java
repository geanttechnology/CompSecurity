// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class EOLConvertingInputStream extends InputStream
{

    public static final int CONVERT_BOTH = 3;
    public static final int CONVERT_CR = 1;
    public static final int CONVERT_LF = 2;
    private int flags;
    private PushbackInputStream in;
    private int previous;

    public EOLConvertingInputStream(InputStream inputstream)
    {
        this(inputstream, 3);
    }

    public EOLConvertingInputStream(InputStream inputstream, int i)
    {
        in = null;
        previous = 0;
        flags = 3;
        in = new PushbackInputStream(inputstream, 2);
        flags = i;
    }

    public void close()
        throws IOException
    {
        in.close();
    }

    public int read()
        throws IOException
    {
        int j;
        j = in.read();
        if (j == -1)
        {
            return -1;
        }
        if ((flags & 1) == 0 || j != 13) goto _L2; else goto _L1
_L1:
        int i;
        int k = in.read();
        if (k != -1)
        {
            in.unread(k);
        }
        i = j;
        if (k != 10)
        {
            in.unread(10);
            i = j;
        }
_L4:
        previous = i;
        return i;
_L2:
        i = j;
        if ((flags & 2) != 0)
        {
            i = j;
            if (j == 10)
            {
                i = j;
                if (previous != 13)
                {
                    i = 13;
                    in.unread(10);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
