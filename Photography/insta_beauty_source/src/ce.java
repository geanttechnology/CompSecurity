// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarOverlayLayout;

public class ce
    implements Runnable
{

    final ActionBarOverlayLayout a;

    public ce(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }

    public void run()
    {
        ActionBarOverlayLayout.access$300(a);
        ActionBarOverlayLayout.access$002(a, ViewCompat.animate(ActionBarOverlayLayout.access$500(a)).translationY(-ActionBarOverlayLayout.access$500(a).getHeight()).setListener(ActionBarOverlayLayout.access$400(a)));
        if (ActionBarOverlayLayout.access$600(a) != null && ActionBarOverlayLayout.access$600(a).getVisibility() != 8)
        {
            ActionBarOverlayLayout.access$202(a, ViewCompat.animate(ActionBarOverlayLayout.access$600(a)).translationY(ActionBarOverlayLayout.access$600(a).getHeight()).setListener(ActionBarOverlayLayout.access$700(a)));
        }
    }
}
