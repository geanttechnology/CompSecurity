// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


public final class at
{

    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;

    private at(float f1, float f2, float f3, float f4, float f5, float f6, float f7, 
            float f8, float f9)
    {
        a = f1;
        b = f4;
        c = f7;
        d = f2;
        e = f5;
        f = f8;
        g = f3;
        h = f6;
        i = f9;
    }

    private static at a(float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8)
    {
        float f11 = f8 - f6;
        float f9 = ((f2 - f4) + f6) - f8;
        if (f11 == 0.0F && f9 == 0.0F)
        {
            return new at(f3 - f1, f5 - f3, f1, f4 - f2, f6 - f4, f2, 0.0F, 0.0F, 1.0F);
        } else
        {
            float f10 = f3 - f5;
            float f12 = f7 - f5;
            f5 = ((f1 - f3) + f5) - f7;
            f6 = f4 - f6;
            float f13 = f10 * f11 - f12 * f6;
            f11 = (f11 * f5 - f12 * f9) / f13;
            f5 = (f10 * f9 - f5 * f6) / f13;
            return new at((f3 - f1) + f11 * f3, (f7 - f1) + f5 * f7, f1, f11 * f4 + (f4 - f2), f5 * f8 + (f8 - f2), f2, f11, f5, 1.0F);
        }
    }

    public static at a(float f1, float f2, float f3, float f4, float f5, float f6, float f7, float f8, 
            float f9, float f10, float f11, float f12, float f13, float f14, float f15, 
            float f16)
    {
        at at1 = a(f1, f2, f3, f4, f5, f6, f7, f8);
        f1 = at1.e;
        f2 = at1.i;
        f3 = at1.f;
        f4 = at1.h;
        f5 = at1.f;
        f6 = at1.g;
        f7 = at1.d;
        f8 = at1.i;
        float f17 = at1.d;
        float f18 = at1.h;
        float f19 = at1.e;
        float f20 = at1.g;
        float f21 = at1.c;
        float f22 = at1.h;
        float f23 = at1.b;
        float f24 = at1.i;
        float f25 = at1.a;
        float f26 = at1.i;
        float f27 = at1.c;
        float f28 = at1.g;
        float f29 = at1.b;
        float f30 = at1.g;
        float f31 = at1.a;
        float f32 = at1.h;
        float f33 = at1.b;
        float f34 = at1.f;
        float f35 = at1.c;
        float f36 = at1.e;
        float f37 = at1.c;
        float f38 = at1.d;
        float f39 = at1.a;
        float f40 = at1.f;
        float f41 = at1.a;
        float f42 = at1.e;
        float f43 = at1.b;
        at1 = new at(f1 * f2 - f3 * f4, f5 * f6 - f7 * f8, f17 * f18 - f19 * f20, f21 * f22 - f23 * f24, f25 * f26 - f27 * f28, f29 * f30 - f31 * f32, f33 * f34 - f35 * f36, f37 * f38 - f39 * f40, f41 * f42 - at1.d * f43);
        at at2 = a(f9, f10, f11, f12, f13, f14, f15, f16);
        f1 = at2.a;
        f2 = at1.a;
        f3 = at2.d;
        f4 = at1.b;
        f5 = at2.g;
        f6 = at1.c;
        f7 = at2.a;
        f8 = at1.d;
        f9 = at2.d;
        f10 = at1.e;
        f11 = at2.g;
        f12 = at1.f;
        f13 = at2.a;
        f14 = at1.g;
        f15 = at2.d;
        f16 = at1.h;
        f17 = at2.g;
        f18 = at1.i;
        f19 = at2.b;
        f20 = at1.a;
        f21 = at2.e;
        f22 = at1.b;
        f23 = at2.h;
        f24 = at1.c;
        f25 = at2.b;
        f26 = at1.d;
        f27 = at2.e;
        f28 = at1.e;
        f29 = at2.h;
        f30 = at1.f;
        f31 = at2.b;
        f32 = at1.g;
        f33 = at2.e;
        f34 = at1.h;
        f35 = at2.h;
        f36 = at1.i;
        f37 = at2.c;
        f38 = at1.a;
        f39 = at2.f;
        f40 = at1.b;
        f41 = at2.i;
        f42 = at1.c;
        f43 = at2.c;
        float f44 = at1.d;
        float f45 = at2.f;
        float f46 = at1.e;
        float f47 = at2.i;
        float f48 = at1.f;
        float f49 = at2.c;
        float f50 = at1.g;
        float f51 = at2.f;
        float f52 = at1.h;
        float f53 = at2.i;
        return new at(f1 * f2 + f3 * f4 + f5 * f6, f7 * f8 + f9 * f10 + f11 * f12, f13 * f14 + f15 * f16 + f17 * f18, f19 * f20 + f21 * f22 + f23 * f24, f25 * f26 + f27 * f28 + f29 * f30, f31 * f32 + f33 * f34 + f35 * f36, f37 * f38 + f39 * f40 + f41 * f42, f43 * f44 + f45 * f46 + f47 * f48, f49 * f50 + f51 * f52 + at1.i * f53);
    }

    public final void a(float af[])
    {
        int k = af.length;
        float f1 = a;
        float f2 = b;
        float f3 = c;
        float f4 = d;
        float f5 = e;
        float f6 = f;
        float f7 = g;
        float f8 = h;
        float f9 = i;
        for (int j = 0; j < k; j += 2)
        {
            float f10 = af[j];
            float f11 = af[j + 1];
            float f12 = f3 * f10 + f6 * f11 + f9;
            af[j] = (f1 * f10 + f4 * f11 + f7) / f12;
            af[j + 1] = (f10 * f2 + f11 * f5 + f8) / f12;
        }

    }
}
