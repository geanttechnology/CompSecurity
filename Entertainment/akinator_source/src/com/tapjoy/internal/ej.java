// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;

// Referenced classes of package com.tapjoy.internal:
//            ei

final class ej extends ei
{

    ej()
    {
    }

    public final Object createPlacement(Context context, String s, TJPlacementListener tjplacementlistener)
    {
        return new TJPlacement(context, s, tjplacementlistener);
    }
}
