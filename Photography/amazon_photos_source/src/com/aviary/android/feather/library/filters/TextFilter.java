// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaColorParameter;
import com.aviary.android.feather.headless.moa.MoaPointParameter;

public class TextFilter extends NativeFilter
{

    TextFilter()
    {
        super(new String[] {
            "addtext"
        });
    }

    public void setBottomRight(double d, double d1)
    {
        mActions.get(0).setValue("bottomright", new MoaPointParameter(d1, d));
    }

    public void setFillColor(int i)
    {
        mActions.get(0).setValue("fillcolor", new MoaColorParameter(Integer.valueOf(i)));
    }

    public void setRotation(float f)
    {
        mActions.get(0).setValue("rotation", f);
    }

    public void setStrokeColor(int i)
    {
        mActions.get(0).setValue("outlinecolor", new MoaColorParameter(Integer.valueOf(i)));
    }

    public void setText(CharSequence charsequence)
    {
        mActions.get(0).setValue("text", charsequence);
    }

    public void setTextSize(double d)
    {
        mActions.get(0).setValue("textsize", d);
    }

    public void setTopLeft(double d, double d1)
    {
        mActions.get(0).setValue("topleft", new MoaPointParameter(d1, d));
    }
}
