// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
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
        double d1 = EffectParameter.c(arraylist, "Alpha");
        double d2 = EffectParameter.c(arraylist, "Beta");
        double d3 = EffectParameter.c(arraylist, "Noise");
        int i = EffectParameter.b(arraylist, "Fade");
        int j = com.socialin.android.photo.effects.factory.a.j(EffectParameter.f(arraylist, "Mode"));
        Log.e("ex1", (new StringBuilder("alfa = ")).append(d1).toString());
        Log.e("ex1", (new StringBuilder("beta = ")).append(d2).toString());
        Log.e("ex1", (new StringBuilder("noise = ")).append(d3).toString());
        Log.e("ex1", (new StringBuilder("mode = ")).append(j).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int k = point.x;
            int l = point.y;
            boolean flag = a1.f;
            int i1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(k).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(l).toString());
            ImageOp.fattal4buf(d, bytebuffer, k, l, k, l, d1, d2, 1.0D, d3, j, -1, -1, i, flag, i1);
            arraylist.a = true;
        }
        return arraylist;
    }

    ()
    {
    }
}
