// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.view.View;

// Referenced classes of package com.appnexus.opensdk:
//            u, r, ac

final class s
    implements u
{

    private long a;
    private r b;
    private boolean c;
    private ac d;

    s(r r1, Long long1, boolean flag, ac ac)
    {
        a = long1.longValue();
        b = r1;
        c = flag;
        d = ac;
    }

    public final long a()
    {
        return a;
    }

    public final View b()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.b();
        }
    }
}
