// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
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
                if (a.D == 0)
                {
                    a.D = 1;
                    View view = a.getChildAt(a.y - a.T);
                    if (view != null && !view.hasFocusable())
                    {
                        a.f = 0;
                        if (a.ah)
                        {
                            break label0;
                        }
                        view.setPressed(true);
                        a.setPressed(true);
                        a.g();
                        a.a(a.y, view);
                        a.refreshDrawableState();
                        int i = ViewConfiguration.getLongPressTimeout();
                        boolean flag = a.isLongClickable();
                        if (a.k != null)
                        {
                            Drawable drawable = a.k.getCurrent();
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
            a.D = 2;
            return;
        }
        a.D = 2;
    }
}
