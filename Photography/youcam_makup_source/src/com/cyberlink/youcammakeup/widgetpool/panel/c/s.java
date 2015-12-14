// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import com.cyberlink.youcammakeup.database.more.l.a;
import com.cyberlink.youcammakeup.database.more.l.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bo;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            u

abstract class s
    implements u
{

    protected static final as a = bo.z("default_original_looks");
    protected final MakeupItemMetadata b;

    s(MakeupItemMetadata makeupitemmetadata)
    {
        b = makeupitemmetadata;
    }

    public s(as as1)
    {
        as1 = h.c().a(as1.a());
        if (as1 != null)
        {
            long l = as1.a();
            b = h.v().a(l);
            return;
        } else
        {
            b = null;
            return;
        }
    }

    public void a(boolean flag)
    {
        if (e())
        {
            as as1 = g();
            if (as1.f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
            {
                as1.b(Boolean.valueOf(flag));
            }
        }
    }

    public boolean a()
    {
        while (!e() || g().f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b) 
        {
            return false;
        }
        return true;
    }

    public MakeupItemMetadata b()
    {
        return b;
    }

    public String c()
    {
        if (b != null)
        {
            String s1 = b.d();
            if (s1 != null && s1.length() > 0)
            {
                return s1;
            }
        }
        return "";
    }

}
