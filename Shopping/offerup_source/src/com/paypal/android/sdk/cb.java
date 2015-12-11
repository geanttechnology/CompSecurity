// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            by, gn, gd

final class cb
    implements Runnable
{

    private gn a;

    cb(gn gn1)
    {
        a = gn1;
        super();
    }

    public final void run()
    {
        gn gn1 = a;
        String s = by.b();
        gn1.r().a(s);
    }
}
