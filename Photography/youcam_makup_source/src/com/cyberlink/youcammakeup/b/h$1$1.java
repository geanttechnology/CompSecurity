// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.b;

import android.os.Handler;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.f;
import com.cyberlink.youcammakeup.utility.al;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.b:
//            h, j

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (h.a(a.a) != null)
        {
            h.a(a.a).a();
        }
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/b/h$1

/* anonymous class */
    class h._cls1
        implements f
    {

        final Handler a;
        final h b;

        private void b(List list)
        {
            a.post(new h._cls1._cls2(list));
        }

        public void a(List list)
        {
            if (al.a("com.cyberlink.U") || !Globals.d().c().b())
            {
                if (list.size() > 0)
                {
                    a.post(new h._cls1._cls1(this));
                    b(list);
                }
                return;
            } else
            {
                b(list);
                return;
            }
        }

            
            {
                b = h1;
                a = handler;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/b/h$1$2

/* anonymous class */
        class h._cls1._cls2
            implements Runnable
        {

            final List a;
            final h._cls1 b;

            public void run()
            {
                h.a(b.b, a);
                h.b(b.b);
            }

                    
                    {
                        b = h._cls1.this;
                        a = list;
                        super();
                    }
        }

    }

}
