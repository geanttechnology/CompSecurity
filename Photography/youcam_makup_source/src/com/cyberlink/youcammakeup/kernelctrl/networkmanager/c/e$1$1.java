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
//            d, e, a, c, 
//            f

class t> extends d
{

    final a a;

    public void a(a a1)
    {
        e.a(a.a, a1, a.a);
        e.d(a.a);
        e.e(a.a);
    }

    public void a(bn bn1)
    {
        m.e("PromotionInfoCtrl", (new StringBuilder()).append("GetPromotionTask: ").append(String.valueOf(bn1)).toString());
        e.a(a.a, null, a.a);
    }

    public volatile void a(Object obj)
    {
        a((a)obj);
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    anager(anager anager)
    {
        a = anager;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/kernelctrl/networkmanager/c/e$1

/* anonymous class */
    class e._cls1 extends AsyncTask
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
                avoid.a(new c(avoid, new e._cls1._cls1(this)));
                return null;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

            
            {
                b = e1;
                a = f;
                super();
            }
    }

}
