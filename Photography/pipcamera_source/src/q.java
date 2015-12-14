// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class q
{

    private Context a;

    private q(Context context)
    {
        a = context;
    }

    public static q a(Context context)
    {
        return new q(context);
    }

    public int a()
    {
        return a.getResources().getInteger(android.support.v7.appcompat.R.integer.abc_max_action_buttons);
    }

    public boolean b()
    {
        while (android.os.Build.VERSION.SDK_INT >= 19 || !ViewConfigurationCompat.hasPermanentMenuKey(ViewConfiguration.get(a))) 
        {
            return true;
        }
        return false;
    }

    public int c()
    {
        return a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean d()
    {
        if (a.getApplicationInfo().targetSdkVersion >= 16)
        {
            return a.getResources().getBoolean(android.support.v7.appcompat.R.bool.abc_action_bar_embed_tabs);
        } else
        {
            return a.getResources().getBoolean(android.support.v7.appcompat.R.bool.abc_action_bar_embed_tabs_pre_jb);
        }
    }

    public int e()
    {
        TypedArray typedarray = a.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        int j = typedarray.getLayoutDimension(android.support.v7.appcompat.R.styleable.ActionBar_height, 0);
        Resources resources = a.getResources();
        int i = j;
        if (!d())
        {
            i = Math.min(j, resources.getDimensionPixelSize(android.support.v7.appcompat.R.dimen.abc_action_bar_stacked_max_height));
        }
        typedarray.recycle();
        return i;
    }

    public boolean f()
    {
        return a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int g()
    {
        return a.getResources().getDimensionPixelSize(android.support.v7.appcompat.R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
