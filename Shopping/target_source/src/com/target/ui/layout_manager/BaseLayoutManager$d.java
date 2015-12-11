// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.layout_manager;

import android.support.v7.widget.x;
import android.view.View;

// Referenced classes of package com.target.ui.layout_manager:
//            BaseLayoutManager

private static class 
{

    static int a(android.support.v7.widget..d d1, x x1, View view, View view1, android.support.v7.widget..d d2, boolean flag)
    {
        if (d2.d() == 0 || d1.d() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return Math.abs(d2.d(view) - d2.d(view1)) + 1;
        } else
        {
            int i = x1.b(view1);
            int j = x1.a(view);
            return Math.min(x1.f(), i - j);
        }
    }

    static int a(android.support.v7.widget..d d1, x x1, View view, View view1, android.support.v7.widget..d d2, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int j = ((flag2) ? 1 : 0);
        if (d2.d() != 0)
        {
            j = ((flag2) ? 1 : 0);
            if (d1.d() != 0)
            {
                j = ((flag2) ? 1 : 0);
                if (view != null)
                {
                    if (view1 == null)
                    {
                        j = ((flag2) ? 1 : 0);
                    } else
                    {
                        int i = Math.min(d2.d(view), d2.d(view1));
                        j = Math.max(d2.d(view), d2.d(view1));
                        if (flag1)
                        {
                            i = Math.max(0, d1.d() - j - 1);
                        } else
                        {
                            i = Math.max(0, i);
                        }
                        j = i;
                        if (flag)
                        {
                            int k = Math.abs(x1.b(view1) - x1.a(view));
                            int l = Math.abs(d2.d(view) - d2.d(view1));
                            float f = (float)k / (float)(l + 1);
                            return Math.round((float)i * f + (float)(x1.c() - x1.a(view)));
                        }
                    }
                }
            }
        }
        return j;
    }

    static int b(android.support.v7.widget..d d1, x x1, View view, View view1, android.support.v7.widget..d d2, boolean flag)
    {
        if (d2.d() == 0 || d1.d() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return d1.d();
        } else
        {
            int i = x1.b(view1);
            int j = x1.a(view);
            int k = Math.abs(d2.d(view) - d2.d(view1));
            return (int)(((float)(i - j) / (float)(k + 1)) * (float)d1.d());
        }
    }
}
