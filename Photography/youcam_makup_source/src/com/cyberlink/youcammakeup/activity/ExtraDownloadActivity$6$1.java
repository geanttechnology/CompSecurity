// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.aa;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.pages.moreview.s;
import com.cyberlink.youcammakeup.pages.moreview.t;
import com.cyberlink.youcammakeup.pages.moreview.v;
import com.cyberlink.youcammakeup.pages.moreview.w;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            ExtraDownloadActivity

class a
    implements w
{

    final a a;

    public void a()
    {
        ExtraDownloadActivity.n(a.a).a(null);
        ExtraDownloadActivity.a(a.a, null);
        ExtraDownloadActivity.b(a.a, false);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/ExtraDownloadActivity$6

/* anonymous class */
    class ExtraDownloadActivity._cls6
        implements t
    {

        final ExtraDownloadActivity a;

        public void onClick(View view)
        {
            ExtraDownloadActivity.b(a, true);
            ExtraDownloadActivity.a(a, (DownloadGridItem)view);
            view = (p)view.getTag();
            view = ExtraDownloadActivity.i(a).a(view.a());
            if (view != null)
            {
                view = view.b();
                ExtraDownloadActivity.n(a).a(view, ExtraDownloadActivity.k(a), ExtraDownloadActivity.l(a), ExtraDownloadActivity.m(a));
                ExtraDownloadActivity.n(a).a(new ExtraDownloadActivity._cls6._cls1(this));
            }
        }

            
            {
                a = extradownloadactivity;
                super();
            }
    }

}
