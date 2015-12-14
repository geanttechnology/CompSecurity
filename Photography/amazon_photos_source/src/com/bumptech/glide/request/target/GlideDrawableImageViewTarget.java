// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

// Referenced classes of package com.bumptech.glide.request.target:
//            ImageViewTarget, SquaringDrawable

public class GlideDrawableImageViewTarget extends ImageViewTarget
{

    private int maxLoopCount;
    private GlideDrawable resource;

    public GlideDrawableImageViewTarget(ImageView imageview)
    {
        this(imageview, -1);
    }

    public GlideDrawableImageViewTarget(ImageView imageview, int i)
    {
        super(imageview);
        maxLoopCount = i;
    }

    public void onResourceReady(GlideDrawable glidedrawable, GlideAnimation glideanimation)
    {
        Object obj = glidedrawable;
        if (!glidedrawable.isAnimated())
        {
            float f = (float)((ImageView)view).getWidth() / (float)((ImageView)view).getHeight();
            float f1 = (float)glidedrawable.getIntrinsicWidth() / (float)glidedrawable.getIntrinsicHeight();
            obj = glidedrawable;
            if (Math.abs(f - 1.0F) <= 0.05F)
            {
                obj = glidedrawable;
                if (Math.abs(f1 - 1.0F) <= 0.05F)
                {
                    obj = new SquaringDrawable(glidedrawable, ((ImageView)view).getWidth());
                }
            }
        }
        super.onResourceReady(obj, glideanimation);
        resource = ((GlideDrawable) (obj));
        ((GlideDrawable) (obj)).setLoopCount(maxLoopCount);
        ((GlideDrawable) (obj)).start();
    }

    public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        onResourceReady((GlideDrawable)obj, glideanimation);
    }

    public void onStart()
    {
        if (resource != null)
        {
            resource.start();
        }
    }

    public void onStop()
    {
        if (resource != null)
        {
            resource.stop();
        }
    }

    protected void setResource(GlideDrawable glidedrawable)
    {
        ((ImageView)view).setImageDrawable(glidedrawable);
    }

    protected volatile void setResource(Object obj)
    {
        setResource((GlideDrawable)obj);
    }
}
