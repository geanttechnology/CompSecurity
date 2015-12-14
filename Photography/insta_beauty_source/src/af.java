// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class af extends ViewPropertyAnimatorListenerAdapter
{

    final ae a;

    af(ae ae1)
    {
        a = ae1;
        super();
    }

    public void onAnimationEnd(View view)
    {
        if (ae.a(a) && ae.b(a) != null)
        {
            ViewCompat.setTranslationY(ae.b(a), 0.0F);
            ViewCompat.setTranslationY(ae.c(a), 0.0F);
        }
        if (ae.d(a) != null && ae.e(a) == 1)
        {
            ae.d(a).setVisibility(8);
        }
        ae.c(a).setVisibility(8);
        ae.c(a).setTransitioning(false);
        ae.a(a, null);
        a.e();
        if (ae.f(a) != null)
        {
            ViewCompat.requestApplyInsets(ae.f(a));
        }
    }
}
