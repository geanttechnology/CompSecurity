// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.view.View;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.g;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements android.view..OnClickListener
{

    final com.cyberlink.youcammakeup.widgetpool.panel.d.d a;

    public void onClick(View view)
    {
        view = (Long)view.getTag();
        a.a(false, null);
        while (view == d.a(a) || view != null && view.equals(d.a(a))) 
        {
            return;
        }
        view = new Runnable(view) {

            final Long a;
            final d._cls1 b;

            public void run()
            {
                d.a(b.a, a);
                Object obj;
                Object obj1;
                v v1;
                az az1;
                if (d.a(b.a) != null)
                {
                    d.b(b.a).put(d.a(b.a), MotionControlHelper.e().M());
                } else
                {
                    d.a(b.a, MotionControlHelper.e().M());
                }
                if (a != null)
                {
                    az1 = new az(a, d.c(b.a));
                    obj = h.b().a(d.c(b.a), a).d();
                    v1 = (v)d.b(b.a).get(a);
                    if (v1 == null)
                    {
                        obj = SkuTemplateUtils.c(((String) (obj)));
                    } else
                    {
                        obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                    }
                    obj1 = obj;
                } else
                {
                    v1 = com.cyberlink.youcammakeup.widgetpool.panel.d.d.d(b.a);
                    if (v1 == null)
                    {
                        obj = PanelDataCenter.a().c(b.a.a());
                    } else
                    {
                        obj = v1.a(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a);
                    }
                    az1 = null;
                    obj1 = obj;
                }
                if (v1 != null)
                {
                    obj = v1.a();
                } else
                if (a != null && com.cyberlink.youcammakeup.widgetpool.panel.d.d.d(b.a) != null)
                {
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.d.d.d(b.a).a();
                } else
                {
                    obj = PanelDataCenter.a().a(b.a.a());
                    if (obj != null && ((List) (obj)).size() > 0)
                    {
                        obj = PanelDataCenter.a().p((String)((List) (obj)).get(0)).a();
                    } else
                    {
                        obj = null;
                    }
                }
                if (d.e(b.a) == null);
                b.a.a(a, false);
                d.f(b.a).a(az1);
                d.f(b.a).a();
                if (obj1 != null)
                {
                    b.a.a(((com.cyberlink.youcammakeup.utility.at) (obj1)), true);
                    b.a.a(((com.cyberlink.youcammakeup.utility.at) (obj1)), ((String) (obj)));
                }
                if (obj != null && !((String) (obj)).equals(StatusManager.j().e()))
                {
                    StatusManager.j().b(((String) (obj)));
                    MotionControlHelper.e().t();
                    MotionControlHelper.e().a(true);
                }
                d.a(b.a, v1, ((String) (obj)), a, ((com.cyberlink.youcammakeup.utility.at) (obj1)));
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.g(b.a).a(((com.cyberlink.youcammakeup.utility.at) (obj1)));
                obj = new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        boolean flag = false;
                        a.b.a.a(false, StatusManager.j().e(), null);
                        com.cyberlink.youcammakeup.widgetpool.panel.d.d d1 = a.b.a;
                        if (a.b.a.z() == 0)
                        {
                            flag = true;
                        }
                        d1.c(flag);
                    }

            
            {
                a = _pcls1;
                super();
            }
                };
                com.cyberlink.youcammakeup.widgetpool.panel.d.d.h(b.a).post(((Runnable) (obj)));
            }

            
            {
                b = d._cls1.this;
                a = long1;
                super();
            }
        };
        com.cyberlink.youcammakeup.widgetpool.panel.d.d.h(a).post(view);
    }

    _cls1.a(com.cyberlink.youcammakeup.widgetpool.panel.d.d d1)
    {
        a = d1;
        super();
    }
}
