// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import com.aviary.android.feather.headless.moa.MoaFloatParameter;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            INativeFilter

public interface INativeRangeFilter
    extends INativeFilter
{

    public abstract MoaFloatParameter getValue();

    public abstract void setValue(Float float1);
}
