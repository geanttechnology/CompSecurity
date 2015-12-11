// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package android.support.v4.widget:
//            l, h

final class on extends Animation
{

    final int a;
    final int b;
    final l c;

    public final void applyTransformation(float f, Transformation transformation)
    {
        l.b(c).setAlpha((int)((float)a + (float)(b - a) * f));
    }

    rmation(l l1, int i, int j)
    {
        c = l1;
        a = i;
        b = j;
        super();
    }
}
