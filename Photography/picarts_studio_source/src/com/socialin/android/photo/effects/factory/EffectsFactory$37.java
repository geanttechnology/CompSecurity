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
        d = EffectParameter.a(arraylist, "Colors");
        int i = (int)EffectsFactory.access$600(((Integer)((EffectParameter) (d)).c).intValue(), ((Integer)((EffectParameter) (d)).d).intValue(), ((Integer)((EffectParameter) (d)).e).intValue(), 2.0F, 255F);
        int j = EffectParameter.b(arraylist, "Details");
        int k = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("colors = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("details = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(k).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2300((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, a1.m, i, j, k);
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
            ImageOp.posterize4buf(d, bytebuffer, l, i1, l, i1, i, j, k, flag, j1);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
