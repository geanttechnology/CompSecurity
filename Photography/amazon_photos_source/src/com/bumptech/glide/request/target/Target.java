// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;

// Referenced classes of package com.bumptech.glide.request.target:
//            SizeReadyCallback

public interface Target
    extends LifecycleListener
{

    public abstract Request getRequest();

    public abstract void getSize(SizeReadyCallback sizereadycallback);

    public abstract void onLoadCleared(Drawable drawable);

    public abstract void onLoadFailed(Exception exception, Drawable drawable);

    public abstract void onLoadStarted(Drawable drawable);

    public abstract void onResourceReady(Object obj, GlideAnimation glideanimation);

    public abstract void setRequest(Request request);
}
