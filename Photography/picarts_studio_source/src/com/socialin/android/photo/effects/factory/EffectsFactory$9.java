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
        d = new c();
        int i = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        if (a1.n == com.photo.effect.yType.EffectApplyTypeRenderScript)
        {
            d.a = RenderScriptOp.h((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i);
        } else
        if (a1.n == com.photo.effect.yType.EffectApplyTypeNative)
        {
            arraylist = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            boolean flag = a1.f;
            int l = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(l).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k).toString());
            ImageOp.effect134buf(arraylist, bytebuffer, j, k, j, k, i, flag, l);
            d.a = true;
            return d;
        }
        return d;
    }

    A()
    {
    }
}
