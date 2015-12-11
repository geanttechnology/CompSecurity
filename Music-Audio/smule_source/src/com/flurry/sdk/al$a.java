// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class  extends BufferedOutputStream
{

    private boolean a;

    private boolean a()
    {
        return a;
    }

    static boolean a(a a1)
    {
        return a1.a();
    }

    public void close()
    {
        try
        {
            super.close();
            return;
        }
        catch (IOException ioexception)
        {
            a = true;
            throw ioexception;
        }
    }

    public void flush()
    {
        try
        {
            super.flush();
            return;
        }
        catch (IOException ioexception)
        {
            a = true;
            throw ioexception;
        }
    }

    public void write(int i)
    {
        try
        {
            super.write(i);
            return;
        }
        catch (IOException ioexception)
        {
            a = true;
            throw ioexception;
        }
    }

    public void write(byte abyte0[])
    {
        try
        {
            super.write(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a = true;
        }
        throw abyte0;
    }

    public void write(byte abyte0[], int i, int j)
    {
        try
        {
            super.write(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a = true;
        }
        throw abyte0;
    }

    private (OutputStream outputstream)
    {
        super(outputstream);
        a = false;
    }

    (OutputStream outputstream,  )
    {
        this(outputstream);
    }
}
