// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ad;
import android.support.v4.view.w;

// Referenced classes of package android.support.v7.internal.widget:
//            ActionBarOverlayLayout, ActionBarContainer

final class a
    implements Runnable
{

    final ActionBarOverlayLayout a;

    public final void run()
    {
        ActionBarOverlayLayout.b(a);
        ActionBarOverlayLayout.a(a, w.n(ActionBarOverlayLayout.d(a)).c(-ActionBarOverlayLayout.d(a).getHeight()).a(ActionBarOverlayLayout.c(a)));
        if (ActionBarOverlayLayout.e(a) != null && ActionBarOverlayLayout.e(a).getVisibility() != 8)
        {
            ActionBarOverlayLayout.b(a, w.n(ActionBarOverlayLayout.e(a)).c(ActionBarOverlayLayout.e(a).getHeight()).a(ActionBarOverlayLayout.f(a)));
        }
    }

    A(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }
}
