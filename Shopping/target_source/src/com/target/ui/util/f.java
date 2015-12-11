// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.h;
import com.target.ui.fragment.coach_mark.NavigationDrawerCoachMarkDialogFragment;

public class f
{

    private static final String COACH_MARK_PREFERENCES_NAME = "coachMarkPreferences";

    private static SharedPreferences a(Context context)
    {
        return context.getSharedPreferences("coachMarkPreferences", 0);
    }

    public static boolean a(Context context, h h1, boolean flag)
    {
        for (context = a(context); context.getBoolean("hasSeenNavigationDrawerCoachMarks", false) || !flag;)
        {
            return false;
        }

        context.edit().putBoolean("hasSeenNavigationDrawerCoachMarks", true).apply();
        if (h1.a(NavigationDrawerCoachMarkDialogFragment.TAG) != null)
        {
            return true;
        } else
        {
            NavigationDrawerCoachMarkDialogFragment.a().show(h1, NavigationDrawerCoachMarkDialogFragment.TAG);
            return true;
        }
    }
}
