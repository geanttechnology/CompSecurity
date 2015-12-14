// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, ln, jj, kg, 
//            ka

class it>
    implements kb
{

    final jj a;

    public volatile void a(ka ka)
    {
        a((ln)ka);
    }

    public void a(ln ln1)
    {
        if (jj.a(a) > 0L && jj.a(a) < System.currentTimeMillis())
        {
            kg.a(4, jj.f(), "No location received in 90 seconds , stopping LocationManager");
            jj.b(a);
        }
    }

    (jj jj1)
    {
        a = jj1;
        super();
    }
}
