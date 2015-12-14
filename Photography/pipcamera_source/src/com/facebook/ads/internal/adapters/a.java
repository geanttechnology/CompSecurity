// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.util.g;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            b

public abstract class a
{

    protected final b a;
    private final Context b;
    private boolean c;

    public a(Context context, b b1)
    {
        b = context;
        a = b1;
    }

    public final void a()
    {
        if (!c)
        {
            if (a != null)
            {
                a.d();
            }
            b();
            c = true;
            g.a(b, "Impression logged");
            if (a != null)
            {
                a.e();
                return;
            }
        }
    }

    protected abstract void b();
}
