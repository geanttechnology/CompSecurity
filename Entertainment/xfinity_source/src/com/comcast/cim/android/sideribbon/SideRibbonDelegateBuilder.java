// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.comcast.cim.android.accessibility.AccessibilityUtil;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

public class SideRibbonDelegateBuilder
{
    public static class Configuration
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
        static int access$002(Configuration configuration1, int i)
        {
            configuration1.ribbonWidth = i;
            return i;
        }

*/


/*
        static long access$102(Configuration configuration1, long l)
        {
            configuration1.slideDuration = l;
            return l;
        }

*/


/*
        static Integer access$302(Configuration configuration1, Integer integer)
        {
            configuration1.backgroundResource = integer;
            return integer;
        }

*/

        public Configuration()
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


    private final AccessibilityUtil accessibilityUtil;
    private Configuration configuration;

    public SideRibbonDelegateBuilder(AccessibilityUtil accessibilityutil)
    {
        accessibilityUtil = accessibilityutil;
        configuration = new Configuration();
    }

    public SideRibbonDelegate build(Activity activity)
    {
        return build(((Context) (activity)), (ViewGroup)activity.getWindow().getDecorView());
    }

    public SideRibbonDelegate build(Context context, ViewGroup viewgroup)
    {
        return new SideRibbonDelegate(context, viewgroup, configuration, accessibilityUtil);
    }

    public SideRibbonDelegateBuilder setBackgroundResource(Integer integer)
    {
        configuration.backgroundResource = integer;
        return this;
    }

    public SideRibbonDelegateBuilder setRibbonWidth(int i)
    {
        configuration.ribbonWidth = i;
        return this;
    }

    public SideRibbonDelegateBuilder setSlideDuration(long l)
    {
        configuration.slideDuration = l;
        return this;
    }
}
