// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.graphics.PointF;

// Referenced classes of package com.pointinside.maps:
//            PIMapZoneSelectorStyle

public static class _cls9
{

    private String mLabelsFontPath;
    private float mLabelsFontSize;
    private boolean mLabelsHidden;
    private PointF mLabelsOffset;
    private int mLabelsOutlineColor;
    private float mLabelsOutlineWidth;
    private int mLabelsTextColor;

    private _cls9 getThis()
    {
        return this;
    }

    public PIMapZoneSelectorStyle build()
    {
        return new PIMapZoneSelectorStyle(this, null);
    }

    public _cls9 setLabelsFontPath(String s)
    {
        mLabelsFontPath = s;
        return getThis();
    }

    public getThis setLabelsFontSize(float f)
    {
        mLabelsFontSize = f;
        return getThis();
    }

    public getThis setLabelsHidden(boolean flag)
    {
        mLabelsHidden = flag;
        return getThis();
    }

    public getThis setLabelsOffset(PointF pointf)
    {
        mLabelsOffset = pointf;
        return getThis();
    }

    public getThis setLabelsOutlineColor(int i)
    {
        mLabelsOutlineColor = i;
        return getThis();
    }

    public getThis setLabelsOutlineWidth(float f)
    {
        mLabelsOutlineWidth = f;
        return getThis();
    }

    public getThis setLabelsTextColor(int i)
    {
        mLabelsTextColor = i;
        return getThis();
    }








    public _cls9()
    {
    }
}
