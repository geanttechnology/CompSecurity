// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.widget.AbsListView;

// Referenced classes of package com.livemixtapes:
//            MixtapeList

class previousLast
    implements android.widget.ScrollListener
{

    private int previousLast;
    final MixtapeList this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        i += j;
        if (i == k && i > 1 && i != previousLast)
        {
            previousLast = i;
            abslistview = MixtapeList.this;
            abslistview.curPage = ((MixtapeList) (abslistview)).curPage + 1;
            MixtapeList.access$0(MixtapeList.this);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    rollListener()
    {
        this$0 = MixtapeList.this;
        super();
        previousLast = -1;
    }
}
