// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ah;
import android.support.v4.view.ay;

// Referenced classes of package android.support.v7.internal.widget:
//            ActionBarOverlayLayout, ActionBarContainer

class a
    implements Runnable
{

    final ActionBarOverlayLayout a;

    public void run()
    {
        ActionBarOverlayLayout.a(a);
        ActionBarOverlayLayout.a(a, ah.q(ActionBarOverlayLayout.c(a)).c(-ActionBarOverlayLayout.c(a).getHeight()).a(ActionBarOverlayLayout.b(a)));
        if (ActionBarOverlayLayout.d(a) != null && ActionBarOverlayLayout.d(a).getVisibility() != 8)
        {
            ActionBarOverlayLayout.b(a, ah.q(ActionBarOverlayLayout.d(a)).c(ActionBarOverlayLayout.d(a).getHeight()).a(ActionBarOverlayLayout.e(a)));
        }
    }

    A(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }
}
