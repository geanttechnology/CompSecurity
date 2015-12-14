// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.g;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.i;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            v, DownloadGridItem, p

class x
    implements f, g, h, i
{

    final v a;

    private x(v v1)
    {
        a = v1;
        super();
    }

    x(v v1, v._cls1 _pcls1)
    {
        this(v1);
    }

    public void a(long l, a a1)
    {
    }

    public void a(long l, bn bn)
    {
        if (l == ((p)com.cyberlink.youcammakeup.pages.moreview.v.a(a).getTag()).b().longValue())
        {
            Globals.d(new Runnable() {

                final x a;

                public void run()
                {
                    com.cyberlink.youcammakeup.pages.moreview.v.a(a.a, DownloadGridItem.DownloadState.e);
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
    }

    public void b(long l)
    {
        if (l == ((p)com.cyberlink.youcammakeup.pages.moreview.v.a(a).getTag()).b().longValue())
        {
            Globals.d(new Runnable() {

                final x a;

                public void run()
                {
                    com.cyberlink.youcammakeup.pages.moreview.v.a(a.a, DownloadGridItem.DownloadState.b);
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
    }

    public void c(long l)
    {
        if (l == ((p)com.cyberlink.youcammakeup.pages.moreview.v.a(a).getTag()).b().longValue())
        {
            Globals.d(new Runnable() {

                final x a;

                public void run()
                {
                    com.cyberlink.youcammakeup.pages.moreview.v.a(a.a, DownloadGridItem.DownloadState.d);
                }

            
            {
                a = x.this;
                super();
            }
            });
        }
    }
}
