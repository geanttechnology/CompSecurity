// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
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

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        d = new c();
        int i = EffectParameter.b(arraylist, "Fade");
        if (a1.n == com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            d.a = RenderScriptOp.g((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i);
        } else
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            arraylist = a1.d;
            java.nio.ByteBuffer bytebuffer = a1.e;
            Point point = a1.i;
            int j = point.x;
            int k = point.y;
            ImageOp.effect124buf(arraylist, bytebuffer, j, k, j, k, i, a1.f, a1.g);
            d.a = true;
            return d;
        }
        return d;
    }

    ()
    {
    }
}
