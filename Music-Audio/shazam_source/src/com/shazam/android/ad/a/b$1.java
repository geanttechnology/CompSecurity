// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ad.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.shazam.android.ad.a:
//            b

final class tion extends Animation
{

    final View a;
    final int b;
    final b c;

    protected final void applyTransformation(float f, Transformation transformation)
    {
        a.setPadding(0, 0, 0, (int)((float)b * f));
    }

    formation(b b1, View view, int i)
    {
        c = b1;
        a = view;
        b = i;
        super();
    }
}
