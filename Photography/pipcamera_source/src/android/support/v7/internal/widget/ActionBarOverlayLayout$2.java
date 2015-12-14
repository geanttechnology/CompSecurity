// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ActionBarOverlayLayout

class <init> extends ViewPropertyAnimatorListenerAdapter
{

    final ActionBarOverlayLayout a;

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

    A(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }
}
