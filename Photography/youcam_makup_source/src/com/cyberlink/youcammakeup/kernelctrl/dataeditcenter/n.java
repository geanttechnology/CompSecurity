// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            j

public class n extends j
{

    private bi a;
    private boolean b;

    public n()
    {
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.w);
        a = null;
        b = false;
        a = null;
        b = false;
    }

    public n(String s, bi bi1, boolean flag)
    {
        Object obj = null;
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.w, s, null, null);
        a = null;
        b = false;
        s = obj;
        if (bi1 != null)
        {
            s = new bi(bi1);
        }
        a = s;
        b = flag;
    }

    public bi f()
    {
        return a;
    }

    public boolean g()
    {
        return b;
    }
}
