// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import android.graphics.ColorMatrixColorFilter;
import com.aviary.android.feather.headless.filters.IFilter;

public interface ILevelFilter
    extends IFilter
{

    public abstract ColorMatrixColorFilter apply(float f);

    public abstract float getAmount(int i, int j);
}
