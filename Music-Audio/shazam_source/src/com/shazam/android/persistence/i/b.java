// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.i;


// Referenced classes of package com.shazam.android.persistence.i:
//            a

public final class b
    implements a
{

    private final com.shazam.android.persistence.n.b a;

    public b(com.shazam.android.persistence.n.b b1)
    {
        a = b1;
    }

    private void b(String s)
    {
        a.b("pk_registration_id", s);
    }

    public final String a()
    {
        return a.h("pk_registration_id");
    }

    public final void a(String s)
    {
        b(s);
        a.a("pk_registration_version", 0x7d064);
    }

    public final void a(boolean flag)
    {
        a.b("pk_registration_active", flag);
    }

    public final int b()
    {
        return a.d("pk_registration_version");
    }

    public final boolean c()
    {
        return a.a("pk_registration_active", false);
    }

    public final void d()
    {
        a(false);
        b(null);
    }
}
