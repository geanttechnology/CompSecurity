// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.SharedPreferences;

// Referenced classes of package com.tapjoy.internal:
//            p

public final class l extends p
{

    private final double c = 0.0D;

    public l(SharedPreferences sharedpreferences, String s)
    {
        super(sharedpreferences, s);
    }

    public final double a()
    {
        String s;
        s = a.getString(b, null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        double d = Double.parseDouble(s);
        return d;
        NumberFormatException numberformatexception;
        numberformatexception;
        return c;
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor)
    {
        return editor.remove(b);
    }

    public final android.content.SharedPreferences.Editor a(android.content.SharedPreferences.Editor editor, double d)
    {
        return editor.putString(b, Double.toString(d));
    }
}
