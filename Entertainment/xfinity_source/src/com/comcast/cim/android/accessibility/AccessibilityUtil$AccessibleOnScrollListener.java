// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.widget.AbsListView;
import com.comcast.cim.utils.UIPresentationUtil;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            AccessibilityUtil

protected class this._cls0
    implements android.widget.ssibleOnScrollListener
{

    private String description;
    final AccessibilityUtil this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        String s = UIPresentationUtil.getAbsListStateDescription(abslistview, description, i, j, k);
        if (abslistview.getTag() != null)
        {
            abslistview.setContentDescription(s);
        }
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
        this$0 = AccessibilityUtil.this;
        super();
    }
}
