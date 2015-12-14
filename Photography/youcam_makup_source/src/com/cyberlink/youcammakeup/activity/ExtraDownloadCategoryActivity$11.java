// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.pages.moreview.y;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity, ExtraDownloadActivity

class a
    implements android.widget.stener
{

    final ExtraDownloadCategoryActivity a;

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        if (!ExtraDownloadCategoryActivity.d(a).d(i))
        {
            return true;
        } else
        {
            b.a(new YMKLooksStoreEvent(com.cyberlink.youcammakeup.clflurry.a, null, ExtraDownloadCategoryActivity.d(a).c(i)));
            Globals.d().a(true);
            expandablelistview = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/ExtraDownloadActivity);
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_SOURCE", a.getIntent().getStringExtra("KEY_EXTRA_DOWNLOAD_SOURCE"));
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", ExtraDownloadCategoryActivity.d(a).getGroupId(i));
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_TYPE", ExtraDownloadCategoryActivity.e(a));
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", ExtraDownloadCategoryActivity.d(a).c(i));
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_DISPLAY_TYPE", ExtraDownloadCategoryActivity.f(a).ordinal());
            expandablelistview.putExtra("KEY_EXTRA_DOWNLOAD_HIDE_TOP_NEW_TAB", true);
            a.startActivity(expandablelistview);
            a.finish();
            return true;
        }
    }

    keupType(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        a = extradownloadcategoryactivity;
        super();
    }
}
