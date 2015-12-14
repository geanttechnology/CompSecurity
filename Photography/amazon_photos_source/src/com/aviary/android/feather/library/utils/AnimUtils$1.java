// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.utils;

import com.nineoldandroids.animation.Animator;
import java.util.HashSet;

// Referenced classes of package com.aviary.android.feather.library.utils:
//            AnimUtils

static final class er
    implements com.nineoldandroids.animation.matorListener
{

    public void onAnimationCancel(Animator animator)
    {
        AnimUtils.sAnimators.remove(animator);
    }

    public void onAnimationEnd(Animator animator)
    {
        AnimUtils.sAnimators.remove(animator);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    er()
    {
    }
}
