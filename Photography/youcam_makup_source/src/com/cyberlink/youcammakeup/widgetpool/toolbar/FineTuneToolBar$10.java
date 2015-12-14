// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.os.Handler;
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

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            FineTuneToolBar

class b
    implements a
{

    final long a;
    final Handler b;
    final FineTuneToolBar c;

    public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.elType eltype, String s, Object obj)
    {
        b.post(new Runnable() {

            final FineTuneToolBar._cls10 a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(a.c);
            }

            
            {
                a = FineTuneToolBar._cls10.this;
                super();
            }
        });
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.q q1, Object obj)
    {
        obj = StatusManager.j().l(a);
        Object obj1 = MotionControlHelper.e().M();
        List list = j.a().g();
        if (obj == null)
        {
            obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, FineTuneToolBar.g(c).m.b, FineTuneToolBar.g(c).m.c, FineTuneToolBar.g(c).m.d, j.a(FineTuneToolBar.g(c).m.i), list, ((ar)list.get(FineTuneToolBar.g(c).m.j)).c.b(), ((ar)list.get(FineTuneToolBar.g(c).m.j)).c.c(), FineTuneToolBar.g(c).m.j, null, ((v) (obj1)), "");
        }
        StatusManager.j().s();
        v v1;
        if (((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f() == null)
        {
            obj1 = new i();
        } else
        {
            obj1 = new i(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).f().g());
        }
        if (obj1 != null)
        {
            StatusManager.j().a(((i) (obj1)));
        }
        v1 = MotionControlHelper.e().M();
        v1.a(((i) (obj1)));
        obj = new com.cyberlink.youcammakeup.kernelctrl.status.a(a, q1.a().b(), q1.a().c(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).d, j.a(FineTuneToolBar.g(c).m.i), list, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).a(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).b(), ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).e, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).c(), v1, ((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)).g());
        obj1 = new d() {

            final FineTuneToolBar._cls10 b;

            public void a()
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
            }

            public void b()
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
            }

            public void c()
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(b.c);
            }

            
            {
                b = FineTuneToolBar._cls10.this;
                super();
            }
        };
        if (StatusManager.j().z())
        {
            StatusManager.j().a(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), ((d) (obj1)));
            return;
        } else
        {
            StatusManager.j().b(((com.cyberlink.youcammakeup.kernelctrl.status.a) (obj)), q1.a(), ((d) (obj1)));
            return;
        }
    }

    public void a(String s, Object obj)
    {
        b.post(new Runnable() {

            final FineTuneToolBar._cls10 a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.i(a.c);
            }

            
            {
                a = FineTuneToolBar._cls10.this;
                super();
            }
        });
    }

    _cls3.a(FineTuneToolBar finetunetoolbar, long l, Handler handler)
    {
        c = finetunetoolbar;
        a = l;
        b = handler;
        super();
    }
}
