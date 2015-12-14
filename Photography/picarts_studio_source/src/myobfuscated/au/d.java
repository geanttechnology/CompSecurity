// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.au;

import com.photo.effect.EffectParameter;
import java.util.ArrayList;

// Referenced classes of package myobfuscated.au:
//            b

public final class d extends b
{

    public d(ArrayList arraylist)
    {
        super(arraylist);
    }

    public final void a(float f, float f1)
    {
        int i = EffectParameter.b(e, "x");
        int k = EffectParameter.b(e, "y");
        int i1 = EffectParameter.b(e, "Radius");
        int k1 = EffectParameter.b(e, "Rotation");
        float f9 = ((float)i * f) / 100F;
        float f10 = ((float)k * f1) / 100F;
        float f4 = Math.min(f, f1) / 2.0F;
        float f2 = k1;
        float f11 = (int)((f4 - 1.0F) * ((float)i1 / 100F));
        float f12 = (float)(((double)f2 * 3.1415926535897931D) / 180D);
        for (int j = 0; j <= b; j++)
        {
            int l = 0;
            while (l <= a) 
            {
                int j1 = (a + 1) * j + l;
                float f5 = c[j1 * 2];
                float f7 = c[j1 * 2 + 1];
                float f13 = f5 - f9;
                float f14 = f7 - f10;
                float f3 = f13 * f13 + f14 * f14;
                if (f3 <= f11 * f11 && f5 != 0.0F && f7 != 0.0F && f5 != f && f7 != f1)
                {
                    Math.sqrt(f3);
                    float f6 = (float)Math.atan2(f14, f13);
                    f3 = (float)Math.sqrt(f3);
                    float f8 = f6 + ((f11 - f3) * f12) / f11;
                    f6 = (float)((double)f3 * Math.cos(f8) + (double)f9);
                    f8 = (float)((double)f3 * Math.sin(f8) + (double)f10);
                    f3 = f6;
                    if (f6 < 0.0F)
                    {
                        f3 = 0.0F;
                    }
                    f6 = f8;
                    if (f8 < 0.0F)
                    {
                        f6 = 0.0F;
                    }
                    f8 = f3;
                    if (f3 >= f)
                    {
                        f8 = f - 1.0F;
                    }
                    f3 = f6;
                    if (f6 >= f1)
                    {
                        f3 = f1 - 1.0F;
                    }
                    a(d, j1, f8, f3);
                } else
                {
                    a(d, j1, c[j1 * 2], c[j1 * 2 + 1]);
                }
                l++;
            }
        }

    }
}
