// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifFrameLoader

static class targetTime extends SimpleTarget
{

    private final Handler handler;
    private final int index;
    private Bitmap resource;
    private final long targetTime;

    public Bitmap getResource()
    {
        return resource;
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation glideanimation)
    {
        resource = bitmap;
        bitmap = handler.obtainMessage(1, this);
        handler.sendMessageAtTime(bitmap, targetTime);
    }

    public volatile void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        onResourceReady((Bitmap)obj, glideanimation);
    }


    public (Handler handler1, int i, long l)
    {
        handler = handler1;
        index = i;
        targetTime = l;
    }
}
