// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AbsListView, b

final class c
    implements Runnable
{

    final AbsListView a;

    c(AbsListView abslistview)
    {
        a = abslistview;
        super();
    }

    public void run()
    {
label0:
        {
label1:
            {
                if (a.C == 0)
                {
                    a.C = 1;
                    View view = a.getChildAt(a.x - a.S);
                    if (view != null && !view.hasFocusable())
                    {
                        a.e = 0;
                        if (a.ag)
                        {
                            break label0;
                        }
                        view.setPressed(true);
                        a.setPressed(true);
                        a.f();
                        a.a(a.x, view);
                        a.refreshDrawableState();
                        int i = ViewConfiguration.getLongPressTimeout();
                        boolean flag = a.isLongClickable();
                        if (a.j != null)
                        {
                            Drawable drawable = a.j.getCurrent();
                            if (drawable != null && (drawable instanceof TransitionDrawable))
                            {
                                if (flag)
                                {
                                    ((TransitionDrawable)drawable).startTransition(i);
                                } else
                                {
                                    ((TransitionDrawable)drawable).resetTransition();
                                }
                            }
                        }
                        if (!flag)
                        {
                            break label1;
                        }
                        if (AbsListView.c(a) == null)
                        {
                            AbsListView.a(a, new b(a, null));
                        }
                        AbsListView.c(a).a();
                        a.postDelayed(AbsListView.c(a), i);
                    }
                }
                return;
            }
            a.C = 2;
            return;
        }
        a.C = 2;
    }
}
