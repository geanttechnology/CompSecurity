// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

// Referenced classes of package com.tapjoy.internal:
//            p

public final class o extends p
{

    private final long c = 0L;

    public o(SharedPreferences sharedpreferences, String s)
    {
        super(sharedpreferences, s);
    }

    public final long a()
    {
        return a.getLong(b, c);
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor)
    {
        return editor.remove(b);
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor, long l)
    {
        return editor.putLong(b, l);
    }

    public final void a(long l)
    {
        a.edit().putLong(b, l).commit();
    }
}
