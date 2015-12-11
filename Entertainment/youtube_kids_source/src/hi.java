// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarOverlayLayout;

public final class hi
    implements Runnable
{

    private ActionBarOverlayLayout a;

    public hi(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }

    public final void run()
    {
        ActionBarOverlayLayout.a(a);
        ActionBarOverlayLayout.a(a, dz.e(ActionBarOverlayLayout.c(a)).a(0.0F).a(ActionBarOverlayLayout.b(a)));
        if (ActionBarOverlayLayout.d(a) != null && ActionBarOverlayLayout.d(a).getVisibility() != 8)
        {
            ActionBarOverlayLayout.b(a, dz.e(ActionBarOverlayLayout.d(a)).a(0.0F).a(ActionBarOverlayLayout.e(a)));
        }
    }
}
