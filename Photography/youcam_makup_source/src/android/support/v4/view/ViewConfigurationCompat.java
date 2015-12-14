// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewConfiguration;

public class ViewConfigurationCompat
{

    static final ViewConfigurationVersionImpl IMPL;

    public ViewConfigurationCompat()
    {
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewconfiguration)
    {
        return IMPL.getScaledPagingTouchSlop(viewconfiguration);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewconfiguration)
    {
        return IMPL.hasPermanentMenuKey(viewconfiguration);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new IcsViewConfigurationVersionImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            IMPL = new HoneycombViewConfigurationVersionImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            IMPL = new FroyoViewConfigurationVersionImpl();
        } else
        {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    /* member class not found */
    class ViewConfigurationVersionImpl {}


    /* member class not found */
    class IcsViewConfigurationVersionImpl {}


    /* member class not found */
    class HoneycombViewConfigurationVersionImpl {}


    /* member class not found */
    class FroyoViewConfigurationVersionImpl {}


    /* member class not found */
    class BaseViewConfigurationVersionImpl {}

}
