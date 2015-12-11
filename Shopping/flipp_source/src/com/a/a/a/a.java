// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.IOException;
import java.io.OutputStream;

public abstract class a extends OutputStream
{

    public boolean a;

    public a()
    {
    }

    public final void a()
    {
        if (a)
        {
            throw new IOException("stream closed");
        } else
        {
            return;
        }
    }

    public final void write(int i)
    {
        write(new byte[] {
            (byte)i
        });
    }
}
