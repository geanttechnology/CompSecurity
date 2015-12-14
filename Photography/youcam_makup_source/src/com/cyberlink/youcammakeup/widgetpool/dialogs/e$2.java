// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.pages.moreview.m;
import java.net.URI;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            e

class a
    implements l
{

    final e a;

    public void a(a a1)
    {
    }

    public void a(bn bn1)
    {
        if (bn1 == null);
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        Globals.c(new Runnable(s) {

            final String a;
            final e._cls2 b;

            public void run()
            {
                String s1;
                int i;
                s1 = a.substring(a.lastIndexOf("/"));
                i = 0;
_L3:
                if (i >= com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.a).size())
                {
                    break MISSING_BLOCK_LABEL_131;
                }
                if (!((URI)com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.a).get(i)).toString().contains(s1)) goto _L2; else goto _L1
_L1:
                if (e.b(b.a) != null)
                {
                    b.a.a.a(330, 400, a, (String)e.c(b.a).get(i), true);
                }
                return;
_L2:
                i++;
                  goto _L3
                i = 0;
                  goto _L1
            }

            
            {
                b = e._cls2.this;
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

    _cls1.a(e e1)
    {
        a = e1;
        super();
    }
}
