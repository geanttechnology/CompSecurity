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
import com.socialin.android.photo.imgop.RenderScriptOp;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class A
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Fade");
        int j = EffectParameter.e(arraylist, "Color");
        boolean flag = EffectParameter.d(arraylist, "Round corners");
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("color = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("coloredCorners = ")).append(flag).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.yType.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$300((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, a1.m, i, j, flag);
        } else
        if (a1.n == com.photo.effect.yType.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int k = point.x;
            int l = point.y;
            boolean flag1 = a1.f;
            int i1 = a1.g;
            a1 = a1.m;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag1).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(k).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(l).toString());
            ImageOp.yestercolor4buf(d, bytebuffer, k, l, k, l, j, i, flag1, i1);
            if (flag)
            {
                RenderScriptOp.a(a1, bytebuffer, k, l, (float)Math.max(k, l) * 0.07F, j);
            }
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    A()
    {
    }
}
