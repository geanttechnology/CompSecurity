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
    implements Runnable
{

    final String a;
    final b b;

    public void run()
    {
        String s;
        int i;
        s = a.substring(a.lastIndexOf("/"));
        i = 0;
_L3:
        if (i >= com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.b).size())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        if (!((URI)com.cyberlink.youcammakeup.widgetpool.dialogs.e.a(b.b).get(i)).toString().contains(s)) goto _L2; else goto _L1
_L1:
        if (e.b(b.b) != null)
        {
            b.b.a.a(330, 400, a, (String)e.c(b.b).get(i), true);
        }
        return;
_L2:
        i++;
          goto _L3
        i = 0;
          goto _L1
    }

    .task.bn(.task.bn bn, String s)
    {
        b = bn;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/e$2

/* anonymous class */
    class e._cls2
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
            Globals.c(new e._cls2._cls1(this, s));
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
                a = e1;
                super();
            }
    }

}
