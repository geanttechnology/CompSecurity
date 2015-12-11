// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.images.remote;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class RemoteImageLoaderHandler extends Handler
{

    private Drawable errorDrawable;
    private String imageUrl;
    private ImageView imageView;

    public RemoteImageLoaderHandler(ImageView imageview, String s, Drawable drawable)
    {
        imageView = imageview;
        imageUrl = s;
        errorDrawable = drawable;
    }

    public Drawable getErrorDrawable()
    {
        return errorDrawable;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    protected boolean handleImageLoaded(Bitmap bitmap, Message message)
    {
        message = (String)imageView.getTag();
        if (imageUrl.equals(message))
        {
            if (bitmap == null)
            {
                imageView.setImageDrawable(errorDrawable);
            } else
            {
                imageView.setImageBitmap(bitmap);
            }
            imageView.setTag(null);
            return true;
        } else
        {
            return false;
        }
    }

    protected final void handleImageLoadedMessage(Message message)
    {
        handleImageLoaded((Bitmap)message.getData().getParcelable("ign:extra_bitmap"), message);
    }

    public final void handleMessage(Message message)
    {
        if (message.what == 0)
        {
            handleImageLoadedMessage(message);
        }
    }
}
