// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity

class a
    implements android.view.loadCategoryActivity._cls2
{

    final ExtraDownloadCategoryActivity a;

    public void onClick(View view)
    {
        boolean flag1 = true;
        boolean flag;
        if (view.getId() == 0x7f0c0100)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == a.b)
        {
            return;
        }
        a.b = flag;
        ExtraDownloadCategoryActivity.h(a).setSelected(flag);
        view = ExtraDownloadCategoryActivity.i(a);
        ExtraDownloadCategoryActivity extradownloadcategoryactivity;
        if (flag)
        {
            flag1 = false;
        }
        view.setSelected(flag1);
        extradownloadcategoryactivity = a;
        if (flag)
        {
            view = CategoryType.b;
        } else
        {
            view = CategoryType.c;
        }
        ExtraDownloadCategoryActivity.a(extradownloadcategoryactivity, view);
        ExtraDownloadCategoryActivity.j(a);
    }

    I(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        a = extradownloadcategoryactivity;
        super();
    }
}
