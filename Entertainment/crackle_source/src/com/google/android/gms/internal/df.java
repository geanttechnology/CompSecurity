// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            dk, dm

public abstract class df
{

    protected final dk lx;
    private final String ly;
    private dm lz;

    protected df(String s, String s1)
    {
        ly = s;
        lx = new dk(s1);
    }

    public void B(String s)
    {
    }

    public void a(long l, int i)
    {
    }

    public final void a(dm dm1)
    {
        lz = dm1;
        if (lz == null)
        {
            aT();
        }
    }

    protected final void a(String s, long l, String s1)
        throws IOException
    {
        lx.a("Sending text message: %s to: %s", new Object[] {
            s, s1
        });
        lz.a(ly, s, l, s1);
    }

    protected final long aS()
    {
        return lz.aR();
    }

    public void aT()
    {
    }

    public final String getNamespace()
    {
        return ly;
    }
}
