// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.a;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.x();
    }

    b(b b)
    {
        a = b;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$3

/* anonymous class */
    class d._cls3
        implements a
    {

        final long a;
        final com.cyberlink.youcammakeup.widgetpool.panel.d.d b;

        public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
        {
            b.x();
        }

        public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
        {
            Object obj1;
            v v1;
            List list;
            if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).p())
            {
                obj = com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).r();
            } else
            {
                obj = StatusManager.j().f(a);
            }
            v1 = MotionControlHelper.e().M();
            list = j.a().g();
            obj1 = obj;
            if (obj == null)
            {
                obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.b, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.c, com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.d, j.a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.i), list, ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).c.b(), ((ar)list.get(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j)).c.c(), com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.j, null, v1, "");
            }
            if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f() == null)
            {
                obj = new i();
            } else
            {
                obj = new i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).f().g());
            }
            b.a(((i) (obj)));
            ((i) (obj)).a(false);
            StatusManager.j().a(((i) (obj)));
            v1 = MotionControlHelper.e().M();
            v1.a(((i) (obj)));
            obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, j.a(com.cyberlink.youcammakeup.widgetpool.panel.d.d.q(b).m.i), j.a().g(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), v1, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
            if (com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).p())
            {
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)));
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.i(b).runOnUiThread(new d._cls3._cls1(this));
                return;
            } else
            {
                StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), new d._cls3._cls2());
                return;
            }
        }

        public void a(String s, Object obj)
        {
            b.x();
        }

            
            {
                b = d1;
                a = l;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$3$2

/* anonymous class */
        class d._cls3._cls2
            implements d
        {

            final d._cls3 b;

            public void a()
            {
                b.b.x();
            }

            public void b()
            {
                b.b.x();
            }

            public void c()
            {
                b.b.x();
            }

                    
                    {
                        b = d._cls3.this;
                        super();
                    }
        }

    }

}
