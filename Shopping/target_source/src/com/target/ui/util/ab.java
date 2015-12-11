// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.res.Resources;
import com.target.mothership.c;

public class ab
{

    public static String a(int i, int j)
    {
        return c.c().getResources().getQuantityString(j, i, new Object[] {
            Integer.valueOf(i)
        });
    }
}
