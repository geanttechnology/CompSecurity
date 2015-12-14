// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.jniproxy.bi;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            j

public class t extends j
{

    private bi a;
    private boolean b;
    private com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask c;

    public t()
    {
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.y);
        a = null;
        b = false;
        c = null;
        a = null;
        b = false;
    }

    public t(String s, bi bi1, boolean flag)
    {
        Object obj = null;
        super(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.y, s, null, null);
        a = null;
        b = false;
        c = null;
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
