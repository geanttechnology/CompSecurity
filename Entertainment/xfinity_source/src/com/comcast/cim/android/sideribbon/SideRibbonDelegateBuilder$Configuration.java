// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.graphics.drawable.Drawable;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegateBuilder

public static class shadowDrawable
{

    private static final Interpolator DEFAULT_ANIMATION_INTERPOLATOR = new DecelerateInterpolator();
    private Interpolator animationInterpolator;
    private Integer backgroundColor;
    private Drawable backgroundDrawable;
    private Integer backgroundResource;
    private int ribbonWidth;
    private int shadowColor;
    private Drawable shadowDrawable;
    private Integer shadowResource;
    private int shadowWidth;
    private long slideDuration;

    public Interpolator getAnimationInterpolator()
    {
        return animationInterpolator;
    }

    public Integer getBackgroundColor()
    {
        return backgroundColor;
    }

    public Drawable getBackgroundDrawable()
    {
        return backgroundDrawable;
    }

    public Integer getBackgroundResource()
    {
        return backgroundResource;
    }

    public int getRibbonWidth()
    {
        return ribbonWidth;
    }

    public int getShadowColor()
    {
        return shadowColor;
    }

    public Drawable getShadowDrawable()
    {
        return shadowDrawable;
    }

    public Integer getShadowResource()
    {
        return shadowResource;
    }

    public int getShadowWidth()
    {
        return shadowWidth;
    }

    public long getSlideDuration()
    {
        return slideDuration;
    }



/*
    static int access$002( , int i)
    {
        .ribbonWidth = i;
        return i;
    }

*/


/*
    static long access$102(ribbonWidth ribbonwidth, long l)
    {
        ribbonwidth.slideDuration = l;
        return l;
    }

*/


/*
    static Integer access$302(slideDuration slideduration, Integer integer)
    {
        slideduration.backgroundResource = integer;
        return integer;
    }

*/

    public backgroundResource()
    {
        ribbonWidth = 200;
        slideDuration = 200L;
        animationInterpolator = DEFAULT_ANIMATION_INTERPOLATOR;
        backgroundResource = null;
        backgroundColor = null;
        backgroundDrawable = null;
        shadowWidth = 2;
        shadowColor = 0xff000000;
        shadowResource = null;
        shadowDrawable = null;
    }
}
