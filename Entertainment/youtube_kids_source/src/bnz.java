// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;

public final class bnz
{

    public final String a;

    protected bnz()
    {
        a = null;
    }

    bnz(String s, Intent intent, Exception exception, boolean flag)
    {
        a = s;
    }

    public static bnz a(Exception exception)
    {
        return new bnz(null, null, (Exception)b.a(exception), false);
    }

    public static bnz a(String s)
    {
        return new bnz(b.a(s), null, null, false);
    }

    public final boolean a()
    {
        return a != null;
    }
}
