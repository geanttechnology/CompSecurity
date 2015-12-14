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
        float f = EffectParameter.c(arraylist, "Amount");
        Log.e("ex1", (new StringBuilder("amount = ")).append(f).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$1300((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, f, 0);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int i = point.x;
            int j = point.y;
            boolean flag = a1.f;
            int k = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j).toString());
            ImageOp.bw4buf(d, bytebuffer, i, j, i, j, 1, 0, false, k);
            ImageOp.vintage4buf(bytebuffer, bytebuffer, i, j, i, j, f, 1, 0, flag, k);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
