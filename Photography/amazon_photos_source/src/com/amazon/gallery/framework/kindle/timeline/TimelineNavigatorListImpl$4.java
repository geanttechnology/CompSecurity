// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.widget.AbsListView;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class this._cls0
    implements android.widget.
{

    final TimelineNavigatorListImpl this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (i != 0)
        {
            TimelineNavigatorListImpl.access$202(TimelineNavigatorListImpl.this, true);
        }
    }

    ()
    {
        this$0 = TimelineNavigatorListImpl.this;
        super();
    }
}
