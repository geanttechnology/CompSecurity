// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ab
{

    private static final Pattern a = Pattern.compile("[A-Z0-9_\\.%\\+\\-]+@(?:[A-Z0-9\\.\\-]+\\.)(?:[A-Z]{2,4}|museum|travel)", 2);

    public static boolean a(String s)
    {
        return s != null && a.matcher(s).matches();
    }

}
