// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public final class e
    implements Interpolator
{

    private final float a[];
    private final float b[];

    public e()
    {
        Path path = new Path();
        path.moveTo(0.0F, 0.0F);
        path.cubicTo(0.2F, 0.0F, 0.2F, 1.0F, 1.0F, 1.0F);
        this(path);
    }

    private e(Path path)
    {
        path = new PathMeasure(path, false);
        float f = path.getLength();
        int j = (int)(f / 0.002F) + 1;
        a = new float[j];
        b = new float[j];
        float af[] = new float[2];
        for (int i = 0; i < j; i++)
        {
            path.getPosTan(((float)i * f) / (float)(j - 1), af, null);
            a[i] = af[0];
            b[i] = af[1];
        }

    }

    public final float getInterpolation(float f)
    {
        if (f <= 0.0F)
        {
            return 0.0F;
        }
        if (f >= 1.0F)
        {
            return 1.0F;
        }
        int j = a.length - 1;
        int i;
        for (i = 0; j - i > 1;)
        {
            int k = (i + j) / 2;
            if (f < a[k])
            {
                j = k;
            } else
            {
                i = k;
            }
        }

        float f1 = a[j] - a[i];
        if (f1 == 0.0F)
        {
            return b[i];
        } else
        {
            f = (f - a[i]) / f1;
            f1 = b[i];
            return f * (b[j] - f1) + f1;
        }
    }
}
