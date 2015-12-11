// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.util;

import android.view.View;

public class ViewUtil
{

    public ViewUtil()
    {
    }

    public static void transformToLocalCoords(View view, int i, int j, int ai[])
    {
        view.getLocationOnScreen(ai);
        ai[0] = i - ai[0];
        ai[1] = j - ai[1];
    }

    public static void transformToScreenCoords(View view, int i, int j, int ai[])
    {
        view.getLocationOnScreen(ai);
        ai[0] = ai[0] + i;
        ai[1] = ai[1] + j;
    }
}
