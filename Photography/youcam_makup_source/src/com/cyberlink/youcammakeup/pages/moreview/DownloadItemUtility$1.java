// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.v;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadItemUtility, r, q

class b
    implements e
{

    final long a;
    final Activity b;
    final DownloadItemUtility c;

    public void a(bn bn1)
    {
        m.e("DownloadItemUtility", bn1.toString());
        b.runOnUiThread(new Runnable(bn1) {

            final bn a;
            final DownloadItemUtility._cls1 b;

            public void run()
            {
                Globals.d().i().h(b.b);
                b.c.a(NetworkManager.a(a.a()));
            }

            
            {
                b = DownloadItemUtility._cls1.this;
                a = bn1;
                super();
            }
        });
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        List list = DownloadItemUtility.a(c, a);
        void1 = new ArrayList();
        v v1;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); void1.add(new r(v1, DownloadItemUtility.a(c, v1))))
        {
            v1 = (v)iterator.next();
        }

        if (list.size() == 0)
        {
            Object obj = new v();
            obj.a = a;
            obj = new r(((v) (obj)), DownloadItemUtility.a(c, ((v) (obj))));
            if (((r) (obj)).c.size() != 0)
            {
                void1.add(obj);
            }
        }
        b.runOnUiThread(new Runnable(void1) {

            final List a;
            final DownloadItemUtility._cls1 b;

            public void run()
            {
                DownloadItemUtility.a(b.c).a(a);
                Globals.d().i().h(b.b);
            }

            
            {
                b = DownloadItemUtility._cls1.this;
                a = list;
                super();
            }
        });
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        m.b("DownloadItemUtility", obj.toString());
        b.runOnUiThread(new Runnable(obj) {

            final Object a;
            final DownloadItemUtility._cls1 b;

            public void run()
            {
                Globals.d().i().h(b.b);
                b.c.a(a.toString());
            }

            
            {
                b = DownloadItemUtility._cls1.this;
                a = obj;
                super();
            }
        });
    }

    _cls3.a(DownloadItemUtility downloaditemutility, long l, Activity activity)
    {
        c = downloaditemutility;
        a = l;
        b = activity;
        super();
    }
}
