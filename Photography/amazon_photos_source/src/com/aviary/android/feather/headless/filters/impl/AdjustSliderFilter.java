// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters.impl;

import com.aviary.android.feather.headless.filters.NativeFilter;

public abstract class AdjustSliderFilter extends NativeFilter
{

    public AdjustSliderFilter(String s)
    {
        super(new String[] {
            s
        });
    }

    public abstract int getToolCount();

    public abstract void setAdjustTool(int i, double d);
}
