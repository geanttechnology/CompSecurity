// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadCategoryActivity

class a
    implements android.view.loadCategoryActivity._cls1
{

    final ExtraDownloadCategoryActivity a;

    public void onClick(View view)
    {
        if (ExtraDownloadCategoryActivity.a(a))
        {
            ExtraDownloadCategoryActivity.b(a);
        } else
        {
            a.f();
        }
        Globals.d().i();
        o.a(a);
    }

    I(ExtraDownloadCategoryActivity extradownloadcategoryactivity)
    {
        a = extradownloadcategoryactivity;
        super();
    }
}
