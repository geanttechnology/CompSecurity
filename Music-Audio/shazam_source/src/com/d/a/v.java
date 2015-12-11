// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;

// Referenced classes of package com.d.a:
//            f

final class v
    implements Runnable
{

    private Context a;
    private boolean b;
    private f c;

    v(f f1, Context context, boolean flag)
    {
        c = f1;
        a = context;
        b = flag;
        super();
    }

    public final void run()
    {
        if (!f.a(c))
        {
            f.a(c, a);
        }
        f.a(c, a, b);
    }
}
