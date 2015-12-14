// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            r

public class s extends r
{

    private float a;

    public s(s s1)
    {
        String s4 = null;
        float f;
        String s2;
        String s3;
        Object obj;
        if (s1 == null)
        {
            s2 = null;
        } else
        {
            s2 = s1.b();
        }
        if (s1 == null)
        {
            s3 = null;
        } else
        {
            s3 = s1.c();
        }
        if (s1 != null)
        {
            s4 = s1.d();
        }
        if (s1 == null)
        {
            obj = new ArrayList();
        } else
        {
            obj = s1.f();
        }
        if (s1 == null)
        {
            f = -1F;
        } else
        {
            f = s1.g();
        }
        super(s2, s3, s4, ((List) (obj)), f);
        a = -1F;
        if (s1 != null)
        {
            a = s1.a();
        }
    }

    public s(String s1, String s2, List list, float f, float f1)
    {
        super(s1, s2, null, list, f);
        a = -1F;
        a = f1;
    }

    public float a()
    {
        return a;
    }

    public void b(float f)
    {
        a = f;
    }
}
