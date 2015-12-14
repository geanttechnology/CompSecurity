// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bu;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity, s

class a
    implements bu
{

    final float a;
    final SplashActivity b;

    public void a(List list)
    {
        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
        SplashActivity.a(b).a = Boolean.valueOf(true);
        SplashActivity.b(b);
    }

    (SplashActivity splashactivity, float f)
    {
        b = splashactivity;
        a = f;
        super();
    }
}
