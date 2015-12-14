// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SplashActivity

class s
{

    public Boolean a;
    public Boolean b;
    public Boolean c;
    public Boolean d;
    public Boolean e;
    public Boolean f;
    final SplashActivity g;

    public s(SplashActivity splashactivity)
    {
        g = splashactivity;
        super();
        a = Boolean.valueOf(false);
        b = Boolean.valueOf(false);
        c = Boolean.valueOf(false);
        d = Boolean.valueOf(false);
        e = Boolean.valueOf(false);
        f = Boolean.valueOf(false);
    }

    public boolean a()
    {
        return a.booleanValue() && b.booleanValue() && c.booleanValue() && d.booleanValue() && e.booleanValue() && f.booleanValue();
    }
}
