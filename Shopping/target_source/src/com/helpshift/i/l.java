// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l
{

    private static Pattern a = Pattern.compile("\\W+");
    private static Pattern b = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");

    public static boolean a(String s)
    {
        return b.matcher(s.trim()).matches();
    }

    public static boolean b(String s)
    {
        return a.matcher(s.trim()).matches();
    }

}
