// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.socialin.android.util:
//            af, AnimUtils

final class b extends af
{

    private View a;
    private int b;

    public final void onAnimationEnd(Animation animation)
    {
        a.setVisibility(b);
    }

    (View view, int i)
    {
        a = view;
        b = i;
        super();
    }
}
