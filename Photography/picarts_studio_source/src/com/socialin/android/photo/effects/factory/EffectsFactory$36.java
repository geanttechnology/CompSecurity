// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.photo.imgop.ImageOp;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = new c();
        int i = EffectParameter.b(arraylist, "Fade");
        float f = (float)EffectParameter.b(arraylist, "Density") / 100F;
        f = (float)Math.max(Math.pow(f, 5D), 1.0D - Math.pow(1.0F - f, 0.20000000298023224D));
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            arraylist = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            ImageOp.polygonize4buf(arraylist, bytebuffer, j, k, j, k, f * 30F, i, a1.f, a1.g);
            d.a = true;
        }
        return d;
    }

    ()
    {
    }
}
