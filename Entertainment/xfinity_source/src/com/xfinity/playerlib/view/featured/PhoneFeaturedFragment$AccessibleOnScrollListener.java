// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.widget.AbsListView;
import com.comcast.cim.utils.UIPresentationUtil;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment

protected class this._cls0
    implements android.widget.ibleOnScrollListener
{

    private String description;
    final PhoneFeaturedFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        abslistview.setContentDescription(UIPresentationUtil.getAbsListStateDescription(abslistview, description, i, j, k));
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    public void setDescription(String s)
    {
        description = s;
    }

    protected ()
    {
        this$0 = PhoneFeaturedFragment.this;
        super();
    }
}
