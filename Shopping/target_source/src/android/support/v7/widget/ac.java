// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            x

class ac
{

    static int a(RecyclerView.q q, x x1, View view, View view1, RecyclerView.h h, boolean flag)
    {
        if (h.o() == 0 || q.e() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return Math.abs(h.d(view) - h.d(view1)) + 1;
        } else
        {
            int i = x1.b(view1);
            int j = x1.a(view);
            return Math.min(x1.f(), i - j);
        }
    }

    static int a(RecyclerView.q q, x x1, View view, View view1, RecyclerView.h h, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int j = ((flag2) ? 1 : 0);
        if (h.o() != 0)
        {
            j = ((flag2) ? 1 : 0);
            if (q.e() != 0)
            {
                j = ((flag2) ? 1 : 0);
                if (view != null)
                {
                    if (view1 == null)
                    {
                        j = ((flag2) ? 1 : 0);
                    } else
                    {
                        int i = Math.min(h.d(view), h.d(view1));
                        j = Math.max(h.d(view), h.d(view1));
                        if (flag1)
                        {
                            i = Math.max(0, q.e() - j - 1);
                        } else
                        {
                            i = Math.max(0, i);
                        }
                        j = i;
                        if (flag)
                        {
                            int k = Math.abs(x1.b(view1) - x1.a(view));
                            int l = Math.abs(h.d(view) - h.d(view1));
                            float f = (float)k / (float)(l + 1);
                            return Math.round((float)i * f + (float)(x1.c() - x1.a(view)));
                        }
                    }
                }
            }
        }
        return j;
    }

    static int b(RecyclerView.q q, x x1, View view, View view1, RecyclerView.h h, boolean flag)
    {
        if (h.o() == 0 || q.e() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return q.e();
        } else
        {
            int i = x1.b(view1);
            int j = x1.a(view);
            int k = Math.abs(h.d(view) - h.d(view1));
            return (int)(((float)(i - j) / (float)(k + 1)) * (float)q.e());
        }
    }
}
