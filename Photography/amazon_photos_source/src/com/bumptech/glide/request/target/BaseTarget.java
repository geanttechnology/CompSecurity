// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

// Referenced classes of package com.bumptech.glide.request.target:
//            Target

public abstract class BaseTarget
    implements Target
{

    private Request request;

    public BaseTarget()
    {
    }

    public Request getRequest()
    {
        return request;
    }

    public void onDestroy()
    {
    }

    public void onLoadCleared(Drawable drawable)
    {
    }

    public void onLoadFailed(Exception exception, Drawable drawable)
    {
    }

    public void onLoadStarted(Drawable drawable)
    {
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void setRequest(Request request1)
    {
        request = request1;
    }
}
