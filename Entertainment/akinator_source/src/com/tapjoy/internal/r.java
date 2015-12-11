// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

// Referenced classes of package com.tapjoy.internal:
//            p

public final class r extends p
{

    private final String c = null;

    public r(SharedPreferences sharedpreferences, String s)
    {
        super(sharedpreferences, s);
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor, String s)
    {
        if (s != null)
        {
            return editor.putString(b, s);
        } else
        {
            return editor.remove(b);
        }
    }

    public final String a()
    {
        return a.getString(b, c);
    }

    public final void a(String s)
    {
        a.edit().putString(b, s).commit();
    }
}
