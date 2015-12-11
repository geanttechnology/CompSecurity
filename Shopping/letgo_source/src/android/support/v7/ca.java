// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ar;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;

public class ca
{

    private Context a;

    private ca(Context context)
    {
        a = context;
    }

    public static ca a(Context context)
    {
        return new ca(context);
    }

    public int a()
    {
        return a.getResources().getInteger(br.g.abc_max_action_buttons);
    }

    public boolean b()
    {
        while (android.os.Build.VERSION.SDK_INT >= 19 || !ar.b(ViewConfiguration.get(a))) 
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
            return a.getResources().getBoolean(br.b.abc_action_bar_embed_tabs);
        } else
        {
            return a.getResources().getBoolean(br.b.abc_action_bar_embed_tabs_pre_jb);
        }
    }

    public int e()
    {
        TypedArray typedarray = a.obtainStyledAttributes(null, br.k.ActionBar, br.a.actionBarStyle, 0);
        int j = typedarray.getLayoutDimension(br.k.ActionBar_height, 0);
        Resources resources = a.getResources();
        int i = j;
        if (!d())
        {
            i = Math.min(j, resources.getDimensionPixelSize(br.d.abc_action_bar_stacked_max_height));
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
        return a.getResources().getDimensionPixelSize(br.d.abc_action_bar_stacked_tab_max_width);
    }
}
