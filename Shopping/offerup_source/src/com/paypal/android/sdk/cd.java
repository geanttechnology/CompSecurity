// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

// Referenced classes of package com.paypal.android.sdk:
//            ft, cj, by, gu, 
//            gw, gq

final class cd
    implements ft
{

    private final cj a;

    cd(by by1, cj cj1)
    {
        this(cj1);
    }

    private cd(cj cj1)
    {
        a = cj1;
    }

    public final void a(gq gq, IOException ioexception)
    {
        a.b(ioexception.getMessage());
        by.b();
        (new StringBuilder()).append(a.n()).append(" failure: ").append(ioexception.getMessage());
    }

    public final void a(gu gu1)
    {
        a.b(gu1.h().d());
        by.b();
        (new StringBuilder()).append(a.n()).append(" success");
    }
}
