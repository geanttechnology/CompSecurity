// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.shazam.android.persistence.n.b;
import com.shazam.b.e.a;
import com.shazam.n.m;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.am:
//            l

public final class o
    implements l
{

    private static final long a;
    private final b b;
    private final m c;

    public o(b b1, m m1)
    {
        b = b1;
        c = m1;
    }

    public final void a(long l1)
    {
        b.a("pk_google_now_next_retry_timestamp_millis", l1);
    }

    public final void a(String s)
    {
        b.b("pk_google_now_access_token", s);
        long l1 = c.a();
        long l2 = a;
        b.a("pk_google_now_access_token_expiry_timestamp_millis", l1 + l2);
    }

    public final boolean a()
    {
        return com.shazam.b.e.a.c(b()) && c.a() < b.g("pk_google_now_access_token_expiry_timestamp_millis");
    }

    public final String b()
    {
        return b.a("pk_google_now_access_token", "");
    }

    public final boolean c()
    {
        return b.g("pk_google_now_next_retry_timestamp_millis") <= c.a();
    }

    static 
    {
        a = TimeUnit.MILLISECONDS.convert(1L, TimeUnit.HOURS);
    }
}
