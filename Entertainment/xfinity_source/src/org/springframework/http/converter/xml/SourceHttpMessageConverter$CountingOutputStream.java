// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.converter.xml;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.springframework.http.converter.xml:
//            SourceHttpMessageConverter

private static class <init> extends OutputStream
{

    private long count;

    public void write(int i)
        throws IOException
    {
        count = count + 1L;
    }

    public void write(byte abyte0[])
        throws IOException
    {
        count = count + (long)abyte0.length;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        count = count + (long)j;
    }


    private ()
    {
        count = 0L;
    }

    count(count count1)
    {
        this();
    }
}
