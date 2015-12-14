// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarContainer;
import android.view.View;

class ag extends ViewPropertyAnimatorListenerAdapter
{

    final ae a;

    ag(ae ae1)
    {
        a = ae1;
        super();
    }

    public void onAnimationEnd(View view)
    {
        ae.a(a, null);
        ae.c(a).requestLayout();
    }
}
