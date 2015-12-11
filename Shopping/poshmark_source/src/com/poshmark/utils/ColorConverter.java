// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.graphics.Color;

public class ColorConverter
{

    public ColorConverter()
    {
    }

    public static int getColorValueFromHexString(String s, int i)
    {
        String s1 = s;
        if (s.startsWith("0x"))
        {
            s1 = s.replace("0x", "#");
        }
        int j;
        try
        {
            j = Color.parseColor(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }
}
