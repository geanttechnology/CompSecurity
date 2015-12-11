// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gk, gl, gq, gr, 
//            gu

public final class bq
    implements gk
{

    private final String a;

    public bq(String s)
    {
        a = s;
    }

    public final gu a(gl gl1)
    {
        return gl1.a(gl1.a().h().b("User-Agent").b("User-Agent", a).a());
    }
}
