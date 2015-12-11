// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.jumio.netverify.sdk.gui.view.TemplateMatcherDrawView;

public class nr extends AnimatorListenerAdapter
{

    final TemplateMatcherDrawView a;

    public nr(TemplateMatcherDrawView templatematcherdrawview)
    {
        a = templatematcherdrawview;
        super();
    }

    public void onAnimationEnd(Animator animator)
    {
        a.mAnimationRunning = false;
    }

    public void onAnimationStart(Animator animator)
    {
        a.mAnimationRunning = true;
    }
}
