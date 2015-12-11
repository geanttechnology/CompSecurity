// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

// Referenced classes of package com.tapjoy.internal:
//            p

public final class n extends p
{

    private final int c;

    public n(SharedPreferences sharedpreferences, String s, int i)
    {
        super(sharedpreferences, s);
        c = i;
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor, int i)
    {
        return editor.putInt(b, i);
    }

    public final Integer a()
    {
        return Integer.valueOf(b());
    }

    public final void a(int i)
    {
        a.edit().putInt(b, i).commit();
    }

    public final int b()
    {
        return a.getInt(b, c);
    }
}
