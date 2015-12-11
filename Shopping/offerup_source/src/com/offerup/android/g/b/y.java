// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import com.b.a.a.g;
import com.facebook.AccessToken;
import com.facebook.FacebookException;

// Referenced classes of package com.offerup.android.g.b:
//            w, k

final class y
    implements w
{

    private k a;

    private y(k k1)
    {
        a = k1;
        super();
    }

    y(k k1, byte byte0)
    {
        this(k1);
    }

    public final void a()
    {
        k.j(a);
    }

    public final void a(AccessToken accesstoken)
    {
        k.a(a, accesstoken);
    }

    public final void a(FacebookException facebookexception)
    {
        k.a(a, null);
        g.a(this, facebookexception);
    }
}
