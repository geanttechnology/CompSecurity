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
import com.socialin.android.photo.imgop.ImageOp;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = new c();
        int i = EffectParameter.b(arraylist, "Mask 1");
        int j = EffectParameter.b(arraylist, "Mask 2");
        int k = EffectParameter.b(arraylist, "Magic 1");
        int l = EffectParameter.b(arraylist, "Magic 2");
        int i1 = EffectParameter.b(arraylist, "Magic 3");
        int j1 = EffectParameter.b(arraylist, "Fade");
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            arraylist = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int k1 = point.x;
            int l1 = point.y;
            boolean flag = a1.f;
            int i2 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(i2).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(l1).toString());
            ImageOp.cartoonizer4buf(arraylist, bytebuffer, k1, l1, k1, l1, i, j, k, l, i1, j1, flag, i2);
            d.a = true;
        }
        return d;
    }

    ()
    {
    }
}
