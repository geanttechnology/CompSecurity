// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            u

final class w
{

    static int a(RecyclerView.r r, u u1, View view, View view1, RecyclerView.i i, boolean flag)
    {
        if (i.j() == 0 || r.a() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return Math.abs(RecyclerView.i.a(view) - RecyclerView.i.a(view1)) + 1;
        } else
        {
            int j = u1.b(view1);
            int k = u1.a(view);
            return Math.min(u1.e(), j - k);
        }
    }

    static int a(RecyclerView.r r, u u1, View view, View view1, RecyclerView.i i, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int k = ((flag2) ? 1 : 0);
        if (i.j() != 0)
        {
            k = ((flag2) ? 1 : 0);
            if (r.a() != 0)
            {
                k = ((flag2) ? 1 : 0);
                if (view != null)
                {
                    if (view1 == null)
                    {
                        k = ((flag2) ? 1 : 0);
                    } else
                    {
                        int j = Math.min(RecyclerView.i.a(view), RecyclerView.i.a(view1));
                        k = Math.max(RecyclerView.i.a(view), RecyclerView.i.a(view1));
                        if (flag1)
                        {
                            j = Math.max(0, r.a() - k - 1);
                        } else
                        {
                            j = Math.max(0, j);
                        }
                        k = j;
                        if (flag)
                        {
                            int l = Math.abs(u1.b(view1) - u1.a(view));
                            int i1 = Math.abs(RecyclerView.i.a(view) - RecyclerView.i.a(view1));
                            float f = (float)l / (float)(i1 + 1);
                            return Math.round((float)j * f + (float)(u1.b() - u1.a(view)));
                        }
                    }
                }
            }
        }
        return k;
    }

    static int b(RecyclerView.r r, u u1, View view, View view1, RecyclerView.i i, boolean flag)
    {
        if (i.j() == 0 || r.a() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return r.a();
        } else
        {
            int j = u1.b(view1);
            int k = u1.a(view);
            int l = Math.abs(RecyclerView.i.a(view) - RecyclerView.i.a(view1));
            return (int)(((float)(j - k) / (float)(l + 1)) * (float)r.a());
        }
    }
}
