// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.view.animation.Animation;

// Referenced classes of package com.picsart.studio.view:
//            m, SwipeRefreshLayout

final class a extends m
{

    private SwipeRefreshLayout a;

    public final void onAnimationEnd(Animation animation)
    {
        SwipeRefreshLayout.g(a);
    }

    (SwipeRefreshLayout swiperefreshlayout)
    {
        a = swiperefreshlayout;
        super(swiperefreshlayout);
    }
}
