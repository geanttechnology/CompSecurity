// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Bitmap;
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
        int i;
        boolean flag;
        flag = false;
        i = EffectParameter.b(arraylist, "Fade");
        Log.e("ex1", (new StringBuilder("fade = ")).append(i).toString());
        arraylist = new c();
        if (a1.n != com.photo.effect.Type.EffectApplyTypeRenderScript) goto _L2; else goto _L1
_L1:
        flag = EffectsFactory.access$1600((RenderScript)a1.j, (Allocation)a1.k, (Allocation)a1.l, i);
_L6:
        arraylist.a = flag;
_L4:
        return arraylist;
_L2:
        if (a1.n != com.photo.effect.Type.EffectApplyTypeBitmap) goto _L4; else goto _L3
_L3:
        d = a1.b;
        arraylist.b = EffectsFactory.applyColorEffect(7, 255, d, a1.c, false);
        if (((c) (arraylist)).b != null && i > 0)
        {
            a1 = ((c) (arraylist)).b;
            if (a1 != null && i > 0)
            {
                int j = a1.getWidth();
                int k = a1.getHeight();
                ByteBuffer bytebuffer = ImageOpCommon.allocNativeBuffer(j * k * 4);
                ByteBuffer bytebuffer1 = ImageOpCommon.allocNativeBuffer(j * k * 4);
                bytebuffer1.rewind();
                a1.copyPixelsToBuffer(bytebuffer1);
                bytebuffer.rewind();
                d.copyPixelsToBuffer(bytebuffer);
                ImageOpCommon.effectBlendWithStrength(bytebuffer, bytebuffer1, (int)((255F * (float)(100 - i)) / 100F), j, k);
                bytebuffer1.rewind();
                a1.copyPixelsFromBuffer(bytebuffer1);
                ImageOpCommon.freeNativeBuffer(bytebuffer);
                ImageOpCommon.freeNativeBuffer(bytebuffer1);
            }
        }
        if (((c) (arraylist)).b != null)
        {
            flag = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
    }
}
