// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public final class u extends p
{

    private final String e;

    public u(df df, k k1, List list, String s, bf bf, h h)
    {
        super(df, k1, k1.w(), list, bf, h);
        e = s;
    }

    protected final void a(cv cv1)
    {
        super.a(cv1);
        String s = e;
        cv1.b("application_session_id", e);
    }
}
