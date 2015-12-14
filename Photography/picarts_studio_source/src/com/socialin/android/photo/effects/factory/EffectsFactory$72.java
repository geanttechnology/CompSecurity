// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.factory;

import android.graphics.Bitmap;
import android.util.Log;
import com.photo.effect.a;
import com.photo.effect.b;
import com.photo.effect.c;
import com.photo.effect.d;
import com.socialin.android.util.w;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.effects.factory:
//            EffectsFactory

final class 
    implements b
{

    public final c a(ArrayList arraylist, d d1, a a1)
    {
        c c1 = new c();
        if (a1.n == com.photo.effect.Type.EffectApplyTypeBitmap)
        {
            Bitmap bitmap = a1.b;
            a1 = a1.c;
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            arraylist = null;
            boolean flag;
            if (d1 != null)
            {
                Log.e("ex1", "aditionalParameter != null");
                d1 = (d)d1;
                java.util.HashMap hashmap = d1.a;
                arraylist = d1.b;
                int k = d1.c;
                if (arraylist != null)
                {
                    Log.e("ex1", "cropPath != null");
                    d1 = new android.graphics.ons();
                    d1.inPreferredConfig = android.graphics._8888;
                    arraylist = com.socialin.android.util.c.a(arraylist, d1);
                } else
                {
                    Log.e("ex1", "cropBufferData != null");
                    arraylist = w.a(hashmap, k, 0);
                }
            }
            d1 = arraylist;
            if (arraylist == null)
            {
                d1 = com.socialin.android.util.c.a(bitmap, 0, 0, bitmap.getWidth() / 4, bitmap.getHeight());
            }
            arraylist = EffectsFactory.access$4000(d1, i, j, a1);
            if (d1 != null)
            {
                com.socialin.android.util.c.a(d1);
            }
            if (arraylist != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c1.a = flag;
            c1.b = arraylist;
        }
        return c1;
    }

    ()
    {
    }
}
