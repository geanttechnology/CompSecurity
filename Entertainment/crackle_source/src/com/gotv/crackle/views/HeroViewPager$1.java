// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.view.animation.Interpolator;

// Referenced classes of package com.gotv.crackle.views:
//            HeroViewPager

static final class 
    implements Interpolator
{

    public float getInterpolation(float f)
    {
        f--;
        return f * f * f + 1.0F;
    }

    ()
    {
    }
}
