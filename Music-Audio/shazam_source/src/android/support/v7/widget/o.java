// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            StaggeredGridLayoutManager, RecyclerView

public final class o extends StaggeredGridLayoutManager
{

    public o(int i)
    {
        super(i);
    }

    public final int[] a(int ai[])
    {
        if (!h())
        {
            RecyclerView.a a1;
            int i;
            if (super.i != null)
            {
                a1 = super.i.getAdapter();
            } else
            {
                a1 = null;
            }
            if (a1 != null)
            {
                i = a1.a();
            } else
            {
                i = 0;
            }
            if (i > 0 && j() > 0 && c(0).getTop() > 0 && super.a == 1)
            {
                return (new int[] {
                    0
                });
            }
        }
        return super.a(ai);
    }
}
