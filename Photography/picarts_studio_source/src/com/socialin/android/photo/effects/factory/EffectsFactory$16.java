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
        int i = EffectParameter.b(arraylist, "Fade");
        float f2 = EffectParameter.c(arraylist, "Contrast");
        float f3 = EffectParameter.c(arraylist, "Amount");
        float f1 = 1.0F - EffectParameter.c(arraylist, "Vignette");
        float f = f1;
        if (f1 < 0.0F)
        {
            f = 0.0F;
        }
        arraylist = EffectParameter.f(arraylist, "Mode");
        int k = Integer.parseInt(arraylist);
        int j = com.socialin.android.photo.effects.factory.a.a(k);
        f = 0.06F + f * 0.25F;
        Log.e("ex1", (new StringBuilder("modeIndex = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("modeStr = ")).append(arraylist).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("mode = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("contrast = ")).append(f2).toString());
        Log.e("ex1", (new StringBuilder("amount = ")).append(f3).toString());
        Log.e("ex1", (new StringBuilder("vignette = ")).append(f).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$800((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, f2, f3, f, j, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int l = point.x;
            int i1 = point.y;
            boolean flag = a1.f;
            int j1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(l).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(i1).toString());
            ImageOp.lomo4buf(d, bytebuffer, l, i1, l, i1, f, f2, f3, j, i, flag, j1);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
