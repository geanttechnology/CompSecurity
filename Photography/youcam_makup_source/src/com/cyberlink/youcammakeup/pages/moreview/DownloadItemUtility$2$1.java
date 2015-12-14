// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ar;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.av;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aw;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadItemUtility

class a
    implements aw
{

    final a a;

    public void a(ar ar1)
    {
        ar1 = MakeupItemTreeManager.a().b();
        DownloadItemUtility.b(a.a).K().a(MoreMakeupActivity.a, ar1);
        a.a.a(null);
    }

    public void a(bn bn1)
    {
        a.a.b(bn1);
    }

    public volatile void a(Object obj)
    {
        a((ar)obj);
    }

    public void a(Void void1)
    {
        a.a.c(void1);
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/DownloadItemUtility$2

/* anonymous class */
    class DownloadItemUtility._cls2
        implements Runnable
    {

        final MKCategoryV2Status a;
        final e b;
        final DownloadItemUtility c;

        public void run()
        {
            DownloadItemUtility.b(c).a(new av(DownloadItemUtility.b(c), -1L, DownloadItemUtility.c(c), a, new DownloadItemUtility._cls2._cls1(this)), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
        }

            
            {
                c = downloaditemutility;
                a = mkcategoryv2status;
                b = e1;
                super();
            }
    }

}
