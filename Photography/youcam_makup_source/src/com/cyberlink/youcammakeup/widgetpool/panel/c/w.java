// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.widget.ImageView;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bn;
import com.cyberlink.youcammakeup.utility.bo;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            s

class w extends s
{

    private as c;

    w(MakeupItemMetadata makeupitemmetadata)
    {
        super(makeupitemmetadata);
        if (e())
        {
            c = PanelDataCenter.a().o(makeupitemmetadata.b());
        }
    }

    public void a(ag ag, ImageView imageview)
    {
        bn.a(ag, b, imageview, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a);
    }

    public String d()
    {
        return c.d();
    }

    public boolean e()
    {
        return bo.h(b.b());
    }

    public boolean f()
    {
        return g().g().booleanValue();
    }

    public as g()
    {
        if (c != null)
        {
            return c;
        }
        if (!e())
        {
            return a;
        } else
        {
            String s1 = b.m();
            c = PanelDataCenter.a().o(s1);
            return c;
        }
    }

    public boolean h()
    {
        return !b.k();
    }

    public boolean i()
    {
        return true;
    }
}
