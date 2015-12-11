// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.graphics.Color;
import roboguice.util.Strings;

public class ColorUtil
{

    private static final String NUMBER_SIGN_CHAR = "#";

    private ColorUtil()
    {
    }

    public final int extractColorFromString(String s, int i)
    {
        if (Strings.isEmpty(s))
        {
            return i;
        }
        int j = Color.parseColor(s);
        i = j;
_L2:
        return i;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String generateHexColorString(int i)
    {
        return (new StringBuilder()).append("#").append(Integer.toHexString(i)).toString();
    }
}
