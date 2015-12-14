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
        arraylist = EffectParameter.f(arraylist, "Mode");
        int j = com.socialin.android.photo.effects.factory.a.e(arraylist);
        Log.e("ex1", (new StringBuilder("modeStr = ")).append(arraylist).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$1100((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, j, i);
        } else
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
            ImageOp.bw4buf(d, bytebuffer, k, l, k, l, j, i, flag, i1);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
