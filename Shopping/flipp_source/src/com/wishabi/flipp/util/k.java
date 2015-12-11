// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.content.SharedPreferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.wishabi.flipp.util:
//            p

public final class k
{

    public static String a(String s)
    {
        SharedPreferences sharedpreferences = p.a();
        if (sharedpreferences == null)
        {
            return s;
        } else
        {
            return sharedpreferences.getString("postal_code", s);
        }
    }

    public static boolean b(String s)
    {
        return s != null && Pattern.compile("(?i)\\A[A-Z][0-9][A-Z] ?[0-9][A-Z][0-9]\\z").matcher(s).matches();
    }

    public static boolean c(String s)
    {
        return s != null && Pattern.compile("\\A[0-9][0-9][0-9][0-9][0-9]\\z").matcher(s).matches();
    }

    public static boolean d(String s)
    {
        return b(s) || c(s);
    }
}
