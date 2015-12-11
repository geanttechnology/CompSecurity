// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;


// Referenced classes of package com.applovin.impl.adview:
//            af

class ah
    implements Runnable
{

    final boolean a;
    final boolean b;
    final af c;

    ah(af af1, boolean flag, boolean flag1)
    {
        c = af1;
        a = flag;
        b = flag1;
        super();
    }

    public void run()
    {
        if (a && b)
        {
            af.a(c);
            return;
        } else
        {
            af.b(c);
            return;
        }
    }
}
