// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;

public class ScreenUtil
{

    private static int getDimension(Resources resources, String s)
    {
        int i = resources.getIdentifier(s, "dimen", "android");
        if (i > 0)
        {
            return resources.getDimensionPixelSize(i);
        } else
        {
            return 0;
        }
    }

    public static int getNavigationBarHeightForPadding(Context context)
    {
        if (!hasSoftKeyNavBar(context) || hasNavBarOnRight(context.getResources()))
        {
            return 0;
        } else
        {
            return getNavigationBarWidth(context.getResources());
        }
    }

    private static int getNavigationBarWidth(Resources resources)
    {
        if (!Api.isAtLeastJellyBean() && !BuildFlavors.isGen5())
        {
            return 0;
        } else
        {
            return getDimension(resources, "navigation_bar_width");
        }
    }

    public static int getNavigationBarWidthForPadding(Context context)
    {
        if (!hasSoftKeyNavBar(context) || !hasNavBarOnRight(context.getResources()))
        {
            return 0;
        } else
        {
            return getNavigationBarWidth(context.getResources());
        }
    }

    public static int getStatusBarHeight(Resources resources)
    {
        return getDimension(resources, "status_bar_height");
    }

    public static int getStatusBarHeightForPadding(Resources resources)
    {
        if (!Api.isAtLeastJellyBean() && !BuildFlavors.isGen5() || BuildFlavors.isDuke())
        {
            return 0;
        } else
        {
            return getStatusBarHeight(resources);
        }
    }

    private static boolean hasNavBarOnRight(Resources resources)
    {
        if (resources.getConfiguration().orientation != 1)
        {
            if (BuildFlavors.isFos4() || BuildFlavors.isGen5())
            {
                return true;
            }
            if (resources.getConfiguration().smallestScreenWidthDp < 600)
            {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSoftKeyNavBar(Context context)
    {
        if (!BuildFlavors.isFireOS4OrLater() && !BuildFlavors.isGen5())
        {
            if (BuildFlavors.isDuke())
            {
                return false;
            }
            if (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4))
            {
                return false;
            }
        }
        return true;
    }
}
