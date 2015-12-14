// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.jniproxy.AthenaStrokeType;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.HairDyeToolPanelMenu;
import java.util.LinkedList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            ai, HairDyeBrushHandler, r, a, 
//            q

class l
    implements ai
{

    final HairDyeBrushHandler a;

    private l(HairDyeBrushHandler hairdyebrushhandler)
    {
        a = hairdyebrushhandler;
        super();
    }

    l(HairDyeBrushHandler hairdyebrushhandler, HairDyeBrushHandler._cls1 _pcls1)
    {
        this(hairdyebrushhandler);
    }

    public void a(float f, float f1)
    {
        if (HairDyeBrushHandler.a(a) != null && HairDyeBrushHandler.a(a).b != null && HairDyeBrushHandler.b(a) != null)
        {
            HairDyeBrushHandler.a(a, new LinkedList());
            HairDyeBrushHandler.a(a, Boolean.valueOf(true));
            HairDyeBrushHandler.a(a, null);
            HairDyeBrushHandler.a(a, null);
            if (com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.c(a) != null)
            {
                com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler.c(a).a(false);
            }
            HairDyeBrushHandler.d(a).eraseColor(0);
            HairDyeBrushHandler.a(a, f, f1);
            com.cyberlink.youcammakeup.kernelctrl.a.a().c();
            int i = (int)((float)HairDyeBrushHandler.e(a).d / HairDyeBrushHandler.f(a));
            c c1;
            if (HairDyeBrushHandler.g(a) == HairDyeBrushHandler.BrushMode.a)
            {
                com.cyberlink.youcammakeup.kernelctrl.a.a().a(AthenaStrokeType.a, i);
            } else
            {
                com.cyberlink.youcammakeup.kernelctrl.a.a().e();
                com.cyberlink.youcammakeup.kernelctrl.a.a().a(AthenaStrokeType.c, i);
            }
            c1 = HairDyeBrushHandler.b(a, f, f1);
            com.cyberlink.youcammakeup.kernelctrl.a.a().a(c1.a, c1.b);
        }
    }
}
