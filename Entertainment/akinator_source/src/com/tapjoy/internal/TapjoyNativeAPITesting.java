// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;

// Referenced classes of package com.tapjoy.internal:
//            ei

public class TapjoyNativeAPITesting extends ei
{

    public TapjoyNativeAPITesting()
    {
    }

    public static void disable()
    {
        ei.b = ei.a;
    }

    public static void enable(TapjoyNativeAPITesting tapjoynativeapitesting)
    {
        ei.b = tapjoynativeapitesting;
    }

    public Object createPlacement(Context context, String s, TJPlacementListener tjplacementlistener)
    {
        return new TJPlacement(context, s, tjplacementlistener);
    }
}
