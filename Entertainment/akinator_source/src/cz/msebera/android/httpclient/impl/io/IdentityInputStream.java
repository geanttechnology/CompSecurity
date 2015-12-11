// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.io.BufferInfo;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InputStream;

public class IdentityInputStream extends InputStream
{

    private boolean closed;
    private final SessionInputBuffer in;

    public IdentityInputStream(SessionInputBuffer sessioninputbuffer)
    {
        closed = false;
        in = (SessionInputBuffer)Args.notNull(sessioninputbuffer, "Session input buffer");
    }

    public int available()
        throws IOException
    {
        if (in instanceof BufferInfo)
        {
            return ((BufferInfo)in).length();
        } else
        {
            return 0;
        }
    }

    public void close()
        throws IOException
    {
        closed = true;
    }

    public int read()
        throws IOException
    {
        if (closed)
        {
            return -1;
        } else
        {
            return in.read();
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (closed)
        {
            return -1;
        } else
        {
            return in.read(abyte0, i, j);
        }
    }
}
