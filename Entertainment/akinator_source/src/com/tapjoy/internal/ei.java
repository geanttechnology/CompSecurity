// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

// Referenced classes of package com.tapjoy.internal:
//            ej

abstract class ei
{

    static final ei a;
    static ei b;

    ei()
    {
    }

    static ei a()
    {
        return b;
    }

    public abstract Object createPlacement(Context context, String s, TJPlacementListener tjplacementlistener);

    static 
    {
        ej ej1 = new ej();
        a = ej1;
        b = ej1;
    }
}
