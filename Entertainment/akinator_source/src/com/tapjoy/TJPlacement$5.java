// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import com.tapjoy.internal.gd;
import com.tapjoy.internal.gk;

// Referenced classes of package com.tapjoy:
//            TJPlacement

final class a
    implements Runnable
{

    final TJPlacement a;

    public final void run()
    {
        TJPlacement.m(a).a(gd.a().j());
    }

    (TJPlacement tjplacement)
    {
        a = tjplacement;
        super();
    }
}
