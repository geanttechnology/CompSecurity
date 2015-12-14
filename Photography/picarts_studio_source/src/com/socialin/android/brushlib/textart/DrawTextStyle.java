// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.textart;

import java.io.Serializable;

public final class DrawTextStyle
    implements Serializable, Cloneable
{

    public final int borderColor;
    public int fillColor;
    public final String fontPackagePath;
    public final String fontPath;
    public final int fontType;
    public final int gradientColor;
    public final boolean hasBorder;
    public final boolean hasGradient;
    public final boolean isFontFromSdCard;
    public final int size;
    public final int styleIndex;
    public final int textHeight;
    public final Object textStyleData;

    public DrawTextStyle(int i, int j, int k, int l, boolean flag, boolean flag1, boolean flag2, 
            String s, String s1, int i1, int j1, int k1, Object obj)
    {
        fillColor = i;
        gradientColor = j;
        borderColor = k;
        size = l;
        hasGradient = flag;
        hasBorder = flag1;
        isFontFromSdCard = flag2;
        fontPath = s;
        fontPackagePath = s1;
        styleIndex = i1;
        fontType = j1;
        textHeight = k1;
        textStyleData = obj;
    }

    public final DrawTextStyle clone()
    {
        return new DrawTextStyle(fillColor, gradientColor, borderColor, size, hasGradient, hasBorder, isFontFromSdCard, fontPath, fontPackagePath, styleIndex, fontType, textHeight, textStyleData);
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final void setFillColor(int i)
    {
        fillColor = i;
    }
}
