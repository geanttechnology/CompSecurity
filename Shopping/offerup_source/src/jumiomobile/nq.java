// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ValueAnimator;
import com.jumio.netverify.sdk.gui.view.TemplateMatcherDrawView;

public class nq
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    final TemplateMatcherDrawView a;

    public nq(TemplateMatcherDrawView templatematcherdrawview)
    {
        a = templatematcherdrawview;
        super();
    }

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.postInvalidate();
    }
}
