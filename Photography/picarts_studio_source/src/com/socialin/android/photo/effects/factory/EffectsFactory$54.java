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
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$3500((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, a1.h, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            boolean flag = a1.f;
            int l = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(l).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k).toString());
            ImageOpCommon.convolution2(d, bytebuffer, j, k, new int[] {
                -1, 0, 0, 0, 0, 0, 0, 0, 1
            }, 1, 128);
            bytebuffer.position(0);
            if (i > 0)
            {
                ImageOpCommon.effectBlendWithStrength(d, bytebuffer, (int)((255F * (float)(100 - i)) / 100F), j, k);
            }
            ImageOpCommon.changeBufferAlphaChannelWithAlpha(bytebuffer, j * k, 255);
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
    }

    ()
    {
    }
}
