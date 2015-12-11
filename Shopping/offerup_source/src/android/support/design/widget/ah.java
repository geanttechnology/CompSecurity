// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            af

final class ah extends AnimatorListenerAdapter
{

    private af a;

    ah(af af1)
    {
        a = af1;
        super();
    }

    public final void onAnimationStart(Animator animator)
    {
        a.e.setVisibility(0);
    }
}
