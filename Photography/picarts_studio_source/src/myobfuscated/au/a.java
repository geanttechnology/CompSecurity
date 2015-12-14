// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.au;

import com.photo.effect.EffectParameter;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.au:
//            b

public final class a extends b
{

    public a(ArrayList arraylist)
    {
        super(arraylist);
    }

    public final void a(float f, float f1)
    {
        int i = EffectParameter.b(e, "x");
        int k = EffectParameter.b(e, "y");
        int i1 = EffectParameter.b(e, "Radius");
        float f7 = ((float)i * f) / 100F;
        float f8 = ((float)k * f1) / 100F;
        float f9 = (int)((Math.min(f, f1) / 2.0F - 1.0F) * ((float)i1 / 100F));
        for (int j = 0; j <= b; j++)
        {
            int l = 0;
            while (l <= a) 
            {
                int j1 = (a + 1) * j + l;
                float f3 = c[j1 * 2];
                float f5 = c[j1 * 2 + 1];
                float f10 = f3 - f7;
                float f11 = f5 - f8;
                float f2 = f10 * f10 + f11 * f11;
                if (f2 <= f9 * f9 && f3 != 0.0F && f5 != 0.0F && f3 != f && f5 != f1)
                {
                    float f6 = (float)Math.atan2(f11, f10);
                    f2 /= f9;
                    float f4 = (float)((double)f2 * Math.cos(f6) + (double)f7);
                    f6 = (float)((double)f2 * Math.sin(f6) + (double)f8);
                    f2 = f4;
                    if (f4 < 0.0F)
                    {
                        f2 = 0.0F;
                    }
                    f4 = f6;
                    if (f6 < 0.0F)
                    {
                        f4 = 0.0F;
                    }
                    f6 = f2;
                    if (f2 >= f)
                    {
                        f6 = f - 1.0F;
                    }
                    f2 = f4;
                    if (f4 >= f1)
                    {
                        f2 = f1 - 1.0F;
                    }
                    a(d, j1, f6, f2);
                } else
                {
                    a(d, j1, c[j1 * 2], c[j1 * 2 + 1]);
                }
                l++;
            }
        }

    }
}
