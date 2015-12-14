// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters.impl;

import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;

public class CropFilter extends NativeFilter
{

    public CropFilter()
    {
        super(new String[] {
            "crop"
        });
    }

    public void setPreviewSize(MoaPointParameter moapointparameter)
    {
        mActions.get(0).setValue("previewsize", moapointparameter);
    }

    public void setSize(MoaPointParameter moapointparameter)
    {
        mActions.get(0).setValue("size", moapointparameter);
    }

    public void setTopLeft(MoaPointParameter moapointparameter)
    {
        mActions.get(0).setValue("upperleftpoint", moapointparameter);
    }
}
