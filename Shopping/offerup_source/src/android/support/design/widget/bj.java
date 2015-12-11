// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.support.v4.widget.bo;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            SwipeDismissBehavior, bi

final class bj
    implements Runnable
{

    private final View a;
    private final boolean b;
    private SwipeDismissBehavior c;

    bj(SwipeDismissBehavior swipedismissbehavior, View view, boolean flag)
    {
        c = swipedismissbehavior;
        super();
        a = view;
        b = flag;
    }

    public final void run()
    {
        if (SwipeDismissBehavior.b(c) != null && SwipeDismissBehavior.b(c).a(true))
        {
            bi.a(a, this);
        } else
        if (b && SwipeDismissBehavior.a(c) != null)
        {
            SwipeDismissBehavior.a(c).a();
            return;
        }
    }
}
