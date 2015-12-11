// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

// Referenced classes of package android.support.v4.widget:
//            ah, al

final class ai extends Animation
{

    private al a;
    private ah b;

    ai(ah ah1, al al1)
    {
        b = ah1;
        a = al1;
        super();
    }

    public final void applyTransformation(float f, Transformation transformation)
    {
        if (b.a)
        {
            ah.a(b, f, a);
            return;
        }
        float f1 = ah.a(b, a);
        float f2 = a.g();
        float f4 = a.f();
        float f3 = a.k();
        ah.b(b, f, a);
        if (f <= 0.5F)
        {
            float f6 = f / 0.5F;
            f6 = ah.a().getInterpolation(f6);
            a.b(f4 + f6 * (0.8F - f1));
        }
        if (f > 0.5F)
        {
            float f5 = (f - 0.5F) / 0.5F;
            f5 = ah.a().getInterpolation(f5);
            a.c((0.8F - f1) * f5 + f2);
        }
        a.d(0.25F * f + f3);
        f1 = ah.a(b) / 5F;
        b.c(216F * f + 1080F * f1);
    }
}
