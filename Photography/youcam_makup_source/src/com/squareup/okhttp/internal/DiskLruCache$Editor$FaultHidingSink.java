// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.d;
import okio.h;
import okio.q;

class this._cls1 extends h
{

    final this._cls1 this$1;

    public void close()
    {
        try
        {
            super.close();
            return;
        }
        catch (IOException ioexception) { }
        synchronized (_fld1)
        {
            this._mth1(this._cls1.this, true);
        }
        return;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void flush()
    {
        try
        {
            super.flush();
            return;
        }
        catch (IOException ioexception) { }
        synchronized (_fld1)
        {
            this._mth1(this._cls1.this, true);
        }
        return;
        exception;
        disklrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void write(d d, long l)
    {
        try
        {
            super.write(d, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (d d) { }
        synchronized (_fld1)
        {
            this._mth1(this._cls1.this, true);
        }
        return;
        exception;
        d;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (q q)
    {
        this$1 = this._cls1.this;
        super(q);
    }
}
