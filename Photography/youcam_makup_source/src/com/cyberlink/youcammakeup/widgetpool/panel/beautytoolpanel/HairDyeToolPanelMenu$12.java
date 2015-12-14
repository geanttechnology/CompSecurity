// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.kernelctrl.aq;
import com.cyberlink.youcammakeup.utility.aw;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            HairDyeToolPanelMenu

class a
    implements aq
{

    final HairDyeToolPanelMenu a;

    public void a(Integer integer)
    {
    }

    public void a(Object obj)
    {
        if (obj != null && (obj instanceof aw))
        {
            obj = (aw)obj;
            a.a(((aw) (obj)).a(), new Float[0]);
        }
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((Integer)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    Y(HairDyeToolPanelMenu hairdyetoolpanelmenu)
    {
        a = hairdyetoolpanelmenu;
        super();
    }
}
