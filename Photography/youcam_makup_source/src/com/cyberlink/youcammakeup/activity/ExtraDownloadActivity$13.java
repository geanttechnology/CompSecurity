// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.widget.ExpandableListView;
import com.cyberlink.youcammakeup.pages.moreview.aa;
import com.idunnololz.widgets.AnimatedExpandableListView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements android.widget.pClickListener
{

    final ExtraDownloadActivity a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (ExtraDownloadActivity.a(a).isGroupExpanded(i))
        {
            ExtraDownloadActivity.a(a).b(i);
        } else
        {
            int k = i + 1;
            for (int j = 0; j < i;)
            {
                int i1 = k;
                if (ExtraDownloadActivity.a(a).isGroupExpanded(j))
                {
                    i1 = k + ExtraDownloadActivity.i(a).getChildrenCount(j);
                }
                j++;
                k = i1;
            }

            ExtraDownloadActivity.a(a).a(i);
            ExtraDownloadActivity.a(a).smoothScrollToPosition(k);
        }
        return true;
    }

    (ExtraDownloadActivity extradownloadactivity)
    {
        a = extradownloadactivity;
        super();
    }
}
