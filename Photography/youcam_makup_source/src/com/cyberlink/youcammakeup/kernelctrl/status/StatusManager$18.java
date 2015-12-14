// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.at;
import com.cyberlink.youcammakeup.kernelctrl.aw;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, a

class e
    implements aw
{

    final ImageViewer a;
    final a b;
    final a c;
    final ImageBufferWrapper d;
    final aw e;
    final StatusManager f;

    public void a()
    {
        d.m();
        f.b(false);
        if (e != null)
        {
            e.a();
        }
    }

    public void a(List list)
    {
        Integer integer;
        if (list.size() > 0)
        {
            integer = Integer.valueOf(VenusHelper.a(list));
        } else
        {
            integer = Integer.valueOf(-1);
        }
        if (a != null && a.m != null)
        {
            a.m.i = list;
            a.m.j = integer.intValue();
        }
        b.a(list, integer.intValue());
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).d != null)
        {
            MotionControlHelper.e().b(((ar)list.get(integer.intValue())).d.b());
        }
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null && ((ar)list.get(integer.intValue())).e != null)
        {
            MotionControlHelper.e().c(((ar)list.get(integer.intValue())).e.b());
        }
        if (list != null && integer.intValue() >= 0 && list.get(integer.intValue()) != null)
        {
            MotionControlHelper.e().a(Boolean.valueOf(((ar)list.get(integer.intValue())).f), false);
            MotionControlHelper.e().a(((ar)list.get(integer.intValue())).g.a(), ((ar)list.get(integer.intValue())).g.b());
            c.f().a(MotionControlHelper.e().f());
        }
        d.m();
        f.b(true);
        if (e != null)
        {
            e.a(list);
        }
    }

    apper(StatusManager statusmanager, ImageViewer imageviewer, a a1, a a2, ImageBufferWrapper imagebufferwrapper, aw aw1)
    {
        f = statusmanager;
        a = imageviewer;
        b = a1;
        c = a2;
        d = imagebufferwrapper;
        e = aw1;
        super();
    }
}
