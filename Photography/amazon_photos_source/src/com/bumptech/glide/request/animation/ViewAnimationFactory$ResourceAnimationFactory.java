// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.bumptech.glide.request.animation:
//            ViewAnimationFactory

private static class animationId
    implements animationId
{

    private final int animationId;
    private final Context context;

    public Animation build()
    {
        return AnimationUtils.loadAnimation(context, animationId);
    }

    public (Context context1, int i)
    {
        context = context1.getApplicationContext();
        animationId = i;
    }
}
