// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.view.View;

public class cc extends ViewPropertyAnimatorListenerAdapter
{

    final ActionBarOverlayLayout a;

    public cc(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }

    public void onAnimationCancel(View view)
    {
        ActionBarOverlayLayout.access$202(a, null);
        ActionBarOverlayLayout.access$102(a, false);
    }

    public void onAnimationEnd(View view)
    {
        ActionBarOverlayLayout.access$202(a, null);
        ActionBarOverlayLayout.access$102(a, false);
    }
}
