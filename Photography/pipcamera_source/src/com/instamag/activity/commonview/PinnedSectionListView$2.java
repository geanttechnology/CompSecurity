// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.view.View;

// Referenced classes of package com.instamag.activity.commonview:
//            PinnedSectionListView

class a
    implements Runnable
{

    final PinnedSectionListView a;

    public void run()
    {
        if (a.getAdapter() != null)
        {
            int i = a.getFirstVisiblePosition();
            int j = PinnedSectionListView.access$100(a, i);
            if (j != -1)
            {
                if (i == j)
                {
                    PinnedSectionListView.access$200(a, i);
                    View view = a.getChildAt(i);
                    PinnedSectionListView pinnedsectionlistview = a;
                    if (view == null)
                    {
                        i = 0;
                    } else
                    {
                        i = -view.getTop();
                    }
                    pinnedsectionlistview.mTranslateY = i;
                    return;
                } else
                {
                    PinnedSectionListView.access$200(a, j);
                    return;
                }
            }
        }
    }

    (PinnedSectionListView pinnedsectionlistview)
    {
        a = pinnedsectionlistview;
        super();
    }
}
