// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.support.v4.view.a;
import android.support.v4.view.a.f;
import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

final class q extends a
{

    q(DrawerLayout drawerlayout)
    {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, f f1)
    {
        super.onInitializeAccessibilityNodeInfo(view, f1);
        if (!android.support.v4.widget.DrawerLayout.f(view))
        {
            f1.c(null);
        }
    }
}
