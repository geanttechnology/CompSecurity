// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.bumptech.glide.request.target:
//            ImageViewTarget

public class BitmapImageViewTarget extends ImageViewTarget
{

    public BitmapImageViewTarget(ImageView imageview)
    {
        super(imageview);
    }

    protected void setResource(Bitmap bitmap)
    {
        ((ImageView)view).setImageBitmap(bitmap);
    }

    protected volatile void setResource(Object obj)
    {
        setResource((Bitmap)obj);
    }
}
