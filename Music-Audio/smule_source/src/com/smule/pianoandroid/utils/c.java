// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class c
{

    public static String a(String s)
    {
        s = Pattern.compile("US; ([0-9]*)").matcher(s);
        if (s.matches())
        {
            return Float.toString(Float.valueOf(s.group(1)).floatValue() / 1000000F);
        } else
        {
            return "0.00";
        }
    }
}
