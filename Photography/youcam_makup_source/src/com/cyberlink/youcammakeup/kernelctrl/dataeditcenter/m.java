// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            r

public class m extends r
{

    private float a;

    public m()
    {
        a = -1F;
    }

    public m(m m1)
    {
        float f = -1F;
        super(m1);
        a = -1F;
        if (m1 != null)
        {
            f = m1.a();
        }
        a = f;
    }

    public m(String s, String s1, List list, float f, float f1)
    {
        super(s, s1, null, list, f);
        a = -1F;
        a = f1;
    }

    public float a()
    {
        return a;
    }
}
