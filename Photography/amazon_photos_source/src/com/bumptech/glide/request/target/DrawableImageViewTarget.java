// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package com.bumptech.glide.request.target:
//            ImageViewTarget

public class DrawableImageViewTarget extends ImageViewTarget
{

    public DrawableImageViewTarget(ImageView imageview)
    {
        super(imageview);
    }

    protected void setResource(Drawable drawable)
    {
        ((ImageView)view).setImageDrawable(drawable);
    }

    protected volatile void setResource(Object obj)
    {
        setResource((Drawable)obj);
    }
}
