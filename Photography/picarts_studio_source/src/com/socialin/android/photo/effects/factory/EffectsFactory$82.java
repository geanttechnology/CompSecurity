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
        int i = EffectParameter.b(arraylist, "Radius");
        int i1 = EffectParameter.b(arraylist, "x");
        int l = EffectParameter.b(arraylist, "y");
        Log.e("ex1", (new StringBuilder("radiusPercent = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("centerXPercent = ")).append(i1).toString());
        Log.e("ex1", (new StringBuilder("centerYPercent = ")).append(l).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$4700((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i, i1, l, a1.h);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            boolean flag = a1.f;
            int j1 = a1.g;
            float f = a1.h;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k).toString());
            i1 = (int)(((float)i1 / 100F) * (float)j);
            l = (int)(((float)l / 100F) * (float)k);
            j1 = (int)Math.sqrt(Math.pow(j / 2, 2D) + Math.pow(k / 2, 2D));
            ImageOpCommon.bathroom23(d, bytebuffer, j, k, i1, l, (int)(((float)i / 100F) * (float)j1), 0.7853982F, f);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
