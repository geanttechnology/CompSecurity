// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;

// Referenced classes of package com.google.android.gms.internal:
//            hz, hs

class .b extends .b
{

    final hz Ec;
    final String Ed;
    final Uri Ee;
    final String Ef;
    final String Eg;
    final int vc;

    protected volatile void a(com.google.android.gms.common.api. )
    {
        a((hs));
    }

    protected void a(hs hs1)
    {
        hs1.a(this, vc, Ed, Ee, Ef, Eg);
    }

    .b(hz hz1, com.google.android.gms.common.api. , int i, String s, Uri uri, String s1, String s2)
    {
        Ec = hz1;
        vc = i;
        Ed = s;
        Ee = uri;
        Ef = s1;
        Eg = s2;
        super();
    }
}
