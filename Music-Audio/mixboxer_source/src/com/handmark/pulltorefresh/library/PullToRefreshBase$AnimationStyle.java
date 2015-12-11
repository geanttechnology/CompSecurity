// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import com.handmark.pulltorefresh.library.internal.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.RotateLoadingLayout;

public final class I extends Enum
{

    private static final FLIP $VALUES[];
    public static final FLIP FLIP;
    public static final FLIP ROTATE;

    static I getDefault()
    {
        return ROTATE;
    }

    static ROTATE mapIntToValue(int i)
    {
        switch (i)
        {
        default:
            return ROTATE;

        case 1: // '\001'
            return FLIP;
        }
    }

    public static FLIP valueOf(String s)
    {
        return (FLIP)Enum.valueOf(com/handmark/pulltorefresh/library/PullToRefreshBase$AnimationStyle, s);
    }

    public static FLIP[] values()
    {
        return (FLIP[])$VALUES.clone();
    }

    final LoadingLayout createLoadingLayout(Context context, e_3B_.clone clone, e_3B_.clone clone1, TypedArray typedarray)
    {
        switch (m.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle[ordinal()])
        {
        default:
            return new RotateLoadingLayout(context, clone, clone1, typedarray);

        case 2: // '\002'
            return new FlipLoadingLayout(context, clone, clone1, typedarray);
        }
    }

    static 
    {
        ROTATE = new <init>("ROTATE", 0);
        FLIP = new <init>("FLIP", 1);
        $VALUES = (new .VALUES[] {
            ROTATE, FLIP
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
