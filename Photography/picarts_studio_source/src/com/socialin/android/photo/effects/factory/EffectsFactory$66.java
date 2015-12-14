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
import myobfuscated.ay.e;
import myobfuscated.bb.bf;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = (String)EffectParameter.a(arraylist, "texture").c;
        int i = EffectParameter.b(arraylist, "Left");
        int j = EffectParameter.b(arraylist, "Right");
        int k = EffectParameter.b(arraylist, "Vignette");
        int l = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("left = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("right = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("vignette = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(l).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            android.graphics.Bitmap bitmap = a1.b;
            RenderScript renderscript = (RenderScript)a1.j;
            Allocation allocation = (Allocation)a1.k;
            Allocation allocation1 = (Allocation)a1.l;
            arraylist.a = EffectsFactory.access$3700(renderscript, allocation, allocation1, a1.a, d, i, j, k, l);
            if (((c) (arraylist)).a && bitmap != null && l > 0 && l < 100)
            {
                allocation.copyFrom(bitmap);
                d = new bf(renderscript);
                d.a(allocation1, allocation, ((100 - l) * 255) / 100);
                d.a(allocation1);
                d.destroy();
            }
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            java.nio.ByteBuffer bytebuffer = a1.d;
            java.nio.ByteBuffer bytebuffer1 = a1.e;
            Point point = a1.i;
            android.content.Context context = a1.a;
            int i1 = point.x;
            int j1 = point.y;
            boolean flag = a1.f;
            int k1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j1).toString());
            d = e.a(context, "sinEnc", d, i1, j1);
            if (d != null)
            {
                ImageOp.holgaart4buf(bytebuffer, bytebuffer1, i1, j1, i1, j1, i, j, k, d, i1, j1, l, flag, k1);
                e.a(d);
                arraylist.a = true;
                return arraylist;
            } else
            {
                arraylist.a = false;
                return arraylist;
            }
        }
        return arraylist;
    }

    ()
    {
    }
}
