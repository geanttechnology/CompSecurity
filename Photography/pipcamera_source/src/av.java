// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class av
{

    public static Menu a(Context context, SupportMenu supportmenu)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new aw(context, supportmenu);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static MenuItem a(Context context, SupportMenuItem supportmenuitem)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return new an(context, supportmenuitem);
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new ai(context, supportmenuitem);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }

    public static SubMenu a(Context context, SupportSubMenu supportsubmenu)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            return new ax(context, supportsubmenu);
        } else
        {
            throw new UnsupportedOperationException();
        }
    }
}
