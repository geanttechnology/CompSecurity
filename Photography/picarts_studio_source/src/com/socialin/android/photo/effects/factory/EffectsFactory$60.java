// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        boolean flag = false;
        int i = EffectParameter.e(arraylist, "Amount");
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeBitmap)
        {
            d = EffectsFactory.applyColorEffect("Saturation", i, a1.b, null, false);
            if (d != null)
            {
                flag = true;
            }
            arraylist.a = flag;
            arraylist.b = d;
        }
        return arraylist;
    }

    ()
    {
    }
}
