// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

// Referenced classes of package com.bumptech.glide:
//            Glide

private static class wTarget extends ViewTarget
{

    public void onLoadCleared(Drawable drawable)
    {
    }

    public void onLoadFailed(Exception exception, Drawable drawable)
    {
    }

    public void onLoadStarted(Drawable drawable)
    {
    }

    public void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
    }

    public GlideAnimation(View view)
    {
        super(view);
    }
}
