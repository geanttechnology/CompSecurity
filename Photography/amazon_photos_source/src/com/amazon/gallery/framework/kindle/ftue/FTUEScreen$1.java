// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.view.View;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUEScreen

class this._cls0 extends ViewTarget
{

    final FTUEScreen this$0;

    public void onResourceReady(GlideDrawable glidedrawable, GlideAnimation glideanimation)
    {
        layout.setBackgroundDrawable(glidedrawable);
    }

    public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        onResourceReady((GlideDrawable)obj, glideanimation);
    }

    e(View view)
    {
        this$0 = FTUEScreen.this;
        super(view);
    }
}
