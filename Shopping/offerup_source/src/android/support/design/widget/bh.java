// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.bi;
import android.support.v4.widget.bo;
import android.support.v4.widget.br;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            SwipeDismissBehavior, bi, bj

final class bh extends br
{

    private int a;
    private SwipeDismissBehavior b;

    bh(SwipeDismissBehavior swipedismissbehavior)
    {
        b = swipedismissbehavior;
        super();
    }

    public final int clampViewPositionHorizontal(View view, int i, int j)
    {
        int k;
        if (bi.h(view) == 1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (SwipeDismissBehavior.c(b) == 0)
        {
            if (j != 0)
            {
                j = a - view.getWidth();
                k = a;
            } else
            {
                j = a;
                k = a + view.getWidth();
            }
        } else
        if (SwipeDismissBehavior.c(b) == 1)
        {
            if (j != 0)
            {
                j = a;
                k = a + view.getWidth();
            } else
            {
                j = a - view.getWidth();
                k = a;
            }
        } else
        {
            j = a - view.getWidth();
            k = a + view.getWidth();
        }
        return SwipeDismissBehavior.a(j, i, k);
    }

    public final int clampViewPositionVertical(View view, int i, int j)
    {
        return view.getTop();
    }

    public final int getViewHorizontalDragRange(View view)
    {
        return view.getWidth();
    }

    public final void onViewDragStateChanged(int i)
    {
        if (SwipeDismissBehavior.a(b) != null)
        {
            SwipeDismissBehavior.a(b).a(i);
        }
    }

    public final void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
        float f = (float)a + (float)view.getWidth() * SwipeDismissBehavior.e(b);
        float f1 = (float)a + (float)view.getWidth() * SwipeDismissBehavior.f(b);
        if ((float)i <= f)
        {
            bi.c(view, 1.0F);
            return;
        }
        if ((float)i >= f1)
        {
            bi.c(view, 0.0F);
            return;
        } else
        {
            bi.c(view, SwipeDismissBehavior.b(0.0F, 1.0F - SwipeDismissBehavior.a(f, f1, i), 1.0F));
            return;
        }
    }

    public final void onViewReleased(View view, float f, float f1)
    {
        boolean flag = true;
        int j = view.getWidth();
        int i;
        if (f != 0.0F)
        {
            if (bi.h(view) == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            int k;
            int l;
            if (SwipeDismissBehavior.c(b) == 2)
            {
                i = 1;
            } else
            if (SwipeDismissBehavior.c(b) == 0)
            {
                if (i != 0)
                {
                    if (f < 0.0F)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                } else
                if (f > 0.0F)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            if (SwipeDismissBehavior.c(b) == 1)
            {
                if (i != 0)
                {
                    if (f > 0.0F)
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                } else
                if (f < 0.0F)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            } else
            {
                i = 0;
            }
        } else
        {
            i = view.getLeft();
            k = a;
            l = Math.round((float)view.getWidth() * SwipeDismissBehavior.d(b));
            if (Math.abs(i - k) >= l)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        }
        if (i != 0)
        {
            if (view.getLeft() < a)
            {
                i = a - j;
            } else
            {
                i = a + j;
            }
        } else
        {
            i = a;
            flag = false;
        }
        if (SwipeDismissBehavior.b(b).a(i, view.getTop()))
        {
            bi.a(view, new bj(b, view, flag));
        } else
        if (flag && SwipeDismissBehavior.a(b) != null)
        {
            SwipeDismissBehavior.a(b).a();
            return;
        }
    }

    public final boolean tryCaptureView(View view, int i)
    {
        a = view.getLeft();
        return true;
    }
}
