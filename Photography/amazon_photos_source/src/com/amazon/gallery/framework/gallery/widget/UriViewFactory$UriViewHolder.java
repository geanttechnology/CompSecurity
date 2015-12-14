// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.amazon.gallery.framework.gallery.widget.holder.LoadingHolderInterface;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            UriViewFactory

private static class imageView
    implements LoadingHolderInterface
{

    private ImageView imageView;
    private boolean isLoaded;

    public void imageLoaded(Bitmap bitmap)
    {
        imageView.setImageBitmap(bitmap);
        isLoaded = true;
    }

    public boolean isLoading()
    {
        return !isLoaded;
    }

    public (ImageView imageview)
    {
        isLoaded = false;
        imageView = imageview;
    }
}
