// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class <init> extends FilterOutputStream
{

    final a a;

    public void close()
    {
        try
        {
            out.close();
            return;
        }
        catch (IOException ioexception)
        {
            lose(a, true);
        }
    }

    public void flush()
    {
        try
        {
            out.flush();
            return;
        }
        catch (IOException ioexception)
        {
            lush(a, true);
        }
    }

    public void write(int i)
    {
        try
        {
            out.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            rite(a, true);
        }
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            out.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            rite(a, true);
        }
    }

    private ream(ream ream, OutputStream outputstream)
    {
        a = ream;
        super(outputstream);
    }

    ream(ream ream, OutputStream outputstream, ream ream1)
    {
        this(ream, outputstream);
    }
}
