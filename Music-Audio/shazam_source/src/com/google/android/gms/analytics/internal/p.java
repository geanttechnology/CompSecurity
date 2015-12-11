// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            o, r

public abstract class p extends o
{

    private boolean a;
    private boolean b;

    public p(r r)
    {
        super(r);
    }

    public abstract void a();

    public final boolean n()
    {
        return a && !b;
    }

    protected final void o()
    {
        if (!n())
        {
            throw new IllegalStateException("Not initialized");
        } else
        {
            return;
        }
    }

    public final void p()
    {
        a();
        a = true;
    }
}
