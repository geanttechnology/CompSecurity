// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.os.Handler;

// Referenced classes of package com.d.a:
//            f, ad, aj

final class t
    implements Runnable
{

    final Context a;
    final f b;
    private boolean c;

    t(f f1, boolean flag, Context context)
    {
        b = f1;
        c = flag;
        a = context;
        super();
    }

    public final void run()
    {
        f.b(b);
        f.c(b);
        if (!c)
        {
            f.e(b).postDelayed(new ad(this), f.c());
        }
        if (f.d())
        {
            f.f(b).b();
        }
    }
}
