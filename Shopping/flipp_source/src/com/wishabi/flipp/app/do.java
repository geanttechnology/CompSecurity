// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.SharedPreferences;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.p;

public final class do extends Enum
{

    public static final do a;
    private static final String c = com/wishabi/flipp/app/do.getSimpleName();
    private static final do d[];
    int b;

    private do(String s)
    {
        super(s, 0);
        b = -1;
    }

    public static do valueOf(String s)
    {
        return (do)Enum.valueOf(com/wishabi/flipp/app/do, s);
    }

    public static do[] values()
    {
        return (do[])d.clone();
    }

    public final int a()
    {
        int i = -1;
        if (b == -1) goto _L2; else goto _L1
_L1:
        i = b;
_L4:
        return i;
_L2:
        SharedPreferences sharedpreferences = p.a();
        if (sharedpreferences == null) goto _L4; else goto _L3
_L3:
        b = sharedpreferences.getInt("last_onboarding_version", 0);
        if (b != 0) goto _L6; else goto _L5
_L5:
        String s = k.a(null);
        if (!sharedpreferences.getBoolean("has_seen_shoplist", false)) goto _L8; else goto _L7
_L7:
        b = 2;
        sharedpreferences.edit().putInt("last_onboarding_version", b).commit();
_L6:
        return b;
_L8:
        if (s != null)
        {
            b = 1;
            sharedpreferences.edit().putInt("last_onboarding_version", b).commit();
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    public final int[] b()
    {
        switch (a())
        {
        default:
            return (new int[] {
                0x7f03003d, 0x7f03003e, 0x7f03003f, 0x7f030040, 0x7f030041
            });

        case 1: // '\001'
            return (new int[] {
                0x7f03003d, 0x7f03003e, 0x7f030041
            });

        case 2: // '\002'
            return (new int[] {
                0x7f03003d, 0x7f030041
            });
        }
    }

    static 
    {
        a = new do("INSTANCE");
        d = (new do[] {
            a
        });
    }
}
