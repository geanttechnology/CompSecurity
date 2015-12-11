// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.android.persistence.d.a;
import com.shazam.model.configuration.ChartsConfiguration;

// Referenced classes of package com.shazam.android.ao:
//            f

public final class e
    implements f
{

    private final a a;
    private final boolean b;
    private final ChartsConfiguration c;

    public e(a a1, boolean flag, ChartsConfiguration chartsconfiguration)
    {
        a = a1;
        b = flag;
        c = chartsconfiguration;
    }

    public final a a()
    {
        return a;
    }

    public final boolean b()
    {
        return b;
    }

    public final ChartsConfiguration c()
    {
        return c;
    }
}
