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
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = new c();
        int l = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("fade = ")).append(l).toString());
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            arraylist = a1.d;
            ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int i1 = point.x;
            int j1 = point.y;
            boolean flag = a1.f;
            int i = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(i).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(j1).toString());
            int j = Math.max(i1, j1);
            if (j > 1024)
            {
                int k = j / 2;
                i = k;
                if (k < 1024)
                {
                    i = 1024;
                }
            } else
            {
                i = j;
            }
            if (i == j)
            {
                System.currentTimeMillis();
                ImageOpCommon.oilFilter3(arraylist, bytebuffer, i1, j1);
                bytebuffer.position(0);
                ImageOpCommon.changeBufferAlphaChannelWithAlpha(bytebuffer, i1 * j1, 255);
                System.currentTimeMillis();
            } else
            {
                a1 = e.a(i1, j1, i);
                i = ((Point) (a1)).x;
                j = ((Point) (a1)).y;
                a1 = e.a(i * j * 4);
                ImageResize.resize(arraylist, i1, j1, a1, i, j, 4);
                ByteBuffer bytebuffer1 = e.a(i * j * 4);
                ImageOpCommon.oilFilter3(a1, bytebuffer1, i, j);
                e.a(a1);
                ImageResize.resize(bytebuffer1, i, j, bytebuffer, i1, j1, 4);
                e.a(bytebuffer1);
            }
            if (l > 0)
            {
                ImageOpCommon.effectBlendWithStrength(arraylist, bytebuffer, (int)((255F * (float)(100 - l)) / 100F), i1, j1);
            }
            d.a = true;
        }
        return d;
    }

    ()
    {
    }
}
