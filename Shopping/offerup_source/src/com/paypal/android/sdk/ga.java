// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            fz

final class ga
    implements Runnable
{

    private fz a;

    ga(fz fz1)
    {
        a = fz1;
        super();
    }

    public final void run()
    {
        fz.a(a);
    }
}
