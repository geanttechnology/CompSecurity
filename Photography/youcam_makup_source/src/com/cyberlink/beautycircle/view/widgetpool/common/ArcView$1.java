// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.animation.Animator;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            ArcView

class a
    implements android.animation.nimatorListener
{

    final ArcView a;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        ArcView.a(a).setText("");
        ArcView.a(a).setVisibility(4);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    A(ArcView arcview)
    {
        a = arcview;
        super();
    }
}
