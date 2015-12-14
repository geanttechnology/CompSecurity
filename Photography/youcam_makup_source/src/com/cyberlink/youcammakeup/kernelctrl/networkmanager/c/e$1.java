// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            e, c, f, d, 
//            a

class a extends AsyncTask
{

    final f a;
    final e b;

    protected transient Void a(Void avoid[])
    {
        long l = e.a(b);
        avoid = com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.b(b);
        if (System.currentTimeMillis() - l <= 0x5265c00L && com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b().equalsIgnoreCase(avoid))
        {
            m.e("PromotionInfoCtrl", "Within 24 hours and same language, try to use the local cache.");
            e.a(b, null, a);
            return null;
        } else
        {
            e.c(b);
            avoid = Globals.d().w();
            avoid.a(new c(avoid, new d() {

                final e._cls1 a;

                public void a(a a1)
                {
                    e.a(a.b, a1, a.a);
                    e.d(a.b);
                    e.e(a.b);
                }

                public void a(bn bn1)
                {
                    m.e("PromotionInfoCtrl", (new StringBuilder()).append("GetPromotionTask: ").append(String.valueOf(bn1)).toString());
                    e.a(a.b, null, a.a);
                }

                public volatile void a(Object obj)
                {
                    a((a)obj);
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

            
            {
                a = e._cls1.this;
                super();
            }
            }));
            return null;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    nit>(e e1, f f)
    {
        b = e1;
        a = f;
        super();
    }
}
