// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

// Referenced classes of package org.apache.log4j:
//            ConsoleAppender

private static class  extends OutputStream
{

    public void close()
    {
    }

    public void flush()
    {
        System.out.flush();
    }

    public void write(int i)
        throws IOException
    {
        System.out.write(i);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        System.out.write(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        System.out.write(abyte0, i, j);
    }

    public ()
    {
    }
}
