// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.view.View;
import android.widget.ExpandableListView;
import com.xiaos.view.PinnedHeaderExpandableListView;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements android.widget.istener
{

    final JunkActivity this$0;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (JunkActivity.access$56(JunkActivity.this) == -1)
        {
            JunkActivity.access$49(JunkActivity.this).expandGroup(i);
            JunkActivity.access$49(JunkActivity.this).setSelectedGroup(i);
            JunkActivity.access$57(JunkActivity.this, i);
        } else
        if (JunkActivity.access$56(JunkActivity.this) == i)
        {
            JunkActivity.access$49(JunkActivity.this).collapseGroup(JunkActivity.access$56(JunkActivity.this));
            JunkActivity.access$57(JunkActivity.this, -1);
        } else
        {
            JunkActivity.access$49(JunkActivity.this).collapseGroup(JunkActivity.access$56(JunkActivity.this));
            JunkActivity.access$49(JunkActivity.this).expandGroup(i);
            JunkActivity.access$49(JunkActivity.this).setSelectedGroup(i);
            JunkActivity.access$57(JunkActivity.this, i);
        }
        return true;
    }

    ()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
