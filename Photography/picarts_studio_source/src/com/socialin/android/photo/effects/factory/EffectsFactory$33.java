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
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = EffectParameter.a(arraylist, "Blur");
        int i = ((Integer)((EffectParameter) (d)).c).intValue();
        int j = ((Integer)((EffectParameter) (d)).d).intValue();
        int k = ((Integer)((EffectParameter) (d)).e).intValue();
        i = (int)EffectsFactory.access$600(i, j, k, 1.0F, 20F);
        j = EffectParameter.b(arraylist, "x");
        k = EffectParameter.b(arraylist, "y");
        Log.e("ex1", (new StringBuilder("blur = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("minBlur = 1")).toString());
        Log.e("ex1", (new StringBuilder("maxBlur = 20")).toString());
        Log.e("ex1", (new StringBuilder("xPercent = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("yPercent = ")).append(k).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2100((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i, 1, 20, j, k);
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
            ImageOpCommon.circularBlur(d, bytebuffer, l, i1, i, 1.0F, 20F, j, k);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
