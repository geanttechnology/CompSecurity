// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

// Referenced classes of package com.bumptech.glide.request.animation:
//            GlideAnimation

public class DrawableCrossFadeViewAnimation
    implements GlideAnimation
{

    private final GlideAnimation defaultAnimation;
    private final int duration;

    public DrawableCrossFadeViewAnimation(GlideAnimation glideanimation, int i)
    {
        defaultAnimation = glideanimation;
        duration = i;
    }

    public boolean animate(Drawable drawable, GlideAnimation.ViewAdapter viewadapter)
    {
        Drawable drawable1 = viewadapter.getCurrentDrawable();
        if (drawable1 != null)
        {
            drawable = new TransitionDrawable(new Drawable[] {
                drawable1, drawable
            });
            drawable.setCrossFadeEnabled(true);
            drawable.startTransition(duration);
            viewadapter.setDrawable(drawable);
            return true;
        } else
        {
            defaultAnimation.animate(drawable, viewadapter);
            return false;
        }
    }

    public volatile boolean animate(Object obj, GlideAnimation.ViewAdapter viewadapter)
    {
        return animate((Drawable)obj, viewadapter);
    }
}
