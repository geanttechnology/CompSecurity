// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class chv
{

    private static final Pattern a = Pattern.compile("RQ.*");

    public static boolean a(String s)
    {
        return !TextUtils.isEmpty(s) && a.matcher(s).matches();
    }

    public static boolean a(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            if (s.equals(s1))
            {
                return true;
            }
            if (a(s))
            {
                return a(s1);
            }
        }
        return false;
    }

}
