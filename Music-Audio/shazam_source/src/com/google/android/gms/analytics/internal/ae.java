// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.g;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            ak

final class ae
    implements g
{

    private int a;
    private boolean b;

    ae()
    {
        a = 2;
    }

    public final void a()
    {
    }

    public final void a(int i)
    {
        a = i;
        if (!b)
        {
            ak.c.a();
            (new StringBuilder("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.")).append((String)ak.c.a()).append(" DEBUG");
            b = true;
        }
    }

    public final void a(String s)
    {
    }

    public final int b()
    {
        return a;
    }
}
