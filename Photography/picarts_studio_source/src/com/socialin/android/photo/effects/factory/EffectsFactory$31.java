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
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int k = EffectParameter.b(arraylist, "Distance");
        int l = EffectParameter.b(arraylist, "Angle");
        int i1 = EffectParameter.b(arraylist, "Fade");
        int j = EffectParameter.b(arraylist, "Noise");
        int i = j;
        if (j == 0x7fffffff)
        {
            i = 0;
        }
        boolean flag = EffectParameter.d(arraylist, "Colorize");
        j = 100;
        if (flag)
        {
            j = EffectParameter.b(arraylist, "Hue");
        }
        Log.e("ex1", (new StringBuilder("distance = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("angle = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("colorize = ")).append(flag).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i1).toString());
        Log.e("ex1", (new StringBuilder("hue = ")).append(j).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$1900((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, k, j, i, l, flag, 30, 50, i1);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j1 = point.x;
            int k1 = point.y;
            boolean flag1 = a1.f;
            int l1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag1).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(l1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k1).toString());
            ImageOp.motionblur4buf(d, bytebuffer, j1, k1, j1, k1, k, l, flag, j, 50, 30, i, i1, flag1, l1);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
