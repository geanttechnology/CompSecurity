// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

public final class w
{

    private static String a[] = {
        "#76A599", "#7D9A96", "#6F8888", "#82A1AB", "#8094A1", "#74838C", "#B6A688", "#9E9481", "#8D8F9F", "#A68C93", 
        "#968388", "#7E808B"
    };
    private static List b;

    public static Drawable a(int i)
    {
        if (b == null || b.size() == 0)
        {
            b = new ArrayList(12);
            for (int j = 0; j < 12; j++)
            {
                int k = Color.parseColor(a[j]);
                b.add(new ColorDrawable(k));
            }

        }
        return (Drawable)b.get(i % 12);
    }

}
