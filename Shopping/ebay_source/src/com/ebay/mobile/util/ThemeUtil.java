// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.util;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.TypedValue;

public final class ThemeUtil
{

    public ThemeUtil()
    {
    }

    public static int resolveThemeColor(Resources resources, android.content.res.Resources.Theme theme, int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (theme.resolveAttribute(i, typedvalue, true))
        {
            return resources.getColor(typedvalue.resourceId);
        } else
        {
            return 0;
        }
    }

    public static ColorStateList resolveThemeColorStateList(Resources resources, android.content.res.Resources.Theme theme, int i)
    {
        return resources.getColorStateList(resolveThemeForegroundColorResId(theme, i));
    }

    public static int resolveThemeForegroundColor(Resources resources, android.content.res.Resources.Theme theme, int i)
    {
        return resources.getColor(resolveThemeForegroundColorResId(theme, i));
    }

    public static int resolveThemeForegroundColorResId(android.content.res.Resources.Theme theme, int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (theme.resolveAttribute(i, typedvalue, true))
        {
            return typedvalue.resourceId;
        } else
        {
            theme.resolveAttribute(0x1010036, typedvalue, true);
            return typedvalue.resourceId;
        }
    }

    public static int resolveThemeResId(android.content.res.Resources.Theme theme, int i, int j)
    {
        TypedValue typedvalue = new TypedValue();
        if (theme.resolveAttribute(i, typedvalue, true))
        {
            j = typedvalue.resourceId;
        }
        return j;
    }

    public static int resolveThemeSecondaryColorResId(android.content.res.Resources.Theme theme, int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (theme.resolveAttribute(i, typedvalue, true))
        {
            return typedvalue.resourceId;
        } else
        {
            theme.resolveAttribute(0x1010038, typedvalue, true);
            return typedvalue.resourceId;
        }
    }

    public static int resolveThemeTertiaryColorResId(android.content.res.Resources.Theme theme, int i)
    {
        TypedValue typedvalue = new TypedValue();
        if (theme.resolveAttribute(i, typedvalue, true))
        {
            return typedvalue.resourceId;
        } else
        {
            theme.resolveAttribute(0x1010212, typedvalue, true);
            return typedvalue.resourceId;
        }
    }
}
