// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.apache.james.mime4j.io:
//            LineNumberSource

public class LineNumberInputStream extends FilterInputStream
    implements LineNumberSource
{

    private int lineNumber;

    public LineNumberInputStream(InputStream inputstream)
    {
        super(inputstream);
        lineNumber = 1;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }

    public int read()
        throws IOException
    {
        int i = in.read();
        if (i == 10)
        {
            lineNumber = lineNumber + 1;
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = in.read(abyte0, i, j);
        for (j = i; j < i + k; j++)
        {
            if (abyte0[j] == 10)
            {
                lineNumber = lineNumber + 1;
            }
        }

        return k;
    }
}
