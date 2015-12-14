// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.d;

import android.util.Log;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bq;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.br;
import com.cyberlink.youcammakeup.kernelctrl.z;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.d:
//            a

class a
    implements bq
{

    final NetworkManager a;
    final a b;

    public void a(bn bn1)
    {
        Log.i("CollageTemplateRequest", "requestTemplateStatus error");
    }

    public void a(br br1)
    {
        long l = br1.a();
        Log.i("CollageTemplateRequest", (new StringBuilder()).append("requestTemplateStatus complete. LastModified=").append(l).toString());
        if (l > z.d("BEFORE_AFTER_COLLAGE_LAST_MODIFIED_DATE", Globals.d().getApplicationContext()).longValue())
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a(b, a, 0, l);
        }
    }

    public volatile void a(Object obj)
    {
        a((br)obj);
    }

    public void a(Void void1)
    {
        Log.i("CollageTemplateRequest", "requestTemplateStatus cancel");
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    kManager(a a1, NetworkManager networkmanager)
    {
        b = a1;
        a = networkmanager;
        super();
    }
}
