// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;

class ActionBarDrawerToggleJellybeanMR2
{

    private static final int THEME_ATTRS[] = {
        0x101030b
    };

    public static Object setActionBarDescription(Object obj, Activity activity, int i)
    {
        activity = activity.getActionBar();
        if (activity != null)
        {
            activity.setHomeActionContentDescription(i);
        }
        return obj;
    }

}
