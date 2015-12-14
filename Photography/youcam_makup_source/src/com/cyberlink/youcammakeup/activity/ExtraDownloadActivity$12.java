// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.AbsListView;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements android.widget.ner
{

    final ExtraDownloadActivity a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        m.b("sean", "sean list view onScroll!!");
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        ExtraDownloadActivity.a(a, i);
    }

    (ExtraDownloadActivity extradownloadactivity)
    {
        a = extradownloadactivity;
        super();
    }
}
