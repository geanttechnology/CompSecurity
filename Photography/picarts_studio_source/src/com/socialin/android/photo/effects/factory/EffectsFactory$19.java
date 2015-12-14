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
        int j = EffectParameter.b(arraylist, "Radius");
        int k = EffectParameter.e(arraylist, "Color");
        arraylist = EffectParameter.f(arraylist, "Mode");
        int l = com.socialin.android.photo.effects.factory.a.d(arraylist);
        Log.e("ex1", (new StringBuilder("modeStr = ")).append(arraylist).toString());
        Log.e("ex1", (new StringBuilder("algoritm = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("radius = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("color = ")).append(k).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$1000((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, k, l, j, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int i1 = point.x;
            int j1 = point.y;
            boolean flag = a1.f;
            int k1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j1).toString());
            ImageOp.vignette4buf(d, bytebuffer, i1, j1, i1, j1, k, j, l, i, flag, k1);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
