// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import c.h;
import c.r;
import java.io.IOException;

class c extends h
{

    private boolean a;

    public c(r r)
    {
        super(r);
    }

    protected void a()
    {
    }

    public final void a_(c.c c1, long l)
    {
        if (a)
        {
            c1.f(l);
            return;
        }
        try
        {
            super.a_(c1, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c.c c1)
        {
            a = true;
        }
        a();
    }

    public void close()
    {
        if (a)
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
            a = true;
        }
        a();
    }

    public void flush()
    {
        if (a)
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
            a = true;
        }
        a();
    }
}
