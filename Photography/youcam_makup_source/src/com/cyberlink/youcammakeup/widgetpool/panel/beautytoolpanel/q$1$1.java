// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            q

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.a(false, false, StatusManager.j().e(), null);
        a.a.b(StatusManager.j().e(), null);
        a.a.g(null);
    }

    witcherMode(witcherMode witchermode)
    {
        a = witchermode;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/q$1

/* anonymous class */
    class q._cls1
        implements Runnable
    {

        final Long a;
        final q b;

        public void run()
        {
            b.a(a);
            Object obj = StatusManager.j().s();
            Object obj1;
            Object obj2;
            az az1;
            String s;
            if (b.o != null)
            {
                b.s.put(b.o, MotionControlHelper.e().M());
            } else
            {
                b.t = MotionControlHelper.e().M();
            }
            if (a != null)
            {
                az1 = new az(a, b.p);
                s = h.b().a(b.p, a).d();
                obj = (v)b.s.get(a);
                aw aw1;
                if (obj != null)
                {
                    obj1 = ((v) (obj)).c();
                    float f = ((v) (obj)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue();
                    Float afloat[] = {
                        Float.valueOf(f)
                    };
                    obj2 = obj;
                    obj = afloat;
                } else
                {
                    obj1 = SkuTemplateUtils.d(s);
                    if (obj1 != null)
                    {
                        obj1 = ((aw) (obj1)).a();
                    } else
                    {
                        obj1 = null;
                    }
                    obj2 = obj;
                    obj = new Float[0];
                }
            } else
            {
                obj2 = b.t;
                if (obj2 == null || obj2 != null && ((v) (obj2)).a() != null && ((v) (obj2)).a().equals("default_original_wig"))
                {
                    obj1 = PanelDataCenter.a().a(((com.cyberlink.youcammakeup.utility.BeautyMode) (obj)), 1);
                } else
                {
                    obj1 = MotionControlHelper.e().k(((v) (obj2)).a());
                }
                if (obj2 != null)
                {
                    obj = new Float[1];
                    obj[0] = Float.valueOf(((v) (obj2)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                } else
                {
                    obj = new Float[1];
                    obj[0] = Float.valueOf(b.J());
                }
                az1 = null;
                s = null;
            }
            aw1 = PanelDataCenter.a().i(((String) (obj1)));
            StatusManager.j().c(((String) (obj1)));
            obj1 = b.a(s, ((v) (obj2)), ((String) (obj1)));
            b.a(az1, null);
            b.d(((String) (obj1)));
            b.a(a, false);
            b.a(aw1, az1);
            if (obj1 != null && !((String) (obj1)).equals(StatusManager.j().e()))
            {
                StatusManager.j().b(((String) (obj1)));
                MotionControlHelper.e().t();
                MotionControlHelper.e().a(true);
            }
            StatusManager.j().a(((String) (obj1)), false, ((Float []) (obj)));
            obj = new q._cls1._cls1(this);
            b.a.post(((Runnable) (obj)));
        }

            
            {
                b = q1;
                a = long1;
                super();
            }
    }

}
