// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

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
//            j, k

class a
    implements Runnable
{

    final Long a;
    final j b;

    public void run()
    {
        b.a(a);
        StatusManager.j().s();
        Object obj;
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
            obj1 = new az(a, b.p);
            obj = h.b().a(b.p, a).d();
            obj2 = (v)b.s.get(a);
            aw aw1;
            if (obj2 != null)
            {
                obj = ((v) (obj2)).c();
                Float afloat[] = {
                    Float.valueOf(((v) (obj2)).d().intValue())
                };
                obj2 = obj1;
                obj1 = obj;
                obj = afloat;
            } else
            {
                obj = SkuTemplateUtils.d(((String) (obj)));
                Object obj3;
                if (obj != null)
                {
                    obj = ((aw) (obj)).a();
                } else
                {
                    obj = null;
                }
                obj2 = obj;
                obj = new Float[0];
                obj3 = obj1;
                obj1 = obj2;
                obj2 = obj3;
            }
        } else
        {
            obj1 = b.t;
            if (obj1 != null)
            {
                obj = new Float[1];
                obj[0] = Float.valueOf(((v) (obj1)).d().intValue());
            } else
            {
                obj = new Float[1];
                obj[0] = Float.valueOf(b.L());
            }
            if (obj1 == null)
            {
                obj1 = "default_original_hair_dye";
            } else
            {
                obj1 = ((v) (obj1)).c();
            }
            obj2 = null;
        }
        aw1 = PanelDataCenter.a().i(((String) (obj1)));
        b.a(a, false);
        b.a(aw1, ((az) (obj2)));
        b.c.a(((String) (obj1)), ((Float []) (obj)));
    }

    (j j1, Long long1)
    {
        b = j1;
        a = long1;
        super();
    }
}
