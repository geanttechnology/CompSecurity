// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaColorParameter;

public class MemeFilter extends NativeFilter
{

    private MoaAction mAction;

    MemeFilter()
    {
        super(new String[] {
            "memegen"
        });
        mAction = mActions.get(0);
    }

    public void setAssetFontName(String s)
    {
        mAction.setValue("fontname", (new StringBuilder()).append("assets/").append(s).toString());
    }

    public void setBottomText(String s)
    {
        mAction.setValue("bottomtext", s);
    }

    public void setFillColor(int i)
    {
        mAction.setValue("fillcolor", new MoaColorParameter(Integer.valueOf(i)));
    }

    public void setFontSourceDir(String s)
    {
        mAction.setValue("fontsourcedir", s);
    }

    public void setPaddingBottom(double d)
    {
        mAction.setValue("paddingbottom", d);
    }

    public void setPaddingTop(double d)
    {
        mAction.setValue("paddingtop", d);
    }

    public void setStrokeColor(int i)
    {
        mAction.setValue("outlinecolor", new MoaColorParameter(Integer.valueOf(i)));
    }

    public void setTextSize(double d)
    {
        mAction.setValue("textsize", d);
    }

    public void setTopText(String s)
    {
        mAction.setValue("toptext", s);
    }
}
