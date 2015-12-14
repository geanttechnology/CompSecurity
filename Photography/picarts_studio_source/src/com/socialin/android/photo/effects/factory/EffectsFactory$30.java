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
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Denoising");
        int j = EffectParameter.b(arraylist, "Details");
        Log.e("ex1", (new StringBuilder("denoising = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("fade = 0")).toString());
        Log.e("ex1", (new StringBuilder("details = ")).append(j).toString());
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
            float f = (float)i / 10000F;
            float f1 = (float)j / 100F;
            Log.e("ex1", (new StringBuilder("denoisingInt = ")).append(i).toString());
            Log.e("ex1", (new StringBuilder("detailsInt = ")).append(j).toString());
            Log.e("ex1", (new StringBuilder("sigma = ")).append(f).toString());
            Log.e("ex1", (new StringBuilder("details = ")).append(f1).toString());
            ImageOp.pyramidnoisereduction4buf(d, bytebuffer, k, l, k, l, f, f, f1, 0.05F, 0.0F, 0, flag, i1);
            arraylist.a = true;
        }
        return arraylist;
    }

    ()
    {
    }
}
