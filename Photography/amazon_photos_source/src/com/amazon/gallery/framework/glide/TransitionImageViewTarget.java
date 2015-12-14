// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class TransitionImageViewTarget extends BitmapImageViewTarget
{

    private final Context context;
    private Request request;
    private ImageView view;

    public TransitionImageViewTarget(Context context1, ImageView imageview)
    {
        super(imageview);
        context = context1;
        view = imageview;
    }

    public Request getRequest()
    {
        return request;
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation glideanimation)
    {
        Drawable drawable = view.getDrawable();
        if (drawable != null)
        {
            bitmap = new TransitionDrawable(new Drawable[] {
                drawable, new BitmapDrawable(context.getResources(), bitmap)
            });
            view.setImageDrawable(bitmap);
            bitmap.startTransition(400);
            return;
        } else
        {
            super.onResourceReady(bitmap, glideanimation);
            return;
        }
    }

    public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        onResourceReady((Bitmap)obj, glideanimation);
    }

    public void setRequest(Request request1)
    {
        request = request1;
    }
}
