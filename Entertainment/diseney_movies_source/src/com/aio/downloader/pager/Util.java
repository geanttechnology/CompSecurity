// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.pager;

import android.content.res.Resources;
import android.util.TypedValue;

public class Util
{

    public Util()
    {
    }

    public static int dpToPx(Resources resources, int i)
    {
        return (int)TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }
}
