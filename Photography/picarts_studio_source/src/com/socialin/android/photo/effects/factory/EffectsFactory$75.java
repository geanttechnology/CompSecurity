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
        int i = EffectParameter.b(arraylist, "Amount");
        Log.e("ex1", (new StringBuilder("amount = ")).append(i).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$4300((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            float f = a1.h;
            boolean flag = a1.f;
            int l = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(l).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(j).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(k).toString());
            ImageOpCommon.pixelize2(d, bytebuffer, j, k, i, f);
            bytebuffer.position(0);
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
