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
//            aa, m

class c
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
        a.post(new Runnable(s) {

            final String a;
            final aa._cls1 b;

            public void run()
            {
                if (b.b != null)
                {
                    b.b.a(b.c.b(), b.c.c(), a);
                }
            }

            
            {
                b = aa._cls1.this;
                a = s;
                super();
            }
        });
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

    .f(aa aa1, ViewGroup viewgroup, m m, f f)
    {
        d = aa1;
        a = viewgroup;
        b = m;
        c = f;
        super();
    }
}
