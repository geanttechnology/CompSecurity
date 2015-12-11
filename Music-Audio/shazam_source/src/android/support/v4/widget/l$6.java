// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package android.support.v4.widget:
//            l, b, h

final class on extends Animation
{

    final l a;

    public final void applyTransformation(float f, Transformation transformation)
    {
        int i;
        int j;
        int k;
        if (!l.j(a))
        {
            i = (int)(l.k(a) - (float)Math.abs(a.c));
        } else
        {
            i = (int)l.k(a);
        }
        j = a.b;
        i = (int)((float)(i - a.b) * f);
        k = l.e(a).getTop();
        l.a(a, (i + j) - k, false);
        l.b(a).a(1.0F - f);
    }

    rmation(l l1)
    {
        a = l1;
        super();
    }
}
