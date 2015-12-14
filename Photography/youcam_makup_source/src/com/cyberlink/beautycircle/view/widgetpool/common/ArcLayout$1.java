// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            ArcLayout

class a
    implements android.animation.matorListener
{

    final ArcLayout a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        a.setVisibility(4);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (ArcLayout arclayout)
    {
        a = arclayout;
        super();
    }
}
