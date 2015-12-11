// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;

public final class cnx
    implements cok
{

    private final SharedPreferences a;

    public cnx(SharedPreferences sharedpreferences)
    {
        a = (SharedPreferences)b.a(sharedpreferences);
    }

    public final boolean a()
    {
        return a.getBoolean("ApiRequestLogging", false);
    }

    public final boolean b()
    {
        return a.getBoolean("FullApiResponseLogging", false);
    }
}
