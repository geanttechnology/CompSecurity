// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.graphics.Color;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.socialin.android.colorpicker:
//            b

public final class a
{

    float a[];
    int b;
    private final Set c;

    public a()
    {
        this(new float[] {
            180F, 0.5F, 0.5F
        });
    }

    public a(float af[])
    {
        a = new float[3];
        a = af;
        c = new HashSet(1);
        b = Color.HSVToColor(a);
    }

    private static float d(float f)
    {
        return (new BigDecimal(Float.toString(f))).setScale(2, 4).floatValue();
    }

    public final float a()
    {
        return (float)Math.round(a[0]);
    }

    public final void a(float f)
    {
        if (f >= 0.0F) goto _L2; else goto _L1
_L1:
        float f1 = 360F;
_L4:
        a[0] = Math.round(d(f1));
        b = Color.HSVToColor(a);
        a(a);
        return;
_L2:
        f1 = f;
        if (f > 360F)
        {
            f1 = 0.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(int i)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        b = Color.rgb(j, Color.green(b), Color.blue(b));
        Color.colorToHSV(b, a);
        a(a);
        return;
_L2:
        j = i;
        if (i > 255)
        {
            j = 255;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(b b1)
    {
        c.add(b1);
    }

    public final void a(float af[])
    {
        a = af;
        d();
    }

    public final float b()
    {
        return d(a[1]);
    }

    public final void b(float f)
    {
        if (f > 0.0F) goto _L2; else goto _L1
_L1:
        float f1 = 0.01F;
_L4:
        a[1] = d(f1);
        b = Color.HSVToColor(a);
        a(a);
        return;
_L2:
        f1 = f;
        if (f > 1.0F)
        {
            f1 = 1.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void b(int i)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        b = Color.rgb(Color.red(b), j, Color.blue(b));
        Color.colorToHSV(b, a);
        a(a);
        return;
_L2:
        j = i;
        if (i > 255)
        {
            j = 255;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final float c()
    {
        return d(a[2]);
    }

    public final void c(float f)
    {
        if (f > 0.0F) goto _L2; else goto _L1
_L1:
        float f1 = 0.01F;
_L4:
        a[2] = d(f1);
        b = Color.HSVToColor(a);
        a(a);
        return;
_L2:
        f1 = f;
        if (f > 1.0F)
        {
            f1 = 1.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void c(int i)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        b = Color.rgb(Color.red(b), Color.green(b), j);
        Color.colorToHSV(b, a);
        a(a);
        return;
_L2:
        j = i;
        if (i > 255)
        {
            j = 255;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void d()
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((b)iterator.next()).a()) { }
    }
}
