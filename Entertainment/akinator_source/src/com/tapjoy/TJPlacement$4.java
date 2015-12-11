// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.fy;

// Referenced classes of package com.tapjoy:
//            TJPlacement, TJPlacementData, TJAdUnitActivity

final class a
    implements fy
{

    final TJPlacement a;

    public final void a(Context context, String s)
    {
        TJPlacement.e(a).setRedirectURL(s);
        TJPlacement.e(a).setHasProgressSpinner(true);
        s = new Intent(TJPlacement.f(a), com/tapjoy/TJAdUnitActivity);
        s.putExtra("placement_data", TJPlacement.e(a));
        s.setFlags(0x10000000);
        context.startActivity(s);
    }

    ty(TJPlacement tjplacement)
    {
        a = tjplacement;
        super();
    }
}
