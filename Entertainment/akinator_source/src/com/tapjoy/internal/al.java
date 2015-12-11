// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;

// Referenced classes of package com.tapjoy.internal:
//            ak

public final class al extends ak
{

    private final AnimationSet b;

    public al()
    {
        super(new AnimationSet(true));
        b = (AnimationSet)a;
    }

    public final volatile Animation a()
    {
        return b;
    }

    public final al a(Animation animation)
    {
        b.addAnimation(animation);
        return this;
    }
}
