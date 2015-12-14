// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu;
import java.util.LinkedList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            am, HairDyeBrushHandler, r, a

class n
    implements am
{

    final HairDyeBrushHandler a;

    private n(HairDyeBrushHandler hairdyebrushhandler)
    {
        a = hairdyebrushhandler;
        super();
    }

    n(HairDyeBrushHandler hairdyebrushhandler, HairDyeBrushHandler._cls1 _pcls1)
    {
        this(hairdyebrushhandler);
    }

    public void a(float f, float f1)
    {
        HairDyeBrushHandler.h(a);
        if (HairDyeBrushHandler.a(a) != null && HairDyeBrushHandler.b(a) != null && HairDyeBrushHandler.i(a).booleanValue())
        {
            HairDyeBrushHandler.a(a, Boolean.valueOf(false));
            HairDyeBrushHandler.a(a, null);
            HairDyeBrushHandler.a(a, null);
            if (com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.c(a) != null)
            {
                com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.c(a).a(true);
            }
            HairDyeBrushHandler.a(a).b.add(HairDyeBrushHandler.j(a));
            c c1 = HairDyeBrushHandler.b(a, f, f1);
            com.cyberlink.youcammakeup.kernelctrl.a.a().a(c1.a, c1.b);
            com.cyberlink.youcammakeup.kernelctrl.a.a().d();
            if (HairDyeBrushHandler.g(a) != HairDyeBrushHandler.BrushMode.a)
            {
                com.cyberlink.youcammakeup.kernelctrl.a.a().e();
            }
            HairDyeBrushHandler.b(a, HairDyeBrushHandler.j(a));
            HairDyeBrushHandler.a(a).c.clear();
        }
    }
}
