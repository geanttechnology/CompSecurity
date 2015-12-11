// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.d;
import android.support.v7.widget.s;

// Referenced classes of package android.support.v7.internal.widget:
//            ActivityChooserView

final class a
    implements android.view.balLayoutListener
{

    final ActivityChooserView a;

    public final void onGlobalLayout()
    {
        if (a.c())
        {
            if (!a.isShown())
            {
                ActivityChooserView.b(a).a();
            } else
            {
                ActivityChooserView.b(a).c();
                if (a.a != null)
                {
                    a.a.subUiVisibilityChanged(true);
                    return;
                }
            }
        }
    }

    (ActivityChooserView activitychooserview)
    {
        a = activitychooserview;
        super();
    }
}
