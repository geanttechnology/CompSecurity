// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.ViewGroup;
import com.cyberlink.youcammakeup.database.more.makeup.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            m, aa

class a
    implements Runnable
{

    final String a;
    final a b;

    public void run()
    {
        if (b.b != null)
        {
            b.b.a(b.b.b(), b.b.c(), a);
        }
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/pages/moreview/aa$1

/* anonymous class */
    class aa._cls1
        implements l
    {

        final ViewGroup a;
        final m b;
        final f c;
        final aa d;

        public void a(a a1)
        {
        }

        public void a(bn bn1)
        {
        }

        public volatile void a(Object obj)
        {
            a((String)obj);
        }

        public void a(String s)
        {
            a.post(new aa._cls1._cls1(this, s));
        }

        public void a(Void void1)
        {
        }

        public void b(Object obj)
        {
            a((bn)obj);
        }

        public void c(Object obj)
        {
            a((Void)obj);
        }

        public void d(Object obj)
        {
            a((a)obj);
        }

            
            {
                d = aa1;
                a = viewgroup;
                b = m1;
                c = f1;
                super();
            }
    }

}
