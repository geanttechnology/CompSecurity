// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.am;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, k

class a
    implements Runnable
{

    final Long a;
    final BeautyToolPanel b;

    public void run()
    {
        b.a(a);
        at at1 = new at(0);
        BeautyMode beautymode = StatusManager.j().s();
        Object obj;
        v v1;
        Object obj1;
        Object obj2;
        if (b.o != null)
        {
            b.s.put(b.o, MotionControlHelper.e().M());
        } else
        {
            b.t = MotionControlHelper.e().M();
        }
        if (a != null)
        {
            az az1 = new az(a, b.p);
            obj = h.b().a(b.p, a).d();
            v v2 = (v)b.s.get(a);
            if (v2 != null)
            {
                obj = v2.a(com.cyberlink.youcammakeup.widgetpool.common..SwitcherMode.a);
                ((at) (obj)).a(v2.b(com.cyberlink.youcammakeup.widgetpool.common..SwitcherMode.a).intValue());
                obj1 = az1;
                v1 = v2;
            } else
            {
                obj = SkuTemplateUtils.d(((String) (obj)));
                if (obj != null)
                {
                    obj2 = ((aw) (obj)).i();
                } else
                {
                    obj2 = null;
                }
                v1 = v2;
                obj = at1;
                obj1 = az1;
                if (obj2 != null)
                {
                    v1 = v2;
                    obj = at1;
                    obj1 = az1;
                    if (((List) (obj2)).size() > 0)
                    {
                        obj = (at)((List) (obj2)).get(0);
                        v1 = v2;
                        obj1 = az1;
                    }
                }
            }
        } else
        {
            v1 = b.t;
            if (v1 == null)
            {
                obj = PanelDataCenter.a().c(beautymode);
            } else
            {
                obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common..SwitcherMode.a);
            }
            obj1 = null;
        }
        obj2 = b.a(a, v1, ((at) (obj)));
        if (b.h != null && (BeautyMode.d(beautymode) || beautymode == BeautyMode.x))
        {
            b.a(((az) (obj1)), null);
        }
        b.d(((String) (obj2)));
        b.a(a, false);
        b.e.a(((az) (obj1)));
        b.e.a();
        if (BeautyMode.d(beautymode))
        {
            obj1 = MotionControlHelper.e().y(((String) (obj2)));
            if (obj1 == null)
            {
                obj1 = PanelDataCenter.a().b(((String) (obj2)));
                if (obj1 != null && ((am) (obj1)).a() > 0 && ((am) (obj1)).b(0) != null)
                {
                    obj1 = ((am) (obj1)).b(0);
                    b.a(((com.cyberlink.youcammakeup.utility.k) (obj1)), true);
                    MotionControlHelper.e().a(((String) (obj2)), ((com.cyberlink.youcammakeup.utility.k) (obj1)));
                }
            } else
            {
                b.a(((com.cyberlink.youcammakeup.utility.k) (obj1)), true);
            }
            obj1 = h.b().a(b.p, b.o);
            if (obj1 == null)
            {
                b.f(null);
            } else
            {
                b.a(((d) (obj1)).d(), ((String) (obj2)));
            }
        } else
        if (obj != null)
        {
            b.a(((at) (obj)), true);
            b.a(((at) (obj)), ((String) (obj2)));
        }
        if (obj2 != null && !((String) (obj2)).equals(StatusManager.j().e()))
        {
            StatusManager.j().b(((String) (obj2)));
            MotionControlHelper.e().t();
            MotionControlHelper.e().a(true);
            b.a(beautymode, ((String) (obj2)));
        }
        b.a(v1, ((String) (obj2)), a, ((at) (obj)));
        if (BeautyMode.d(beautymode))
        {
            StatusManager.j().a(((String) (obj2)), false, new Float[0]);
        } else
        {
            b.c.a(((at) (obj)));
        }
        obj = new Runnable() {

            final BeautyToolPanel._cls12 a;

            public void run()
            {
                a.b.a(false, false, StatusManager.j().e(), null);
                a.b.b(StatusManager.j().e(), null);
                a.b.g(null);
                a.b.b(false);
                a.b.e(true);
            }

            
            {
                a = BeautyToolPanel._cls12.this;
                super();
            }
        };
        b.a.post(((Runnable) (obj)));
    }

    _cls1.a(BeautyToolPanel beautytoolpanel, Long long1)
    {
        b = beautytoolpanel;
        a = long1;
        super();
    }
}
