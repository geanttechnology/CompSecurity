// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters.impl;

import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;

// Referenced classes of package com.aviary.android.feather.headless.filters.impl:
//            AdjustSliderFilter

public class AdjustExposureFilter extends AdjustSliderFilter
{

    public static final String BRIGHTNESS = "brightness";
    public static final String CONTRAST = "contrast";
    public static final String HIGHLIGHT = "highlight";
    public static final String SHADOW = "shadow";

    public AdjustExposureFilter()
    {
        super("consolidatedadjust");
    }

    public static String getToolName(int i)
    {
        switch (i)
        {
        default:
            throw new IndexOutOfBoundsException();

        case 0: // '\0'
            return "brightness";

        case 1: // '\001'
            return "contrast";

        case 2: // '\002'
            return "highlight";

        case 3: // '\003'
            return "shadow";
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
            moaaction.setValue("brightness", d);
            return;

        case 1: // '\001'
            moaaction.setValue("contrast", d);
            return;

        case 2: // '\002'
            moaaction.setValue("highlight", d);
            return;

        case 3: // '\003'
            moaaction.setValue("shadow", d);
            break;
        }
    }
}
