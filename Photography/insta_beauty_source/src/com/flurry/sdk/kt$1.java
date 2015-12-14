// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, kt, jk, kg, 
//            ka

class it>
    implements kb
{

    final kt a;

    public void a(jk jk1)
    {
        kg.a(4, a.a, (new StringBuilder()).append("onNetworkStateChanged : isNetworkEnable = ").append(jk1.a).toString());
        if (jk1.a)
        {
            a.e();
        }
    }

    public volatile void a(ka ka)
    {
        a((jk)ka);
    }

    der(kt kt1)
    {
        a = kt1;
        super();
    }
}
