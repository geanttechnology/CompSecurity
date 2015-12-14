// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.widget.ImageView;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.utility.as;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            s

class t extends s
{

    private final as c;

    t(as as1)
    {
        super(as1);
        c = as1;
    }

    public void a(ag ag1, ImageView imageview)
    {
        ag1.a(c.d(), imageview);
    }

    public String c()
    {
        String s1 = super.c();
        if (s1 != null && s1.length() > 0)
        {
            return s1;
        } else
        {
            return c.b();
        }
    }

    public String d()
    {
        return c.d();
    }

    public boolean e()
    {
        return true;
    }

    public boolean f()
    {
        return c.g().booleanValue();
    }

    public as g()
    {
        return c;
    }

    public boolean h()
    {
        return true;
    }

    public boolean i()
    {
        return false;
    }
}
