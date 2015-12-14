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

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        int i = EffectParameter.b(arraylist, "Lines");
        int j = EffectParameter.b(arraylist, "Brightness");
        int k = EffectParameter.b(arraylist, "Fade");
        String s = (String)EffectParameter.a(arraylist, "texture").c;
        Log.e("ex1", (new StringBuilder("lines = ")).append(i).toString());
        Log.e("ex1", (new StringBuilder("brightness = ")).append(j).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(k).toString());
        Log.e("ex1", (new StringBuilder("textureName = ")).append(s).toString());
        arraylist = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            arraylist.a = EffectsFactory.access$2600((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, a1.a, i, j, s, k);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            android.content.Context context = a1.a;
            int l = point.x;
            int i1 = point.y;
            boolean flag = a1.f;
            int j1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(j1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(l).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(i1).toString());
            a1 = e.a(context, "sinEnc", s, l, i1);
            if (a1 != null)
            {
                ImageOp.comicboom4buf(d, bytebuffer, l, i1, l, i1, a1, l, i1, i, j, k, flag, j1);
                e.a(a1);
                arraylist.a = true;
                return arraylist;
            }
        }
        return arraylist;
    }

    ()
    {
    }
}
