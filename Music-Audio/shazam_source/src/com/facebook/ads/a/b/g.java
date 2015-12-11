// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;

// Referenced classes of package com.facebook.ads.a.b:
//            h

public abstract class g
{

    protected final h a;
    private final Context b;
    private boolean c;

    public g(Context context, h h1)
    {
        b = context;
        a = h1;
    }

    public final void a()
    {
        if (c)
        {
            return;
        }
        if (a != null)
        {
            a.b();
        }
        b();
        c = true;
        com.facebook.ads.a.f.g.a(b, "Impression logged");
    }

    protected abstract void b();
}
