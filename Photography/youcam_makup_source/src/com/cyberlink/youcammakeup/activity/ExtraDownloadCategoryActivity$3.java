// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.AbsListView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity

class a
    implements android.widget.adCategoryActivity._cls3
{

    final ExtraDownloadCategoryActivity a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        ExtraDownloadCategoryActivity.a(a, i);
    }

    I(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        a = extradownloadcategoryactivity;
        super();
    }
}
