// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
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
        int i = Integer.parseInt(EffectParameter.f(arraylist, "Shape"));
        int j = EffectParameter.b(arraylist, "Radius");
        int k = EffectParameter.b(arraylist, "Lightness");
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2200((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, 0, k, 0, j, i, 3);
            (new StringBuilder("applyEffectOutput.success = ")).append(((c) (arraylist)).a);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int l = point.x;
            int i1 = point.y;
            ImageOp.lensblur4buf(d, bytebuffer, l, i1, l, i1, 0, k, 0, j, i, 3, a1.f, a1.g);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
