// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import d.aa;
import d.f;
import d.m;
import java.io.IOException;

class FaultHidingSink extends m
{

    private boolean hasErrors;

    public FaultHidingSink(aa aa)
    {
        super(aa);
    }

    public void close()
    {
        if (hasErrors)
        {
            return;
        }
        try
        {
            super.close();
            return;
        }
        catch (IOException ioexception)
        {
            hasErrors = true;
            onException(ioexception);
            return;
        }
    }

    public void flush()
    {
        if (hasErrors)
        {
            return;
        }
        try
        {
            super.flush();
            return;
        }
        catch (IOException ioexception)
        {
            hasErrors = true;
            onException(ioexception);
            return;
        }
    }

    protected void onException(IOException ioexception)
    {
    }

    public void write(f f1, long l)
    {
        if (hasErrors)
        {
            f1.f(l);
            return;
        }
        try
        {
            super.write(f1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            hasErrors = true;
        }
        onException(f1);
    }
}
