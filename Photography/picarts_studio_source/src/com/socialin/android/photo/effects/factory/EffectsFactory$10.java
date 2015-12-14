// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.Type;
import android.util.Log;
import com.photo.effect.EffectParameter;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.photo.imgop.ImageOpCommon;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.ba.e;
import myobfuscated.bb.bf;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d, a a1)
    {
        float f = EffectParameter.b(arraylist, "InputShift");
        int j = (int)((f / 100F) * 141F);
        int i = j;
        if (j != 0)
        {
            i = j + 1;
        }
        j = i + 114;
        float f1;
        Object obj;
        Object obj1;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag;
        boolean flag1;
        if (j > 255)
        {
            j = 255;
            k = 141;
        } else
        {
            k = i;
        }
        f1 = EffectParameter.b(arraylist, "OutputShift");
        l = (int)((f1 / 100F) * 137F);
        i = l;
        if (l != 0)
        {
            i = l + 1;
        }
        i1 = i + 118;
        l = i;
        i = i1;
        if (i1 > 255)
        {
            i = 255;
            l = 137;
        }
        flag = EffectParameter.d(arraylist, "Desaturate");
        j1 = EffectParameter.b(arraylist, "Fade");
        arraylist = new c();
        Log.e("ex1", (new StringBuilder("inputLowPercent = ")).append(f).toString());
        Log.e("ex1", (new StringBuilder("outputLowPercent = ")).append(f1).toString());
        Log.e("ex1", (new StringBuilder("correctGamma = 14.4")).toString());
        Log.e("ex1", (new StringBuilder("desaturate = ")).append(flag).toString());
        Log.e("ex1", (new StringBuilder("fade = ")).append(j1).toString());
        if (a1.n != com.photo.effect.Type.EffectApplyTypeRenderScript)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        obj = (RenderScript)a1.j;
        d = (Allocation)a1.k;
        a1 = (Allocation)a1.l;
        if (obj == null)
        {
            arraylist.a = false;
            return arraylist;
        }
        if (j1 != 100) goto _L2; else goto _L1
_L1:
        a1.copy2DRangeFrom(0, 0, d.getType().getX(), d.getType().getY(), d, 0, 0);
_L4:
        arraylist.a = true;
        return arraylist;
_L2:
        try
        {
            obj1 = new e(((RenderScript) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (d d)
        {
            arraylist.a = false;
            return arraylist;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        ((e) (obj1)).a(1);
_L5:
        ((e) (obj1)).b(k);
        ((e) (obj1)).c(j);
        ((e) (obj1)).d(l);
        ((e) (obj1)).e(i);
        ((e) (obj1)).a();
        ((e) (obj1)).b();
        ((e) (obj1)).a(d, a1);
        ((e) (obj1)).destroy();
        if (j1 <= 0) goto _L4; else goto _L3
_L3:
        obj = new bf(((RenderScript) (obj)));
        ((bf) (obj)).a(a1, d, ((100 - j1) * 255) / 100);
        ((bf) (obj)).a(a1);
        ((bf) (obj)).destroy();
          goto _L4
        ((e) (obj1)).a(0);
          goto _L5
        if (a1.n == com.photo.effect.Type.EffectApplyTypeNative)
        {
            d = a1.d;
            obj = a1.e;
            obj1 = a1.i;
            k1 = ((Point) (obj1)).x;
            l1 = ((Point) (obj1)).y;
            flag1 = a1.f;
            i1 = a1.g;
            Log.e("ex1", (new StringBuilder("interruptable = ")).append(flag1).toString());
            Log.e("ex1", (new StringBuilder("taskId = ")).append(i1).toString());
            Log.e("ex1", (new StringBuilder("width = ")).append(k1).toString());
            Log.e("ex1", (new StringBuilder("height = ")).append(l1).toString());
            i1 = 0;
            if (flag)
            {
                i1 = 1;
            }
            ImageOpCommon.desaturate(d, ((java.nio.Buffer) (obj)), k1, l1, i1, k, j, l, i, 14.4F);
            if (j1 > 0)
            {
                ((ByteBuffer) (obj)).rewind();
                ImageOpCommon.effectBlendWithStrength(d, ((java.nio.Buffer) (obj)), (int)((255F * (float)(100 - j1)) / 100F), k1, l1);
            }
            arraylist.a = true;
            return arraylist;
        }
        return arraylist;
          goto _L4
    }

    ()
    {
    }
}
