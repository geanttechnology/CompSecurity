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
//            n, k

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

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/n$1

/* anonymous class */
    class n._cls1
        implements Runnable
    {

        final Long a;
        final n b;

        public void run()
        {
            Object obj1 = null;
            b.a(a);
            com.cyberlink.youcammakeup.utility.BeautyMode beautymode = StatusManager.j().s();
            Object obj;
            Object obj2;
            Object obj3;
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
                obj3 = new az(a, b.p);
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
                    obj2 = SkuTemplateUtils.d(s);
                    if (obj2 != null)
                    {
                        obj1 = ((aw) (obj2)).a();
                    }
                    obj2 = obj;
                    obj = new Float[0];
                }
            } else
            {
                obj2 = b.t;
                Object obj4;
                if (obj2 != null)
                {
                    obj1 = new Float[1];
                    obj1[0] = Float.valueOf(((v) (obj2)).b(com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper.SwitcherMode.a).intValue());
                } else
                {
                    obj1 = new Float[1];
                    obj1[0] = Float.valueOf(b.J());
                }
                if (obj2 == null)
                {
                    if (PanelDataCenter.a().a(beautymode, 1) != null)
                    {
                        obj = PanelDataCenter.a().a(beautymode, 1);
                    } else
                    {
                        obj = PanelDataCenter.a().a(beautymode, 2);
                    }
                } else
                {
                    obj = ((v) (obj2)).c();
                }
                s = null;
                obj4 = null;
                obj3 = obj;
                obj = obj1;
                obj1 = obj3;
                obj3 = obj4;
            }
            aw1 = PanelDataCenter.a().i(((String) (obj1)));
            obj2 = b.a(s, ((v) (obj2)), ((String) (obj1)));
            b.a(a, false);
            b.a(aw1, ((az) (obj3)));
            if (obj2 != null && !((String) (obj2)).equals(StatusManager.j().e()))
            {
                StatusManager.j().b(((String) (obj2)));
                MotionControlHelper.e().t();
                MotionControlHelper.e().a(true);
                b.a(beautymode, ((String) (obj2)));
            }
            b.c.a(((String) (obj1)), ((Float []) (obj)));
            obj = new n._cls1._cls1(this);
            b.a.post(((Runnable) (obj)));
        }

            
            {
                b = n1;
                a = long1;
                super();
            }
    }

}
