// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            by, cd, cj

final class bz
    implements Runnable
{

    private cj a;
    private String b;
    private by c;

    bz(by by1, cj cj, String s)
    {
        c = by1;
        a = cj;
        b = s;
        super();
    }

    public final void run()
    {
        try
        {
            by.a(c, a, b, by.a(c), new cd(c, a));
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }
}
