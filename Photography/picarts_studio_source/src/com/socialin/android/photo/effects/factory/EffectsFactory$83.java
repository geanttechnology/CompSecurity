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
        int i = EffectParameter.b(arraylist, "Phase");
        d = EffectParameter.a(arraylist, "Wave");
        int j = (int)EffectsFactory.access$600(((Integer)((EffectParameter) (d)).c).intValue(), ((Integer)((EffectParameter) (d)).d).intValue(), ((Integer)((EffectParameter) (d)).e).intValue(), 2.0F, 30F);
        int k = EffectParameter.b(arraylist, "Radius");
        int l = EffectParameter.b(arraylist, "x");
        int i1 = EffectParameter.b(arraylist, "y");
        Log.e("ex1", (new StringBuilder("radiusPercent = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("wave = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("centerXPercent = ")).append(l).toString());
        Log.e("ex1", (new StringBuilder("centerYPercent = ")).append(i1).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$4800((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, k, l, i1, j, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j1 = point.x;
            int k1 = point.y;
            boolean flag = a1.f;
            int l1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(l1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k1).toString());
            ImageOpCommon.waterFilter(d, bytebuffer, j1, k1, l, i1, k, (float)j / 10F, (float)(((double)(float)i * 3.1415926535897931D) / 180D));
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
