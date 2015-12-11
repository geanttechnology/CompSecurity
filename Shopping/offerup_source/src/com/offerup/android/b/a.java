// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.b;

import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.b:
//            c

public final class a
{

    private static final Bus BUS = new Bus();
    private static final c NONUIBUS = new c();

    private a()
    {
    }

    public static Bus getInstance()
    {
        return BUS;
    }

    public static Bus getNonUIInstance()
    {
        return NONUIBUS;
    }

}
