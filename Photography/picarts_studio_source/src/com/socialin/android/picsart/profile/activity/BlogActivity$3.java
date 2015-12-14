// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.view.View;
import android.widget.AbsListView;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            BlogActivity, a

final class a
    implements android.widget.crollListener
{

    private BlogActivity a;

    public final void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (BlogActivity.c(a) != null)
        {
            abslistview = BlogActivity.c(a);
            if (i > 5)
            {
                k = 0;
            } else
            {
                k = 8;
            }
            abslistview.setVisibility(k);
        }
        if (!com.socialin.android.picsart.profile.activity.BlogActivity.d(a) && BlogActivity.e(a) != null && (i + j) - 1 == BlogActivity.e(a).getCount() - 1)
        {
            BlogActivity.f(a);
        }
    }

    public final void onScrollStateChanged(AbsListView abslistview, int i)
    {
        d.c(new Object[] {
            BlogActivity.a(), (new StringBuilder("setOnScrollListener: ")).append(i).toString()
        });
    }

    (BlogActivity blogactivity)
    {
        a = blogactivity;
        super();
    }
}
