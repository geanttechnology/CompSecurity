// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            aj, HairDyeBrushHandler, r, a

class m
    implements aj
{

    final HairDyeBrushHandler a;

    private m(HairDyeBrushHandler hairdyebrushhandler)
    {
        a = hairdyebrushhandler;
        super();
    }

    m(HairDyeBrushHandler hairdyebrushhandler, HairDyeBrushHandler._cls1 _pcls1)
    {
        this(hairdyebrushhandler);
    }

    public void a(float f, float f1)
    {
        if (HairDyeBrushHandler.a(a) != null && HairDyeBrushHandler.a(a).b != null && HairDyeBrushHandler.b(a) != null)
        {
            HairDyeBrushHandler.a(a, f, f1);
            c c1 = HairDyeBrushHandler.b(a, f, f1);
            com.cyberlink.youcammakeup.kernelctrl.a.a().a(c1.a, c1.b);
        }
    }
}
