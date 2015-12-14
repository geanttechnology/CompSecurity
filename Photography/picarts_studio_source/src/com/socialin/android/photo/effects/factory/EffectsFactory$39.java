// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.util.Log;
import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.imgop.ImageResize;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.ay.e;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory, a

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = com.socialin.android.photo.effects.factory.a.h(EffectParameter.f(arraylist, "Shape"));
        int j = EffectParameter.b(arraylist, "Size");
        int i1 = EffectParameter.b(arraylist, "Angle");
        Log.e("ex1", (new StringBuilder("shape = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("distancePercent = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("angle = ")).append(i1).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            ByteBuffer bytebuffer = a1.d;
            d = a1.e;
            Point point = a1.i;
            int k = point.x;
            int l = point.y;
            boolean flag = a1.f;
            int k1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(k).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(l).toString());
            if (i == 4)
            {
                ImageOpCommon.shearFilter2(bytebuffer, d, k, l);
                d.position(0);
                ImageOpCommon.changeBufferAlphaChannelWithAlpha(d, k * l, 255);
            } else
            {
                float f = Math.max(k, l);
                float f1 = (float)(((double)(float)i1 * 3.1415926535897931D) / 180D);
                if (f <= 1280F || j <= 20 || i == 1 || i == 0)
                {
                    ImageOpCommon.smearFilter(bytebuffer, d, k, l, i, (int)((((float)j * 0.04921875F) / 100F + 0.00078125F) * f), f1, 1.0F);
                } else
                {
                    a1 = e.a(k, l, 1280F);
                    int j1 = ((Point) (a1)).x;
                    int l1 = ((Point) (a1)).y;
                    Log.e("ex", (new StringBuilder("scaledWidth = ")).append(j1).toString());
                    Log.e("ex", (new StringBuilder("scaledHeight = ")).append(l1).toString());
                    a1 = e.a(j1 * l1 * 4);
                    ImageResize.resize(bytebuffer, k, l, a1, j1, l1, 4);
                    bytebuffer = e.a(j1 * l1 * 4);
                    ImageOpCommon.smearFilter(a1, bytebuffer, j1, l1, i, (int)((0.00078125F + ((float)j * 0.04921875F) / 100F) * 1280F), f1, 1.0F);
                    e.a(a1);
                    ImageResize.resize(bytebuffer, j1, l1, d, k, l, 4);
                    e.a(bytebuffer);
                }
            }
            arraylist.a = true;
        }
        return arraylist;
    }

    ()
    {
    }
}
