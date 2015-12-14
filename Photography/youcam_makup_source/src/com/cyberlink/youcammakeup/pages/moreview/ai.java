// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            PromoteLooksDialog, aj, af

class ai
    implements f, g, h, i
{

    final PromoteLooksDialog a;

    private ai(PromoteLooksDialog promotelooksdialog)
    {
        a = promotelooksdialog;
        super();
    }

    ai(PromoteLooksDialog promotelooksdialog, PromoteLooksDialog._cls1 _pcls1)
    {
        this(promotelooksdialog);
    }

    public void a(long l, a a1)
    {
        Object obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(a).a(l);
        if (obj != null)
        {
            if ((obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(a).findViewWithTag(((MakeupItemMetadata) (obj)).m())) != null)
            {
                ((ProgressBar)((View) (obj)).findViewById(0x7f0c0524)).setProgress(com.cyberlink.youcammakeup.pages.moreview.af.a(a1));
                return;
            }
        }
    }

    public void a(long l, bn bn)
    {
        Globals.d(new Runnable(l) {

            final long a;
            final ai b;

            public void run()
            {
                Object obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a).a(a);
                if (obj == null)
                {
                    return;
                } else
                {
                    obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a).findViewWithTag(((MakeupItemMetadata) (obj)).m());
                    com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a, ((View) (obj)), DownloadGridItem.DownloadState.e);
                    return;
                }
            }

            
            {
                b = ai.this;
                a = l;
                super();
            }
        });
    }

    public void b(long l)
    {
        Globals.d(new Runnable(l) {

            final long a;
            final ai b;

            public void run()
            {
                Object obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a).a(a);
                if (obj == null)
                {
                    return;
                } else
                {
                    obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a).findViewWithTag(((MakeupItemMetadata) (obj)).m());
                    com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a, ((View) (obj)), DownloadGridItem.DownloadState.b);
                    return;
                }
            }

            
            {
                b = ai.this;
                a = l;
                super();
            }
        });
    }

    public void c(long l)
    {
        Globals.d(new Runnable(l) {

            final long a;
            final ai b;

            public void run()
            {
                Object obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.i(b.a).a(a);
                if (obj == null)
                {
                    return;
                } else
                {
                    obj = com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a).findViewWithTag(((MakeupItemMetadata) (obj)).m());
                    com.cyberlink.youcammakeup.pages.moreview.PromoteLooksDialog.a(b.a, ((View) (obj)), DownloadGridItem.DownloadState.d);
                    return;
                }
            }

            
            {
                b = ai.this;
                a = l;
                super();
            }
        });
    }
}
