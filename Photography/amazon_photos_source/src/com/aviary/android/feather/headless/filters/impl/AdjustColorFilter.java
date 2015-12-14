// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters.impl;

import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;

// Referenced classes of package com.aviary.android.feather.headless.filters.impl:
//            AdjustSliderFilter

public class AdjustColorFilter extends AdjustSliderFilter
{

    public static final String FADE = "fade";
    public static final String SATURATION = "saturation";
    public static final String TINT = "tint";
    public static final String WARMTH = "warmth";

    public AdjustColorFilter()
    {
        super("adjustcolor");
    }

    public static String getToolName(int i)
    {
        switch (i)
        {
        default:
            throw new IndexOutOfBoundsException();

        case 0: // '\0'
            return "saturation";

        case 1: // '\001'
            return "warmth";

        case 2: // '\002'
            return "tint";

        case 3: // '\003'
            return "fade";
        }
    }

    public int getToolCount()
    {
        return 4;
    }

    public void setAdjustTool(int i, double d)
    {
        MoaAction moaaction = mActions.get(0);
        switch (i)
        {
        default:
            throw new IndexOutOfBoundsException();

        case 0: // '\0'
            moaaction.setValue("saturation", d);
            return;

        case 1: // '\001'
            moaaction.setValue("warmth", d);
            return;

        case 2: // '\002'
            moaaction.setValue("tint", d);
            return;

        case 3: // '\003'
            moaaction.setValue("fade", d);
            break;
        }
    }
}
