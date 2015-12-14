// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public final class ViewScaleType extends Enum
{

    public static final ViewScaleType a;
    public static final ViewScaleType b;
    private static final ViewScaleType c[];

    private ViewScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ViewScaleType a(ImageView imageview)
    {
        switch (_cls1.a[imageview.getScaleType().ordinal()])
        {
        default:
            return b;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return a;
        }
    }

    public static ViewScaleType valueOf(String s)
    {
        return (ViewScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ViewScaleType, s);
    }

    public static ViewScaleType[] values()
    {
        return (ViewScaleType[])c.clone();
    }

    static 
    {
        a = new ViewScaleType("FIT_INSIDE", 0);
        b = new ViewScaleType("CROP", 1);
        c = (new ViewScaleType[] {
            a, b
        });
    }

    /* member class not found */
    class _cls1 {}

}
