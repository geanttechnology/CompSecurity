// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements android.view.xtraDownloadActivity._cls9
{

    final ExtraDownloadActivity a;

    public void onClick(View view)
    {
        boolean flag1 = true;
        boolean flag;
        if (view.getId() == 0x7f0c00f3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag == ExtraDownloadActivity.d(a))
        {
            return;
        }
        ExtraDownloadActivity.a(a, flag);
        if (ExtraDownloadActivity.e(a) != null)
        {
            ExtraDownloadActivity.e(a).setSelected(flag);
        }
        if (ExtraDownloadActivity.f(a) != null)
        {
            view = ExtraDownloadActivity.f(a);
            if (!flag)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            view.setSelected(flag);
        }
        ExtraDownloadActivity.g(a);
    }

    A(ExtraDownloadActivity extradownloadactivity)
    {
        a = extradownloadactivity;
        super();
    }
}
