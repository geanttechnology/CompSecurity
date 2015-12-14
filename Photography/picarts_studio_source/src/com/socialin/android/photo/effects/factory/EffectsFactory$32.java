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
        d = EffectParameter.f(arraylist, "BlendMode");
        int i = com.socialin.android.photo.effects.factory.a.g(d);
        int j = EffectParameter.b(arraylist, "Focal zoom");
        int k = EffectParameter.b(arraylist, "Radius");
        int l = EffectParameter.b(arraylist, "Hardness");
        int i1 = EffectParameter.b(arraylist, "Fade");
        int j1 = EffectParameter.b(arraylist, "x");
        int k1 = EffectParameter.b(arraylist, "y");
        Log.e("ex1", (new StringBuilder("blendModeStr = ")).append(d).toString());
        Log.e("ex1", (new StringBuilder("blendMode = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("blur = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("radiusPercent = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("hardness = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i1).toString());
        Log.e("ex1", (new StringBuilder("xPercent = ")).append(j1).toString());
        Log.e("ex1", (new StringBuilder("yPercent = ")).append(k1).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2000((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, j, k, l, j1, k1, i, i1);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int l1 = point.x;
            int i2 = point.y;
            boolean flag = a1.f;
            int j2 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(j2).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(l1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(i2).toString());
            ImageOp.focalzoom4buf(d, bytebuffer, l1, i2, l1, i2, j, j1, k1, k, l, i, i1, flag, j2);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
