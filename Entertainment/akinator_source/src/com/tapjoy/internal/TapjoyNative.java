// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

// Referenced classes of package com.tapjoy.internal:
//            ei

public class TapjoyNative
{

    public TapjoyNative()
    {
    }

    public static Object createPlacement(Context context, String s, TJPlacementListener tjplacementlistener)
    {
        return ei.a().createPlacement(context, s, tjplacementlistener);
    }
}
