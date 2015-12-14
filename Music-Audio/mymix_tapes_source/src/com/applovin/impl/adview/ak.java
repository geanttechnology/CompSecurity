// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;


// Referenced classes of package com.applovin.impl.adview:
//            af, w

class ak
    implements Runnable
{

    final af a;

    ak(af af1)
    {
        a = af1;
        super();
    }

    public void run()
    {
        af.d(a).dismiss();
    }
}
