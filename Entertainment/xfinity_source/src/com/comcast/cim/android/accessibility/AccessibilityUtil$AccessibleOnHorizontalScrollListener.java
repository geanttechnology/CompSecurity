// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import com.comcast.cim.utils.UIPresentationUtil;
import it.sephiroth.android.library.widget.AbsHListView;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            AccessibilityUtil

protected class 
    implements it.sephiroth.android.library.widget.r
{

    private String description;

    public void onScroll(AbsHListView abshlistview, int i, int j, int k)
    {
        String s = UIPresentationUtil.getAbsListStateDescription(abshlistview, description, i, j, k);
        if (abshlistview.getTag() != null)
        {
            abshlistview.setContentDescription(s);
        }
    }

    public void onScrollStateChanged(AbsHListView abshlistview, int i)
    {
    }

    public void setDescription(String s)
    {
        description = s;
    }
}
