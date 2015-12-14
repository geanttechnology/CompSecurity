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

    final List a;
    final b b;

    public void run()
    {
        h.a(b.b, a);
        h.b(b.b);
    }

    a(a a1, List list)
    {
        b = a1;
        a = list;
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
            a.post(new h._cls1._cls2(this, list));
        }

        public void a(List list)
        {
            if (al.a("com.cyberlink.U") || !Globals.d().c().b())
            {
                if (list.size() > 0)
                {
                    a.post(new h._cls1._cls1());
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

        // Unreferenced inner class com/cyberlink/youcammakeup/b/h$1$1

/* anonymous class */
        class h._cls1._cls1
            implements Runnable
        {

            final h._cls1 a;

            public void run()
            {
                if (h.a(a.b) != null)
                {
                    h.a(a.b).a();
                }
            }

                    
                    {
                        a = h._cls1.this;
                        super();
                    }
        }

    }

}
