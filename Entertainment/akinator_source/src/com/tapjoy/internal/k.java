// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

// Referenced classes of package com.tapjoy.internal:
//            p

public final class k extends p
{

    private final boolean c = false;

    public k(SharedPreferences sharedpreferences, String s)
    {
        super(sharedpreferences, s);
    }

    public final Boolean a()
    {
        return Boolean.valueOf(b());
    }

    public final void a(boolean flag)
    {
        a.edit().putBoolean(b, flag).commit();
    }

    public final boolean b()
    {
        return a.getBoolean(b, c);
    }
}
