// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils
{

    public ListUtils()
    {
    }

    public static String asCSV(List list)
    {
        return TextUtils.join(",", list.toArray());
    }

    public static List asList(String s)
    {
        if (s == null)
        {
            return new ArrayList();
        } else
        {
            return new ArrayList(Arrays.asList(s.split(",")));
        }
    }
}
