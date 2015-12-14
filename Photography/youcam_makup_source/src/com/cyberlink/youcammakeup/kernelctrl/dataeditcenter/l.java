// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            j

public class l extends j
{

    private bi a;
    private bi b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public l()
    {
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.z);
        a = null;
        b = null;
        c = false;
        d = false;
        e = true;
        f = true;
        g = false;
        a = null;
        b = null;
        c = false;
        d = false;
        e = true;
        f = true;
    }

    public l(String s, bi bi1, bi bi2, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        Object obj = null;
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.z, s, null, null);
        a = null;
        b = null;
        c = false;
        d = false;
        e = true;
        f = true;
        g = false;
        if (bi1 != null)
        {
            s = new bi(bi1);
        } else
        {
            s = null;
        }
        a = s;
        s = obj;
        if (bi2 != null)
        {
            s = new bi(bi2);
        }
        b = s;
        c = flag;
        d = flag1;
        e = flag2;
        f = flag3;
    }

    public bi f()
    {
        return a;
    }

    public bi g()
    {
        return b;
    }

    public boolean h()
    {
        return c;
    }

    public boolean i()
    {
        return d;
    }

    public boolean j()
    {
        return e;
    }

    public boolean k()
    {
        return f;
    }
}
