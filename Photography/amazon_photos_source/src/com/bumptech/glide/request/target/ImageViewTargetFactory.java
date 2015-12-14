// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

// Referenced classes of package com.bumptech.glide.request.target:
//            GlideDrawableImageViewTarget, BitmapImageViewTarget, DrawableImageViewTarget, Target

public class ImageViewTargetFactory
{

    public ImageViewTargetFactory()
    {
    }

    public Target buildTarget(ImageView imageview, Class class1)
    {
        if (com/bumptech/glide/load/resource/drawable/GlideDrawable.isAssignableFrom(class1))
        {
            return new GlideDrawableImageViewTarget(imageview);
        }
        if (android/graphics/Bitmap.equals(class1))
        {
            return new BitmapImageViewTarget(imageview);
        }
        if (android/graphics/drawable/Drawable.isAssignableFrom(class1))
        {
            return new DrawableImageViewTarget(imageview);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unhandled class: ").append(class1).append(", try .as*(Class).transcode(ResourceTranscoder)").toString());
        }
    }
}
