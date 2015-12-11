// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            e

class a
    implements 
{

    final e a;

    public void a(int i)
    {
        if (e.b(a) == -1)
        {
            e.a(a, i);
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -e.c(a).getMeasuredHeight() * 2);
            translateanimation.setDuration(500L);
            translateanimation.setFillAfter(true);
            translateanimation.setFillBefore(true);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 200L);
            e.c(a).setAnimation(translateanimation);
            if (!a.s)
            {
                e.a(a, 400, true);
            }
        }
    }

    lator(e e1)
    {
        a = e1;
        super();
    }
}
