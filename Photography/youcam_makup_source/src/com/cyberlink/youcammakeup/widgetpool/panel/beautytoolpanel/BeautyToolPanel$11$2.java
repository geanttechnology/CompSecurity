// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.q;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class b
    implements d
{

    final b b;

    public void a()
    {
        b.b.i();
    }

    public void b()
    {
        b.b.i();
    }

    public void c()
    {
        b.b.i();
    }

    a(a a1)
    {
        b = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$11

/* anonymous class */
    class BeautyToolPanel._cls11
        implements a
    {

        final long a;
        final BeautyToolPanel b;

        public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
        {
            b.i();
        }

        public void a(q q1, Object obj)
        {
            if (b.b == null || q1 == null || q1 != null && q1.a() == null)
            {
                b.i();
            } else
            {
                Object obj1;
                v v1;
                List list;
                if (b.b.p())
                {
                    obj = b.b.r();
                } else
                {
                    obj = StatusManager.j().f(a);
                }
                v1 = MotionControlHelper.e().M();
                list = j.a().g();
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, BeautyToolPanel.g(b).m.b, BeautyToolPanel.g(b).m.c, BeautyToolPanel.g(b).m.d, j.a(BeautyToolPanel.g(b).m.i), list, ((ar)list.get(BeautyToolPanel.g(b).m.j)).c.b(), ((ar)list.get(BeautyToolPanel.g(b).m.j)).c.c(), BeautyToolPanel.g(b).m.j, null, v1, "");
                }
                b.a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)));
                obj = MotionControlHelper.e().M();
                ((v) (obj)).a(StatusManager.j().d());
                if (BeautyToolPanel.g(b) != null && BeautyToolPanel.g(b).m != null)
                {
                    obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).d, j.a(BeautyToolPanel.g(b).m.i), j.a().g(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).c(), ((v) (obj)), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj1)).g());
                    if (b.b.p() && StatusManager.j().s() != BeautyMode.x)
                    {
                        b.b.a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)));
                        b.b.runOnUiThread(new BeautyToolPanel._cls11._cls1());
                        return;
                    } else
                    {
                        StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), new BeautyToolPanel._cls11._cls2(this));
                        return;
                    }
                }
            }
        }

        public void a(String s, Object obj)
        {
            b.i();
        }

            
            {
                b = beautytoolpanel;
                a = l;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$11$1

/* anonymous class */
        class BeautyToolPanel._cls11._cls1
            implements Runnable
        {

            final BeautyToolPanel._cls11 a;

            public void run()
            {
                a.b.i();
            }

                    
                    {
                        a = BeautyToolPanel._cls11.this;
                        super();
                    }
        }

    }

}
