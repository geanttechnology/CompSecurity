// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.picsart.studio.view:
//            SwipeRefreshLayout

final class a extends Animation
{

    private SwipeRefreshLayout a;

    public final void applyTransformation(float f, Transformation transformation)
    {
        int i = 0;
        if (SwipeRefreshLayout.a(a) != SwipeRefreshLayout.b(a))
        {
            i = SwipeRefreshLayout.a(a) + (int)((float)(SwipeRefreshLayout.b(a) - SwipeRefreshLayout.a(a)) * f);
        }
        int j = i - SwipeRefreshLayout.c(a).getTop();
        int k = SwipeRefreshLayout.c(a).getTop();
        i = j;
        if (j + k < 0)
        {
            i = 0 - k;
        }
        SwipeRefreshLayout.a(a, i);
    }

    (SwipeRefreshLayout swiperefreshlayout)
    {
        a = swiperefreshlayout;
        super();
    }
}
