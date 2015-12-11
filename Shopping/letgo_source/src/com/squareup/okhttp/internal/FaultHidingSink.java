// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import android.support.v7.apv;
import android.support.v7.aqa;
import android.support.v7.aqj;
import java.io.IOException;

class FaultHidingSink extends aqa
{

    private boolean hasErrors;

    public FaultHidingSink(aqj aqj)
    {
        super(aqj);
    }

    public void close()
        throws IOException
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
        throws IOException
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

    public void write(apv apv1, long l)
        throws IOException
    {
        if (hasErrors)
        {
            apv1.g(l);
            return;
        }
        try
        {
            super.write(apv1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (apv apv1)
        {
            hasErrors = true;
        }
        onException(apv1);
    }
}
