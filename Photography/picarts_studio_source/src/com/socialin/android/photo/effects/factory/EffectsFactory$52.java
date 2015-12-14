// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.util.Log;
import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.photo.imgop.ImageOp;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory, a

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Mask 1");
        int j = EffectParameter.b(arraylist, "Mask 2");
        int k = EffectParameter.b(arraylist, "Magic 1");
        int l = EffectParameter.b(arraylist, "Magic 2");
        int i1 = EffectParameter.b(arraylist, "Fade");
        int j1 = EffectParameter.e(arraylist, "Color1");
        int k1 = EffectParameter.e(arraylist, "Color2");
        int l1 = com.socialin.android.photo.effects.factory.a.i(EffectParameter.f(arraylist, "Mode"));
        Log.e("ex1", (new StringBuilder("dog1Width = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("dog2Width = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("lowerIntesity = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("upperIntesity = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("color1 = ")).append(j1).toString());
        Log.e("ex1", (new StringBuilder("color2 = ")).append(k1).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i1).toString());
        Log.e("ex1", (new StringBuilder("mode = ")).append(l1).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$3400((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i, j, k, l, l1, j1, k1, i1);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int i2 = point.x;
            int j2 = point.y;
            boolean flag = a1.f;
            int k2 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k2).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i2).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j2).toString());
            ImageOp.sketcher4buf(d, bytebuffer, i2, j2, i2, j2, i, j, k, l, j1, k1, l1, i1, flag, k2);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
