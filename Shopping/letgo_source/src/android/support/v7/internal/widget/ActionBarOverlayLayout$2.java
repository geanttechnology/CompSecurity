// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.bd;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            ActionBarOverlayLayout

class a extends bd
{

    final ActionBarOverlayLayout a;

    public void onAnimationCancel(View view)
    {
        ActionBarOverlayLayout.b(a, null);
        ActionBarOverlayLayout.a(a, false);
    }

    public void onAnimationEnd(View view)
    {
        ActionBarOverlayLayout.b(a, null);
        ActionBarOverlayLayout.a(a, false);
    }

    A(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        a = actionbaroverlaylayout;
        super();
    }
}
