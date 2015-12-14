// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.socialin.android.util.w;
import java.util.UUID;

// Referenced classes of package com.socialin.android.videogenerator.layer:
//            LayerConfig

public final class a
{

    public Bitmap a;
    public LayerConfig b;
    public UUID c;
    public Canvas d;
    public String e;
    public final int f;
    public final int g;
    public final float h;
    public final float i;

    public a(UUID uuid, int j, int k, LayerConfig layerconfig, float f1, float f2)
    {
        f = j;
        g = k;
        h = f1;
        i = f2;
        a = Bitmap.createBitmap((int)((float)f * f1), (int)((float)g * f2), android.graphics.Bitmap.Config.ARGB_8888);
        b = layerconfig;
        c = uuid;
        e = null;
    }

    public a(UUID uuid, int j, int k, String s, LayerConfig layerconfig, float f1, float f2)
    {
        f = j;
        g = k;
        h = f1;
        i = f2;
        e = s;
        b = layerconfig;
        c = uuid;
        a();
    }

    public final void a()
    {
        int j = (int)((float)f * h);
        int k = (int)((float)g * i);
        Bitmap bitmap = w.a(f, g, e);
        if (h != 1.0F || i != 1.0F)
        {
            a = Bitmap.createScaledBitmap(bitmap, j, k, true);
            if (a != bitmap)
            {
                bitmap.recycle();
                Runtime.getRuntime().gc();
            }
            return;
        } else
        {
            a = bitmap;
            return;
        }
    }

    public final Canvas b()
    {
        if (d == null)
        {
            d = new Canvas(a);
            d.scale(h, i);
        }
        return d;
    }

    public final String toString()
    {
        return (new StringBuilder("MetaLayer LayerId:")).append(c).append(" bufferPath:").append(e).append(" oheight:").append(g).append(" owidth:").append(f).append("scale:").append(h).toString();
    }
}
