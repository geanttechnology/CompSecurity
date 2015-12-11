// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search.ui;

import android.content.res.Resources;
import android.util.TypedValue;

public class ViewUtil
{

    public ViewUtil()
    {
    }

    public static float dipToPixels(int i, Resources resources)
    {
        return TypedValue.applyDimension(1, i, resources.getDisplayMetrics());
    }
}
