// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.bi;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            r

public class u extends r
{

    private String a;
    private bi b;
    private boolean c;
    private boolean d;

    public u()
    {
        a = null;
        b = null;
        c = false;
        d = false;
    }

    public u(u u1)
    {
        Object obj1 = null;
        boolean flag1 = false;
        super(u1);
        a = null;
        b = null;
        c = false;
        d = false;
        Object obj;
        boolean flag;
        if (u1 == null)
        {
            obj = null;
        } else
        {
            obj = u1.a();
        }
        a = ((String) (obj));
        obj = obj1;
        if (u1 != null)
        {
            if (u1.h() == null)
            {
                obj = obj1;
            } else
            {
                obj = new bi(u1.h());
            }
        }
        b = ((bi) (obj));
        if (u1 == null)
        {
            flag = false;
        } else
        {
            flag = u1.i();
        }
        c = flag;
        if (u1 == null)
        {
            flag = flag1;
        } else
        {
            flag = u1.j();
        }
        d = flag;
    }

    public u(String s, String s1, List list, float f, String s2, bi bi1, boolean flag)
    {
        Object obj = null;
        super(s, s1, null, list, f);
        a = null;
        b = null;
        c = false;
        d = false;
        a = s2;
        s = obj;
        if (bi1 != null)
        {
            s = new bi(bi1);
        }
        b = s;
        c = false;
        d = flag;
    }

    public String a()
    {
        return a;
    }

    public bi h()
    {
        return b;
    }

    public boolean i()
    {
        return c;
    }

    public boolean j()
    {
        return d;
    }
}
