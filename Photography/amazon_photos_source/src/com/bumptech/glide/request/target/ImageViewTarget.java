// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;

// Referenced classes of package com.bumptech.glide.request.target:
//            ViewTarget

public abstract class ImageViewTarget extends ViewTarget
    implements com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter
{

    public ImageViewTarget(ImageView imageview)
    {
        super(imageview);
    }

    public Drawable getCurrentDrawable()
    {
        return ((ImageView)view).getDrawable();
    }

    public void onLoadCleared(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    public void onLoadFailed(Exception exception, Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    public void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        if (glideanimation == null || !glideanimation.animate(obj, this))
        {
            setResource(obj);
        }
    }

    public void setDrawable(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Object obj);
}
