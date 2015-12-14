// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView

final class a
    implements Runnable
{

    final PLA_AbsListView a;

    a(PLA_AbsListView pla_abslistview)
    {
        a = pla_abslistview;
        super();
    }

    public void run()
    {
label0:
        {
label1:
            {
                if (a.v == 0)
                {
                    a.v = 1;
                    View view = a.getChildAt(a.q - a.E);
                    if (view != null && !view.hasFocusable())
                    {
                        a.c = 0;
                        if (a.Q)
                        {
                            break label0;
                        }
                        a.d();
                        view.setPressed(true);
                        a.a(view);
                        a.setPressed(true);
                        int i = ViewConfiguration.getLongPressTimeout();
                        boolean flag = a.isLongClickable();
                        if (a.g != null)
                        {
                            Drawable drawable = a.g.getCurrent();
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
                    }
                }
                return;
            }
            a.v = 2;
            return;
        }
        a.v = 2;
    }
}
