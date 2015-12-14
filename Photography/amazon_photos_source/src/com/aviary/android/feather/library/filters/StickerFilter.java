// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;

public class StickerFilter extends NativeFilter
{

    public StickerFilter(String s, String s1)
    {
        super(new String[] {
            "addsticker"
        });
        setSourceDir(s);
        setUrl(s1);
    }

    public final String getSourceDir()
    {
        return (String)getActions().get(0).getValue("source", "");
    }

    public final String getUrl()
    {
        return (String)getActions().get(0).getValue("url", "");
    }

    public void setAlpha(int i)
    {
        getActions().get(0).setValue("alpha", i);
    }

    public void setBottomRight(float f, float f1)
    {
        getActions().get(0).setValue("bottomright", new MoaPointParameter(f, f1));
    }

    public void setCenter(float f, float f1)
    {
        getActions().get(0).setValue("center", new MoaPointParameter(f, f1));
    }

    public void setFlipH(boolean flag)
    {
        getActions().get(0).setValue("fliph", flag);
    }

    public void setRotation(double d)
    {
        getActions().get(0).setValue("rotation", d);
    }

    public void setScale(float f, float f1)
    {
        getActions().get(0).setValue("scale", new MoaPointParameter(f, f1));
    }

    public void setSize(int i, int j)
    {
        getActions().get(0).setValue("size", new MoaPointParameter(i, j));
    }

    public void setSourceDir(String s)
    {
        getActions().get(0).setValue("source", s);
    }

    public void setTopLeft(float f, float f1)
    {
        getActions().get(0).setValue("topleft", new MoaPointParameter(f, f1));
    }

    public void setUrl(String s)
    {
        getActions().get(0).setValue("url", s);
    }
}
